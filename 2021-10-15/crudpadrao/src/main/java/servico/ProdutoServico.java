package servico;

import java.util.Date;
import java.util.List;

import dominio.Produto;
import repositorio.ProdutoRepositorio;

public class ProdutoServico extends BaseServico {
	
	private ProdutoRepositorio repo;
	
	public ProdutoServico(ProdutoRepositorio repo) {
		this.repo = repo;
		
	} 
	
	public void inserir() {
		// Integer categoriaID, String descricao, Date dataDeInsercao
		Produto c = new Produto(null, 11, 10, "testeteste", new Date());
		repo.create(c);
	}
	
	
	public void alterar(Produto cat) {
		repo.update(cat);
		
	}

	public void excluir(Produto cat) {
		this.excluirPorId(cat.getProdutoID());
		
		
	}
	
	public void excluirPorId(int id) {
		repo.delete(id);
	
	}
	
	public List<Produto> listar() {
		return repo.readAll();

	}
	
	public Produto obter(int id) {
		return repo.read(id);
		
	}
	
	
	
}
