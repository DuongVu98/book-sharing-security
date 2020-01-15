package com.hcmiu.bookssharingsecurity.usercases.firebaseservices;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.hcmiu.bookssharingsecurity.domain.objects.FireUser;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class FirebaseUserManagement {

    @Autowired
    private FirebaseAuth firebaseAuth;

    @Autowired
    private Logger logger;

    public UserRecord createUser(FireUser user) throws FirebaseAuthException {
        UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .setDisplayName(user.getDisplayName())
                .setDisabled(false);
        UserRecord userRecord = firebaseAuth.createUser(request);
        logger.info("{New User} --> {}", userRecord.getUid());

        return userRecord;
    }
}
