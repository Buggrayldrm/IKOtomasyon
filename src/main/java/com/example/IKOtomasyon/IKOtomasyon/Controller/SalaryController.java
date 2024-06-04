package com.example.IKOtomasyon.IKOtomasyon.Controller;

import com.example.IKOtomasyon.IKOtomasyon.Dto.Request.SalaryCreateRequest;
import com.example.IKOtomasyon.IKOtomasyon.Dto.Response.SalaryResponseDto;
import com.example.IKOtomasyon.IKOtomasyon.Entities.Salary;
import com.example.IKOtomasyon.IKOtomasyon.Services.concretes.SalaryBusiness;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salaryApi")
public class SalaryController {

    private final SalaryBusiness salaryBusiness;

    public SalaryController(SalaryBusiness salaryBusiness) {
        this.salaryBusiness = salaryBusiness;
    }

    @GetMapping("/getAllSalary")
    public List<SalaryResponseDto> getAllSalary(){
        return salaryBusiness.getAllSalary();
    }
    @GetMapping("getByIdSalary")
    public Salary getByIdSalary(@PathVariable Long id){
        return  salaryBusiness.getByIdSalary(id);
    }
    @DeleteMapping("/deleteOneSalary")
    public void deleteOneSalary(@PathVariable Long id){
        salaryBusiness.deleteOneSalary(id);
    }

    @PostMapping("/(createOneSalary")
    public Salary createOneSalary(SalaryCreateRequest salaryCreateRequest){
        return  salaryBusiness.createOneSalary(salaryCreateRequest);

    }

    @PutMapping("/updateOneSalary")
    public Salary updateOneSalary(Long id, Salary newSalary){
        return salaryBusiness.updateOneSalary(id,newSalary);
    }


}
