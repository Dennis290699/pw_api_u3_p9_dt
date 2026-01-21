package uce.edu.web.api.matricula.aplication;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.POST;
import uce.edu.web.api.matricula.domain.Estudiante;
import uce.edu.web.api.matricula.infrastructure.EstudianteRepository;

import java.util.List;

@ApplicationScoped
public class EstudianteService {

    @Inject
    EstudianteRepository estudianteRepository;

    public List<Estudiante> listarTodos(){
        return this.estudianteRepository.listAll();
    }

    public Estudiante consultarbyId(Integer id){
        return this.estudianteRepository.findById(id.longValue());
    }

    @Transactional
    public void crear(Estudiante estudiante){
        this.estudianteRepository.persist(estudiante);
    }

    @Transactional
    public void actualizar(Integer id,Estudiante est){
        Estudiante estudiante = this.consultarbyId(id);
        estudiante.apellido = est.apellido;
        estudiante.nombre = est.nombre;
        estudiante.fechaNacimiento = est.fechaNacimiento;
    }

    @Transactional
    public void actualizarParcial(Integer id, Estudiante est) {
        Estudiante estudiante = this.consultarbyId(id);
        if (est.nombre != null) {
            estudiante.nombre = est.nombre;
        }
        if (est.apellido != null) {
            estudiante.apellido = est.apellido;
        }
        if (est.fechaNacimiento != null) {
            estudiante.fechaNacimiento = est.fechaNacimiento;
        }
    }

    @Transactional
    public void eliminar(Integer id){
        this.estudianteRepository.deleteById(id.longValue());
    }

    public List<Estudiante> buscarPorProvincia(String provincia, String genero) {
        return this.estudianteRepository.find("provincia = ?1 and genero = ?2", provincia,genero).list();
    }
}
