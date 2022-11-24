package vinhodas.repository;

import vinhodas.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    Product findById(Integer id);

    void delete(Integer id);

    void add(Product product);

    List<Product> search(String name);

    void edit(Product product);
}
