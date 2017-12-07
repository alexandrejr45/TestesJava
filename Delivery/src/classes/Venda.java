
package classes;

import java.util.ArrayList;


public class Venda {
    private ArrayList<Pedido> pedidos = new ArrayList<>();
    private Cliente cliente;
    private double valor;
    
    public Venda(Pedido p){
        if(p == null){
            System.out.println("Nenhum pedido existente");
        }else{
           pedidos.add(p);
        } 
    }
    
    public double concluiVenda(Cliente c, Pedido p, double valor){
        if(valor >= pedidos.get(pedidos.size() - 1).getValorPedido()){
            double troco = valor - pedidos.get(pedidos.size() - 1).getValorPedido();
            this.valor = troco;
            
            return getValor();
        }else{
            this.valor = valor;
            return getValor();
        }     
        
    }
        
    
        

    public void getPedidos() {
        for (Pedido pedido : pedidos) {
            System.out.println(pedido.getCliente());
            System.out.println(pedido.getMenu());
            System.out.println(pedido.getQuantidade());
            System.out.println(pedido.getValorPedido());
            
        }
        

    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

 

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
}
