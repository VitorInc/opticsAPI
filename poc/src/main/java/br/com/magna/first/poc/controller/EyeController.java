package br.com.magna.first.poc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magna.first.poc.DTO.EyeGlassesDTO;
import br.com.magna.first.poc.service.EyeGlassesService;



@RestController
@RequestMapping("v2")
public class EyeController {
	
	@Autowired
	private EyeGlassesService eyeGlassesService;
	

	
	@GetMapping
	public ResponseEntity<List<EyeGlassesDTO>> allGlasses() {
		try {
		return new ResponseEntity(eyeGlassesService.allGlasses(), HttpStatus.OK);
		} 	catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
		}



	
	@GetMapping("/{serialNumber}")	
	public ResponseEntity<EyeGlassesDTO> troughtId(@PathVariable Long id){
	try {
		return new ResponseEntity(eyeGlassesService.perIdentification(id),HttpStatus.OK);
		}
		catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	
	@PostMapping
	public ResponseEntity<EyeGlassesDTO> addClient(@RequestBody EyeGlassesDTO eyeGlassesDTO){
		try{
			return new ResponseEntity(eyeGlassesService.saveGlasses(eyeGlassesDTO),HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PutMapping("/{number}")
	
	public ResponseEntity<EyeGlassesDTO> changeData(@PathVariable Integer number,@RequestBody@Valid EyeGlassesDTO eyeGlassesDTO){
		try{
			return new ResponseEntity(eyeGlassesService.replaceGlasses(number, eyeGlassesDTO),HttpStatus.NO_CONTENT);
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<EyeGlassesDTO> delete(@PathVariable("id") Long id) throws Exception {
	try {
		EyeGlassesDTO deleted = eyeGlassesService.delete(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(deleted);
	} catch (Exception e) {
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
}	
}
