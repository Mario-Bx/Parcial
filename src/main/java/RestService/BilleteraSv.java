/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestService;

import DTO.BilleteraDTO;
import DaoGenerico.ConexionException;
import DatoClases.BilleteraCL;
import DatoClases.ParcheCL;
import DatoClases.UsuarioCL;
import Fachadas.BilleteraFh;
import Fachadas.ParcheFh;
import Fachadas.UsuarioFh;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author MARIO
 */
@Path("/BilleteraSv")
public class BilleteraSv {

    BilleteraFh objetoFH = null;
    UsuarioFh objetoFH2 = null;
    BilleteraDTO dto = null;

    ////Buscar Todo
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<BilleteraDTO> getListaDto_JSON() throws ConexionException {
        objetoFH = new BilleteraFh();
        List<BilleteraCL> objetoCl = objetoFH.buscarTodoObj();
        List<BilleteraDTO> objetoDTO = new ArrayList<BilleteraDTO>();
        for (BilleteraCL objetoCLS : objetoCl) {
            dto = new BilleteraDTO(objetoCLS);
            objetoDTO.add(dto);
        }
        return objetoDTO;
    }

    ////BusCAr Por Id
    @GET
    @Path("/{ID}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public BilleteraDTO buscarObjeto(@PathParam("ID") String id) throws ConexionException {
        objetoFH = new BilleteraFh();
        BilleteraCL objetoCLS = objetoFH.busacarObj(Integer.parseInt(id));
        dto = new BilleteraDTO(objetoCLS);
        return dto;
    }

    /////Crear Objeto
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public BilleteraDTO addObjeto(BilleteraDTO objetoDto) throws ConexionException {

        objetoFH = new BilleteraFh();
        BilleteraCL objetoCLS = new BilleteraCL();
        objetoCLS.setMonto(objetoDto.getMonto());

        objetoFH2 = new UsuarioFh();
        UsuarioCL objetoCLS2 = new UsuarioCL();
        objetoCLS2.setNombre(objetoDto.getUsuarioFk().getNombre());
        
        objetoCLS.setUsuarioFk(objetoCLS2);
        System.out.println("###################");
        System.out.println(objetoCLS);
        System.out.println("###################");
        objetoFH.crearObj(objetoCLS);
        return dto;
    }

    ////Actualizar Objeto
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public BilleteraDTO actualizarObjeto(BilleteraDTO objetoDto) throws ConexionException {

        objetoFH = new BilleteraFh();
        BilleteraCL objetoCLS = new BilleteraCL();
        objetoCLS.setID_Billetera(objetoDto.getID_Billetera());

        objetoFH2 = new UsuarioFh();
        UsuarioCL objetoCLS2 = objetoFH2.busacarObj(objetoDto.getUsuarioFk().getID_Usuario());
        objetoCLS.setUsuarioFk(objetoCLS2);

        objetoFH.actualizarObj(objetoCLS);
        return dto;
    }

    ///////Eliminar Objeto
    @DELETE
    @Path("/{ID}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteStudent(@PathParam("ID") String id) throws ConexionException {

        objetoFH = new BilleteraFh();
        BilleteraCL objetoCLS = objetoFH.busacarObj(Integer.parseInt(id));
        objetoFH.eliminarObje(objetoCLS);
    }
}
