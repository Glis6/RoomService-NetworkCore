package com.glis.message;

import lombok.Data;

/**
 * @author Glis
 */
@Data
public final class ProfileMessage implements Message {
    /**
     * The identifier for the profile.
     */
    private String identifier;

    /**
     * @param identifier The identifier for the profile.
     */
    public ProfileMessage(String identifier) {
        this.identifier = identifier;
    }

    /**
     * A default constructor.
     */
    public ProfileMessage() {
    }
}
