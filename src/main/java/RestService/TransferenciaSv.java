/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestService;

import DTO.TransferenciaDTO;
import DaoGenerico.ConexionException;
import DatoClases.BilleteraCL;
import DatoClases.ParcheCL;
import DatoClases.TransferenciaCL;
import Fachadas.BilleteraFh;
import Fachadas.ParcheFh;
import Fachadas.TransferenciaFh;
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
@Path("/TransferenciaSv")
public class TransferenciaSv {

    TransferenciaFh objetoFH = null;
    BilleteraFh objetoFH2 = null;
    BilleteraFh objetoFH3 = null;
    ParcheFh objetoFH4 = null;
    ParcheFh objetoFH5 = null;
    TransferenciaDTO dto = null;

    ////Buscar Todo
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<TransferenciaDTO> getListaDto_JSON() throws ConexionException {
        objetoFH = new TransferenciaFh();
        List<TransferenciaCL> objetoCl = objetoFH.buscarTodoObj();
        List<TransferenciaDTO> objetoDTO = new ArrayList<TransferenciaDTO>();
        for (TransferenciaCL objetoCLS : objetoCl) {
            dto = new TransferenciaDTO(objetoCLS);
            objetoDTO.add(dto);
        }
        return objetoDTO;
    }

    ////BusCAr Por Id
    @GET
    @Path("/{ID}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public TransferenciaDTO buscarObjeto(@PathParam("ID") String id) throws ConexionException {
        objetoFH = new TransferenciaFh();
        TransferenciaCL objetoCLS = objetoFH.busacarObj(Integer.parseInt(id));
        dto = new TransferenciaDTO(objetoCLS);
        return dto;
    }

    /////Crear Objeto
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public TransferenciaDTO addObjeto(TransferenciaDTO objetoDto) throws ConexionException {

        objetoFH = new TransferenciaFh();
        TransferenciaCL objetoCLS = new TransferenciaCL();

        objetoCLS.setMonto(objetoDto.getMonto());

        objetoFH2 = new BilleteraFh();
        BilleteraCL objetoCLS2 = objetoFH2.busacarObj(objetoDto.getBilleteraOFK().getID_Billetera());
        objetoCLS.setBilleteraOFK(objetoCLS2);

        objetoFH3 = new BilleteraFh();
        BilleteraCL objetoCLS3 = objetoFH3.busacarObj(objetoDto.getBilleteraDFK().getID_Billetera());
        objetoCLS.setBilleteraDFK(objetoCLS3);

        objetoFH4 = new ParcheFh();
        ParcheCL objetoCLS4 = objetoFH4.busacarObj(objetoDto.getParcheOFk().getID_Parche());
        objetoCLS.setParcheOFk(objetoCLS4);

        objetoFH5 = new ParcheFh();
        ParcheCL objetoCLS5 = objetoFH5.busacarObj(objetoDto.getParcheDFk().getID_Parche());
        objetoCLS.setParcheDFk(objetoCLS5);

        objetoFH.crearObj(objetoCLS);
        return dto;
    }

    ////Actualizar Objeto
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public TransferenciaDTO actualizarObjeto(TransferenciaDTO objetoDto) throws ConexionException {

        objetoFH = new TransferenciaFh();
        TransferenciaCL objetoCLS = new TransferenciaCL();
        objetoCLS.setID_Transferencia(objetoDto.getID_Transferencia());
        objetoCLS.setMonto(objetoDto.getMonto());

        objetoFH2 = new BilleteraFh();
        BilleteraCL objetoCLS2 = objetoFH2.busacarObj(objetoDto.getBilleteraOFK().getID_Billetera());
        objetoCLS.setBilleteraOFK(objetoCLS2);

        objetoFH3 = new BilleteraFh();
        BilleteraCL objetoCLS3 = objetoFH3.busacarObj(objetoDto.getBilleteraDFK().getID_Billetera());
        objetoCLS.setBilleteraDFK(objetoCLS3);

        objetoFH4 = new ParcheFh();
        ParcheCL objetoCLS4 = objetoFH4.busacarObj(objetoDto.getParcheOFk().getID_Parche());
        objetoCLS.setParcheOFk(objetoCLS4);

        objetoFH5 = new ParcheFh();
        ParcheCL objetoCLS5 = objetoFH5.busacarObj(objetoDto.getParcheDFk().getID_Parche());
        objetoCLS.setParcheDFk(objetoCLS5);

        objetoFH.actualizarObj(objetoCLS);
        return dto;
    }

    ///////Eliminar Objeto
    @DELETE
    @Path("/{ID}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteStudent(@PathParam("ID") String id) throws ConexionException {

        objetoFH = new TransferenciaFh();
        TransferenciaCL objetoCLS = objetoFH.busacarObj(Integer.parseInt(id));
        objetoFH.eliminarObje(objetoCLS);
    }
}
