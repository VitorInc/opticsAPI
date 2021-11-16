package br.com.magna.first.poc.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.magna.first.poc.DTO.ClientDTO;
import br.com.magna.first.poc.DTO.SupplierDTO;
import br.com.magna.first.poc.entity.ClientEntity;
import br.com.magna.first.poc.entity.SupplierEntity;
import br.com.magna.first.poc.repository.SupplierRepository;
import javassist.NotFoundException;

@Service
public class SupplierService {
	
	@Autowired
	private SupplierRepository supplierRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	
	 public Page<SupplierDTO> all() throws Exception{
		 try {
		Pageable pageStyle = PageRequest.of(0, 10);
		Page<SupplierEntity> clients = supplierRepository.findAll(pageStyle);
		return toDTO(clients);
		 } catch(Exception e) {
			 e.printStackTrace();
			 throw e;
		 }
	}
	 /**
	  * 
	  * @param cnpj
	  * @return
	  * @throws Exception
	  */
	 
	 public SupplierDTO perIdentification(Integer cnpj) throws Exception {
			try {
			SupplierEntity supplier = supplierRepository.findByCnpj(cnpj);
			if(supplier != null) {
			return modelMapper.map(supplier, SupplierDTO.class);
			}else{
				throw new NotFoundException(null);
				} 
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
	 
	 /**
	  * 
	  * @param form
	  * @return
	  * @throws Exception
	  */
	 
	 public SupplierDTO saveOn(SupplierDTO form) throws Exception {
			try {
			SupplierEntity supplier = modelMapper.map(form, SupplierEntity.class);
			SupplierEntity clientEntity = supplierRepository.save(supplier);
			return form;
			} catch(Exception e){
					throw e;
				}
			}
	 /**
	  * 
	  * @param cnpj
	  * @param supplierDTO
	  * @return
	  * @throws Exception
	  */
	 
	 
	 public SupplierDTO replace(Integer cnpj,SupplierDTO supplierDTO) throws Exception {	
			try {
				if (!this.supplierRepository.existsById(supplierDTO.getCnpj())) {
					throw new NotFoundException("The cnpj refered does not match with any supplier");
				}
				SupplierEntity entity = supplierRepository.findByCnpj(cnpj); 
				entity.setCnpj(supplierDTO.getCnpj());
				entity.setEyeGlassesList(supplierDTO.getEyeGlassesList());
				supplierRepository.save(entity);
				SupplierDTO dto = modelMapper.map(entity, SupplierDTO.class);
				return dto;
			} catch (Exception e) {
				
				throw e;
			}
			
		}
	 
	 /**
	  * 
	  * @param id
	  * @return
	  * @throws Exception
	  */
	 
	 public SupplierDTO delete(Long id) throws Exception {
			try {
			supplierRepository.deleteById(id);
			return modelMapper.map(id, SupplierDTO.class);
			} catch (IllegalArgumentException e) {
				throw e;
			} catch(Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
	 
	 
	 /**
	  * 
	  * @param suplier
	  * @return
	  */
		public Page<SupplierDTO> toDTO(Page<SupplierEntity> suplier) {
			return suplier.map(x -> this.convertDTO(x));
		}

		public SupplierDTO convertDTO(SupplierEntity suplier) {
			SupplierDTO dto = new SupplierDTO();
			dto.setId(suplier.getId());
			dto.setEyeGlassesList(suplier.getEyeGlassesList());
			dto.setCnpj(suplier.getCnpj());
			return dto;
		}

}
