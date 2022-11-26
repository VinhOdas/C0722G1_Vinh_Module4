package vinhodas.service;

import vinhodas.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    Product findById(Integer id);

    void edit(Integer id, Product product);

    void remove(Integer id);

    void add(Product product);

    List<Product> findByName(String name);
}
