package com.example.IKOtomasyon.IKOtomasyon.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonalCreateRequest {

    @NotEmpty
    Long Tc;
    @Length(min = 3, max = 20 , message = "isim alanı minimum 3 max 20 karakterli olmalıdır.")
    String ad;
    String soyad;
    int yas;
    String cinsiyet;
    Boolean calismaDurumu;
    String cv;
}
