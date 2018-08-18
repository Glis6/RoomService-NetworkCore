package com.glis.io.network.networktype;

import com.glis.io.network.codec.NetworkMessageEncoder;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.stereotype.Component;

/**
 * @author Glis
 */
@Component
public abstract class Upstream extends NetworkType {
    /**
     * @param customNetworkTypeHandler The {@link CustomNetworkTypeHandler} that handles the custom handling.
     */
    public Upstream(CustomNetworkTypeHandler customNetworkTypeHandler) {
        super(customNetworkTypeHandler);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void passThrough(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.pipeline().addLast(new NetworkMessageEncoder());
        logger.info(getClass().getSimpleName() + " has been linked.");
    }
}
