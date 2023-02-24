package com.example.vitospizzaserver.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.vitospizzaserver.model.UnregisteredUser;

@Repository
public interface UnregisteredUserDao extends CrudRepository<UnregisteredUser, Long>  {

}
