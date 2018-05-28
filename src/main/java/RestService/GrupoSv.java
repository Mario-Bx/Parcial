/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestService;

import DTO.GrupoDTO;
import DaoGenerico.ConexionException;
import DatoClases.GrupoCL;
import DatoClases.ParcheCL;
import DatoClases.UsuarioCL;
import Fachadas.*;
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
@Path("/GrupoSv")
public class GrupoSv {

    GrupoFh objetoFH = null;
    UsuarioFh objetoFH2 = null;
    ParcheFh objetoFH3 = null;
    GrupoDTO dto = null;

    ////Buscar Todo
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<GrupoDTO> getListaDto_JSON() throws ConexionException {
        objetoFH = new GrupoFh();
        List<GrupoCL> objetoCl = objetoFH.buscarTodoObj();
        List<GrupoDTO> objetoDTO = new ArrayList<GrupoDTO>();
        for (GrupoCL objetoCLS : objetoCl) {
            dto = new GrupoDTO(objetoCLS);
            objetoDTO.add(dto);
        }
        return objetoDTO;
    }

    ////BusCAr Por Id
    @GET
    @Path("/{ID}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public GrupoDTO buscarObjeto(@PathParam("ID") String id) throws ConexionException {
        objetoFH = new GrupoFh();
        GrupoCL objetoCLS = objetoFH.busacarObj(Integer.parseInt(id));
        dto = new GrupoDTO(objetoCLS);
        return dto;
    }

    /////Crear Objeto
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public GrupoDTO addObjeto(GrupoDTO objetoDto) throws ConexionException {

        objetoFH = new GrupoFh();
        GrupoCL objetoCLS = new GrupoCL();

        objetoFH2 = new UsuarioFh();
        UsuarioCL objetoCLS2 = objetoFH2.busacarObj(objetoDto.getUsuarioFk().getID_Usuario());
        objetoCLS.setUsuarioFk(objetoCLS2);

        objetoFH3 = new ParcheFh();
        ParcheCL objetoCLS3 = objetoFH3.busacarObj(objetoDto.getParcheFk().getID_Parche());
        objetoCLS.setParcheFk(objetoCLS3);

        objetoFH.crearObj(objetoCLS);
        return dto;
    }

    ////Actualizar Objeto
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public GrupoDTO actualizarObjeto(GrupoDTO objetoDto) throws ConexionException {

        objetoFH = new GrupoFh();
        GrupoCL objetoCLS = new GrupoCL();
        objetoCLS.setID_Grupo(objetoDto.getID_Grupo());

        objetoFH2 = new UsuarioFh();
        UsuarioCL objetoCLS2 = objetoFH2.busacarObj(objetoDto.getUsuarioFk().getID_Usuario());
        objetoCLS.setUsuarioFk(objetoCLS2);

        objetoFH3 = new ParcheFh();
        ParcheCL objetoCLS3 = objetoFH3.busacarObj(objetoDto.getParcheFk().getID_Parche());
        objetoCLS.setParcheFk(objetoCLS3);

        objetoFH.actualizarObj(objetoCLS);
        return dto;
    }

    ///////Eliminar Objeto
    @DELETE
    @Path("/{ID}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteStudent(@PathParam("ID") String id) throws ConexionException {

        objetoFH = new GrupoFh();
        GrupoCL objetoCLS = objetoFH.busacarObj(Integer.parseInt(id));
        objetoFH.eliminarObje(objetoCLS);
    }
}
