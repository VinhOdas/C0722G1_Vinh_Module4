package vinhodas.service;

import vinhodas.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    Product findById(Integer id);


    Product remove(Integer id);

    void add(Product product);


    void edit(Product product);

    List<Product> search(String nameSearch);
}
