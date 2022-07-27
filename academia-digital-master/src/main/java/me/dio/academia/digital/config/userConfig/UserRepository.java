package me.dio.academia.digital.config.userConfig;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

	//SELECT e FROM User e JOIN FETCH e.roles WHERE e.username= (:username)
	//@Query("SELECT e FROM User e JOIN FETCH e.roles WHERE e.username= (:username)")
	User findByUsername(@Param("username") String username);
	
	boolean existsByUsername(String username);
	
}
