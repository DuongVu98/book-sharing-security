package com.hcmiu.bookssharingsecurity.usercases.firebaseservices;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.hcmiu.bookssharingsecurity.domain.objects.FireUser;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class FirebaseUserManagement {

    @Autowired
    private FirebaseAuth firebaseAuth;

//    @Autowired
//    private Logger logger;

    public UserRecord createUser(FireUser user) throws FirebaseAuthException {
        UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .setDisplayName(user.getDisplayName())
                .setDisabled(false);
        UserRecord userRecord = firebaseAuth.createUser(request);
        log.info("{New User} --> {}", userRecord.getUid());

        return userRecord;
    }

    public UserRecord getUserById(String uid) throws FirebaseAuthException {
        return firebaseAuth.getUser(uid);
    }

    public UserRecord getUserByEmail(String email) throws FirebaseAuthException {
        return firebaseAuth.getUserByEmail(email);
    }

    public UserRecord updateUser(String uid, FireUser user) throws FirebaseAuthException {
        UserRecord.UpdateRequest request = new UserRecord.UpdateRequest(uid)
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .setDisplayName(user.getDisplayName());
        return firebaseAuth.updateUser(request);
    }

    public void deleteUser(String uid) throws FirebaseAuthException {
        firebaseAuth.deleteUser(uid);
    }
}
