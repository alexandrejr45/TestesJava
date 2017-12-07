package classes;


public class Pedido {
    
    private Cliente cliente;
    private Menu menu;
    private double valorPedido;
    private int quantidade;
    
    public Pedido(Cliente cliente, Menu menu, int quantidade, double valor){
        if(cliente == null || menu == null){
            throw new RuntimeException("O Cliente ou Menu são inválidos");
        }else{
           salvarPedido(cliente, menu, quantidade, valor);
      
        }
       
    }
    
    public int verificaQuantidade(int quantidade){
        if(quantidade <= 0){
            quantidade =  1;
        }else if(quantidade >= 1 && quantidade <= 5){
           quantidade = quantidade;
        }else if(quantidade > 5){
            quantidade =  5;
        }
        return quantidade;
        
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public double getValorPedido() {
        return valorPedido;
    }

    public void setValorPedido(double valorPedido) {
        this.valorPedido = valorPedido;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public void salvarPedido(Cliente c, Menu m, int quantidade, double valor){
        
        
        this.cliente = c;
        this.valorPedido = valor;
        this.quantidade = verificaQuantidade(quantidade);
        this.menu = m;
        
    }
    
    
    
    
}
