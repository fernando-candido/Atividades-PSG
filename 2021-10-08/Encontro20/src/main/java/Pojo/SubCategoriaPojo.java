package Pojo;

import java.util.*;

public class SubCategoriaPojo extends CamposComuns {
    
    private int subCategoriaID;
    
    private int categoriaID;
    
    public int getSubCategoriaID() {
        return this.subCategoriaID;
    }

    public void setSubCategoriaID(int subCategoriaID) {
        this.subCategoriaID = subCategoriaID;
    }

    public int getCategoriaID() {
        return this.categoriaID;
    }

    public void setCategoriaID(int categoriaID) {
        this.categoriaID = categoriaID;
    }
}
