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

import br.com.magna.first.poc.DTO.ClientDTO;
import br.com.magna.first.poc.service.ClientService;

@RestController
@RequestMapping("v1")
public class ClientController {
	
	@Autowired
		private ClientService clientService;
	

	@GetMapping	
		public ResponseEntity<List<ClientDTO>> all() {
			try {
			return new ResponseEntity(clientService.all(), HttpStatus.OK);
			} 	catch (Exception e) {
					e.printStackTrace();
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
				}
			}
	

	@GetMapping("/{cpf}")	
		public ResponseEntity<ClientDTO> troughtId(@PathVariable Integer cpf){
		try {
			return new ResponseEntity(clientService.perIdentification(cpf),HttpStatus.OK);
			}
			catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
	}

	@PostMapping
		public ResponseEntity<ClientDTO> addClient(@RequestBody ClientDTO clientDTO){
			try{
				return new ResponseEntity(clientService.saveOn(clientDTO),HttpStatus.CREATED);
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
	}
	
	@PutMapping("/{cpf}")
	
		public ResponseEntity<ClientDTO> changeData(@PathVariable Integer cpf,@RequestBody@Valid ClientDTO clientDTO){
			try{
				return new ResponseEntity(clientService.replace(cpf, clientDTO),HttpStatus.NO_CONTENT);
			}catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
		}
	
	@DeleteMapping("/{id}")
		public ResponseEntity<ClientDTO> delete(@PathVariable("id") Long id) throws Exception {
		try {
		ClientDTO deleted = clientService.delete(id);
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(deleted);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}	
}
