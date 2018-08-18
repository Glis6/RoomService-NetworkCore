package com.glis.io.network;

import com.glis.ApplicationContextProvider;
import com.glis.io.network.networktype.NetworkType;
import io.github.cdimascio.dotenv.Dotenv;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.springframework.context.ApplicationContext;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author Glis
 */
public abstract class AuthorizationHandler extends ChannelInboundHandlerAdapter {
    /**
     * The {@link Logger} that we're using.
     */
    protected final Logger logger = Logger.getLogger(getClass().getSimpleName());

    /**
     * The {@link Dotenv} for the currently running environment.
     */
    protected final Dotenv dotenv = Dotenv.load();

    /**
     * All network types we support.
     */
    protected final Map<Integer, NetworkType> networkTypes;

    /**
     * A default constructor.
     */
    public AuthorizationHandler() {
        ApplicationContext context = ApplicationContextProvider.getApplicationContext();
        final Map<Integer, NetworkType> networkTypes = new HashMap<>();
        for (NetworkType possibleNetworkType : context.getBeansOfType(NetworkType.class).values()) {
            networkTypes.put(possibleNetworkType.getTypeIdentifier(), possibleNetworkType);
        }
        this.networkTypes = networkTypes;
    }
}
