package com.example.IKOtomasyon.IKOtomasyon.Repository;


import com.example.IKOtomasyon.IKOtomasyon.Entities.Personal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalRepository extends JpaRepository<Personal,Long> {
}
