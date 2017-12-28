package it.unisa.libra.model.jpa;

import javax.ejb.Stateless;
import it.unisa.libra.bean.Studente;
import it.unisa.libra.model.dao.IStudenteDao;

@Stateless
public class StudenteJpa extends GenericJpa<Studente, String> implements IStudenteDao {

	@Override
	public int contaOccorrenze() {
		 int count = ((Number)entityManager.createNamedQuery("Studente.occorrenze").getSingleResult()).intValue();
		 return count;
	}
}
