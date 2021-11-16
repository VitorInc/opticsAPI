package br.com.magna.first.poc.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.magna.first.poc.DTO.ClientDTO;
import br.com.magna.first.poc.entity.ClientEntity;
import br.com.magna.first.poc.repository.ClientRepository;
import javassist.NotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private ModelMapper modelMapper;

	/*******************************************************************************************************************
	 * //Index to all clients
	 * 
	 * @return
	 * @throws Exception
	 *********************************************************************************************************************/

	public Page<ClientDTO> all() throws Exception {
		try {
			Pageable pageStyle = PageRequest.of(0, 10);
			Page<ClientEntity> clients = clientRepository.findAll(pageStyle);
			return toDTO(clients);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/********************************************************************************************************************
	 * 
	 * //Display only with the CPF
	 * 
	 * @param cpf
	 * @return
	 * @throws Exception
	 *********************************************************************************************************************/

	public ClientDTO perIdentification(Integer cpf) throws Exception {
		try {
			ClientEntity clientEntity = clientRepository.findByCpf(cpf);
			if (clientEntity != null) {
				return modelMapper.map(clientEntity, ClientDTO.class);
			} else {
				throw new NotFoundException(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**************************************************************************************************************************
	 * //Save data on the API
	 * 
	 * @param form
	 * @return
	 * @throws Exception
	 ****************************************************************************************************************************/

	public ClientDTO saveOn(ClientDTO form) throws Exception {
		try {
			ClientEntity client = modelMapper.map(form, ClientEntity.class);
			ClientEntity clientEntity = clientRepository.save(client);
			return form;
		} catch (Exception e) {
			throw e;
		}
	}

	/***************************************************************************************************************************
	 * //Update data
	 * 
	 * @param cpf
	 * @param clientDTO
	 * @return
	 * @throws Exception
	 ****************************************************************************************************************************/

	public ClientDTO replace(Integer cpf, ClientDTO clientDTO) throws Exception {
		try {
			if (!this.clientRepository.existsById(clientDTO.getCpf())) {
				throw new NotFoundException("The cpf refered does not match with any client");
			}
			ClientEntity entity = clientRepository.findByCpf(cpf);
			entity.setCpf(clientDTO.getCpf());
			entity.setName(clientDTO.getName());
			clientRepository.save(entity);
			ClientDTO dto = modelMapper.map(entity, ClientDTO.class);
			return dto;
		} catch (Exception e) {

			throw e;
		}

	}

	/**************************************************************************************************************************
	 * //Delete method
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 ***************************************************************************************************************************/

	public ClientDTO delete(Long id) throws Exception {
		try {
			clientRepository.deleteById(id);
			return modelMapper.map(id, ClientDTO.class);
		} catch (IllegalArgumentException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/********************************************************************************************************************
	 * //Methods to help with Entity conversion
	 * 
	 * @param clientEntity
	 * @return
	 ********************************************************************************************************************/

	public Page<ClientDTO> toDTO(Page<ClientEntity> clientEntity) {
		return clientEntity.map(x -> this.convertDTO(x));
	}

	public ClientDTO convertDTO(ClientEntity clientEntity) {
		ClientDTO dto = new ClientDTO();
		dto.setId(clientEntity.getId());
		dto.setName(clientEntity.getName());
		dto.setCpf(clientEntity.getCpf());
		return dto;
	}

}
