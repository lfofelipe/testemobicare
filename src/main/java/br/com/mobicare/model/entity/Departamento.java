package br.com.mobicare.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "departamento")
public class Departamento implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column
	private String descricao;

	@OneToMany( mappedBy = "departamento", fetch = FetchType.EAGER)
	private List<Empregado> empregados;

	public List<Empregado> getEmpregados() {
		return empregados;
	}

	public void setEmpregados(List<Empregado> empregados) {
		this.empregados = empregados;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		return (id==null)?0:id;
	}

	@Override
	public boolean equals(Object obj) {
        if (obj == null)  return false;  
        if (obj instanceof Departamento){
            return ((Departamento)obj).getId().equals(this.id);  
        }
        return false;  
	}

	@Override
	public String toString() {
		return "Departamento [id=" + id + ", descricao=" + descricao + ", empregados=" + empregados + "]";
	}


}
