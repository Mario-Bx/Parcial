/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatoClases;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author MARIO
 */
@Entity
@Table(name = "GRUPO")
public class GrupoCL implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_Grupo;

    public GrupoCL() {
    }

    public int getID_Grupo() {
        return ID_Grupo;
    }

    public void setID_Grupo(int ID_Grupo) {
        this.ID_Grupo = ID_Grupo;
    }

    @Override
    public String toString() {
        return "GrupoCL{" + "ID_Grupo=" + ID_Grupo + ", UsuarioFk=" + UsuarioFk + ", ParcheFk=" + ParcheFk + '}';
    }

    @ManyToOne
    @JoinColumn(name = "UsuarioFk")
    private UsuarioCL UsuarioFk;

    public UsuarioCL getUsuarioFk() {
        return UsuarioFk;
    }

    public void setUsuarioFk(UsuarioCL UsuarioFk) {
        this.UsuarioFk = UsuarioFk;
    }

    @ManyToOne
    @JoinColumn(name = "ParcheFk")
    private ParcheCL ParcheFk;

    public ParcheCL getParcheFk() {
        return ParcheFk;
    }

    public void setParcheFk(ParcheCL ParcheFk) {
        this.ParcheFk = ParcheFk;
    }

    public GrupoCL(UsuarioCL UsuarioFk, ParcheCL ParcheFk) {
        this.UsuarioFk = UsuarioFk;
        this.ParcheFk = ParcheFk;
    }

}
