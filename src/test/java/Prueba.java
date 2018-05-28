
import DaoGenerico.ConexionException;
import DatoClases.*;
import Fachadas.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author MARIO
 */
public class Prueba {

    public static void main(String[] args) throws ConexionException {
        UsuarioFh uf = new UsuarioFh();
        AmigoFh af = new AmigoFh();
        GrupoFh gf = new GrupoFh();
        ParcheFh pf = new ParcheFh();
        BilleteraFh bf = new BilleteraFh();
        TransferenciaFh tf = new TransferenciaFh();

        System.err.println(uf.buscarTodoObj());
//        System.out.println(af.buscarTodoObj());
//        System.out.println(gf.buscarTodoObj());
//        System.out.println(pf.buscarTodoObj());
//        System.out.println(bf.buscarTodoObj());
//        System.out.println(tf.buscarTodoObj());

    }
}
