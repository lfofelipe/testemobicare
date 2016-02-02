package br.com.mobicare.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.mobicare.model.entity.Departamento;

@Repository
public class DepartamentoDAO {

	@PersistenceContext
	EntityManager em;

	public DepartamentoDAO(EntityManager em) {
		this.em = em;
	}

	public DepartamentoDAO() {

	}

	// insert ou update
	@Transactional
	public Departamento salvar (Departamento departamento) throws DAOException{
		Departamento dep;
		try{
		dep = em.merge(departamento);
		}catch(Exception e){
		throw new DAOException("Não foi possível salvar", e);
		}
		return dep;

	}

	@Transactional
	public void excluir(Departamento departamento) throws DAOException {
		try{
			Departamento depManaged = em.getReference(Departamento.class, departamento.getId());
		em.remove(depManaged);
		}catch(Exception e){
			throw new DAOException("Não foi possível excluir", e);
		}
		
	}

	public Departamento buscarPorId(int id) {
		return em.find(Departamento.class, id);
		
	}

	public List<Departamento> buscarTodos() {
		Query q = em.createQuery("select d from Departamento d");
		return q.getResultList();
	}

}
