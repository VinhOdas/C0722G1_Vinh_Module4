package vinhodas.repository.impl;

import org.springframework.stereotype.Repository;
import vinhodas.model.Product;
import vinhodas.repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Máy tính", 12222, "Bền", "Asus"));
        products.add(new Product(2, "Máy tính", 12222, "Bền", "Asus"));
        products.add(new Product(3, "Máy tính", 12222, "Bền", "Asus"));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(Integer id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public int findIndex(int id) {
        for (int i =0; i < products.size(); i++){
            if (products.get(i).getId() == id ){
                return i;
            }
        }
            return -1;
    }

    @Override
    public void edit(Integer id, Product product) {
        int index = findIndex(id);
        products.remove(index);
        products.add(index, product);

    }

    @Override
    public void delete(Integer id) {
        int index = findIndex(id);
        products.remove(index);
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public List<Product> search(String name) {
    List<Product> productSearch =new ArrayList<>();
        for (Product product: products
             ) {
            if (product.getName().contains(name)){
                productSearch.add(product);
            }

        }
        return productSearch;
    }
}
