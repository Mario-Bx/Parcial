/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import DatoClases.BilleteraCL;
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
@XmlRootElement(name = "BilleteraDTO")
@XmlAccessorType(XmlAccessType.FIELD)
public class BilleteraDTO {

    private int ID_Billetera;
    private Double monto;
    private UsuarioDTO UsuarioFk;
    private List<TransferenciaDTO> list_BilleteraOrigen;
    private List<TransferenciaDTO> list_BilleteraDestino;

    public BilleteraDTO() {
    }

    public BilleteraDTO(BilleteraCL objCL) {
        this.ID_Billetera = objCL.getID_Billetera();
        this.monto = objCL.getMonto();
        if (objCL.getUsuarioFk() != null) {
            this.UsuarioFk = new UsuarioDTO(objCL.getUsuarioFk());
        }
        this.list_BilleteraDestino = new ArrayList<TransferenciaDTO>();
        this.list_BilleteraOrigen = new ArrayList<TransferenciaDTO>();

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

    public UsuarioDTO getUsuarioFk() {
        return UsuarioFk;
    }

    public void setUsuarioFk(UsuarioDTO UsuarioFk) {
        this.UsuarioFk = UsuarioFk;
    }

    public List<TransferenciaDTO> list_BilleteraOrigen(List<TransferenciaCL> list_Objs) {
        for (TransferenciaCL list_Obj : list_Objs) {
            TransferenciaDTO dTO = new TransferenciaDTO(list_Obj);
            this.list_BilleteraOrigen.add(dTO);
        }
        return this.list_BilleteraOrigen;
    }

    public List<TransferenciaDTO> list_BilleteraDestino(List<TransferenciaCL> list_Objs) {
        for (TransferenciaCL list_Obj : list_Objs) {
            TransferenciaDTO dTO = new TransferenciaDTO(list_Obj);
            this.list_BilleteraDestino.add(dTO);
        }
        return this.list_BilleteraDestino;
    }

}
