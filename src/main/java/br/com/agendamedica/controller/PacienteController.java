package br.com.agendamedica.controller;

import br.com.agendamedica.model.Paciente;
import br.com.agendamedica.service.PacienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService service;

    public PacienteController(PacienteService service) {
        this.service = service;
    }

    // Lista todos os pacientes
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("pacientes", service.listarTodos());
        return "pacientes/lista";
    }

    // Abre formulário para novo paciente
    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("paciente", new Paciente());
        return "pacientes/formulario";
    }

    // Salva novo paciente ou atualiza paciente existente
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Paciente paciente) {
        service.salvar(paciente);
        return "redirect:/pacientes";
    }

    // Edita paciente
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {

        Paciente paciente = service.buscarPorId(id);

        if (paciente == null) {
            return "redirect:/pacientes";
        }

        model.addAttribute("paciente", paciente);

        return "pacientes/formulario";
    }

    // Exclui paciente
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {

        service.excluir(id);

        return "redirect:/pacientes";
    }

    // Abre os detalhes do paciente
    @GetMapping("/{id}")
    public String detalhes(@PathVariable Long id, Model model) {

        Paciente paciente = service.buscarPorId(id);

        if (paciente == null) {
            return "redirect:/pacientes";
        }

        model.addAttribute("paciente", paciente);

        return "pacientes/detalhes";
    }
}

