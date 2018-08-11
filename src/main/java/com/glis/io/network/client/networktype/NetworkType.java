package com.glis.io.network.client.networktype;

import com.glis.io.network.codec.AuthorizationDecoder;
import com.glis.io.network.server.ServerAuthorizationHandler;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author Glis
 */
public interface NetworkType {
    /**
     * Makes the network connect to the new handlers.
     *
     * @param channelHandlerContext The channel context.
     */
    void passThrough(final ChannelHandlerContext channelHandlerContext);

    /**
     * Does all the neccessary networking to connect to the new handlers and disconnect the old ones.
     *
     * @param channelHandlerContext The channel context.
     */
    default void link(final ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.writeAndFlush(channelHandlerContext.alloc().buffer(1).writeByte(1));
        channelHandlerContext.pipeline().remove(AuthorizationDecoder.class);
        channelHandlerContext.pipeline().remove(ServerAuthorizationHandler.class);
        passThrough(channelHandlerContext);
    }
}
