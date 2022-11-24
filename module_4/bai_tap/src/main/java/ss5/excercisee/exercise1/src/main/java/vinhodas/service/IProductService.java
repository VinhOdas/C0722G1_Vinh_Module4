package vinhodas.service;

import vinhodas.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    Product findById(Integer id);
    

    Product remove(Integer id);

    void add(Product product);

    List<Product> findByName(String name);


    void edit(Product product);
}
