package dev.shiftsad.capag.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MunicipioDataRequest {
    private String municipio;
    private String uf;
    private Integer ano;
}
