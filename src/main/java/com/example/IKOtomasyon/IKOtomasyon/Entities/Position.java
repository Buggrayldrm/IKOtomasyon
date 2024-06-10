package com.example.IKOtomasyon.IKOtomasyon.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Position {
    @Id
    @Column(name = "position_id")
    private int position_id;

    @OneToOne
    @JoinColumn(name = "personal_id")
    private  Personal personal_id;

    @Column(name = "position_name")
    private int position_name;
}
