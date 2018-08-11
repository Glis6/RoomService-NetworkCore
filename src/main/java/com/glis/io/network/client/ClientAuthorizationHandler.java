package com.glis.io.network.client;

import com.glis.ApplicationContextProvider;
import com.glis.io.network.client.networktype.NetworkType;
import com.glis.io.network.networktype.TypeIdentifier;
import com.glis.message.AuthorizationMessage;
import io.github.cdimascio.dotenv.Dotenv;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.springframework.context.ApplicationContext;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * @author Glis
 */
public final class ClientAuthorizationHandler extends ChannelInboundHandlerAdapter {
    /**
     * The {@link Logger} that we're using.
     */
    private final Logger logger = Logger.getLogger(getClass().getSimpleName());

    /**
     * The {@link Dotenv} for the currently running environment.
     */
    private final Dotenv dotenv = Dotenv.load();

    /**
     * All network types we support.
     */
    private final Map<Integer, NetworkType> networkTypes;

    /**
     * A default constructor.
     */
    public ClientAuthorizationHandler() {
            ApplicationContext context = ApplicationContextProvider.getApplicationContext();
            final Map<Integer, NetworkType> networkTypes = new HashMap<>();
            for (NetworkType possibleNetworkType : context.getBeansOfType(NetworkType.class).values()) {
                if(!possibleNetworkType.getClass().isAnnotationPresent(TypeIdentifier.class)) {
                    logger.warning(NetworkType.class.getSimpleName() + " found without a type. Please add the " + TypeIdentifier.class.getSimpleName() + " annotation.");
                    continue;
                }
                networkTypes.put(possibleNetworkType.getClass().getAnnotation(TypeIdentifier.class).value(), possibleNetworkType);
            }
        this.networkTypes = networkTypes;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void channelActive(final ChannelHandlerContext ctx) {
        ctx.writeAndFlush(new AuthorizationMessage(Integer.valueOf(Objects.requireNonNull(dotenv.get("networkType"))), dotenv.get("networkName")));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        try {
            if (byteBuf.isReadable()) {
                final int response = byteBuf.readByte();
                if(response == 1) {
                    logger.info("Got a positive response back, connecting...");
                    networkTypes.get(Integer.valueOf(Objects.requireNonNull(dotenv.get("networkType")))).link(ctx);
                } else {
                    throw new Exception("Something went wrong connecting to the server.");
                }
            }
        } finally {
            byteBuf.release();
        }
    }
}
