package br.com.magna.first.poc.controller;

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
import br.com.magna.first.poc.DTO.SupplierDTO;
import br.com.magna.first.poc.service.SupplierService;

@RestController
@RequestMapping("v3")
public class SupplierController {
	
	@Autowired
	private SupplierService supplierService;
	
	/**
	 * 					
	 * 
	 */
	
		@GetMapping
			public ResponseEntity<SupplierDTO> all(){
			try {
				return new ResponseEntity(supplierService.all(), HttpStatus.OK);
				} 	catch (Exception e) {
						e.printStackTrace();
						return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
					}
				}
		
		/**
		 * 
		 * @param cnpj
		 * @return
		 */
		@GetMapping("/{cnpj}")
		public ResponseEntity<SupplierDTO> troughtId(@PathVariable Integer cnpj){
			try {
				return new ResponseEntity(supplierService.perIdentification(cnpj),HttpStatus.OK);
				}
				catch (Exception e) {
					e.printStackTrace();
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
				}
		}
		
		/**
		 * 
		 * @param SupplierDTO
		 * @return
		 */
		@PostMapping
		public ResponseEntity<SupplierDTO> addClient(@RequestBody SupplierDTO supplierDTO){
			try{
				return new ResponseEntity(supplierService.saveOn(supplierDTO),HttpStatus.CREATED);
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
	}
		@PutMapping("/{cnpj}")
		
		public ResponseEntity<SupplierDTO> changeData(@PathVariable Integer cnpj,@RequestBody@Valid SupplierDTO supplierDTO){
			try{
				return new ResponseEntity(supplierService.replace(cnpj, supplierDTO),HttpStatus.NO_CONTENT);
			}catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
		}
	
	@DeleteMapping("/{id}")
		public ResponseEntity<SupplierDTO> delete(@PathVariable("id") Long id) throws Exception {
		try {
			SupplierDTO deleted = supplierService.delete(id);
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(deleted);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
		
		
		
		}


