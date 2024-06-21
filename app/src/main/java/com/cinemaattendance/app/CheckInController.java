package com.cinemaattendance.app;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cinemaattendance.app.domain.CheckIn;
import com.cinemaattendance.app.repository.CheckInRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin(origins = "http://localhost:8080")
@Controller
@RequestMapping("/cinema")
public class CheckInController {
	
	@Autowired
	CheckInRepository checkRepository; 

	@GetMapping
	public String listRegisters(Model model) {
		List<CheckIn> checkIns = checkRepository.findAll();
		model.addAttribute("checks", checkIns);
		return "list-registers"; 
	}
	
	@GetMapping("/new")
	public String newCheckInForm() {
		return "new-register";
	}
	
	@PostMapping
	public String createNewCheckIn(CheckIn checkIn) {
		checkRepository.save(checkIn);
		return "redirect:/cinema";
	}

	@GetMapping("/{id}")
	public String viewCheckInDetail(@PathVariable("id") Long id, Model model) {
		Optional<CheckIn> checkIn = checkRepository.findById(id);
		if (checkIn.isPresent()) {
			model.addAttribute("check", checkIn.get());
			return "check-detail";
		} else{
			return "redirect:/cinema";
		}
	}
	
	//POSTMAN
	
	@GetMapping("/api")
	@ResponseBody
	public List<CheckIn> getAllRegisters() {
		return checkRepository.findAll();
	}

	@PostMapping("/api")
	@ResponseBody
	public void addRegisters(@RequestBody CheckIn checkIn){
		checkRepository.save(checkIn);
	}

	@GetMapping("/api/{id}")
	@ResponseBody
	public CheckIn getRegisterById(@PathVariable Long id) {
		Optional<CheckIn> checkIn = checkRepository.findById(id);
		return checkIn.get();
	}
	

	@PutMapping("/api/{id}")
	@ResponseBody
	public void updateRegister(@PathVariable Long id, @RequestBody CheckIn checkIn){
		checkIn.setId(id);
		if (checkRepository.existsById(checkIn.getId())) {
			checkRepository.save(checkIn);
		} else {
			throw new RuntimeException("No actualizo, no existe el libro en el repositorio bajo id: "+checkIn.getId());
		}
	}

	@DeleteMapping("/api/{id}")
	@ResponseBody
	public void deleteRegister(@PathVariable Long id){
		checkRepository.deleteById(id);
	}

	@DeleteMapping("/api")
	@ResponseBody
	public void deleteAllRegister(){
		checkRepository.deleteAll();
	}
	
}
