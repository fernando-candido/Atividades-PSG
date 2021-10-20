package servico;

import java.util.List;

import ancestral.BaseGenericService;
import ancestral.IGenericService;
import dominio.SubCategoria;
import repositorio.SubCategoriaRepositorio;

public class SubCategoriaServico
		extends BaseGenericService<SubCategoriaRepositorio>
		implements IGenericService<SubCategoria> {

	public SubCategoriaServico(String nomeUnidade) {
		super(nomeUnidade);
		this.repositorio = new SubCategoriaRepositorio(this.nomeUnidade);

	}

	@Override
	public void inserir(SubCategoria instance) {
		this.repositorio.create(instance);

	}

	@Override
	public void alterar(SubCategoria instance) {
		this.repositorio.update(instance);

	}

	@Override
	public void excluir(SubCategoria instance) {
		this.repositorio.delete(instance);

	}

	@Override
	public void excluir(int id) {
		this.repositorio.delete(id);

	}

	@Override
	public List<SubCategoria> listar() {
		return this.repositorio.readAll();
	}

	@Override
	public SubCategoria obter(int id) {
		return this.repositorio.read(id);
	}

	@Override
	public void dispose() {
		this.repositorio.dispose();

	}

}
