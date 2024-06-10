package com.example.IKOtomasyon.IKOtomasyon.Services.concretes;

import com.example.IKOtomasyon.IKOtomasyon.Dto.Request.SalaryCreateRequest;
import com.example.IKOtomasyon.IKOtomasyon.Dto.Response.SalaryResponseDto;
import com.example.IKOtomasyon.IKOtomasyon.Entities.Salary;
import com.example.IKOtomasyon.IKOtomasyon.Repository.SalaryRepository;
import com.example.IKOtomasyon.IKOtomasyon.Services.abstracts.SalaryService;
import com.example.IKOtomasyon.IKOtomasyon.Services.adapters.SalaryAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SalaryBusiness implements SalaryService {
    private final SalaryRepository salaryRepository;

    private final SalaryAdapter salaryMapper;

    @Override
    public List<SalaryResponseDto> getAllSalary(){

        List<Salary> salaries = this.salaryRepository.findAll();
        List<SalaryResponseDto> dtos  = this.salaryMapper.convertToListResponseDto(salaries);
        return  dtos;
    }

    @Override
    public Salary getByIdSalary(Long id) {
        return salaryRepository.findById((long) id).orElse(null);
    }

    @Override
    public void deleteOneSalary(Long id) {

        salaryRepository.deleteById(id);

    }

    @Override
    public Salary createOneSalary(SalaryCreateRequest salaryCreateRequest) {
        Salary salary=salaryMapper.convertToEntity(salaryCreateRequest);
        return salaryRepository.save(salary);
    }

    @Override
    public Salary updateOneSalary(Long id, Salary newSalary) {
        Optional<Salary> salary=salaryRepository.findById(id);
        if (salary.isPresent()){
            Salary salary1=new Salary();
            salary1.setSalary(newSalary.getSalary());
            salary1.setSalary_id(newSalary.getSalary_id());
            salary1.setPersonalId(newSalary.getPersonalId());
            salaryRepository.save(salary1);
            return salary1;
        }
        else return null;

    }


}
