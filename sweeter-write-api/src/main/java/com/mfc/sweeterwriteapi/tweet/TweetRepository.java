package com.mfc.sweeterwriteapi.tweet;

import org.springframework.data.couchbase.repository.CouchbaseRepository;

public interface TweetRepository extends CouchbaseRepository<Tweet, String> {

}
