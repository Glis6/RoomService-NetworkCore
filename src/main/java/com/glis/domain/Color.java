package com.glis.domain;

import lombok.Data;

/**
 * @author Glis
 */
@Data
public class Color {
    /**
     * The maximum value a color can be.
     */
    private final static int MAX_COLOR_VALUE = 100;

    /**
     * The minimum value a color can be.
     */
    private final static int MIN_COLOR_VALUE = 0;

    /**
     * The red value of the color.
     */
    private final int red;

    /**
     * The green value to the color.
     */
    private final int green;

    /**
     * The blue value of the color.
     */
    private final int blue;

    /**
     * @param red   The red value of the color.
     * @param green The green value to the color.
     * @param blue  The blue value of the color.
     */
    public Color(int red, int green, int blue) {
        if (red > MAX_COLOR_VALUE) {
            red = MAX_COLOR_VALUE;
        }
        if (red < MIN_COLOR_VALUE) {
            red = MIN_COLOR_VALUE;
        }
        this.red = red;

        if (green > MAX_COLOR_VALUE) {
            green = MAX_COLOR_VALUE;
        }
        if (green < MIN_COLOR_VALUE) {
            green = MIN_COLOR_VALUE;
        }
        this.green = green;

        if (blue > MAX_COLOR_VALUE) {
            blue = MAX_COLOR_VALUE;
        }
        if (blue < MIN_COLOR_VALUE) {
            blue = MIN_COLOR_VALUE;
        }
        this.blue = blue;
    }
}
