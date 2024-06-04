package com.example.IKOtomasyon.IKOtomasyon.Dto.Request;


import com.example.IKOtomasyon.IKOtomasyon.Entities.Personal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalaryCreateRequest {
private int salary_id;
private Personal personalId;
private  int salary;

}
