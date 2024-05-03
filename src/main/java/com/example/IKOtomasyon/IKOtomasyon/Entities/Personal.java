package com.example.IKOtomasyon.IKOtomasyon.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "personal")
public class Personal {
    @Id
    @Column(name = "personal_TC")
    Long Tc;
    @Column(name = "personal_name")
    String ad;
    @Column(name = "personal_surname")
    String soyad;
    @Column(name = "personal_age")
    int yas;
    @Column(name = "personal_gender")
    String cinsiyet;
    @Column(name = "calısmaDurumu")
    Boolean calismaDurumu;
    @Column(name = "personal_cv")
    String cv;



}
