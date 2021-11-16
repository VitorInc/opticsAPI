package br.com.magna.first.poc.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TB_FORNECEDOR")
public class SupplierEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6149674448922349856L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer cnpj;
	@OneToMany
	@Column(name = "OCULOS")
	private List<EyeGlassesEntity> eyeGlassesList;
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
	public SupplierEntity() {
		super();
	}
	public SupplierEntity(Integer cnpj, List<EyeGlassesEntity> eyeGlassesList) {
		super();
		this.cnpj = cnpj;
		this.eyeGlassesList = eyeGlassesList;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cnpj, eyeGlassesList, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SupplierEntity other = (SupplierEntity) obj;
		return Objects.equals(cnpj, other.cnpj) && Objects.equals(eyeGlassesList, other.eyeGlassesList)
				&& Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return "SupplierEntity [id=" + id + ", cnpj=" + cnpj + ", eyeGlassesList=" + eyeGlassesList + "]";
	}
	
	


}
