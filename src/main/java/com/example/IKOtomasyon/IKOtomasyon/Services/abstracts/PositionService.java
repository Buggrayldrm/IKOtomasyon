package com.example.IKOtomasyon.IKOtomasyon.Services.abstracts;

import com.example.IKOtomasyon.IKOtomasyon.Dto.Request.PersonalCreateRequest;
import com.example.IKOtomasyon.IKOtomasyon.Dto.Request.PositionCreateRequest;
import com.example.IKOtomasyon.IKOtomasyon.Dto.Request.SalaryCreateRequest;
import com.example.IKOtomasyon.IKOtomasyon.Dto.Response.PositionResponseDto;
import com.example.IKOtomasyon.IKOtomasyon.Dto.Response.SalaryResponseDto;
import com.example.IKOtomasyon.IKOtomasyon.Entities.Position;
import com.example.IKOtomasyon.IKOtomasyon.Entities.Salary;

import java.util.List;


public interface PositionService {

    List<PositionResponseDto> getAllPosition();

    Position getByIdPosition(Long id);

    void deleteOnePosition(Long id);

    Position createOnePosition(PositionCreateRequest positionCreateRequest);

    Position updateOnePosition(Long id,Position newPosition);

}
