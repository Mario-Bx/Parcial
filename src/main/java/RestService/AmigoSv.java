/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestService;

import DTO.AmigoDTO;
import DaoGenerico.ConexionException;
import DatoClases.AmigoCL;
import DatoClases.ParcheCL;
import DatoClases.UsuarioCL;
import Fachadas.AmigoFh;
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
@Path("/AmigoSv")
public class AmigoSv {

    AmigoFh objetoFH = null;
    UsuarioFh objetoFH2 = null;
    UsuarioFh objetoFH3 = null;
    AmigoDTO dto = null;

    ////Buscar Todo
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<AmigoDTO> getListaDto_JSON() throws ConexionException {
        objetoFH = new AmigoFh();
        List<AmigoCL> objetoCl = objetoFH.buscarTodoObj();
        List<AmigoDTO> objetoDTO = new ArrayList<AmigoDTO>();
        for (AmigoCL objetoCLS : objetoCl) {
            dto = new AmigoDTO(objetoCLS);
            objetoDTO.add(dto);
        }
        return objetoDTO;
    }

    ////BusCAr Por Id
    @GET
    @Path("/{ID}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public AmigoDTO buscarObjeto(@PathParam("ID") String id) throws ConexionException {
        objetoFH = new AmigoFh();
        AmigoCL objetoCLS = objetoFH.busacarObj(Integer.parseInt(id));
        dto = new AmigoDTO(objetoCLS);
        return dto;
    }

    /////Crear Objeto
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public AmigoDTO addObjeto(AmigoDTO objetoDto) throws ConexionException {

        objetoFH = new AmigoFh();
        AmigoCL objetoCLS = new AmigoCL();

        objetoFH2 = new UsuarioFh();
        UsuarioCL objetoCLS2 = objetoFH2.busacarObj(objetoDto.getAmigoFk1().getID_Usuario());
        objetoCLS.setAmigoFk1(objetoCLS2);

        objetoFH3 = new UsuarioFh();
        UsuarioCL objetoCLS3 = objetoFH3.busacarObj(objetoDto.getAmigoFk2().getID_Usuario());
        objetoCLS.setAmigoFk2(objetoCLS3);

        objetoFH.crearObj(objetoCLS);
        return dto;
    }

    ////Actualizar Objeto
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public AmigoDTO actualizarObjeto(AmigoDTO objetoDto) throws ConexionException {

        objetoFH = new AmigoFh();
        AmigoCL objetoCLS = new AmigoCL();
        objetoCLS.setID_Amigo(objetoDto.getID_Amigo());

        objetoFH2 = new UsuarioFh();
        UsuarioCL objetoCLS2 = objetoFH2.busacarObj(objetoDto.getAmigoFk1().getID_Usuario());
        objetoCLS.setAmigoFk1(objetoCLS2);

        objetoFH3 = new UsuarioFh();
        UsuarioCL objetoCLS3 = objetoFH3.busacarObj(objetoDto.getAmigoFk2().getID_Usuario());
        objetoCLS.setAmigoFk2(objetoCLS3);

        objetoFH.actualizarObj(objetoCLS);
        return dto;
    }

    ///////Eliminar Objeto
    @DELETE
    @Path("/{ID}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteStudent(@PathParam("ID") String id) throws ConexionException {

        objetoFH = new AmigoFh();
        AmigoCL objetoCLS = objetoFH.busacarObj(Integer.parseInt(id));
        objetoFH.eliminarObje(objetoCLS);
    }

}
