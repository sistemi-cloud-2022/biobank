package sprec.biobank.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sprec.biobank.domain.Option;
import sprec.biobank.service.OptionService;

@Controller
@RequestMapping("/biobank/options")
public class OptionController {
	
	@Autowired
	private OptionService optionService;
	
	@GetMapping("/")
	public @ResponseBody Iterable<Option> getAllOptions() {
		return optionService.getAllOptions();
	}
	
	@GetMapping("/{id}")
	public @ResponseBody Optional<Option> getOptionById(@PathVariable int id) {
		return optionService.getOptionById(id);
	}
	
	@PostMapping("/")
	public @ResponseBody Option insertOption(@Valid @RequestBody Option option) {
		return optionService.addOption(option);
	}
	
	@DeleteMapping("/{id}")
	public @ResponseBody String insertOption(@Valid @PathVariable int id) {
		return optionService.deleteOption(id);
	}
	
	@PutMapping("/{id}")
	public @ResponseBody String updateOption(@PathVariable int id, @Valid @RequestBody Option newOption) {
		return optionService.updateOption(id, newOption);
	}	
	
}