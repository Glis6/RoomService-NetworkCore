package com.glis.io.network.networktype;

import com.glis.io.network.codec.NetworkMessageDecoder;
import com.glis.io.network.input.library.MessageLibrary;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * @author Glis
 */
@Component
public abstract class Downstream implements NetworkType {
    /**
     * The {@link Logger} for this class.
     */
    private final Logger logger = Logger.getLogger(getClass().getName());

    /**
     * The {@link MessageLibrary} to pass on to the decoder.
     */
    private final MessageLibrary messageLibrary;

    /**
     * @param messageLibrary The {@link MessageLibrary} to pass on to the decoder.
     */
    @Autowired
    public Downstream(MessageLibrary messageLibrary) {
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
