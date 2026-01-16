package uce.edu.web.api.matricula.aplication;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
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
}
