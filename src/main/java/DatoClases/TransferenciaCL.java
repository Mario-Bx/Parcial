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
@Table(name = "TRANSFERENCIA")
public class TransferenciaCL implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_Transferencia;

    private Double monto;

    public TransferenciaCL() {
    }

    public TransferenciaCL(Double monto) {
        this.monto = monto;
    }

    public int getID_Transferencia() {
        return ID_Transferencia;
    }

    public void setID_Transferencia(int ID_Transferencia) {
        this.ID_Transferencia = ID_Transferencia;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "TransferenciaCL{" + "ID_Deporte=" + ID_Transferencia + ", monto=" + monto + ", tipo=" +  parcheOFk + ", parcheDFk=" + parcheDFk + ", billeteraOFK=" + billeteraOFK + ", billeteraDFK=" + billeteraDFK + '}';
    }

    @ManyToOne
    @JoinColumn(name = "billeteraOFK")
    private BilleteraCL billeteraOFK;

    @ManyToOne
    @JoinColumn(name = "billeteraDFK")
    private BilleteraCL billeteraDFK;

    public BilleteraCL getBilleteraOFK() {
        return billeteraOFK;
    }

    public void setBilleteraOFK(BilleteraCL billeteraOFK) {
        this.billeteraOFK = billeteraOFK;
    }

    public BilleteraCL getBilleteraDFK() {
        return billeteraDFK;
    }

    public void setBilleteraDFK(BilleteraCL billeteraDFK) {
        this.billeteraDFK = billeteraDFK;
    }

    @ManyToOne
    @JoinColumn(name = "parcheOFk")
    private ParcheCL parcheOFk;

    @ManyToOne
    @JoinColumn(name = "parcheDFk")
    private ParcheCL parcheDFk;

    public ParcheCL getParcheOFk() {
        return parcheOFk;
    }

    public void setParcheOFk(ParcheCL parcheOFk) {
        this.parcheOFk = parcheOFk;
    }

    public ParcheCL getParcheDFk() {
        return parcheDFk;
    }

    public void setParcheDFk(ParcheCL parcheDFk) {
        this.parcheDFk = parcheDFk;
    }

}
