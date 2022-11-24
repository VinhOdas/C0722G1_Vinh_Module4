package vinhodas.repository.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import vinhodas.model.Product;
import vinhodas.repository.IProductRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    @Override
    public List<Product> findAll() {
        Session session = null;
        List<Product> productList = null;
        try{
            session = ConnectionUtil.sessionFactory.openSession();
            productList = session.createQuery("FROM Product").getResultList();
        }finally {
            if (session != null){
                session.close();
            }
        }

        return productList;
    }

    @Override
    public Product findById(Integer id) {
        Session session = null;
        Product product = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            product = (Product) session.createQuery("from Product where id =:id").setParameter("id", id).getSingleResult();

        }finally {
            if (session != null){
                session.close();
            }
        }
        return product ;

    }

    public int findIndex(int id) {
//        for (int i =0; i < products.size(); i++){
//            if (products.get(i).getId() == id ){
//                return i;
//            }
//        }
            return -1;
    }



    @Override
    public void delete(Integer id) {
        Session session = null;
        Product product = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
          transaction =  session.beginTransaction();
            product = session.load(Product.class,id);
            session.delete(product);
            transaction.commit();

        }finally {
            if (session != null){
                session.close();
            }
        }

    }

    @Override
    public void add(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.save(product);

        }finally {
            if (session != null){
                session.close();
            }
        }
    }



    @Override
    public void edit(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.merge(product);
            transaction.commit();
        }finally {
            if (session != null){
                session.close();
            }
        }
    }

    @Override
    public List<Product> search(String nameSearch) {
        List<Product> productList = new ArrayList<>();
        Session session = null;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            productList = session.createQuery("from Product where name like :name").setParameter("name","%"+nameSearch+"%").getResultList();
        }finally {
            if (session != null){
                session.close();
            }
        }
        return productList;
    }
}
