/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fachadas;

import DaoGenerico.ConexionException;
import DaoGenerico.ServiceImpl;
import DaoGenerico.SingletonConnection;
import DatoClases.UsuarioCL;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author MARIO
 */
public class UsuarioFh extends ServiceImpl<UsuarioCL> {

    public UsuarioFh() throws ConexionException {
        super(UsuarioCL.class);
        try {
            EntityManager objetoEnty = SingletonConnection.getConnection();
            super.setEntityManager(objetoEnty);

        } catch (Exception e) {
            throw new ConexionException("Problemas en la realizacion de conexion con la base de datos en UsuarioFh Fachada");
        }
    }

    @Override
    public List<UsuarioCL> buscarTodoObj() {
        return super.buscarTodoObj();
    }

}
