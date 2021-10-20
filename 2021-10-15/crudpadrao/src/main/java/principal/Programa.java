package principal;
import java.util.Date;

import dominio.Categoria;
import dominio.SubCategoria;
import repositorio.CategoriaRepositorio;
import repositorio.ProdutoRepositorio;
import repositorio.SubCategoriaRepositorio;
import servico.CategoriaServico;
import servico.ProdutoServico;
import servico.SubCategoriaServico;

public class Programa {

	public static void main(String[] args) {

		CategoriaRepositorio catrepo = new CategoriaRepositorio("exemplo-jpa");
		CategoriaServico catservico = new CategoriaServico(catrepo);
		
		SubCategoriaRepositorio subcatrepo = new SubCategoriaRepositorio("exemplo-jpa");
		SubCategoriaServico subcatservico = new  SubCategoriaServico(subcatrepo);

		ProdutoRepositorio prorepo = new ProdutoRepositorio("exemplo-jpa");
		ProdutoServico proservico = new ProdutoServico(prorepo);
		
		
		
		//Categoria c = new Categoria(null, "testeteste", new Date());
		//catservico.inserir(c);
		//subcatservico.excluirPorId(98);
		
		proservico.inserir();
		
		
		
		//for (Categoria item : catservico.listar()) {
		//	System.out.println(item);
		//}

		catrepo.dispose();
	}

}




