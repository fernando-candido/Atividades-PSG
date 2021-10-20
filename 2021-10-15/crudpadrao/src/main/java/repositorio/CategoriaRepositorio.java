package repositorio;

import java.util.List;

import javax.persistence.Query;

import dominio.Categoria;

public class CategoriaRepositorio extends BaseRepositorio {

	public CategoriaRepositorio(String nomeUnidade) {
		super(nomeUnidade);
		this.em = this.emf.createEntityManager();
		
	}
	
	
	// crud
	
	
	public void create(Categoria categoria) {
		this.em.getTransaction().begin();
		this.em.persist(categoria);
		this.em.getTransaction().commit();

	}
	
	public List<Categoria> readAll() {
		
		Query qry = this.em.createQuery("FROM Categoria");
		@SuppressWarnings("unchecked")
		List<Categoria> lista = qry.getResultList();

		return lista;
		
	}
	
	public Categoria read(int id) {
		Categoria cat = this.em.find(Categoria.class, id);

		return cat;
		
	}
	
	
	public Categoria update(Categoria categoria) {
		Categoria cat = this.em.find(Categoria.class, categoria.getCategoriaID());
		this.em.detach(cat);
		this.em.getTransaction().begin();
		Categoria mergeCategoria = (Categoria)this.em.merge(categoria);
		this.em.getTransaction().commit();

		return mergeCategoria;
		
	}
	

	public void delete(int id) {
		Categoria cat = this.em.find(Categoria.class, id);
		this.em.getTransaction().begin();
		this.em.remove(cat);
		this.em.getTransaction().commit();
		//this.em.close();
		//this.emf.close();
		
	}
	
	public void dispose() {
		
		this.em.close();
		this.emf.close();
		

	}
	
}



//métodos que estavam na main 
//	categoriaServicoInserir(repo);
//	categoriaServicoListar(repo);
//	categoriaServicoExcluir(repo);
	
//	categoriaServicoListar(repo);
//	categoriaServicoObter(repo);
	
//categoriaServicoAlterar(repo, 22);
//categoriaServicoObter(repo, 22);
