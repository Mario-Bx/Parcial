/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fachadas;

import DaoGenerico.ConexionException;
import DaoGenerico.ServiceImpl;
import DaoGenerico.SingletonConnection;
import DatoClases.ParcheCL;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author MARIO
 */
public class ParcheFh extends ServiceImpl<ParcheCL> {

    public ParcheFh() throws ConexionException {
        super(ParcheCL.class);
        try {
            EntityManager objetoEnty = SingletonConnection.getConnection();
            super.setEntityManager(objetoEnty);

        } catch (Exception e) {
            throw new ConexionException("Problemas en la realizacion de conexion con la base de datos en ParcheFh Fachada");
        }
    }

    @Override
    public List<ParcheCL> buscarTodoObj() {
        return super.buscarTodoObj();
    }

}
