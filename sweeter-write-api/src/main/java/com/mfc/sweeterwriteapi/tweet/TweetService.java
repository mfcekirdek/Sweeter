package com.mfc.sweeterwriteapi.tweet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TweetService {

    @Autowired
    private TweetRepository tweetRepository;

    public Tweet findTweetById(String tweetId) {
        Optional<Tweet> optional = tweetRepository.findById(tweetId);
        return optional.orElse(null);
    }

    public Tweet save(Tweet tweet) {
        return tweetRepository.save(tweet);
    }
}
