package com.sothrose.assetflow_user_service.model;

import java.time.LocalDate;
import lombok.*;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
  private Long userId;
  private String username;
  private String firstName;
  private String lastName;
  private String email;
  private LocalDate birthday;
  private Boolean isActive;

  public static UserDto from(User user) {
    return new UserDto(
        user.getUserId(),
        user.getUsername(),
        user.getFirstName(),
        user.getLastName(),
        user.getEmail(),
        user.getBirthday(),
        user.getIsActive());
  }

  public User toUser() {
    return new User(username, firstName, lastName, email, birthday, isActive);
  }
}
