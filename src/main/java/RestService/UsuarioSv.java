/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestService;

import DTO.UsuarioDTO;
import DaoGenerico.ConexionException;
import DatoClases.UsuarioCL;
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
@Path("/UsuarioSv")
public class UsuarioSv {
    UsuarioFh objetoFH = null;
    UsuarioDTO dto = null;

    ////Buscar Todo
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<UsuarioDTO> getListaDto_JSON() throws ConexionException {
        objetoFH = new UsuarioFh();
        List<UsuarioCL> objetoCl = objetoFH.buscarTodoObj();
        List<UsuarioDTO> objetoDTO = new ArrayList<UsuarioDTO>();
        for (UsuarioCL objetoCLS : objetoCl) {
            dto = new UsuarioDTO(objetoCLS);
            objetoDTO.add(dto);
        }
        return objetoDTO;
    }

    ////BusCAr Por Id
    @GET
    @Path("/{ID}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public UsuarioDTO buscarObjeto(@PathParam("ID") String id) throws ConexionException {
        objetoFH = new UsuarioFh();
        UsuarioCL objetoCLS = objetoFH.busacarObj(Integer.parseInt(id));
        dto = new UsuarioDTO(objetoCLS);
        //dto.List_Amigos(objetoCLS.getList_Amisgos());
        //dto.List_Billeteras(objetoCLS.getList_Billetera());
        //dto.List_Grupos(objetoCLS.getList_Grupos());
        return dto;
    }

    /////Crear Objeto
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public UsuarioDTO addObjeto(UsuarioDTO objetoDto) throws ConexionException {

        objetoFH = new UsuarioFh();
        UsuarioCL objetoCLS = new UsuarioCL();

        objetoCLS.setNombre(objetoDto.getNombre());

        objetoFH.crearObj(objetoCLS);
        return dto;
    }

    ////Actualizar Objeto
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public UsuarioDTO actualizarObjeto(UsuarioDTO objetoDto) throws ConexionException {

        objetoFH = new UsuarioFh();
        UsuarioCL objetoCLS = new UsuarioCL();
        objetoCLS.setID_Usuario(objetoDto.getID_Usuario());
        objetoCLS.setNombre(objetoDto.getNombre());

        objetoFH.actualizarObj(objetoCLS);
        return dto;
    }

    ///////Eliminar Objeto
    @DELETE
    @Path("/{ID}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteStudent(@PathParam("ID") String id) throws ConexionException {

        objetoFH = new UsuarioFh();
        UsuarioCL objetoCLS = objetoFH.busacarObj(Integer.parseInt(id));
        objetoFH.eliminarObje(objetoCLS);
    }
}
