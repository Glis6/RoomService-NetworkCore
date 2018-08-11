package com.glis.message;

import lombok.Data;

/**
 * @author Glis
 */
@Data
public class AccessTokenMessage implements Message {
    /**
     * The access token for Spotify.
     */
    private String accessToken;

    /**
     * @param accessToken The access token for Spotify.
     */
    public AccessTokenMessage(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * A default constructor.
     */
    public AccessTokenMessage() {
    }
}
