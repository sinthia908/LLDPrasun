package com.interview.practice.statergies.playback;

import com.interview.practice.enums.SubscriptionTier;

public interface PlaybackStatergy {

    void play();

    // Simple Factory method to get the correct statergy

    static PlaybackStatergy getStatergy(SubscriptionTier subscriptionTier,int songsPlayed){
         return tier == SubscriptionTier.PREMIUM ? new
    }
}
