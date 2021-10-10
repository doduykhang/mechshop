package com.laptrinhjavaweb.api.admin;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.NewDTO;

@RestController(value="newAPIOfAdmin")
public class NewAPI {
	@PostMapping(value="/api/new")
	public NewDTO createNew(@RequestBody NewDTO newDTO) {
		return newDTO;
	}
	
	@PutMapping(value="/api/new")
	public NewDTO updateNew(@RequestBody NewDTO newDTO) {
		return newDTO;
	}
	
	@DeleteMapping(value="/api/new")
	public NewDTO deleteNew(@RequestBody long[] ids) {
		return null;
	}
}
