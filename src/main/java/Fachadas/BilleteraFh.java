/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fachadas;

import DaoGenerico.ConexionException;
import DaoGenerico.ServiceImpl;
import DaoGenerico.SingletonConnection;
import DatoClases.BilleteraCL;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author MARIO
 */
public class BilleteraFh extends ServiceImpl<BilleteraCL> {

    public BilleteraFh() throws ConexionException {
        super(BilleteraCL.class);
        try {
            EntityManager objetoEnty = SingletonConnection.getConnection();
            super.setEntityManager(objetoEnty);

        } catch (Exception e) {
            throw new ConexionException("Problemas en la realizacion de conexion con la base de datos en BilleteraFh Fachada");
        }
    }

    @Override
    public List<BilleteraCL> buscarTodoObj() {
        return super.buscarTodoObj();
    }

}
