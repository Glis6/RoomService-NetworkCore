package com.glis.io.network.networktype;

import io.netty.channel.ChannelHandlerContext;

import java.util.logging.Logger;

/**
 * @author Glis
 */
public abstract class NetworkType {
    /**
     * The {@link Logger} for this class.
     */
    protected final Logger logger = Logger.getLogger(getClass().getName());

    /**
     * The {@link CustomNetworkTypeHandler} that handles the custom handling.
     */
    private final CustomNetworkTypeHandler customNetworkTypeHandler;

    /**
     * @param customNetworkTypeHandler The {@link CustomNetworkTypeHandler} that handles the custom handling.
     */
    NetworkType(CustomNetworkTypeHandler customNetworkTypeHandler) {
        this.customNetworkTypeHandler = customNetworkTypeHandler;
    }

    /**
     * Makes the network connect to the new handlers.
     *
     * @param channelHandlerContext The channel context.
     */
    protected abstract void passThrough(final ChannelHandlerContext channelHandlerContext);

    /**
     * @return The type identifier for this type of network.
     */
    protected abstract int getTypeIdentifier();

    /**
     * Does all the neccessary networking to connect to the new handlers and disconnect the old ones.
     *
     * @param channelHandlerContext The channel context.
     * @param linkData The extra {@link LinkData} provided.
     */
    public final void link(final ChannelHandlerContext channelHandlerContext, final LinkData linkData) {
        passThrough(channelHandlerContext);
        customNetworkTypeHandler.doCustom(channelHandlerContext, linkData);
    }
}
