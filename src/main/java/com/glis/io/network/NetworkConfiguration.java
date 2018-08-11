package com.glis.io.network;

import com.glis.message.Message;
import com.glis.io.network.input.library.MappedMessageLibrary;
import com.glis.io.network.input.library.MessageLibrary;
import com.glis.io.network.networktype.Both;
import com.glis.io.network.networktype.Downstream;
import com.glis.io.network.networktype.Upstream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Glis
 */
@Configuration
public class NetworkConfiguration {
    @Bean
    public MessageLibrary messageLibrary(Message... messages) {
        return new MappedMessageLibrary(messages);
    }

    @Bean
    public Upstream upstream() {
        return new Upstream();
    }

    @Bean
    public Downstream downstream(final MessageLibrary messageLibrary) {
        return new Downstream(messageLibrary);
    }

    @Bean
    public Both both(final Upstream upstream, final Downstream downstream) {
        return new Both(upstream, downstream);
    }
}
