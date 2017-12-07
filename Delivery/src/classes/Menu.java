
package classes;

public class Menu {
    private String comida;
    private String bebida;
    private String sobremesa;

    public Menu(String comida, String bebida, String sobremesa){
        this.bebida = bebida;
        this.comida = comida;
        this.sobremesa = sobremesa;
    }
    
    public String getComida() {
        return comida;
    }

    public void setComida(String comida) {
        this.comida = comida;
    }

    public String getBebida() {
        return bebida;
    }

    public void setBebida(String bebida) {
        this.bebida = bebida;
    }

    public String getSobremesa() {
        return sobremesa;
    }

    public void setSobremesa(String sobremesa) {
        this.sobremesa = sobremesa;
    }
    
  
    @Override
        public String toString(){
            return " " + this.comida +
                    " " + this.bebida+
                    " " + this.sobremesa;
        }
    
    
}
