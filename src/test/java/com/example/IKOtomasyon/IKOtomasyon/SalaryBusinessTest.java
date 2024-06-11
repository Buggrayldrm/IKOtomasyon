package com.example.IKOtomasyon.IKOtomasyon.Services.concretes;

import com.example.IKOtomasyon.IKOtomasyon.Dto.Request.SalaryCreateRequest;
import com.example.IKOtomasyon.IKOtomasyon.Dto.Response.SalaryResponseDto;
import com.example.IKOtomasyon.IKOtomasyon.Entities.Salary;
import com.example.IKOtomasyon.IKOtomasyon.Repository.SalaryRepository;
import com.example.IKOtomasyon.IKOtomasyon.Services.adapters.SalaryAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SalaryBusinessTest {

    @Mock
    private SalaryRepository salaryRepository;

    @Mock
    private SalaryAdapter salaryMapper;

    @InjectMocks
    private SalaryBusiness salaryBusiness;

    private Salary salary;
    private SalaryCreateRequest salaryCreateRequest;
    private SalaryResponseDto salaryResponseDto;

    @BeforeEach
    void setUp() {
        salary = new Salary();
        salary.setSalary_id(1);
        salary.setSalary(5000);


        salaryCreateRequest = new SalaryCreateRequest();
        salaryCreateRequest.setSalary(5000);


        salaryResponseDto = new SalaryResponseDto();
        salaryResponseDto.setSalary(5000);

    }

    @Test
    void testGetAllSalary() {
        List<Salary> salaries = Arrays.asList(salary);
        List<SalaryResponseDto> salaryResponseDtos = Arrays.asList(salaryResponseDto);

        when(salaryRepository.findAll()).thenReturn(salaries);
        when(salaryMapper.convertToListResponseDto(salaries)).thenReturn(salaryResponseDtos);

        List<SalaryResponseDto> result = salaryBusiness.getAllSalary();

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(salaryRepository, times(1)).findAll();
        verify(salaryMapper, times(1)).convertToListResponseDto(salaries);
    }

    @Test
    void testGetByIdSalary() {
        when(salaryRepository.findById(1L)).thenReturn(Optional.of(salary));

        Salary result = salaryBusiness.getByIdSalary(1L);

        assertNotNull(result);
        assertEquals(5000.0, result.getSalary());
        verify(salaryRepository, times(1)).findById(1L);
    }

    @Test
    void testDeleteOneSalary() {
        doNothing().when(salaryRepository).deleteById(1L);

        salaryBusiness.deleteOneSalary(1L);

        verify(salaryRepository, times(1)).deleteById(1L);
    }

    @Test
    void testCreateOneSalary() {
        when(salaryMapper.convertToEntity(salaryCreateRequest)).thenReturn(salary);
        when(salaryRepository.save(salary)).thenReturn(salary);

        Salary result = salaryBusiness.createOneSalary(salaryCreateRequest);

        assertNotNull(result);
        assertEquals(5000.0, result.getSalary());
        verify(salaryMapper, times(1)).convertToEntity(salaryCreateRequest);
        verify(salaryRepository, times(1)).save(salary);
    }

    @Test
    void testUpdateOneSalary() {
        Salary newSalary = new Salary();
        newSalary.setSalary_id(1);
        newSalary.setSalary(6000);


        when(salaryRepository.findById(1L)).thenReturn(Optional.of(salary));
        when(salaryRepository.save(any(Salary.class))).thenReturn(newSalary);

        Salary result = salaryBusiness.updateOneSalary(1L, newSalary);

        assertNotNull(result);
        assertEquals(6000.0, result.getSalary());
        verify(salaryRepository, times(1)).findById(1L);
        verify(salaryRepository, times(1)).save(any(Salary.class));
    }
}
