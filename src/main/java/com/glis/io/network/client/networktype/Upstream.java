package com.glis.io.network.client.networktype;

import com.glis.io.network.codec.NetworkMessageEncoder;
import com.glis.io.network.networktype.TypeIdentifier;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * @author Glis
 */
@Component
@TypeIdentifier(2)
public class Upstream implements NetworkType {
    /**
     * The {@link Logger} for this class.
     */
    private final Logger logger = Logger.getLogger(getClass().getName());

    /**
     * {@inheritDoc}
     */
    @Override
    public void passThrough(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.pipeline().addLast(new NetworkMessageEncoder());
        logger.info(getClass().getSimpleName() + " has been linked.");
    }
}
