package cn.ekgc.springjpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cn.ekgc.springjpa.entity.User;

public interface UserDao extends JpaRepository<User, Long>{
	@Query("from User u where u.cellphone=:cellphone")
	public User findUserByCellphone(@Param("cellphone")String cellphone) throws Exception;
	
}
