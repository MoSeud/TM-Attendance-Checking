package com.redsea.mas.controller;


import com.redsea.mas.domain.TmCheckRetreat;
import com.redsea.mas.dto.TmCheckRetreatDto;
import com.redsea.mas.serviceImpl.TmCheckRetreatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/tm")

public class TmController {

	@Autowired
	private TmCheckRetreatService tmCheckRetreatService;


	@RequestMapping("/retreatCreate")
	public String display(Model model, @RequestParam(value = "id", required = false) Long id) {
		// @ModelAttribute("record") TmCheckRetreatDto record
		if (id == null) {
			model.addAttribute("tmCheckRetreatDto", new TmCheckRetreatDto());
		} else {
			model.addAttribute("tmCheckRetreatDto", tmCheckRetreatService.findTmCheckRetreatById(id));	
		}
		List<TmCheckRetreat> list = findRetreat(null, null);
		model.addAttribute("list", list);

		return "admin/tmcheck";
	}

	@PostMapping("/retreatCreate")
	public String save(@Valid TmCheckRetreatDto dto, BindingResult br, Model model) {
		if (br.hasErrors()) {
			return "admin/tmcheck";
		}
		tmCheckRetreatService.saveTmCheckRetreat(dto);
		return "redirect:/tm/retreatCreate";
	}



	@RequestMapping("/retreatList")
	public String search(

			Model model) {
		List<TmCheckRetreat> list = findRetreat(null, null);
		model.addAttribute("list", list);
		return "admin/tmcheck";
	}

	private List<TmCheckRetreat> findRetreat(LocalDate startDate, LocalDate endDate) {
		if (startDate == null) {
			startDate = LocalDate.now().minusYears(10);
		}
		if (endDate == null) {
			endDate = LocalDate.now().plusYears(10);
		}
		List<TmCheckRetreat> list = tmCheckRetreatService.findTmCheckRetreatByDate(startDate, endDate);
		return list;
	}

	@PostMapping("/retreatDelete")
	public String retreatDelete(@RequestParam("id") Long id) {
		tmCheckRetreatService.removeTmCheckRetreat(id);
		return "redirect:/tm/retreatList";
	}



}
