package com.mfc.sweeterwriteapi.user;

import com.couchbase.client.core.deps.com.fasterxml.jackson.annotation.JsonSubTypes;
import com.mfc.sweeterwriteapi.tweet.Tweet;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Document
@JsonSubTypes.Type(value = User.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationStrategy.UNIQUE)
    private String id;

    @Field
    @NotNull
    private String userName;

    @Field
    @Email
    @NotNull
    private String email;

    @Field
    private Date createdAt;

    @Field
    private boolean isProtected;

    @Field
    private String bio;

    public User(@NotNull String userName, @Email @NotNull String email, Date createdAt, boolean isProtected, String bio) {
        this.userName = userName;
        this.email = email;
        this.createdAt = createdAt;
        this.isProtected = isProtected;
        this.bio = bio;
    }

    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isProtected() {
        return isProtected;
    }

    public void setProtected(boolean aProtected) {
        isProtected = aProtected;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", createdAt=" + createdAt +
                ", isProtected=" + isProtected +
                ", bio='" + bio + '\'' +
                '}';
    }
}
