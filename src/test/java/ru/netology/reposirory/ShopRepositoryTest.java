package ru.netology.reposirory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa63.AlreadyExistsException;
import ru.netology.javaqa63.NotFoundException;
import ru.netology.javaqa63.Product;

public class ShopRepositoryTest {
    Product item1 = new Product(11, "Книга", 1011);
    Product item2 = new Product(12, "Тетрадь", 20);
    Product item3 = new Product(13, "Ручка", 35);
    Product item4 = new Product(14, "Дневник", 105);
    Product item5 = new Product(10, "Ластик", 25);
    Product item6 = new Product(11, "Альбом", 60);

    @Test
    public void shouldAddByIdOne() {
        ShopRepository repo = new ShopRepository();

        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        repo.add(item4);
        repo.add(item5);



        Product[] expected = {item1, item2, item3, item4, item5};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAlreadyByIdTwo() {
        ShopRepository repo = new ShopRepository();

        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        repo.add(item4);


        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.add(item6);
        });
    }


    @Test
    public void shouldRemoveByILast() {
        ShopRepository repo = new ShopRepository();

        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        repo.add(item4);
        repo.remove(14);

        Product[] expected = {item1, item2, item3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldWithoutRemoveById() {
        ShopRepository repo = new ShopRepository();

        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        repo.add(item4);


        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(18);
        });

    }
}
