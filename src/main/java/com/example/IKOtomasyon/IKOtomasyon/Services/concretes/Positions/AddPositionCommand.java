package com.example.IKOtomasyon.IKOtomasyon.Services.concretes.Positions;

import com.example.IKOtomasyon.IKOtomasyon.Entities.Position;
import com.example.IKOtomasyon.IKOtomasyon.Repository.PositionRepository;
import com.example.IKOtomasyon.IKOtomasyon.Services.abstracts.Command;


import org.springframework.stereotype.Service;
@Service
public class AddPositionCommand implements Command {
    public AddPositionCommand (PositionRepository positionRepository){
        this.positionRepository=positionRepository;

    }
    public void setPosition(Position position){
        this.position=position;
    }
    private  Position position;
    private  PositionRepository positionRepository;
    @Override
    public void execute() {
        positionRepository.save(position);
    }
}
