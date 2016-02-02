package br.com.mobicare.model.entity;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Empregado.class)
public abstract class Empregado_ {

	public static volatile SingularAttribute<Empregado, String> funcao;
	public static volatile SingularAttribute<Empregado, Departamento> departamento;
	public static volatile SingularAttribute<Empregado, String> nome;
	public static volatile SingularAttribute<Empregado, Integer> id;

}

