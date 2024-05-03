package com.example.IKOtomasyon.IKOtomasyon.Controller;

import com.example.IKOtomasyon.IKOtomasyon.Dto.PersonalCreateRequest;
import com.example.IKOtomasyon.IKOtomasyon.Entities.Personal;
import com.example.IKOtomasyon.IKOtomasyon.Services.PersonalService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class PersonalController {
    private final PersonalService personalService;

    public PersonalController(PersonalService personalService) {
        this.personalService = personalService;
    }

    @GetMapping(value = "/getAllPersonal")
    public List<Personal> getAllPersonal(){
        return personalService.getALlPersonal();
    }

    @GetMapping(value = "/getOnePersonal/{id}")
    public Personal getByIdPersonal(@PathVariable Long id){
        return personalService.getByIdPersonal(id);
    }

    @DeleteMapping(value = "/deleteOnePersonal/{id}")
    public void deleteByIdPersonal(@PathVariable long id){
        personalService.deleteByIdPersonal(id);
    }

    @PutMapping(value = "/update/{id}")
    public void updateByIdPersonal(@PathVariable long id, @RequestBody Personal newPersonal){
        personalService.updateByIdPersonal(id, newPersonal);
    }

    @PostMapping(value = "/createPersonal")
    public void createPersonal(@RequestBody PersonalCreateRequest personalCreateRequest){
        personalService.createPersonal(personalCreateRequest);
    }
}
