package com.hcmiu.bookssharingsecurity;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import java.io.FileInputStream;
import java.io.IOException;

@EnableZuulProxy
@SpringBootApplication
public class BooksSharingSecurityApplication {

	public static void main(String[] args) throws IOException {
		initFireApp();
		SpringApplication.run(BooksSharingSecurityApplication.class, args);
	}

	public static void initFireApp() throws IOException {

		FileInputStream serviceAccount = new FileInputStream("src/main/resources/firebase-admin-private-key.json");

		FirebaseOptions options = null;

		options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.setDatabaseUrl("https://books-sharing-system.firebaseio.com")
				.build();

		FirebaseApp.initializeApp(options);
	}

}
