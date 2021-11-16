package br.com.magna.first.poc.DTO;


import br.com.magna.first.poc.entity.EyeGlassesEntity;

public class ClientDTO {

	private Long id;
	private Integer cpf;
	private String name;
	private EyeGlassesEntity glasses;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public EyeGlassesEntity getGlasses() {
		return glasses;
	}
	public void setGlasses(EyeGlassesEntity glasses) {
		this.glasses = glasses;
	}
	public Integer getCpf() {
		return cpf;
	}
	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
