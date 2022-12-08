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
    public Product remove(Integer id) {
        productRepository.delete(id);

        return null;
    }

    @Override
    public void add(Product product) {
        productRepository.add(product);
    }


    @Override
    public void edit(Product product) {
        productRepository.edit(product);
    }

    @Override
    public List<Product> search(String nameSearch) {
        return productRepository.search(nameSearch);
    }
}
