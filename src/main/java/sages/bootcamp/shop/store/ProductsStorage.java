package sages.bootcamp.shop.store;

import sages.bootcamp.shop.store.exceptions.CapacityExceededException;
import sages.bootcamp.shop.store.exceptions.StorageFailureException;

import java.util.List;

public interface ProductsStorage {

  /**
   * Retrieve products from store
   *
   * @return stored products
   * @throws StorageFailureException when fails to retrieve products
   */
  List<String> retrieveProducts() throws StorageFailureException;

  /**
   * Store products
   *
   * @param products products to store
   * @throws StorageFailureException   when fails to store products
   * @throws CapacityExceededException when products exceed storage capacity
   */
  void storeProducts(List<String> products) throws StorageFailureException, CapacityExceededException;

  /**
   * Is it possible to store products
   *
   * @param products products to check for storing
   * @return true if possible, false otherwise
   */
  boolean isStoringPossible(List<String> products);
}
