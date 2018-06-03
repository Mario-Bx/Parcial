/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatoClases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author MARIO
 */
@Entity
@Table(name = "USUARIO")
public class UsuarioCL implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_Usuario;

    private String nombre;

    public UsuarioCL() {
    }

    public UsuarioCL(String nombre) {
        this.nombre = nombre;
        this.list_Amisgos = new ArrayList<AmigoCL>();
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

    @Override
    public String toString() {
        return "UsuarioCL{" + "ID_Usuario=" + ID_Usuario + ", nombre=" + nombre + '}';
    }

    @OneToMany(mappedBy = "AmigoFk1", cascade = CascadeType.ALL)
    private List<AmigoCL> list_Amisgos;

    public List<AmigoCL> getList_Amisgos() {
        return list_Amisgos;
    }

    public void setList_Amisgos(List<AmigoCL> list_Amisgos) {
        this.list_Amisgos = list_Amisgos;
    }

    @OneToMany(mappedBy = "UsuarioFk", cascade = CascadeType.ALL)
    private List<GrupoCL> list_Grupos;

    public List<GrupoCL> getList_Grupos() {
        return list_Grupos;
    }

    public void setList_Grupos(List<GrupoCL> list_Grupos) {
        this.list_Grupos = list_Grupos;
    }

    @OneToMany(mappedBy = "UsuarioFk", cascade = CascadeType.ALL)
    private List<BilleteraCL> list_Billetera;

    public List<BilleteraCL> getList_Billetera() {
        return list_Billetera;
    }

    public void setList_Billetera(List<BilleteraCL> list_Billetera) {
        this.list_Billetera = list_Billetera;
    }
    
    public void addBilletera(BilleteraCL bill) {
        bill.setUsuarioFk(this);
        this.list_Billetera.add(bill);
    }

}
