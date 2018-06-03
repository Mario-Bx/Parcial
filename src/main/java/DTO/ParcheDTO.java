/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import DatoClases.GrupoCL;
import DatoClases.ParcheCL;
import DatoClases.TransferenciaCL;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MARIO
 */
@XmlRootElement(name = "ParcheDTO")
@XmlAccessorType(XmlAccessType.FIELD)
public class ParcheDTO {

    private int ID_Parche;
    private String clave;
    private String nombre;
    private String descripcion;
    private Double valorObjetivo;
    private Double monto;
    private boolean estado;
    private List<GrupoDTO> list_Grupos;
    private List<TransferenciaDTO> list_TransferenciaOrigen;
    private List<TransferenciaDTO> list_TransferenciaDestino;

    public ParcheDTO() {
    }

    public ParcheDTO(ParcheCL objCL) {
        this.ID_Parche = objCL.getID_Parche();
        this.clave = objCL.getClave();
        this.nombre = objCL.getNombre();
        this.descripcion = objCL.getDescripcion();
        this.valorObjetivo = objCL.getValorObjetivo();
        this.monto = objCL.getMonto();
        this.estado = objCL.isEstado();
        this.list_Grupos = new ArrayList<GrupoDTO>();
        this.list_TransferenciaDestino = new ArrayList<TransferenciaDTO>();
        this.list_TransferenciaOrigen = new ArrayList<TransferenciaDTO>();
    }

    public int getID_Parche() {
        return ID_Parche;
    }

    public void setID_Parche(int ID_Parche) {
        this.ID_Parche = ID_Parche;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getValorObjetivo() {
        return valorObjetivo;
    }

    public void setValorObjetivo(Double valorObjetivo) {
        this.valorObjetivo = valorObjetivo;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public List<GrupoDTO> List_Grupos(List<GrupoCL> list_Objs) {
        for (GrupoCL list_Obj : list_Objs) {
            GrupoDTO dTO = new GrupoDTO(list_Obj);
            this.list_Grupos.add(dTO);
        }
        return this.list_Grupos;
    }

    public List<TransferenciaDTO> list_TransferenciaOrigen(List<TransferenciaCL> list_Objs) {
        for (TransferenciaCL list_Obj : list_Objs) {
            TransferenciaDTO dTO = new TransferenciaDTO(list_Obj);
            this.list_TransferenciaOrigen.add(dTO);
        }
        return this.list_TransferenciaOrigen;
    }

    public List<TransferenciaDTO> list_TransferenciaDestino(List<TransferenciaCL> list_Objs) {
        for (TransferenciaCL list_Obj : list_Objs) {
            TransferenciaDTO dTO = new TransferenciaDTO(list_Obj);
            this.list_TransferenciaDestino.add(dTO);
        }
        return this.list_TransferenciaDestino;
    }

}
