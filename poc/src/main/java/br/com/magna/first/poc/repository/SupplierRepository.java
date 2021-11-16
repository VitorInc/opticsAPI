package br.com.magna.first.poc.repository;


import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.magna.first.poc.entity.SupplierEntity;

public interface SupplierRepository extends PagingAndSortingRepository<SupplierEntity, Long> {

	SupplierEntity findByCnpj(Integer cnpj);

	boolean existsById(Integer cnpj);



}
