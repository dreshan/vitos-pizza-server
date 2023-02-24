package com.example.vitospizzaserver.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.vitospizzaserver.model.Cart;

@Repository
public interface CartDao extends CrudRepository<Cart, Long>{

}
