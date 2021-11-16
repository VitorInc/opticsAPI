package br.com.magna.first.poc.DTO;

import java.util.ArrayList;
import java.util.List;

import br.com.magna.first.poc.entity.EyeGlassesEntity;

public class SupplierDTO {
	private Long id;
	private Integer cnpj;
	private List<EyeGlassesEntity> eyeGlassesList = new ArrayList<EyeGlassesEntity>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getCnpj() {
		return cnpj;
	}
	public void setCnpj(Integer cnpj) {
		this.cnpj = cnpj;
	}
	public List<EyeGlassesEntity> getEyeGlassesList() {
		return eyeGlassesList;
	}
	public void setEyeGlassesList(List<EyeGlassesEntity> eyeGlassesList) {
		this.eyeGlassesList = eyeGlassesList;
	}
	
	

}
