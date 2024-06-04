package com.example.IKOtomasyon.IKOtomasyon.Services.mappers;


import com.example.IKOtomasyon.IKOtomasyon.Dto.Request.SalaryCreateRequest;
import com.example.IKOtomasyon.IKOtomasyon.Dto.Response.SalaryResponseDto;
import com.example.IKOtomasyon.IKOtomasyon.Entities.Salary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SalaryMapper {


    public List<SalaryResponseDto> convertToListResponseDto(List<Salary> salaries){

        // todo: 1. Yöntem
        List<SalaryResponseDto> responseDtos = new ArrayList<>();
        for (Salary salary : salaries){
            SalaryResponseDto dto = convertToResponseDto(salary);

            responseDtos.add(dto);
        }

        return  responseDtos;


    }



    public SalaryResponseDto convertToResponseDto(Salary salary){

        return new SalaryResponseDto(salary.getSalary_id(), salary.getPersonalId().getTc(), salary.getSalary());

    }


    public Salary convertToEntity(SalaryCreateRequest request){
        Salary salary =new Salary();
        salary.setSalary_id(request.getSalary_id());
        salary.setPersonalId(request.getPersonalId());
        salary.setSalary(request.getSalary());
        return salary;
    }

}
