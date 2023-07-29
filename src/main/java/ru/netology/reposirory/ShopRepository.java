package ru.netology.reposirory;

import ru.netology.javaqa63.AlreadyExistsException;
import ru.netology.javaqa63.NotFoundException;
import ru.netology.javaqa63.Product;

public class ShopRepository {
    private Product[] products = new Product[0];
    public int id;


    /**
     * Вспомогательный метод для имитации добавления элемента в массив
     *
     * @param current — массив, в который мы хотим добавить элемент
     * @param product — элемент, который мы хотим добавить
     * @return — возвращает новый массив, который выглядит, как тот, что мы передали,
     * но с добавлением нового элемента в конец
     */
    private Product[] addToArray(Product[] current, Product product) {
        Product[] tmp = new Product[current.length + 1];
        for (int i = 0; i < current.length; i++) {
            tmp[i] = current[i];
        }
        tmp[tmp.length - 1] = product;
        return tmp;
    }

    /**
     * Метод добавления товара в репозиторий
     *
     * @param product — добавляемый товар
     */
    public void add(Product product) {
        if (findById(product.getId()) != null) {//вызывает метод `findById` с аргументом `product.getId()`, который возвращает товар с соответствующим ID из репозитория. Если товар с таким ID не найден, метод `findById` возвращает `null`.
            //проверяет, найден ли в репозитории товар с таким же ID, как у добавляемого товара `product`.
            throw new AlreadyExistsException(
                    "Element with id: " + id + " already found"
            );
        } else {
            products = addToArray(products, product);
        }
    }


    public Product[] findAll() {
        return products;
    }

    // Этот способ мы рассматривали в теории в теме про композицию
    public void remove(int id) {
        if (findById(id) == null) {
            throw new NotFoundException(
                    "Element with id: " + id + " not found"
            );
        }
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }


}