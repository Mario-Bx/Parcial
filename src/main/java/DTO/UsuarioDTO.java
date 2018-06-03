/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import DatoClases.AmigoCL;
import DatoClases.BilleteraCL;
import DatoClases.GrupoCL;
import DatoClases.UsuarioCL;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MARIO
 */
@XmlRootElement(name = "UsuarioDTO")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsuarioDTO {

    private int ID_Usuario;
    private String nombre;
    private List<AmigoDTO> list_Amisgos;
    private List<GrupoDTO> list_Grupos;
    private List<BilleteraDTO> list_Billetera;

    public UsuarioDTO() {
    }

    public UsuarioDTO(UsuarioCL objetoCL) {
        this.ID_Usuario = objetoCL.getID_Usuario();
        this.nombre = objetoCL.getNombre();
        this.list_Amisgos = new ArrayList<AmigoDTO>();
        this.list_Billetera = new ArrayList<BilleteraDTO>();
        this.list_Grupos = new ArrayList<GrupoDTO>();
    }

    public int getID_Usuario() {
        return ID_Usuario;
    }

    public void setID_Usuario(int ID_Usuario) {
        this.ID_Usuario = ID_Usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<AmigoDTO> List_Amigos(List<AmigoCL> list_Objs) {
        for (AmigoCL list_Obj : list_Objs) {
            AmigoDTO dTO = new AmigoDTO(list_Obj);
            this.list_Amisgos.add(dTO);
        }
        return this.list_Amisgos;
    }

    public List<GrupoDTO> List_Grupos(List<GrupoCL> list_Objs) {
        for (GrupoCL list_Obj : list_Objs) {
            GrupoDTO dTO = new GrupoDTO(list_Obj);
            this.list_Grupos.add(dTO);
        }
        return this.list_Grupos;
    }

    public List<BilleteraDTO> List_Billeteras(List<BilleteraCL> list_Objs) {
        for (BilleteraCL list_Obj : list_Objs) {
            BilleteraDTO dTO = new BilleteraDTO(list_Obj);
            this.list_Billetera.add(dTO);
        }
        return this.list_Billetera;
    }
}
