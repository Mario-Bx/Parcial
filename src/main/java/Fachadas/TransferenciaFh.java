/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fachadas;

import DaoGenerico.ConexionException;
import DaoGenerico.ServiceImpl;
import DaoGenerico.SingletonConnection;
import DatoClases.TransferenciaCL;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author MARIO
 */
public class TransferenciaFh extends ServiceImpl<TransferenciaCL> {

    public TransferenciaFh() throws ConexionException {
        super(TransferenciaCL.class);
        try {
            EntityManager objetoEnty = SingletonConnection.getConnection();
            super.setEntityManager(objetoEnty);

        } catch (Exception e) {
            throw new ConexionException("Problemas en la realizacion de conexion con la base de datos en TransferenciaFh Fachada");
        }
    }

    @Override
    public List<TransferenciaCL> buscarTodoObj() {
        return super.buscarTodoObj();
    }

}
