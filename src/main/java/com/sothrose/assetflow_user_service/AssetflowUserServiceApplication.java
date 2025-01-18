package com.sothrose.assetflow_user_service;

import com.sothrose.assetflow_user_service.model.User;
import com.sothrose.assetflow_user_service.repository.UserRepository;
import java.time.LocalDate;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AssetflowUserServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(AssetflowUserServiceApplication.class, args);
  }

  @Bean
  public ApplicationRunner applicationRunner(UserRepository userRepository) {
    return args -> {
      var user1 =
          User.builder()
              .username("john_doe")
              .firstName("John")
              .lastName("Doe")
              .email("john.doe@example.com")
              .birthday(LocalDate.of(1990, 5, 15))
              .isActive(true)
              .build();

      userRepository.save(user1);
    };
  }
}
