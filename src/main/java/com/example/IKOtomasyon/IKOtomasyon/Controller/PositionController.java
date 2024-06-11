package com.example.IKOtomasyon.IKOtomasyon.Controller;


import com.example.IKOtomasyon.IKOtomasyon.Dto.Request.PositionCreateRequest;
import com.example.IKOtomasyon.IKOtomasyon.Entities.Position;
import com.example.IKOtomasyon.IKOtomasyon.Services.concretes.PositionBusiness;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/positionApi")
public class PositionController {
    private PositionBusiness positionBusiness;

    @GetMapping("/getAllPosition")
    public List<Position> getAllPosition(){
        return positionBusiness.getAllPosition();
    }

    @GetMapping("/getByIdPosition")
    public Optional<Position> getByIdPosition(Long id){
        return positionBusiness.getByIdPosition(id);
    }

    @GetMapping("/deleteOnePosition")
    public void deleteOnePosition(Long id){
        positionBusiness.deleteOnePosition(id);
    }

    @GetMapping("/createPosition")
    public Position createOnePosition(PositionCreateRequest positionCreateRequest){
        return positionBusiness.createOnePosition(positionCreateRequest);
    }



}
