package com.glis.io.network.networktype;

import io.netty.channel.ChannelHandlerContext;

import java.util.logging.Logger;

/**
 * @author Glis
 */
public abstract class Both extends NetworkType {
    /**
     * The {@link Logger} for this class.
     */
    private final Logger logger = Logger.getLogger(getClass().getName());

    /**
     * The {@link Upstream} object to link the upstream.
     */
    private final Upstream upstream;

    /**
     * The {@link Downstream} object to link the downstream.
     */
    private final Downstream downstream;

    /**
     * @param customNetworkTypeHandler The {@link CustomNetworkTypeHandler} that handles the custom handling.
     * @param upstream The {@link Upstream} object to link the upstream.
     * @param downstream The {@link Downstream} object to link the downstream.
     */
    public Both(CustomNetworkTypeHandler customNetworkTypeHandler, Upstream upstream, Downstream downstream) {
        super(customNetworkTypeHandler);
        this.upstream = upstream;
        this.downstream = downstream;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void passThrough(ChannelHandlerContext channelHandlerContext) {
        logger.info("Passing though to " + Upstream.class.getSimpleName() +  "...");
        upstream.passThrough(channelHandlerContext);
        logger.info("Passing though to " + Downstream.class.getSimpleName() +  "...");
        downstream.passThrough(channelHandlerContext);
    }
}
