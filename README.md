Task 1.
-------
project A bootcamp.sages:shop:v1.0 -> bootcamp.sages.shop.Shop  
	void buy()
project B bootcamp.sages:customer:v1.0 -> bootcamp.sages.customer.CustomerApp  
	static void main()
*project C bootcamp.sages:provider:v1.0 -> bootcamp.sages.provider.ProductsProvider
    List<String> provideProduct(int count, String type)

B depends on A
*A depends on C

Basic maven directory structure
-------------------------------
project-name/pom.xml - konfiguracja
project-name/src/main/java - kod produkcyjny
project-name/src/test/java - kod testowy
project-name/target - skompilowane/wygenerowane pliki


Maven repo
----------
https://mvnrepository.com/