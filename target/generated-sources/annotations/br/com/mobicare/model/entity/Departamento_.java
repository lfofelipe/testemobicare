package br.com.mobicare.model.entity;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Departamento.class)
public abstract class Departamento_ {

	public static volatile ListAttribute<Departamento, Empregado> empregados;
	public static volatile SingularAttribute<Departamento, Integer> id;
	public static volatile SingularAttribute<Departamento, String> descricao;

}

