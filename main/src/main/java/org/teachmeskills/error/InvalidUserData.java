package org.teachmeskills.error;

public class InvalidUserData extends RuntimeException{

  public InvalidUserData(final String message) {
    super(message);
  }

}
