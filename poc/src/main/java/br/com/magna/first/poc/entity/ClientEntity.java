package br.com.magna.first.poc.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="TB_CLIENTE")
public class ClientEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	

	@Column (name ="CPF")
	private Integer cpf;
	
	
	@Column (name = "NOME")
	private String name;
	
	@Column(name = "OCULOS")	
	private EyeGlassesEntity glasses;

	public ClientEntity(Integer cpf, String name, EyeGlassesEntity glasses) {
		super();
		this.cpf = cpf;
		this.name = name;
		this.glasses = glasses;
	}
	
	public ClientEntity() {
		
	}


	@Override
	public int hashCode() {
		return Objects.hash(cpf, glasses, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientEntity other = (ClientEntity) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(glasses, other.glasses) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	
	
	public EyeGlassesEntity getGlasses() {
		return glasses;
	}

	public void setGlasses(EyeGlassesEntity glasses) {
		this.glasses = glasses;
	}

	@Override
	public String toString() {
		return "ClientEntity [id=" + id + ", cpf=" + cpf + ", name=" + name + ", glasses=" + glasses + "]";
	}




	
	
	

}
