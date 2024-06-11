package com.example.IKOtomasyon.IKOtomasyon.Dto.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PositionResponseDto {

    private int positionId;
    private long personalTc;
    private String position_name;
}
