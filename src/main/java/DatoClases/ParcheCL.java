/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatoClases;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author MARIO
 */
@Entity
@Table(name = "PARCHE")
public class ParcheCL implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_Parche;

    private String clave;
    private String nombre;
    private String descripcion;
    private Double valorObjetivo;
    private Double monto;
    private boolean estado;

    public ParcheCL() {
    }

    public ParcheCL(String clave, String nombre, String descripcion, Double valorObjetivo, Double monto, boolean estado) {
        this.clave = clave;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.valorObjetivo = valorObjetivo;
        this.monto = monto;
        this.estado = estado;
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

    @Override
    public String toString() {
        return "ParcheCL{" + "ID_Parche=" + ID_Parche + ", clave=" + clave + ", nombre=" + nombre + ", descripcion=" + descripcion + ", valorObjetivo=" + valorObjetivo + ", estado=" + estado + '}';
    }

    @OneToMany(mappedBy = "ParcheFk", cascade = CascadeType.ALL)
    private List<GrupoCL> list_Grupos;

    public List<GrupoCL> getList_Grupos() {
        return list_Grupos;
    }

    public void setList_Grupos(List<GrupoCL> list_Grupos) {
        this.list_Grupos = list_Grupos;
    }

    @OneToMany(mappedBy = "parcheOFk", cascade = CascadeType.ALL)
    private List<TransferenciaCL> list_TransferenciaOrigen;

    @OneToMany(mappedBy = "parcheDFk", cascade = CascadeType.ALL)
    private List<TransferenciaCL> list_TransferenciaDestino;

    public List<TransferenciaCL> getList_TransferenciaOrigen() {
        return list_TransferenciaOrigen;
    }

    public void setList_TransferenciaOrigen(List<TransferenciaCL> list_TransferenciaOrigen) {
        this.list_TransferenciaOrigen = list_TransferenciaOrigen;
    }

    public List<TransferenciaCL> getList_TransferenciaDestino() {
        return list_TransferenciaDestino;
    }

    public void setList_TransferenciaDestino(List<TransferenciaCL> list_TransferenciaDestino) {
        this.list_TransferenciaDestino = list_TransferenciaDestino;
    }

}
