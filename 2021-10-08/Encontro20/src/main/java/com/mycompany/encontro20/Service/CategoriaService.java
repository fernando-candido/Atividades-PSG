package com.mycompany.encontro20.Service;
import DAO.CategoriaDao;
import Pojo.CategoriaPojo;
import java.util.*;

public class CategoriaService {
    
    private CategoriaDao dao;
    private Scanner sc;
    
    public CategoriaService(){
        this.sc = new Scanner(System.in);
        this.dao = new CategoriaDao();
    }
    
    public void exibirMenu(){
        boolean sair = false;
        do {
            
            int op = this.printMenu();
            switch(op){
                case 1:
                    this.printMenuInserir();
                    
                     break;
                     
                case 2:
                    this.printMenuListar();
                     break;
                     
                case 3:
                    this.printMenuDetalhar();
                    
                     break;
                     
                case 4:
                    this.printMenuAlterar();
                    
                     break;
                     
                case 5:
                    this.printMenuDeletar();
                    break;
                    
                case 6:
                     sair = true;
                     break;
                     
                default:
                    System.out.println("Opção não dísponivel. Tente novamente.");
            }
            
        }
        
        while (sair != true);
    }
        private int printMenu(){
            System.out.printf("Menu Categoria - Crud\n");
            System.out.printf("**************************\n");
            System.out.printf("1 - Inserir\n");
            System.out.printf("2 - Listar\n");
            System.out.printf("3 - Detalhar\n");
            System.out.printf("4 - Alterar\n");
            System.out.printf("5 - Deletar\n");
            System.out.printf("6 - Sair\n");
            System.out.printf("**************************\n");
            System.out.printf("Digite uma opção: \n"); 
            
            return this.sc.nextInt();
        }
        
        private void printMenuInserir(){
            System.out.println("Digite o ID da Categoria: ");
            int id = this.sc.nextInt();
            System.out.println("Digite a Descrição da categoria: ");
            String desc = this.sc.next();
            
            CategoriaPojo pojo = new CategoriaPojo();
            pojo.setCategoriaID(id);
            pojo.setDescricao(desc);
            this.dao.create(pojo);
            
            if (this.dao.read(id) != null){
                            
                System.out.println("Categoria adicionada.");
                System.out.println("******************************\n");
                
            }
            
            else{
                
                System.out.println("Erro ao adicionar Categoria.");
            }


        }
        private void printMenuListar(){
            for (CategoriaPojo item : this.dao.readAll()) {
            System.out.printf("*****Menu Listar********\n");
            System.out.printf("Categoria ID: %d \n", item.getCategoriaID());
            System.out.printf("Listar: %s \n", item.getDescricao());
            System.out.printf("**************************\n");
            }
            
            //this.dao.readAll().stream().forEach(-> {});
        
        }
        
        
        private void printMenuDetalhar(){
            System.out.printf("*****Menu Detalhar********\n");
            System.out.println("Digite qual categoria: \n");
            int op = this.sc.nextInt();
            CategoriaPojo item = this.dao.read(op);
            if (item == null){
                System.out.println("Categoria não existe. Tente novamente.");
                
            }
            else{
            System.out.printf("Categoria ID: %d \n", item.getCategoriaID());
            System.out.printf("Listar: %s \n", item.getDescricao());
            System.out.printf("**************************\n");     
            
            }
            
        }
        
        

        
        private void printMenuAlterar(){
            
            System.out.printf("*****Menu Alterar********\n");
            System.out.println("Digite qual categoria: \n");
            int op = this.sc.nextInt();
            CategoriaPojo item = this.dao.read(op);
            if (item == null){
                System.out.println("Categoria não existe. Tente novamente.");
                
            }
            else{
            System.out.printf("Categoria ID: %d \n", item.getCategoriaID());
            System.out.printf("Listar: %s \n", item.getDescricao());
            System.out.printf("Digite a descrição da nova Categoria: \n");   
            String desc = sc.nextLine();
            item.setDescricao(desc);
            System.out.println("Categoria alterada com sucesso.");
            System.out.println("*****************");
            
            }

        }
        
        
        private void printMenuDeletar(){
            
            System.out.printf("*****Menu Deletar********\n");
            System.out.println("Digite qual categoria: \n");
            int op = this.sc.nextInt();
            CategoriaPojo item = this.dao.read(op);
            if (item == null){
                System.out.println("Categoria não existe. Tente novamente.");
                
            }
            else{
            System.out.printf("Categoria ID: %d \n", item.getCategoriaID());
            System.out.printf("Listar: %s \n", item.getDescricao());
            System.out.printf("Digite a descrição da nova Categoria: \n");   
            this.dao.delete(item.getCategoriaID());
            CategoriaPojo itemDeletado = this.dao.read(op);
            if (itemDeletado == null){
                System.out.println("Categoria excluida com sucesso.");
            }
            System.out.println("*****************");
            }
        
        }

        
}




/*

 System.out.println("Digite qual categoria: \n");
            int op = this.sc.nextInt();
            CategoriaPojo item = this.dao.read(op);

            this.printMenuDetalhar();
            System.out.println("Digite a Descrição da categoria: \n");
            String desc = this.sc.next();
            CategoriaPojo item = this.dao.read(op);


*/
