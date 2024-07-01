package ru.netology.statistic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ShopRepositoryTest {

    @Test
    public void testRemoveExistingProduct() {
        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(1, "Product 1", 100);
        Product product2 = new Product(2, "Product 2", 200);

        repo.add(product1);
        repo.add(product2);

        repo.removeById(1);

        Product[] expected = { new Product(2, "Product 2", 200) };
        Assertions.assertArrayEquals(expected, repo.findAll());
    }

    @Test
    public void testRemoveNonExistingProduct() {
        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(1, "Product 1", 100);
        Product product2 = new Product(2, "Product 2", 200);

        repo.add(product1);
        repo.add(product2);

        Exception exception = Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(3);
        });

        String expectedMessage = "Element with id: 3 not found.";
        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }
}