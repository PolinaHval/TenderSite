package org.teachmeskills.error;

public class OrganizationAlreadyParticipating extends RuntimeException{
  public OrganizationAlreadyParticipating(final String message) {
    super(message);
  }

}
