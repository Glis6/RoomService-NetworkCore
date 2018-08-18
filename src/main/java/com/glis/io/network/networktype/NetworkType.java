package com.glis.io.network.networktype;

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
     * @return The type identifier for this type of network.
     */
    int getTypeIdentifier();

    /**
     * The custom actions that get completed by the overwriting class.
     *
     * @param channelHandlerContext The channel context.
     * @param linkData The extra {@link LinkData} provided.
     */
    void doCustom(final ChannelHandlerContext channelHandlerContext, final LinkData linkData);

    /**
     * Does all the neccessary networking to connect to the new handlers and disconnect the old ones.
     *
     * @param channelHandlerContext The channel context.
     * @param linkData The extra {@link LinkData} provided.
     */
    default void link(final ChannelHandlerContext channelHandlerContext, final LinkData linkData) {
        passThrough(channelHandlerContext);
        doCustom(channelHandlerContext, linkData);
    }
}
