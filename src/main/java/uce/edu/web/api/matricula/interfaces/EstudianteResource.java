package uce.edu.web.api.matricula.interfaces;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import uce.edu.web.api.matricula.aplication.EstudianteService;
import uce.edu.web.api.matricula.domain.Estudiante;

import java.util.List;

@Path("/estudiantes")
@Produces(MediaType.APPLICATION_JSON)
public class EstudianteResource {
    @Inject
    private EstudianteService estudianteService;

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Estudiante> listarTodos() {
        System.out.println("ListarTODOSXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        return this.estudianteService.listarTodos();
    }

    @GET
    @Path("/{id}")
    public Estudiante consultarbyId(@PathParam("id") Integer id) {
        return this.estudianteService.consultarbyId(id);
    }

    @POST
    @Path("")
    public Response registrar(Estudiante estudiante) {
        this.estudianteService.crear(estudiante);
        return Response.status(Response.Status.CREATED).entity(estudiante).build();
    }

    @PUT
    @Path("/{id}")
    public Response actualizar(@PathParam("id") Integer id,Estudiante estudiante) {
        this.estudianteService.actualizar(id,estudiante);
        return Response.status(209).entity(estudiante).build();
    }

    @PATCH
    @Path("/{id}")
    public void actualizarParcial(@PathParam("id") Integer id, Estudiante estudiante) {
        this.estudianteService.actualizarParcial(id,estudiante);
    }

    @DELETE
    @Path("/{id}")
    public void eliminar(@PathParam("id") Integer id) {
        this.estudianteService.eliminar(id);
    }

    @GET
    @Path("/provincia/genero")
    @Produces(MediaType.APPLICATION_XML)
    public List<Estudiante> buscarPorProvincia(@QueryParam("provincia") String provincia, @QueryParam("genero") String genero) {
        System.out.println("ListarPorProvincia");
        return this.estudianteService.buscarPorProvincia(provincia, genero);
    }
}
