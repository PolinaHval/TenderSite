package org.teachmeskills.error;

public final class UserNameExistException extends RuntimeException  {

  public UserNameExistException(final String message) {
    super(message);
  }
}
