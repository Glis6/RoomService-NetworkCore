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
public final class AuthorizationMessage {
    /**
     * The name of the network that is connecting.
     */
    private String clientId;

    /**
     * The name of the network that is connecting.
     */
    private String clientSecret;
}
