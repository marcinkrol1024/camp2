Maven repo
----------
https://mvnrepository.com/

Helpful links
-------------
http://www.vogella.com/tutorials/JUnit/article.html
http://www.vogella.com/tutorials/Mockito/article.html


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

Mockito Task 2
------------
Create tests for Shop, mock ProductsStorage

TDD Task 3
--------
Create ProductsStore implementation that stores products in a List.

1. Create empty implementation ProductsListStore.
2. Create tests for the class.
3. Check that the test fails.
4. Implement ProductsListStore so that tests pass.

Task 4*
-----
Create tests for products file storage.

Use @Rule TemporaryFolder for setting up files.

Use Parameterized to test storing:
* empty list
* singleton list
* lists with multiple elements
 
Task 5**
-----
Rewrite tests to spock 