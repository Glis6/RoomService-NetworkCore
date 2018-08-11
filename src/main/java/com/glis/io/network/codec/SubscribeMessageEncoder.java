package com.glis.io.network.codec;

import com.glis.message.Message;
import com.glis.message.SubscribeMessage;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author Glis
 */
public class SubscribeMessageEncoder extends NetworkMessageEncoder {
    /**
     * {@inheritDoc}
     */
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Message networkMessage, ByteBuf out) throws Exception {
        //We'll simply do an extra check to see if the message is a Subscribe message.
        if(networkMessage instanceof SubscribeMessage) {
            super.encode(channelHandlerContext, networkMessage, out);
        }
    }
}
