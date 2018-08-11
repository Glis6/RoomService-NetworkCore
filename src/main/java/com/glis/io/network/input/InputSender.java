package com.glis.io.network.input;

import com.glis.io.network.output.MessageSender;

/**
 * @author Glis
 */
public interface InputSender extends MessageSender {
    /**
     * @return The identifier for the sender of the input.
     */
    String getIdentifier();
}
