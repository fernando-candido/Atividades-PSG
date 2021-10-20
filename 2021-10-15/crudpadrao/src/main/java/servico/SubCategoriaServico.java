package servico;

import java.util.Date;
import java.util.List;

import dominio.SubCategoria;
import repositorio.SubCategoriaRepositorio;

public class SubCategoriaServico extends BaseServico {
	
	private SubCategoriaRepositorio repo;
	
	public SubCategoriaServico(SubCategoriaRepositorio repo) {
		this.repo = repo;
		
	} 
	
	public void inserir() {
		// Integer categoriaID, String descricao, Date dataDeInsercao
		SubCategoria c = new SubCategoria(null, 11,"testeteste", new Date());
		repo.create(c);
	}
	
	
	public void alterar(SubCategoria cat) {
		repo.update(cat);
		
	}

	public void excluir(SubCategoria cat) {
		this.excluirPorId(cat.getSubCategoriaID());
		
		
	}
	
	public void excluirPorId(int id) {
		repo.delete(id);
	
	}
	
	public List<SubCategoria> listar() {
		return repo.readAll();

	}
	
	public SubCategoria obter(int id) {
		return repo.read(id);
		
	}
	
	
	
}
