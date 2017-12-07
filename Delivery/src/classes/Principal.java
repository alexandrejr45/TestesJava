
package classes;

import java.sql.Connection; 
import java.sql.SQLException;


public class Principal {
    public static void main(String[] args) throws SQLException {
        
        Cliente alex = new Cliente("Alexandre");
        
        Menu cardapio = new Menu("macarronada", "coca-cola", "pudim");
        
        Pedido p  = new Pedido(alex, cardapio, 7, 100);
        PedidoDAO salva = new PedidoDAO();
        
        salva.salvarPedido(p);
         
            
    }
}
