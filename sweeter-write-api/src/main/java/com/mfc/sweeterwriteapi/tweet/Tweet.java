package com.mfc.sweeterwriteapi.tweet;

import com.couchbase.client.core.deps.com.fasterxml.jackson.annotation.JsonSubTypes;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Document
@JsonSubTypes.Type(value = Tweet.class)
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationStrategy.UNIQUE)
    private String id;

    @Field
    @NotNull
    private Date createdAt;

    @Field
    @NotNull
    private String content;

    @Field
    @NotNull
    private String authorId;

    @Field
    @NotNull
    private int likeCount;

    @Field
    @NotNull
    private int retweetCount;

    @Field
    @NotNull
    private int replyCount;

    public Tweet(Date createdAt, String content, String authorId, int likeCount, int retweetCount, int replyCount) {
        this.createdAt = createdAt;
        this.content = content;
        this.authorId = authorId;
        this.likeCount = likeCount;
        this.retweetCount = retweetCount;
        this.replyCount = replyCount;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getRetweetCount() {
        return retweetCount;
    }

    public void setRetweetCount(int retweetCount) {
        this.retweetCount = retweetCount;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "createdAt=" + createdAt +
                ", id=" + id +
                ", content='" + content + '\'' +
                ", authorId='" + authorId + '\'' +
                ", likeCount=" + likeCount +
                ", retweetCount=" + retweetCount +
                ", replyCount=" + replyCount +
                '}';
    }
}
