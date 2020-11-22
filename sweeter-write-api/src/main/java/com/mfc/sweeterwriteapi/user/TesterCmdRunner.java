package com.mfc.sweeterwriteapi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class TesterCmdRunner implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User("user::001","user1@gmail.com", new Date(), false, "");
//        userRepository.save(user1);
//        Optional<User> tmp = userRepository.findById("cf592894-4eed-4672-85b4-e8b5fcdcf830");
//        System.out.println(tmp);
    }
}
