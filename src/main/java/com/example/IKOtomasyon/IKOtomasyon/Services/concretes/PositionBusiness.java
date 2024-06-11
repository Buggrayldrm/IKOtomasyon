package com.example.IKOtomasyon.IKOtomasyon.Services.concretes;

import com.example.IKOtomasyon.IKOtomasyon.Dto.Request.PositionCreateRequest;
import com.example.IKOtomasyon.IKOtomasyon.Entities.Position;
import com.example.IKOtomasyon.IKOtomasyon.Repository.PositionRepository;
import com.example.IKOtomasyon.IKOtomasyon.Services.abstracts.PositionService;
import com.example.IKOtomasyon.IKOtomasyon.Services.concretes.Positions.AddPositionCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PositionBusiness implements PositionService {
    private final PositionRepository positionRepository;
    @Override
    public List<Position> getAllPosition() {
        return positionRepository.findAll();
    }

    @Override
    public Optional<Position> getByIdPosition(Long id) {
        return positionRepository.findById(id);
    }

    @Override
    public void deleteOnePosition(Long id) {
        positionRepository.deleteById(id);
    }

    @Override
    public Position createOnePosition(PositionCreateRequest positionCreateRequest) {
        AddPositionCommand addPositionCommand=new AddPositionCommand(positionRepository);
        Position position=new Position();
        position.setPosition_name(positionCreateRequest.getPosition_name());
        position.setPosition_id(positionCreateRequest.getPosition_id());
        position.setPersonal_id(positionCreateRequest.getPersonalId());
        addPositionCommand.setPosition(position);
        addPositionCommand.execute();
        return position;

    }

    @Override
    public Position updateOnePosition(Long id, Position newPosition) {
        return null;
    }
}
