package com.glis.io.network.networktype;

import io.netty.channel.ChannelHandlerContext;

/**
 * A simple class to not have to repeat the same code over and over
 * but to also not have to mess with the inheritance of {@link NetworkType}.
 *
 * @author Glis
 */
public interface CustomNetworkTypeHandler {
    /**
     * @param channelHandlerContext The {@link ChannelHandlerContext} that is provided.
     * @param linkData The {@link LinkData} given with the linking process.
     */
    void doCustom(ChannelHandlerContext channelHandlerContext, LinkData linkData);
}
