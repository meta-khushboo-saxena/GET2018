package com.metacube.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.metacube.training.model.EmployeeRole;

@Repository
@Transactional
public interface EmployeeRolesRepository<E> extends JpaRepository<EmployeeRole, Integer> {
	List<EmployeeRole> findByEmail(String email);
}
