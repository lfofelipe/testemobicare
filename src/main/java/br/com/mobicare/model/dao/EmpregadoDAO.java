package br.com.mobicare.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.mobicare.model.entity.Empregado;

@Repository
public class EmpregadoDAO {

	@PersistenceContext
	EntityManager em;

	public EmpregadoDAO(EntityManager em) {
		this.em = em;
	}

	public EmpregadoDAO() {

	}

	// insert ou update
	@Transactional
	public Empregado salvar (Empregado empregado) throws DAOException{
		Empregado emp;
		try{
		emp = em.merge(empregado);
		}catch(Exception e){
		throw new DAOException("Não foi possível salvar", e);
		}
		return emp;

	}

	@Transactional
	public void excluir(Empregado empregado) throws DAOException {
		try{
			Empregado empManaged = em.getReference(Empregado.class, empregado.getId());
		em.remove(empManaged);
		}catch(Exception e){
			throw new DAOException("Não foi possível excluir", e);
		}
		
	}

	public Empregado buscarPorId(int id) {
		return em.find(Empregado.class, id);
	}

	public List<Empregado> buscarTodos() {
		Query q = em.createQuery("select u from Empregado u");
		return q.getResultList();
	}

}
