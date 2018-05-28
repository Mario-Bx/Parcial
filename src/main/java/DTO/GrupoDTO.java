/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import DatoClases.GrupoCL;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MARIO
 */
@XmlRootElement(name = "GrupoDTO")
@XmlAccessorType(XmlAccessType.FIELD)
public class GrupoDTO {

    private int ID_Grupo;
    private UsuarioDTO UsuarioFk;
    private ParcheDTO ParcheFk;

    public GrupoDTO() {
    }

    public GrupoDTO(GrupoCL objCL) {
        this.ID_Grupo = objCL.getID_Grupo();
        this.UsuarioFk = new UsuarioDTO(objCL.getUsuarioFk());
        this.ParcheFk = new ParcheDTO(objCL.getParcheFk());
    }

    public int getID_Grupo() {
        return ID_Grupo;
    }

    public void setID_Grupo(int ID_Grupo) {
        this.ID_Grupo = ID_Grupo;
    }

    public UsuarioDTO getUsuarioFk() {
        return UsuarioFk;
    }

    public void setUsuarioFk(UsuarioDTO UsuarioFk) {
        this.UsuarioFk = UsuarioFk;
    }

    public ParcheDTO getParcheFk() {
        return ParcheFk;
    }

    public void setParcheFk(ParcheDTO ParcheFk) {
        this.ParcheFk = ParcheFk;
    }

}
