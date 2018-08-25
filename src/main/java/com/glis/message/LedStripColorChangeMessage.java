package com.glis.message;

import lombok.Data;

/**
 * @author Glis
 */
@Data
public class LedStripColorChangeMessage implements Message {
    /**
     * The red value to set.
     */
    private int red;

    /**
     * The green value to set.
     */
    private int green;

    /**
     * The blue value to set.
     */
    private int blue;
}
