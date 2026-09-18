package br.com.agendamedica.config;

import br.com.agendamedica.model.Consulta;
import br.com.agendamedica.model.Paciente;
import br.com.agendamedica.repository.ConsultaRepository;
import br.com.agendamedica.repository.PacienteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DadosIniciais implements CommandLineRunner {

    private final PacienteRepository pacienteRepository;
    private final ConsultaRepository consultaRepository;

    public DadosIniciais(
            PacienteRepository pacienteRepository,
            ConsultaRepository consultaRepository) {

        this.pacienteRepository = pacienteRepository;
        this.consultaRepository = consultaRepository;
    }

    @Override
    public void run(String... args) {

        // Não cria dados novamente se o banco já possuir pacientes.
        if (pacienteRepository.count() > 0) {
            return;
        }

        Paciente paciente1 = new Paciente();
        paciente1.setNome("Maria da Silva");
        paciente1.setCpf("123.456.789-00");
        paciente1.setDataNascimento("1985-03-15");
        paciente1.setTelefone("(89) 99999-1111");
        paciente1.setEndereco("Rua Principal, 100");

        paciente1 = pacienteRepository.save(paciente1);

        Paciente paciente2 = new Paciente();
        paciente2.setNome("João Santos");
        paciente2.setCpf("987.654.321-00");
        paciente2.setDataNascimento("1990-08-20");
        paciente2.setTelefone("(89) 98888-2222");
        paciente2.setEndereco("Rua Central, 200");

        paciente2 = pacienteRepository.save(paciente2);

        Consulta consulta1 = new Consulta();
        consulta1.setPaciente(paciente1);
        consulta1.setData("2026-09-20");
        consulta1.setHorario("08:00");
        consulta1.setEspecialidade("Clínico Geral");
        consulta1.setProfissional("Dr. Carlos Oliveira");
        consulta1.setStatus("Agendada");
        consulta1.setObservacao("Consulta de rotina.");

        consultaRepository.save(consulta1);

        Consulta consulta2 = new Consulta();
        consulta2.setPaciente(paciente2);
        consulta2.setData("2026-09-21");
        consulta2.setHorario("14:00");
        consulta2.setEspecialidade("Cardiologia");
        consulta2.setProfissional("Dra. Ana Souza");
        consulta2.setStatus("Agendada");
        consulta2.setObservacao("Avaliação cardiológica.");

        consultaRepository.save(consulta2);
    }
}

