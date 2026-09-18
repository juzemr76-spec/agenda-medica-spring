package br.com.agendamedica.service;

import br.com.agendamedica.model.Consulta;
import br.com.agendamedica.repository.ConsultaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    private final ConsultaRepository repository;

    public ConsultaService(ConsultaRepository repository) {
        this.repository = repository;
    }

    public List<Consulta> listarTodas() {
        return repository.findAll();
    }

    public Consulta buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Consulta salvar(Consulta consulta) {
        return repository.save(consulta);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}