package br.com.agendamedica.controller;

import br.com.agendamedica.model.Consulta;
import br.com.agendamedica.model.Paciente;
import br.com.agendamedica.service.ConsultaService;
import br.com.agendamedica.service.PacienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/consultas")
public class ConsultaController {

    private final ConsultaService consultaService;
    private final PacienteService pacienteService;

    public ConsultaController(
            ConsultaService consultaService,
            PacienteService pacienteService) {

        this.consultaService = consultaService;
        this.pacienteService = pacienteService;
    }

    @GetMapping
    public String listar(Model model) {

        model.addAttribute(
                "consultas",
                consultaService.listarTodas()
        );

        return "consultas/lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {

        model.addAttribute("consulta", new Consulta());
        model.addAttribute(
                "pacientes",
                pacienteService.listarTodos()
        );

        return "consultas/formulario";
    }

    @PostMapping("/salvar")
    public String salvar(
            @ModelAttribute Consulta consulta,
            @RequestParam("paciente.id") Long pacienteId) {

        Paciente paciente = pacienteService.buscarPorId(pacienteId);

        if (paciente == null) {
            return "redirect:/consultas/novo";
        }

        consulta.setPaciente(paciente);

        if (consulta.getStatus() == null ||
                consulta.getStatus().isBlank()) {

            consulta.setStatus("Agendada");
        }

        consultaService.salvar(consulta);

        return "redirect:/consultas";
    }

    @GetMapping("/editar/{id}")
    public String editar(
            @PathVariable Long id,
            Model model) {

        Consulta consulta = consultaService.buscarPorId(id);

        if (consulta == null) {
            return "redirect:/consultas";
        }

        model.addAttribute("consulta", consulta);
        model.addAttribute(
                "pacientes",
                pacienteService.listarTodos()
        );

        return "consultas/formulario";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {

        consultaService.excluir(id);

        return "redirect:/consultas";
    }
}