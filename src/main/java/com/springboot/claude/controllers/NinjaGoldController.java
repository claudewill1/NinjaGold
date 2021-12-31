package com.springboot.claude.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NinjaGoldController {
	
	
	@GetMapping("/")
	public String index(Model model, HttpSession session) {
		if(session.getAttribute("totalGold") == null) {
			session.setAttribute("totalGold", 0);
		}
		ArrayList<String> messages = new ArrayList<String>();
		if(session.getAttribute("messages") == null) {
			session.setAttribute("messages", messages);
		}
		model.addAttribute("totalGold",session.getAttribute("totalGold"));
		model.addAttribute("messages",session.getAttribute("messages"));
		
		return "index.jsp";
	}
	
	// route for farm 
	@PostMapping("/findGold")
	public String findGold(@RequestParam(value="location") String location, HttpSession session) {
		Random rng = new Random();
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd Y h:mma");
		
		ArrayList<String> messages = (ArrayList<String>)session.getAttribute("messages");
		int goldForTurn;
		
		if(location.equals("farm")) {
			goldForTurn = (rng.nextInt((20-10)+1)+10);
			messages.add(String.format("You entered a %s and earned %d gold %s ", location,goldForTurn,formatter.format(now)));
		} else if(location.equals("cave")) {
			goldForTurn = (rng.nextInt((10-5)+1)+5);
			messages.add(String.format("You entered a %s and earned %d gold %s", location,goldForTurn,formatter.format(now)));
		} else if(location.equals("house")) {
			goldForTurn = (rng.nextInt((5-2)+1)+2);
			messages.add(String.format("You entered a %s and earned %d gold %s", location,goldForTurn,formatter.format(now)));
		} else if(location.equals("casino")) {
			goldForTurn = (rng.nextInt((50+50)+1)-50);
			if(goldForTurn < 0) {
				messages.add(String.format("You entered a %s and lost %d gold. ouch %s</p>", location,goldForTurn,formatter.format(now)));
			} else {
				messages.add(String.format("You entered a %s and earned %d gold %s", location,goldForTurn,formatter.format(now)));
			}
		} else {
			System.out.println("location not recognized");
			return "redirect:/";
		}
		int gold= (int)session.getAttribute("totalGold");
		int totalGold = gold += goldForTurn;
		session.setAttribute("totalGold", totalGold);
		session.setAttribute("messages", messages);
		
		return "redirect:/";
		
	}
	
	
}
