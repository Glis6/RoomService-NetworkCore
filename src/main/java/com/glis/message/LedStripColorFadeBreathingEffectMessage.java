package com.glis.message;

import com.glis.domain.Color;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Glis
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public final class LedStripColorFadeBreathingEffectMessage extends LedStripEffectMessage {
    /**
     * The colors that the breathing effect brings.
     */
    private Color[] colors;

    /**
     * The amount of time a color is active.
     */
    private int colorLength;

    /**
     * The amount of time it takes to fade in and out.
     */
    private int fadeLength;
}
