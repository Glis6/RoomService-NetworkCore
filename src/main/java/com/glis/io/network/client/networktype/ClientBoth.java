package com.glis.io.network.client.networktype;

import com.glis.io.network.codec.SubscribeMessageEncoder;
import com.glis.io.network.networktype.Both;
import com.glis.io.network.networktype.Downstream;
import com.glis.io.network.networktype.Upstream;

/**
 * @author Glis
 */
public final class ClientBoth extends Both {
    /**
     * {@inheritDoc}
     */
    public ClientBoth(Upstream upstream, Downstream downstream) {
        super((channelHandlerContext, linkData) -> channelHandlerContext.pipeline().remove(SubscribeMessageEncoder.class), upstream, downstream);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected int getTypeIdentifier() {
        return 2;
    }
}
