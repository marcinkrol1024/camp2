package sages.bootcamp.shop;

import sages.bootcamp.shop.store.ProductsStorage;
import sages.bootcamp.shop.store.exceptions.StorageFailureException;

import java.util.List;
import java.util.stream.Collectors;

public class Shop {
  private final ProductsStorage productsStorage;

  public Shop(ProductsStorage productsStorage) {
    this.productsStorage = productsStorage;
  }

  /**
   * @param product product to buy
   * @return true if product is available, false otherwise
   * @throws StorageFailureException when products storage fails
   */
  public boolean buy(String product) throws StorageFailureException {
    List<String> strings = productsStorage.retrieveProducts();
    boolean found = strings.remove(product);
    productsStorage.storeProducts(strings);
    return found;
  }

  public String getProductsView() throws StorageFailureException {
    return productsStorage
        .retrieveProducts()
        .stream()
        .collect(Collectors.joining(", "));
  }
}
