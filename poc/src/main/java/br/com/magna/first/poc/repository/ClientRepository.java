package br.com.magna.first.poc.repository;



import org.springframework.data.repository.PagingAndSortingRepository;

import org.springframework.stereotype.Repository;


import br.com.magna.first.poc.entity.ClientEntity;

@Repository
public interface ClientRepository extends PagingAndSortingRepository<ClientEntity, Long> {



	public ClientEntity findByCpf(Integer cpf);

	

	public void deleteById(Integer cpf);



	public boolean existsById(Integer cpf);






	
	
}
