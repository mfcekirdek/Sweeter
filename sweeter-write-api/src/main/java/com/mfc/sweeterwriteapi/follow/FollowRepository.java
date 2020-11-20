package com.mfc.sweeterwriteapi.follow;

import org.springframework.data.couchbase.repository.CouchbaseRepository;

public interface FollowRepository extends CouchbaseRepository<Follow, String> {

}
