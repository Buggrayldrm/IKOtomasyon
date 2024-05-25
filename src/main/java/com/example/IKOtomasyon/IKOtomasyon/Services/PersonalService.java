package com.example.IKOtomasyon.IKOtomasyon.Services;

import com.example.IKOtomasyon.IKOtomasyon.Dto.PersonalCreateRequest;
import com.example.IKOtomasyon.IKOtomasyon.Entities.Personal;
import com.example.IKOtomasyon.IKOtomasyon.Repository.PersonalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalService {


    private final PersonalRepository personalRepository;


    public PersonalService(PersonalRepository personalRepository) {
        this.personalRepository = personalRepository;
    }

    public List<Personal> getALlPersonal(){

        return  personalRepository.findAll();
    }

    public Personal getByIdPersonal(Long id){
        return personalRepository.findById(id).orElse(null);
    }

    public void deleteByIdPersonal(Long id){
        personalRepository.deleteById(id);
    }

    public Personal updateByIdPersonal(Long id,Personal newPersonal){
        Optional<Personal> personal=personalRepository.findById(id);
        if (personal.isPresent()){
            Personal personal1=new Personal();
            personal1.setAd(newPersonal.getAd());
            personal1.setSoyad(newPersonal.getSoyad());
            personal1.setYas(newPersonal.getYas());
            personal1.setCinsiyet(newPersonal.getCinsiyet());
            personal1.setCalismaDurumu(newPersonal.getCalismaDurumu());
            personal1.setCv(newPersonal.getCv());
             personalRepository.save(personal1);
             return personal1;
        }
        else {
            return null;
        }

    }

    public Personal createPersonal(PersonalCreateRequest newPersonalRequest){

        Personal personal=new Personal();


        personal.setAd(newPersonalRequest.getAd());
        personal.setSoyad(newPersonalRequest.getSoyad());
        personal.setYas(newPersonalRequest.getYas());
        personal.setCinsiyet(newPersonalRequest.getCinsiyet());
        personal.setCalismaDurumu(newPersonalRequest.getCalismaDurumu());
        personal.setCv(newPersonalRequest.getCv());
        return personalRepository.save(personal);
    }

}
