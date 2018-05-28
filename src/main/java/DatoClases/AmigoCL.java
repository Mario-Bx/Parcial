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
@Table(name = "AMIGO")
public class AmigoCL implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_Amigo;

    public AmigoCL() {
    }

    public int getID_Amigo() {
        return ID_Amigo;
    }

    public void setID_Amigo(int ID_Amigo) {
        this.ID_Amigo = ID_Amigo;
    }

    @Override
    public String toString() {
        return "AmigoCL{" + "ID_Amigo=" + ID_Amigo + ", AmigoFk1=" + AmigoFk1 + ", AmigoFk2=" + AmigoFk2 + '}';
    }

    @ManyToOne
    @JoinColumn(name = "AmigoFk1")
    private UsuarioCL AmigoFk1;

    public UsuarioCL getAmigoFk1() {
        return AmigoFk1;
    }

    public void setAmigoFk1(UsuarioCL AmigoFk1) {
        this.AmigoFk1 = AmigoFk1;
    }

    @ManyToOne
    @JoinColumn(name = "AmigoFk2")
    private UsuarioCL AmigoFk2;

    public UsuarioCL getAmigoFk2() {
        return AmigoFk2;
    }

    public void setAmigoFk2(UsuarioCL AmigoFk2) {
        this.AmigoFk2 = AmigoFk2;
    }

    public AmigoCL(UsuarioCL AmigoFk1, UsuarioCL AmigoFk2) {
        this.AmigoFk1 = AmigoFk1;
        this.AmigoFk2 = AmigoFk2;
    }
}
