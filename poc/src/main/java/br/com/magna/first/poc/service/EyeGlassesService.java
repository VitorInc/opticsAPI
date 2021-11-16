package br.com.magna.first.poc.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.magna.first.poc.DTO.EyeGlassesDTO;
import br.com.magna.first.poc.entity.EyeGlassesEntity;
import br.com.magna.first.poc.repository.EyeGlassesRepository;
import javassist.NotFoundException;

@Service
public class EyeGlassesService {
	
	@Autowired
	private EyeGlassesRepository eyeGlassesRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	/*******************************************************************************************************************
		//Index to all clients
		 * 
		 * @return
		 * @throws Exception
		 ****************************************************************************************************************/
	
	
	 public Page<EyeGlassesDTO> allGlasses() throws Exception{
		 try {
		Pageable pageStyle = PageRequest.of(0, 10);
		Page<EyeGlassesEntity> glasses = eyeGlassesRepository.findAll(pageStyle);
		return toDTO(glasses);
		 } catch(Exception e) {
			 e.printStackTrace();
			 throw e;
		 }
	}

	 /**********************************************************************
	   				/Display only with the CPF
	  * @param serialNumber
	  * @return
	  * @throws Exception
	  ***********************************************************************/
	 
	 public EyeGlassesDTO perIdentification(Long id) throws Exception {
			try {
			Optional<EyeGlassesEntity> eyeEntity = eyeGlassesRepository.findById(id);
			if(eyeEntity != null) {
			return modelMapper.map(eyeEntity, EyeGlassesDTO.class);
			}else{
				throw new NotFoundException(null);
				} 
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
	 /*******************************************************************
	  * //Save data on the API
	  * @param form
	  * @return
	  * @throws Exception
	  *******************************************************************/
	 
	 public EyeGlassesDTO saveGlasses(EyeGlassesDTO form) throws Exception {
			try {
			EyeGlassesEntity glasses = modelMapper.map(form, EyeGlassesEntity.class);
			EyeGlassesEntity eyeEntity = eyeGlassesRepository.save(glasses);
			return form;
			} catch(Exception e){
					throw e;
				}
			}
	 /***********************************
	  * //Update data
	  * @param serialNumber
	  * @param eyeGlassesDTO
	  * @return
	  * @throws Exception
	  *************************************************************/
	 
	 public EyeGlassesDTO replaceGlasses(Integer number,EyeGlassesDTO eyeGlassesDTO) throws Exception {	
			try {
				if (!this.eyeGlassesRepository.existsByNumber(number)) {
					throw new NotFoundException("The serial number refered does not match with any client");
				}
				EyeGlassesEntity eyeGlass = eyeGlassesRepository.findByNumber(number); 
				eyeGlass.setNumber(eyeGlassesDTO.getNumber());
				eyeGlass.setModel(eyeGlassesDTO.getModel());
				eyeGlassesRepository.save(eyeGlass);
				EyeGlassesDTO dto = modelMapper.map(eyeGlass, EyeGlassesDTO.class);
				return dto;
			} catch (Exception e) {
				
				throw e;
				}
			}
	 /***
	  * 
	  * 	//Delete method
	  * @param id
	  * @return
	  * @throws Exception
	  */
	
	 
		public EyeGlassesDTO delete(Long id) throws Exception {
			try {
				eyeGlassesRepository.deleteById(id);
			return modelMapper.map(id, EyeGlassesDTO.class);
			} catch (IllegalArgumentException e) {
				throw e;
			} catch(Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
		
		/********************************************************************************************************************
			//Methods to help with Entity conversion
			* 
			* @param clientEntity
			* @return
********************************************************************************************************************/

	 
		public Page<EyeGlassesDTO> toDTO(Page<EyeGlassesEntity> eyeEntity) {
			return eyeEntity.map(x -> this.convertDTO(x));
		}

		public EyeGlassesDTO convertDTO(EyeGlassesEntity eyeEntity) {
			EyeGlassesDTO dto = new EyeGlassesDTO();
			dto.setId(eyeEntity.getId());
			dto.setNumber(eyeEntity.getNumber());
			dto.setModel(eyeEntity.getModel());
			return dto;
		}
		}


