package com.hcmiu.bookssharingsecurity.configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.*;

@Configuration
public class FirebaseConfiguration {

//    public void initFireApp() throws IOException {
//
//        FileInputStream serviceAccount = new FileInputStream("src/main/resources/firebase-admin-private-key.json");
//
//        FirebaseOptions options = null;
//
//        options = new FirebaseOptions.Builder()
//                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//                .setDatabaseUrl("https://books-sharing-system.firebaseio.com")
//                .build();
//
//        FirebaseApp.initializeApp(options);
//    }
}
