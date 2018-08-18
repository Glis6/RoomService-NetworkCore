package com.glis.io.network.networktype;

import com.glis.io.network.codec.NetworkMessageDecoder;
import com.glis.io.network.input.library.MessageLibrary;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author Glis
 */
public abstract class Downstream extends NetworkType {
    /**
     * The {@link MessageLibrary} to pass on to the decoder.
     */
    private final MessageLibrary messageLibrary;

    /**
     * @param customNetworkTypeHandler The {@link CustomNetworkTypeHandler} that handles the custom handling.
     * @param messageLibrary The {@link MessageLibrary} to pass on to the decoder.
     */
    public Downstream(CustomNetworkTypeHandler customNetworkTypeHandler, MessageLibrary messageLibrary) {
        super(customNetworkTypeHandler);
        this.messageLibrary = messageLibrary;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void passThrough(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.pipeline().addFirst(new NetworkMessageDecoder(messageLibrary));
        logger.info(getClass().getSimpleName() + " has been linked.");
    }
}
