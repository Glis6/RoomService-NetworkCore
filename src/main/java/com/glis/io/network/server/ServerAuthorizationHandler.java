package com.glis.io.network.server;

import com.glis.exceptions.InvalidTypeException;
import com.glis.io.network.AuthorizationHandler;
import com.glis.io.network.networktype.NetworkType;
import com.glis.message.AuthorizationMessage;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author Glis
 */
public final class ServerAuthorizationHandler extends AuthorizationHandler {
    /**
     * {@inheritDoc}
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (!(msg instanceof AuthorizationMessage)) {
            throw new InvalidTypeException("Got a message of the wrong format. Expected a " + AuthorizationMessage.class.getSimpleName() + " message.");
        }
        final AuthorizationMessage authorizationMessage = (AuthorizationMessage) msg;
        if (!networkTypes.containsKey(authorizationMessage.getNetworkType())) {
            throw new InvalidTypeException(String.format("The given type does not exist. Received: %d", authorizationMessage.getNetworkType()));
        }
        logger.info("Found a matching " + NetworkType.class.getSimpleName() + ", linking...");
        networkTypes.get(authorizationMessage.getNetworkType()).link(ctx, new ServerLinkData(authorizationMessage.getNetworkName()));
    }
}
