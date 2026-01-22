package uce.edu.web.api.matricula.interfaces;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import uce.edu.web.api.matricula.aplication.MateriaService;
import uce.edu.web.api.matricula.domain.Materia;

import java.util.List;

@Path("/materias")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MateriaResource {

    @Inject
    MateriaService materiaService;

    @GET
    @Path("")
    public List<Materia> listar() {
        return materiaService.listarTodos();
    }

    @GET
    @Path("/{id}")
    public Materia buscar(@PathParam("id") Integer id) {
        return materiaService.consultarById(id);
    }

    @POST
    @Path("")
    public void crear(Materia materia) {
        materiaService.crear(materia);
    }

    @PUT
    @Path("/{id}")
    public void actualizar(
            @PathParam("id") Integer id,
            Materia materia) {
        materiaService.actualizar(id, materia);
    }

    @PATCH
    @Path("/{id}")
    public void actualizarParcial(
            @PathParam("id") Integer id,
            Materia materia) {
        materiaService.actualizarParcial(id, materia);
    }

    @DELETE
    @Path("/{id}")
    public void eliminar(@PathParam("id") Integer id) {
        materiaService.eliminar(id);
    }

    // ---------- NUEVOS ENDPOINTS ----------

    // 1. Materias activas
    @GET
    @Path("/activas")
    public List<Materia> listarActivas() {
        return materiaService.listarActivas();
    }

    // 2. Buscar por nombre
    @GET
    @Path("/buscar/{nombre}")
    public List<Materia> buscarPorNombre(
            @PathParam("nombre") String nombre) {
        return materiaService.buscarPorNombre(nombre);
    }

}
