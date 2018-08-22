package com.glis.io.network.codec;

import com.glis.message.AuthorizationMessage;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Glis
 */
public class AuthorizationDecoder extends ByteToMessageDecoder {
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
        //First we check for the client id header.
        if (in.readableBytes() < HEADER_LENGTH) {
            throw new Exception("Received a message with invalid length.");
        }
        byte[] clientIdHeader = new byte[HEADER_LENGTH];
        in.readBytes(clientIdHeader, 0, HEADER_LENGTH);
        ByteBuffer clientIdHeaderBuffer = ByteBuffer.allocate(HEADER_LENGTH).put(clientIdHeader, 0, HEADER_LENGTH);
        clientIdHeaderBuffer.rewind();
        final int clientIdLength = clientIdHeaderBuffer.getInt();

        if (in.readableBytes() < clientIdLength) {
            throw new Exception("Received a message with invalid length.");
        }

        //Then we decode the client id.
        byte[] encodedClientId = new byte[clientIdLength];
        in.readBytes(encodedClientId, 0, clientIdLength);
        final String clientId = new String(encodedClientId, StandardCharsets.UTF_8);


        //Then we check the client secret length.
        if (in.readableBytes() < HEADER_LENGTH) {
            throw new Exception("Received a message with invalid length.");
        }
        byte[] clientSecretHeader = new byte[HEADER_LENGTH];
        in.readBytes(clientSecretHeader, 0, HEADER_LENGTH);
        ByteBuffer clientSecretHeaderBuffer = ByteBuffer.allocate(HEADER_LENGTH).put(clientSecretHeader, 0, HEADER_LENGTH);
        clientSecretHeaderBuffer.rewind();
        final int clientSecretLength = clientSecretHeaderBuffer.getInt();

        if (in.readableBytes() < clientSecretLength) {
            throw new Exception("Received a message with invalid length.");
        }

        //Then we decode the client id.
        byte[] encodedClientSecret = new byte[clientSecretLength];
        in.readBytes(encodedClientSecret, 0, clientSecretLength);
        final String clientSecret = new String(encodedClientSecret, StandardCharsets.UTF_8);


        out.add(new AuthorizationMessage(clientId, clientSecret));
    }
}
