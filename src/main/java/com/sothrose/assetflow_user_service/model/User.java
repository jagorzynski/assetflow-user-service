package com.sothrose.assetflow_user_service.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
  @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
  private Long userId;

  private String username;
  private String firstName;
  private String lastName;
  private String email;
  private LocalDate birthday;
  private Boolean isActive;

  public User(
      String username,
      String firstName,
      String lastName,
      String email,
      LocalDate birthday,
      boolean isActive) {
    this.username = username;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.birthday = birthday;
    this.isActive = isActive;
  }
}
