package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.EmployeeEntity;





public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Long> {

	@Query("select m.firstName,m.lastName from EmployeeEntity as m where m.userId=:userId")
	List<Object[]> findByRequiredUserId(@Param("userId")Integer userId);


	@Modifying
	@Query("update EmployeeEntity m set m.firstName =:firstName , m.lastName =:lastName where m.userId =:userId" )
	int updateEmployeeList(@Param("firstName") String firstName,@Param("lastName") String lastName,@Param("userId")Integer userId);
	
	
	@Modifying
	@Query("Delete from EmployeeEntity as m  where m.userId =:userId")
	void deleteByUserId(@Param("userId")Integer userId);


}
