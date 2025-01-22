package com.sothrose.assetflow_user_service.service;

import static java.lang.String.format;
import static java.lang.String.join;

import com.sothrose.assetflow_user_service.exception.UserAlreadyPresentException;
import com.sothrose.assetflow_user_service.exception.UserDtoValidationException;
import com.sothrose.assetflow_user_service.exception.UserNotFoundException;
import com.sothrose.assetflow_user_service.model.UserDto;
import com.sothrose.assetflow_user_service.repository.UserRepository;
import com.sothrose.assetflow_user_service.validator.UserDtoValidator;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {
  public static final String DELIMITER = ", ";
  private final UserRepository userRepository;
  private final UserDtoValidator userDtoValidator;

  public void saveUser(UserDto useDto) {
    var userDtoValidationErrors = userDtoValidator.validatePortfolioDto(useDto);

    if (!userDtoValidationErrors.isEmpty()) {
      var validationErrors = join(DELIMITER, userDtoValidationErrors);
      log.error("Error occurred when validation UserDto: [{}]", validationErrors);
      throw new UserDtoValidationException(
          format("Error occurred when validation UserDto: [%s]", validationErrors));
    }

    var username = useDto.getUsername();
    var presentUserOpt = userRepository.findByUsername(username);
    if (presentUserOpt.isPresent()) {
      log.error("Cannot save new user, user with username: [{}] already exists in db", username);
      throw new UserAlreadyPresentException(
          format("Cannot save new user, user with username: [%s] already exists in db", username));
    }

    userRepository.save(useDto.toUser());
  }

  public UserDto getUserById(Long userId) {
    return userRepository
        .findById(userId)
        .map(UserDto::from)
        .orElseThrow(
            () ->
                new UserNotFoundException(
                    format("User with id: [%s] not found in repository", userId)));
  }

  public List<UserDto> getAllUsers() {
    return userRepository.findAll().stream().map(UserDto::from).toList();
  }

  public void deleteUserById(Long userId) {
    userRepository.deleteById(userId);
  }
}
