package com.example.IKOtomasyon.IKOtomasyon.Dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PersonalCreateRequest {

private String  ad;
private String soyad;
private int yas;
private String cinsiyet;
private Boolean calismaDurumu;
private String cv;



}
