package com.example.springdemo;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


@SpringBootApplication
@EnableSwagger2
public class SpringDemoApplication {

    public static void main(String[] args) throws IOException {
//        ClassLoader classLoader=SpringDemoApplication.class.getClassLoader();
        File file= new File(SpringDemoApplication.class.getClassLoader().getResource("firebase_config.json").getFile());
        FileInputStream serviceInput=new FileInputStream(file.getAbsoluteFile());

        FirebaseOptions options= new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceInput))
                        .build();

        FirebaseApp.initializeApp(options);
        SpringApplication.run(SpringDemoApplication.class, args);
    }

}
