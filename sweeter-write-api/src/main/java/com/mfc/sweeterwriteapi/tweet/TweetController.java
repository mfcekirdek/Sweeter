package com.mfc.sweeterwriteapi.tweet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@RestController
public class TweetController {
    // create(post-put), read (get), update (post), delete(delete)

    Logger logger = LoggerFactory.getLogger(TweetController.class);

    @Autowired
    private TweetService tweetService;

    @GetMapping(value = "/tweets/{tweetId}")
    public Tweet getTweet(@PathVariable(name = "tweetId") String tweetId) {
        Tweet tweet = tweetService.findTweetById(tweetId);

        if (tweet == null) {
            logger.error("Tweet not found! (tweetId=" + tweetId + ")");
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Tweet not found"
            );
        }
        return tweet;
    }

    @PostMapping("/tweets")
    public Tweet createTweet(@RequestParam String tweetContent, HttpServletResponse response) {
        Date createdAt = new Date();
        String authorId = "fb921b50-f784-4d0c-b45e-84567a7d8e26";
        int likeCount = 5;
        int retweetCount = 2;
        int replyCount = 3;
        Tweet tweet = new Tweet(createdAt, tweetContent, authorId, likeCount, retweetCount, replyCount);
        logger.error(tweet.toString());
        response.setStatus(201);
        return tweetService.save(tweet);
    }
}
