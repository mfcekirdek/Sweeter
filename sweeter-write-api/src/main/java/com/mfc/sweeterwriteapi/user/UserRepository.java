package com.mfc.sweeterwriteapi.user;

import org.springframework.data.couchbase.repository.CouchbaseRepository;
import java.util.List;

public interface UserRepository extends CouchbaseRepository<User, String> {
    List<User> findByEmail(String email);
}
