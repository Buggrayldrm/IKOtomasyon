package com.example.IKOtomasyon.IKOtomasyon.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Salary {
    @Id
    @Column(name = "salary_id")
    private int salary_id;

    @OneToOne
    @JoinColumn(name = "personal_id")
    private  Personal personalId;

    @Column(name = "salary")
    private int salary;
}
