package com.example.vitospizzaserver.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.vitospizzaserver.model.UnregisteredUser;

@Repository
public interface UnregisteredUserDao extends CrudRepository<UnregisteredUser, Long>  {

	@Query(value = "select * from vitospizza.unregistered_user where phone =:phone", nativeQuery = true)
	public UnregisteredUser findUnregisteredUserByPhone(@Param("phone") String phone);
}
