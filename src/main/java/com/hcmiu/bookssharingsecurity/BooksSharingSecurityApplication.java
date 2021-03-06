package com.hcmiu.bookssharingsecurity;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import java.io.FileInputStream;
import java.io.IOException;

@EnableZuulProxy
@SpringBootApplication
public class BooksSharingSecurityApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BooksSharingSecurityApplication.class, args);
	}

	public void initFireApp() throws IOException {

	}

	@Override
	public void run(String... args) throws Exception {
		initFireApp();
	}
}
