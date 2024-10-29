package com.PhD_UAE.PhD.Dto;

import com.PhD_UAE.PhD.Entity.CED;
import lombok.Data;

@Data
public class CedDTO {
    private Long idCED;
    private Long idUser;
    private Long idEtablissement;
    private Long idSujet;

    public CedDTO(CED ced){
        this.idCED = ced.getIdCED();
        this.idUser = ced.getUser().getIdUser();
}


}