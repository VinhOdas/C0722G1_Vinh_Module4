package vinhodas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vinhodas.model.Product;
import vinhodas.repository.IProductRepository;
import vinhodas.service.IProductService;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public void edit(Integer id, Product product) {
        productRepository.edit(id,product);
    }

    @Override
    public void remove(Integer id) {
        productRepository.delete(id);

    }

    @Override
    public void add(Product product) {
        productRepository.add(product);
    }

    @Override
    public List<Product> findByName(String name) {
      return    productRepository.search(name);
    }
}
