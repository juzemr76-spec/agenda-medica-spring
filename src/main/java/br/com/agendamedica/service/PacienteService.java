package br.com.agendamedica.service;

import br.com.agendamedica.model.Paciente;
import br.com.agendamedica.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    private final PacienteRepository repository;

    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    public List<Paciente> listarTodos() {
        return repository.findAll();
    }

    public Paciente buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Paciente salvar(Paciente paciente) {
        return repository.save(paciente);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}