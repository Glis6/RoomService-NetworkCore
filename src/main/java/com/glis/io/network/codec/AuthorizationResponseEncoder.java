package com.glis.io.network.codec;

import com.glis.io.network.AuthorizationResponse;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.logging.Logger;

/**
 * @author Glis
 */
public class AuthorizationResponseEncoder extends MessageToByteEncoder<AuthorizationResponse> {
    /**
     * The {@link Logger} for this class.
     */
    private final Logger logger = Logger.getLogger(getClass().getName());

    /**
     * {@inheritDoc}
     */
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, AuthorizationResponse authorizationResponse, ByteBuf out) throws Exception {
        logger.info("Encoding authorization response...");
        byte[] output = ByteBuffer.allocate(Integer.SIZE / Byte.SIZE).putInt(authorizationResponse.ordinal()).array();
        out.writeBytes(output);
        logger.info("Authorization response as " + Arrays.toString(output));
    }
}
