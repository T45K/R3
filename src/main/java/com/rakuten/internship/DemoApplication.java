package com.rakuten.internship;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    @Bean
    public GoogleCredential getGoogleCredential() throws FileNotFoundException, IOException {
        GoogleCredential credential = GoogleCredential
            .fromStream(new FileInputStream(System.getenv("GOOGLE_APPLICATION_CREDENTIALS")))
            .createScoped(Arrays.asList("https://www.googleapis.com/auth/cloud-platform"));
        credential.refreshToken();
        return credential;
    }

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
