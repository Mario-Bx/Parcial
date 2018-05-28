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
@Table(name = "BILLETERA")
public class BilleteraCL implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_Billetera;

    private Double monto;

    public BilleteraCL() {
    }

    public BilleteraCL(Double monto) {
        this.monto = monto;
    }

    public int getID_Billetera() {
        return ID_Billetera;
    }

    public void setID_Billetera(int ID_Billetera) {
        this.ID_Billetera = ID_Billetera;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "BilleteraCL{" + "ID_Billetera=" + ID_Billetera + ", monto=" + monto + ", UsuarioFk=" + UsuarioFk + '}';
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

    public BilleteraCL(Double monto, UsuarioCL UsuarioFk) {
        this.monto = monto;
        this.UsuarioFk = UsuarioFk;
    }

    @OneToMany(mappedBy = "billeteraOFK", cascade = CascadeType.ALL)
    private List<TransferenciaCL> list_BilleteraOrigen;

    @OneToMany(mappedBy = "billeteraDFK", cascade = CascadeType.ALL)
    private List<TransferenciaCL> list_BilleteraDestino;

    public List<TransferenciaCL> getList_BilleteraOrigen() {
        return list_BilleteraOrigen;
    }

    public void setList_BilleteraOrigen(List<TransferenciaCL> list_BilleteraOrigen) {
        this.list_BilleteraOrigen = list_BilleteraOrigen;
    }

    public List<TransferenciaCL> getList_BilleteraDestino() {
        return list_BilleteraDestino;
    }

    public void setList_BilleteraDestino(List<TransferenciaCL> list_BilleteraDestino) {
        this.list_BilleteraDestino = list_BilleteraDestino;
    }

}
