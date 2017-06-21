package sages.bootcamp.shop.store;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sages.bootcamp.shop.store.exceptions.StorageFailureException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ProductsFileStorage implements ProductsStorage {

  private static final Logger log = LoggerFactory.getLogger(ProductsFileStorage.class);

  private final String productsFile;
  private final int capacity;

  public ProductsFileStorage(String productsFile, int capacity) {
    this.productsFile = productsFile;
    this.capacity = capacity;
  }

  @Override
  public List<String> retrieveProducts() throws StorageFailureException {
    try {
      return Files
          .lines(Paths.get(this.productsFile))
          .collect(Collectors.toList());
    } catch (IOException e) {
      log.warn("Retrieving products failed.", e);
      throw new StorageFailureException("Retrieving products failed.", e);
    }
  }

  @Override
  public void storeProducts(List<String> products) throws StorageFailureException {
    try {
      Files.write(Paths.get(this.productsFile), products);
    } catch (IOException e) {
      log.warn("Storing products failed.", e);
      throw new StorageFailureException("Storing products failed.", e);
    }
  }

  @Override
  public boolean isStoringPossible(List<String> products) {
    return capacity >= products.size();
  }

}
