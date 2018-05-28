/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import DatoClases.TransferenciaCL;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MARIO
 */
@XmlRootElement(name = "TransferenciaDTO")
@XmlAccessorType(XmlAccessType.FIELD)
public class TransferenciaDTO {

    private int ID_Transferencia;
    private Double monto;
    private BilleteraDTO billeteraOFK;
    private BilleteraDTO billeteraDFK;
    private ParcheDTO parcheOFk;
    private ParcheDTO parcheDFk;

    public TransferenciaDTO() {
    }

    public TransferenciaDTO(TransferenciaCL objCL) {
        this.ID_Transferencia = objCL.getID_Transferencia();
        this.monto = objCL.getMonto();
        if (objCL.getBilleteraOFK() != null) {
            this.billeteraOFK = new BilleteraDTO(objCL.getBilleteraOFK());
        } else {
            this.billeteraDFK = new BilleteraDTO(objCL.getBilleteraDFK());
        }
         if (objCL.getParcheOFk() != null) {
            this.parcheOFk = new ParcheDTO(objCL.getParcheOFk());
        } else {
            this.parcheDFk = new ParcheDTO(objCL.getParcheDFk());
        }
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

    public BilleteraDTO getBilleteraOFK() {
        return billeteraOFK;
    }

    public void setBilleteraOFK(BilleteraDTO billeteraOFK) {
        this.billeteraOFK = billeteraOFK;
    }

    public BilleteraDTO getBilleteraDFK() {
        return billeteraDFK;
    }

    public void setBilleteraDFK(BilleteraDTO billeteraDFK) {
        this.billeteraDFK = billeteraDFK;
    }

    public ParcheDTO getParcheOFk() {
        return parcheOFk;
    }

    public void setParcheOFk(ParcheDTO parcheOFk) {
        this.parcheOFk = parcheOFk;
    }

    public ParcheDTO getParcheDFk() {
        return parcheDFk;
    }

    public void setParcheDFk(ParcheDTO parcheDFk) {
        this.parcheDFk = parcheDFk;
    }

}
