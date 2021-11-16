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
@Table(name = "TB_OCULOS")
public class EyeGlassesEntity implements Serializable{
	


	private static final long serialVersionUID = -2409136526770178945L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name = "IDENTIFICADOR")
	private Integer number;
	
	@Column(name = "MODELO")
	private String model;
	
	

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, model, number);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EyeGlassesEntity other = (EyeGlassesEntity) obj;
		return Objects.equals(id, other.id) && Objects.equals(model, other.model)
				&& Objects.equals(number, other.number);
	}

	public EyeGlassesEntity(Integer number, String model) {
		super();
		
		this.number = number;
		this.model = model;
	}

	public EyeGlassesEntity() {
		super();
		
	}

	@Override
	public String toString() {
		return "EyeGlassesEntity [id=" + id + ", number=" + number + ", model=" + model + "]";
	}
	
	

}


