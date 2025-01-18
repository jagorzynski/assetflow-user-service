package com.sothrose.assetflow_user_service.exception;

public class UserAlreadyPresentException extends RuntimeException {
  public UserAlreadyPresentException(String message) {
    super(message);
  }
}
