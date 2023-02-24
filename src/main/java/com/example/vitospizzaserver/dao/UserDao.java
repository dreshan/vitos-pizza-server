package com.example.vitospizzaserver.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.vitospizzaserver.model.User;

@Repository
public interface UserDao extends CrudRepository<User, String>{

	@Query(value ="select * from vitospizza.appl_user where user_name = :userName", nativeQuery = true)
	public User findByUserName(@Param("userName") String userName);
}
