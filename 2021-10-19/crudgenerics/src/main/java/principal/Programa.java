package principal;

public class Programa {

	public static void main(String[] args) {

		try {

			Teste teste = new Teste();
			teste.deletarCategoriaPorInstancia(28);

		} catch (Exception e) {

			System.out.println(e.toString() + "\nOcorreu um erro ao tentar deletar a categoria.");

		}

	}
}

//Teste teste = new Teste();
//teste.listarCategoria();
//teste.listarSubCategoria();
//teste.inserirCategoria();
//teste.listarProduto();
//teste.listarCategoriaPorID(3);

//try {
//	Teste teste = new Teste();
//	teste.listarCategoria();	
//	
//} catch (Exception e) {			
//	System.out.println(e.hashCode()+ "\nOcorreu um erro." );
//
//	
//}

//try {
//	
//	Teste teste = new Teste();
//	teste.alterarCategoria();
//
//} catch (Exception e) {
//	
//	System.out.println(e.hashCode()+ "\nOcorreu um erro." );
//
//	
//}
