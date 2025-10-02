package com.itccloud.mwccdc.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.itccloud.mwccdc.data.CSVFileParser;
import com.itccloud.mwccdc.data.Person;

@Controller	
public class HomeController {

	@GetMapping("/persons")
	public String persons(Model model) throws FileNotFoundException, IOException {			
		model.addAttribute("message","Hello there");
		//Uses previously created code
		List<Person> persons = CSVFileParser.readCsv();
		model.addAttribute("persons", persons);

		return "persons";
	}
	
	@GetMapping("/")
	public String home(Model model) {
		return "home-form";
	}
	
	@GetMapping("/business1")
	public String business1(Model model) {
		return "business1-form";
	}
	
	@GetMapping("/bootstrap-home")
	public String bootstrapHome(Model model) {
		return "bootstrap-home-form";
	}
	
	@GetMapping("/bootstrap-feature1")
	public String bootstrapFeature1(Model model) {
		return "bootstrap-feature1-form";
	}
	
	
}
