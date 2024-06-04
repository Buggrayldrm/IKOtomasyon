package com.example.IKOtomasyon.IKOtomasyon.Services.abstracts;

import com.example.IKOtomasyon.IKOtomasyon.Dto.Request.PersonalCreateRequest;
import com.example.IKOtomasyon.IKOtomasyon.Entities.Personal;

import java.util.List;

public interface PersonalService {
    List<Personal> getAllPersonal();
    Personal getByIdPersonal(Long id);
    void deleteByIdPersonal(Long id);
    Personal updateByIdPersonal(Long id,Personal newPersonal);

    Personal createPersonal(PersonalCreateRequest newPersonalRequest);

}
