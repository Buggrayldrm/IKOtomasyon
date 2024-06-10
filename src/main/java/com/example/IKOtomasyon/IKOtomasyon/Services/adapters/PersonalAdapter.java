package com.example.IKOtomasyon.IKOtomasyon.Services.adapters;

import com.example.IKOtomasyon.IKOtomasyon.Dto.Request.PersonalCreateRequest;
import com.example.IKOtomasyon.IKOtomasyon.Entities.Personal;
import org.springframework.stereotype.Service;

@Service
public class PersonalAdapter {

public Personal convertToEntity(PersonalCreateRequest request){


    Personal  personal= new Personal();
    personal.setAd(request.getAd());
    personal.setSoyad(request.getSoyad());
    personal.setYas(request.getYas());
    personal.setCinsiyet(request.getCinsiyet());
    personal.setCalismaDurumu(request.getCalismaDurumu());
    personal.setCv(request.getCv());
    return personal;
}

}
