package br.com.magna.first.poc.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.magna.first.poc.entity.EyeGlassesEntity;

@Repository
public interface EyeGlassesRepository extends PagingAndSortingRepository<EyeGlassesEntity, Long> {


	void save(Optional<EyeGlassesEntity> entity);
	EyeGlassesEntity findByNumber(Integer number);
	boolean existsByNumber(Integer number);

}
