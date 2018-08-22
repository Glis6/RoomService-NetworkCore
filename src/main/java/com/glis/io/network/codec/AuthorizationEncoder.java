package com.glis.io.network.codec;

import com.glis.message.AuthorizationMessage;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.logging.Logger;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * @author Glis
 */
public class AuthorizationEncoder extends MessageToByteEncoder<AuthorizationMessage> {
    /**
     * The {@link Logger} for this class.
     */
    private final Logger logger = Logger.getLogger(getClass().getName());

    /**
     * {@inheritDoc}
     */
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, AuthorizationMessage authorizationMessage, ByteBuf out) throws Exception {
        logger.info("Encoding authorization...");
        byte[] clientId = authorizationMessage.getClientId().getBytes(UTF_8);
        byte[] clientIdHeader = ByteBuffer.allocate(Integer.SIZE / Byte.SIZE).putInt(clientId.length).array();
        byte[] clientSecret = authorizationMessage.getClientSecret().getBytes(UTF_8);
        byte[] clientSecretHeader = ByteBuffer.allocate(Integer.SIZE / Byte.SIZE).putInt(clientSecret.length).array();
        byte[] output = new byte[clientId.length + clientIdHeader.length + clientSecret.length + clientSecretHeader.length];

        System.arraycopy(clientIdHeader, 0, output, 0, clientIdHeader.length);
        System.arraycopy(clientId, 0, output, clientIdHeader.length, clientId.length);
        System.arraycopy(clientSecretHeader, 0, output, clientIdHeader.length + clientId.length, clientSecretHeader.length);
        System.arraycopy(clientSecret, 0, output, clientIdHeader.length + clientId.length + clientSecretHeader.length, clientSecret.length);

        out.writeBytes(output);
        logger.info("Authorization encoded as " + Arrays.toString(output));
    }
}
