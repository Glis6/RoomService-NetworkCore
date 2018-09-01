package com.glis.message;

import lombok.Data;

/**
 * @author Glis
 */
@Data
public final class PlaybackMessage implements Message {
    /**
     * The command that requests the song to be played.
     */
    private String playbackCommand;

    /**
     * @param playbackCommand The song that is currently playing.
     */
    public PlaybackMessage(String playbackCommand) {
        this.playbackCommand = playbackCommand;
    }

    /**
     * A default constructor.
     */
    public PlaybackMessage() {
    }
}
