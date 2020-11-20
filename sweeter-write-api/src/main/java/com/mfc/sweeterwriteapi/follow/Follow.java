package com.mfc.sweeterwriteapi.follow;

import com.couchbase.client.core.deps.com.fasterxml.jackson.annotation.JsonSubTypes;
import com.mfc.sweeterwriteapi.tweet.Tweet;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

@Document
@JsonSubTypes.Type(value = Follow.class)
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationStrategy.UNIQUE)
    private String id;

    @Field
    private String follower_id;

    @Field
    private String following_id;

    public Follow(String follower_id, String following_id) {
        this.follower_id = follower_id;
        this.following_id = following_id;
    }

    public String getFollower_id() {
        return follower_id;
    }

    public void setFollower_id(String follower_id) {
        this.follower_id = follower_id;
    }

    public String getFollowing_id() {
        return following_id;
    }

    public void setFollowing_id(String following_id) {
        this.following_id = following_id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Follow{" +
                "id='" + id + '\'' +
                ", follower_id='" + follower_id + '\'' +
                ", following_id='" + following_id + '\'' +
                '}';
    }
}
