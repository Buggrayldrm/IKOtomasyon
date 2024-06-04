package com.example.IKOtomasyon.IKOtomasyon.Dto.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SalaryResponseDto {

    private int salaryId;
    private long personalTc;

    private int salary;
}
