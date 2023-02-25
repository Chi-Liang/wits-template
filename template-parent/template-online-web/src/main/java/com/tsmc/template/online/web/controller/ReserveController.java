package com.tsmc.template.online.web.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tsmc.template.common.vo.ReserveVo;

@Controller
@RequestMapping("/auth/reserve")
public class ReserveController {
	
	public static List<ReserveVo> reserveVoList = new ArrayList<>(Arrays.asList(
		new ReserveVo(1L,"中餐","2023-02-12",""),
		new ReserveVo(2L,"上課","2023-02-07 10:00:00","2023-02-07 12:00:00"),
		new ReserveVo(3L,"會議","2023-02-22 09:00:00","2023-02-22 12:00:00") 
    ));
	
	@RequestMapping("/list")
	public String list(Model model) {
		
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		try {
			json = objectMapper.writeValueAsString(reserveVoList);
		} catch (JsonProcessingException e) {
			
		}
		model.addAttribute("reserveList", json);
		return "reserve/list";
	}
	
	@PostMapping("/add")
	public String add(@ModelAttribute ReserveVo reserveVo) {
		ReserveVo reserveVo1 = new ReserveVo(4L,reserveVo.getTitle(),reserveVo.getStart(),"");
		reserveVoList.add(reserveVo1);
		return "redirect:/auth/reserve/list";
	}
	
	@PostMapping("/del")
	public String delete(@ModelAttribute ReserveVo reserveVo) {
		reserveVoList.removeIf(p -> p.getId() == 4L);
		return "redirect:/auth/reserve/list";
	}
	
	
}
