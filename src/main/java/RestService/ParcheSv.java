/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestService;

import DTO.ParcheDTO;
import DaoGenerico.ConexionException;
import DatoClases.ParcheCL;
import Fachadas.ParcheFh;
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
@Path("/ParcheSv")
public class ParcheSv {

    ParcheFh objetoFH = null;
    ParcheDTO dto = null;

    ////Buscar Todo
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<ParcheDTO> getListaDto_JSON() throws ConexionException {
        objetoFH = new ParcheFh();
        List<ParcheCL> objetoCl = objetoFH.buscarTodoObj();
        List<ParcheDTO> objetoDTO = new ArrayList<ParcheDTO>();
        for (ParcheCL objetoCLS : objetoCl) {
            dto = new ParcheDTO(objetoCLS);
            objetoDTO.add(dto);
        }
        return objetoDTO;
    }

    ////BusCAr Por Id
    @GET
    @Path("/{ID}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ParcheDTO buscarObjeto(@PathParam("ID") String id) throws ConexionException {
        objetoFH = new ParcheFh();
        ParcheCL objetoCLS = objetoFH.busacarObj(Integer.parseInt(id));
        dto = new ParcheDTO(objetoCLS);
        return dto;
    }

    /////Crear Objeto
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ParcheDTO addObjeto(ParcheDTO objetoDto) throws ConexionException {

        objetoFH = new ParcheFh();
        ParcheCL objetoCLS = new ParcheCL();

        objetoCLS.setClave(objetoDto.getClave());
        objetoCLS.setNombre(objetoDto.getNombre());
        objetoCLS.setDescripcion(objetoDto.getDescripcion());
        objetoCLS.setValorObjetivo(objetoDto.getValorObjetivo());
        objetoCLS.setMonto(objetoDto.getMonto());
        objetoCLS.setEstado(objetoDto.isEstado());

        objetoFH.crearObj(objetoCLS);
        return dto;
    }

    ////Actualizar Objeto
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ParcheDTO actualizarObjeto(ParcheDTO objetoDto) throws ConexionException {

        objetoFH = new ParcheFh();
        ParcheCL objetoCLS = new ParcheCL();
        objetoCLS.setID_Parche(objetoDto.getID_Parche());
        objetoCLS.setClave(objetoDto.getClave());
        objetoCLS.setNombre(objetoDto.getNombre());
        objetoCLS.setDescripcion(objetoDto.getDescripcion());
        objetoCLS.setValorObjetivo(objetoDto.getValorObjetivo());
        objetoCLS.setMonto(objetoDto.getMonto());
        objetoCLS.setEstado(objetoDto.isEstado());

        objetoFH.actualizarObj(objetoCLS);
        return dto;
    }

    ///////Eliminar Objeto
    @DELETE
    @Path("/{ID}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteStudent(@PathParam("ID") String id) throws ConexionException {

        objetoFH = new ParcheFh();
        ParcheCL objetoCLS = objetoFH.busacarObj(Integer.parseInt(id));
        objetoFH.eliminarObje(objetoCLS);
    }

}
