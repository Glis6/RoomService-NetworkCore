package com.glis.io.network.codec;

import com.glis.io.network.AuthorizationResponse;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Glis
 */
public class AuthorizationResponseDecoder extends ByteToMessageDecoder {
    /**
     * The length of the header.
     */
    private final static int HEADER_LENGTH = Integer.SIZE / Byte.SIZE;

    /**
     * The {@link Logger} for this class.
     */
    private final Logger logger = Logger.getLogger(getClass().getName());

    /**
     * {@inheritDoc}
     */
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf in, List<Object> out) throws Exception {
        logger.info("Decoding message...");
        if (in.readableBytes() < HEADER_LENGTH) {
            out.add((int)in.readByte());
            return;
        }
        byte[] ordinalBytes = new byte[HEADER_LENGTH];
        in.readBytes(ordinalBytes, 0, HEADER_LENGTH);
        ByteBuffer ordinalBuffer = ByteBuffer.allocate(HEADER_LENGTH).put(ordinalBytes, 0, HEADER_LENGTH);
        ordinalBuffer.rewind();
        final int ordinal = ordinalBuffer.getInt();
        out.add(AuthorizationResponse.values()[ordinal]);
    }
}
