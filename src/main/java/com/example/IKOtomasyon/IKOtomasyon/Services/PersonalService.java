package com.example.IKOtomasyon.IKOtomasyon.Services;

import com.example.IKOtomasyon.IKOtomasyon.Dto.PersonalCreateRequest;
import com.example.IKOtomasyon.IKOtomasyon.Entities.Personal;
import com.example.IKOtomasyon.IKOtomasyon.Repository.PersonalRepository;
import com.example.IKOtomasyon.IKOtomasyon.Services.mappers.PersonalMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonalService {


    private final PersonalRepository personalRepository;

    private final PersonalMapper mapper;




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

        Personal personal=mapper.convertToEntity(newPersonalRequest);
        return personalRepository.save(personal);
    }

}
