package com.example.repository;

import com.example.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
//    @Query(value = " select c.* from `customer` c  join  `customer_type` ct " +
//            " on c.customer_type_id = ct.id " +
//            "where c.name like %:name% and c.status =1", nativeQuery = true)
    Page<Customer> findByName(@Param("name") String searchName,
                              Pageable pageable);
    @Transactional
    @Modifying
    @Query(value = "update customer set status = 0 where id = :id", nativeQuery = true)
    void remove(@Param("id") Integer id);

    @Query(value = "select c.* from `customer` c  join `customer_type` ct " +
            "on c.customer_type_id = ct.id " +
            "where c.name like %:name% and c.email like %:email% and ct.name like %:type% and c.status= 1", nativeQuery = true)
    Page<Customer> findByNameAndEmailAndCustomerType(@Param("name") String name,
                                                     @Param("email") String email,
                                                     @Param("type") String type,
                                                     Pageable pageable);

}
