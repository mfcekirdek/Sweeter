package com.mfc.sweeterwriteapi.tweet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class TweetService {

    @Autowired
    private TweetRepository tweetRepository;

    @Autowired
    private RedisTemplate<String, Tweet> redisTemplate;

    Logger logger = LoggerFactory.getLogger(TweetService.class);


    public Tweet findTweetById(String tweetId) {
        final String key = "tweet_" + tweetId;
        final ValueOperations<String, Tweet> operations = redisTemplate.opsForValue();
        final boolean hasKey = redisTemplate.hasKey(key);

        if (hasKey) {
            final Tweet tweet = operations.get(key);
            logger.info("TweetService.findTweetById() : cache tweet >> " + tweet);
            return tweet;
        }

        final Optional<Tweet> optional = tweetRepository.findById(tweetId);
        if (optional.isPresent()) {
            Tweet tweet = optional.get();
            operations.set(key, tweet, 10, TimeUnit.SECONDS);
            logger.info("TweetService.findTweetById() : cache insert >> " + optional.get().toString());
            return tweet;
        } else {
            throw new RuntimeException("Resource not found!");
        }
    }

    public Tweet save(Tweet tweet) {
        return tweetRepository.save(tweet);
    }
}
