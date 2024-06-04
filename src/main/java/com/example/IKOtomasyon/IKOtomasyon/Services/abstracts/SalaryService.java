package com.example.IKOtomasyon.IKOtomasyon.Services.abstracts;

import com.example.IKOtomasyon.IKOtomasyon.Dto.Request.SalaryCreateRequest;
import com.example.IKOtomasyon.IKOtomasyon.Dto.Response.SalaryResponseDto;
import com.example.IKOtomasyon.IKOtomasyon.Entities.Salary;

import java.util.List;


public interface SalaryService {

    List<SalaryResponseDto> getAllSalary();
    Salary getByIdSalary(Long id);

    void deleteOneSalary(Long id);
    Salary createOneSalary(SalaryCreateRequest salaryCreateRequest);

    Salary updateOneSalary(Long id,Salary newSalary);

}
