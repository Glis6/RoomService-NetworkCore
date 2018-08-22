package com.glis.io.network;

/**
 * @author Glis
 */
public enum AuthorizationResponse {
    /**
     * The authorization was a success.
     */
    SUCCESS,

    /**
     * There was incomplete information received.
     */
    INCOMPLETE_INFORMATION,

    /**
     * The client id is unknown.
     */
    UNKNOWN_CLIENT_ID,

    /**
     * The credentials were invalid.
     */
    INVALID_CREDENTIALS
}
