package ancestral;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class BaseGenericRepository<T> {
	
	protected EntityManagerFactory factory;
	protected EntityManager session;

	public EntityManagerFactory getFactory() {
		return factory;
	}

	public EntityManager getSession() {
		return session;
	}

	public BaseGenericRepository(String nomeUnidade) {
		this.factory  = Persistence.createEntityManagerFactory(nomeUnidade);
		this.session = this.factory.createEntityManager();
		
	}
	
	
	public void dispose() {
		
		this.session.close();
		this.factory.close();
		

	}
	
	
	

}
