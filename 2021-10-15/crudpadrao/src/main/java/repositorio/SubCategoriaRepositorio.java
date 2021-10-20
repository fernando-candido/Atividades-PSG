package repositorio;

import java.util.List;

import javax.persistence.Query;

import dominio.SubCategoria;

public class SubCategoriaRepositorio extends BaseRepositorio {

	public SubCategoriaRepositorio(String nomeUnidade) {
		super(nomeUnidade);
		this.em = this.emf.createEntityManager();
		
	}
	
	
	// crud
	
	
	public void create(SubCategoria subCategoria) {
		this.em.getTransaction().begin();
		this.em.persist(subCategoria);
		this.em.getTransaction().commit();

	}
	
	public List<SubCategoria> readAll() {
		
		Query qry = this.em.createQuery("FROM SubCategoria");
		@SuppressWarnings("unchecked")
		List<SubCategoria> lista = qry.getResultList();

		return lista;
		
	}
	
	public SubCategoria read(int id) {
		SubCategoria subcat = this.em.find(SubCategoria.class, id);

		return subcat;
		
	}
	
	
	public SubCategoria update(SubCategoria subCategoria) {
		SubCategoria subcat = this.em.find(SubCategoria.class, subCategoria.getSubCategoriaID());
		this.em.detach(subcat);
		this.em.getTransaction().begin();
		SubCategoria mergeSubCategoria = (SubCategoria)this.em.merge(subCategoria);
		this.em.getTransaction().commit();

		return mergeSubCategoria;
		
	}
	

	public void delete(int id) {
		SubCategoria subcat = this.em.find(SubCategoria.class, id);
		this.em.getTransaction().begin();
		this.em.remove(subcat);
		this.em.getTransaction().commit();
		//this.em.close();
		//this.emf.close();
		
	}
	
	public void dispose() {
		
		this.em.close();
		this.emf.close();
		

	}
	
}
