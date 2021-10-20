package DAO;

import FakeDB.*;
import Pojo.*;
import java.util.*;

public class CategoriaDao {
    
    public CategoriaDao(){
        EstoqueFakeDB.getCategorias();
   
    }
    
    // CRUD
    
    public void create(CategoriaPojo pojo){
        EstoqueFakeDB.getCategorias().add(pojo);

    }
    
    public CategoriaPojo read(int categoriaID){
        return this.search(categoriaID);
        
    }
    
    public ArrayList<CategoriaPojo> readAll(){
        
        return EstoqueFakeDB.getCategorias();
        
    }
    
    public void update(CategoriaPojo pojo){
        CategoriaPojo busca =  this.search(pojo.getCategoriaID());
        EstoqueFakeDB.getCategorias().remove(busca);
        EstoqueFakeDB.getCategorias().add(pojo);
        
        
    }
    
    public void delete(int categoriaID){
        CategoriaPojo busca = this.search(categoriaID);
        EstoqueFakeDB.getCategorias().remove(busca);
        
    }   
    
    private CategoriaPojo search(int id){
        
            return EstoqueFakeDB.getCategorias().stream()
                .filter(c -> c.getCategoriaID() == id)
                .findFirst()
                .orElse(null);
        
    
    }
}


/*
EstoqueFakeDB.getCategorias().stream()
                .filter(c -> c.getCategoriaID() == categoriaID)
                .findFirst()
                .orElse(null);

*/