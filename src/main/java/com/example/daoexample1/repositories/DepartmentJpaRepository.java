package com.example.daoexample1.repositories;

import com.example.daoexample1.models.DepartmentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentJpaRepository extends JpaRepository<DepartmentModel, Long> {
}
