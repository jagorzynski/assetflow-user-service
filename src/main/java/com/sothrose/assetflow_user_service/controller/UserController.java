package com.sothrose.assetflow_user_service.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.sothrose.assetflow_user_service.model.UserDto;
import com.sothrose.assetflow_user_service.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/v1/assetflow/users")
public class UserController {

  private final UserService userService;

  @PostMapping(consumes = APPLICATION_JSON_VALUE)
  public void saveUser(@RequestBody UserDto userDto) {
    userService.saveUser(userDto);
  }

  @GetMapping(path = "/{userId}", produces = APPLICATION_JSON_VALUE)
  public UserDto getUserById(@PathVariable Long userId) {
    return userService.getUserById(userId);
  }

  @GetMapping(produces = APPLICATION_JSON_VALUE)
  public List<UserDto> getAllUsers() {
    return userService.getAllUsers();
  }

  @DeleteMapping(path = "/{userId}")
  public void deleteUserById(@PathVariable Long userId) {
    userService.deleteUserById(userId);
  }
}
