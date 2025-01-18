package com.sothrose.assetflow_user_service.validator;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.google.common.collect.Lists.newArrayList;
import static java.util.Objects.isNull;

import com.sothrose.assetflow_user_service.model.UserDto;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class UserDtoValidator {
  public List<String> validatePortfolioDto(UserDto userDto) {
    List<String> validationErrors = newArrayList();

    if (isNull(userDto)) {
      validationErrors.add("UserDto cannot be null");
    }

    if (isNullOrEmpty(userDto.getUsername())) {
      validationErrors.add("Username cannot be null or empty");
    }

    if (isNullOrEmpty(userDto.getFirstName())) {
      validationErrors.add("FirstName cannot be null or empty");
    }

    if (isNullOrEmpty(userDto.getLastName())) {
      validationErrors.add("LastName cannot be null or empty");
    }

    if (isNullOrEmpty(userDto.getEmail())) {
      validationErrors.add("Email cannot be null or empty");
    }

    if (isNull(userDto.getBirthday())) {
      validationErrors.add("Birthday cannot be null");
    }

    return validationErrors;
  }
}
