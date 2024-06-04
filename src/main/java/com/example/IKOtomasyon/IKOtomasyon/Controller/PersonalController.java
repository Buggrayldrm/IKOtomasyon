package com.example.IKOtomasyon.IKOtomasyon.Controller;

import com.example.IKOtomasyon.IKOtomasyon.Dto.Request.PersonalCreateRequest;
import com.example.IKOtomasyon.IKOtomasyon.Entities.Personal;
import com.example.IKOtomasyon.IKOtomasyon.Services.concretes.PersonalBusiness;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/personalApi")
public class PersonalController {
    private final PersonalBusiness personalBusiness;

    public PersonalController(PersonalBusiness personalBusiness) {
        this.personalBusiness = personalBusiness;
    }

    @GetMapping(value = "/getAllPersonal")
    public List<Personal> getAllPersonal(){
        return personalBusiness.getAllPersonal();
    }

    @GetMapping(value = "/getOnePersonal/{id}")
    public Personal getByIdPersonal(@PathVariable Long id){
        return personalBusiness.getByIdPersonal(id);
    }

    @DeleteMapping(value = "/deleteOnePersonal/{id}")
    public void deleteByIdPersonal(@PathVariable long id){
        personalBusiness.deleteByIdPersonal(id);
    }

    @PutMapping(value = "/update/{id}")
    public void updateByIdPersonal(@PathVariable long id, @RequestBody Personal newPersonal){
        personalBusiness.updateByIdPersonal(id, newPersonal);
    }

    @PostMapping(value = "/createPersonal")
    public void createPersonal(@RequestBody  PersonalCreateRequest personalCreateRequest){
        personalBusiness.createPersonal(personalCreateRequest);
    }
}
