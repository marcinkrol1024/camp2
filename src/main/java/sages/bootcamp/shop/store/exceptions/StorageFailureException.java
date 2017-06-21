package sages.bootcamp.shop.store.exceptions;

public class StorageFailureException extends Exception {
  public StorageFailureException(String message, Throwable cause) {
    super(message, cause);
  }
}
