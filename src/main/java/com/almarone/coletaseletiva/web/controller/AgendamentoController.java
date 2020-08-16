package com.almarone.coletaseletiva.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.almarone.coletaseletiva.web.domain.Agendamento;
import com.almarone.coletaseletiva.web.services.AgendamentoService;



@Controller
@RequestMapping("/agendamento")
public class AgendamentoController {
	@Autowired
	private AgendamentoService service;

	@GetMapping("/cadastrar")
	public String cadastrar(Agendamento agendamento) {
		return "agendamento/cadastro_agendamento";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("agendamentos", service.findAll());
		return "agendamento/lista_agentamento";
	}
	@PostMapping("/salvar")
	public String salvar(Agendamento agendamento, RedirectAttributes attr) {
		service.save(agendamento);
		attr.addFlashAttribute("success", "agendamento adicionado com sucesso!");
		return "redirect:/agendamento/cadastrar";
	}
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("agendamento", service.findById(id));
		return "/agendamento/cadastro_agendamento";
	}
	@PostMapping("/editar")
	public String editar(Agendamento agendamento, RedirectAttributes attr) {
		service.update(agendamento);
		attr.addFlashAttribute("success", "Agendamento alterado com sucesso");
		return "redirect:/agendamento/listar";
	}
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.delete(id);
		model.addAttribute("success", "Agendamento removido com sucesso");
		return listar(model);
	}
	
}
