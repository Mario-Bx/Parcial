/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fachadas;

import DaoGenerico.ConexionException;
import DaoGenerico.ServiceImpl;
import DaoGenerico.SingletonConnection;
import DatoClases.GrupoCL;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author MARIO
 */
public class GrupoFh extends ServiceImpl<GrupoCL> {

    public GrupoFh() throws ConexionException {
        super(GrupoCL.class);
        try {
            EntityManager objetoEnty = SingletonConnection.getConnection();
            super.setEntityManager(objetoEnty);

        } catch (Exception e) {
            throw new ConexionException("Problemas en la realizacion de conexion con la base de datos en GrupoFh Fachada");
        }
    }

    @Override
    public List<GrupoCL> buscarTodoObj() {
        return super.buscarTodoObj();
    }

}
