package com.example.IKOtomasyon.IKOtomasyon.Services.abstracts;

import com.example.IKOtomasyon.IKOtomasyon.Dto.Request.PositionCreateRequest;
import com.example.IKOtomasyon.IKOtomasyon.Entities.Position;

import java.util.List;
import java.util.Optional;


public interface PositionService {

    List<Position> getAllPosition();

    Optional<Position> getByIdPosition(Long id);

    void deleteOnePosition(Long id);

    Position createOnePosition(PositionCreateRequest positionCreateRequest);

    Position updateOnePosition(Long id,Position newPosition);

}
