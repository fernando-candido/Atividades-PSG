package ancestral;

public abstract class BaseGenericService<R> {
	
	protected R repositorio;
	
	protected String nomeUnidade;
	
	public R getRepositorio() {	
		return this.repositorio;
	}

	public String getNomeUnidade() {
		return nomeUnidade;
	}

	public BaseGenericService(String nomeUnidade) {
		super();
		this.nomeUnidade = nomeUnidade;
	}
	
}
