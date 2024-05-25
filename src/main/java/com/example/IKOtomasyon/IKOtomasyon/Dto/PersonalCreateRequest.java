package com.example.IKOtomasyon.IKOtomasyon.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonalCreateRequest {
    Long Tc;
    String ad;
    String soyad;
    int yas;
    String cinsiyet;
    Boolean calismaDurumu;
    String cv;
}
