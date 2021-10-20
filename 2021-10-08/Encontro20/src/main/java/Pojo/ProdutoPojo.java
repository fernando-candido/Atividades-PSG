package Pojo;

public class ProdutoPojo extends CamposComuns {

    private int produtoID;
    
    private int categoriaID;
    
    private int subCategoriaID;

    public int getProdutoID() {
        return produtoID;
    }

    public void setProdutoID(int produtoID) {
        this.produtoID = produtoID;
    }

    public int getCategoriaID() {
        return categoriaID;
    }

    public void setCategoriaID(int categoriaID) {
        this.categoriaID = categoriaID;
    }

    public int getSubCategoriaID() {
        return subCategoriaID;
    }

    public void setSubCategoriaID(int subCategoriaID) {
        this.subCategoriaID = subCategoriaID;
    }
}
