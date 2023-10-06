package org.teachmeskills.error;

public final class OrganizationAlreadyExistException extends RuntimeException {

  public OrganizationAlreadyExistException(final String message) {
    super(message);
  }

}
