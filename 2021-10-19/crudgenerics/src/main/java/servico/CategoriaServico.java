package servico;

import java.util.List;

import ancestral.BaseGenericService;
import ancestral.IGenericService;
import dominio.Categoria;
import repositorio.CategoriaRepositorio;

public class CategoriaServico 
	extends BaseGenericService<CategoriaRepositorio> 
	implements IGenericService<Categoria> {

	public CategoriaServico(String nomeUnidade) {
		super(nomeUnidade);
		this.repositorio = new CategoriaRepositorio(this.nomeUnidade);
	}



	@Override
	public void inserir(Categoria instance) {
		this.repositorio.create(instance);
	
		
	}

	@Override
	public void alterar(Categoria instance) {
		this.repositorio.update(instance);

		
	}

	@Override
	public void excluir(Categoria instance) {
		this.repositorio.delete(instance);
		
		
	}

	@Override
	public void excluir(int id) {
		this.repositorio.delete(id);	
	}
	

	@Override
	public List<Categoria> listar() {
	
		return this.repositorio.readAll();
	}

	@Override
	public Categoria obter(int id) {
		return this.repositorio.read(id);
	}

	@Override
	public void dispose() {
		this.repositorio.dispose();
		
	}
	


}
