/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import DatoClases.AmigoCL;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MARIO
 */
@XmlRootElement(name = "AmigoDTO")
@XmlAccessorType(XmlAccessType.FIELD)
public class AmigoDTO {

    private int ID_Amigo;
    private UsuarioDTO AmigoFk1;
    private UsuarioDTO AmigoFk2;

    public AmigoDTO() {
    }

    public AmigoDTO(AmigoCL objCL) {
        this.ID_Amigo = objCL.getID_Amigo();
        this.AmigoFk1 = new UsuarioDTO(objCL.getAmigoFk1());
        this.AmigoFk2 = new UsuarioDTO(objCL.getAmigoFk2());
    }

    public int getID_Amigo() {
        return ID_Amigo;
    }

    public void setID_Amigo(int ID_Amigo) {
        this.ID_Amigo = ID_Amigo;
    }

    public UsuarioDTO getAmigoFk1() {
        return AmigoFk1;
    }

    public void setAmigoFk1(UsuarioDTO AmigoFk1) {
        this.AmigoFk1 = AmigoFk1;
    }

    public UsuarioDTO getAmigoFk2() {
        return AmigoFk2;
    }

    public void setAmigoFk2(UsuarioDTO AmigoFk2) {
        this.AmigoFk2 = AmigoFk2;
    }

}
