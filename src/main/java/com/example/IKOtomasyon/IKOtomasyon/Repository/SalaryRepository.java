package com.example.IKOtomasyon.IKOtomasyon.Repository;

import com.example.IKOtomasyon.IKOtomasyon.Entities.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepository extends JpaRepository<Salary,Long> {

}
