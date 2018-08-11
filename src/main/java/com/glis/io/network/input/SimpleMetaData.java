package com.glis.io.network.input;

import lombok.Data;

/**
 * @author Glis
 */
@Data
public final class SimpleMetaData implements MetaData {
    /**
     * The {@link InputSender} that originally composed the message.
     */
    private final InputSender inputSender;
}
