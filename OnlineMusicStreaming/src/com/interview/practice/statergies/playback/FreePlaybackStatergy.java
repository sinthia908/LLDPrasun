package com.interview.practice.statergies.playback;

import com.interview.practice.entities.Player;
import com.interview.practice.entities.Song;

public class FreePlaybackStatergy implements PlaybackStatergy{

    private int songsPlayed;
    private static final int SONGS_BEFORE_AD = 3 ;


    public FreePlaybackStatergy(int songsPlayed){
           this.songsPlayed = songsPlayed;

    }

    @Override
    public void play(Song song, Player player) {
        if ( songsPlayed > 0 && songsPlayed % SONGS_BEFORE_AD == 0){

        }

        pl

    }
}
