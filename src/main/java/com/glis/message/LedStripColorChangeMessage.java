package com.glis.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Glis
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public final class LedStripColorChangeMessage implements Message {
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
