
package classes;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.CoreMatchers.equalTo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


/**
 *
 * @author Aluno
 */
public class PedidoTest {
    
    private Cliente alfredo;
    private Cliente beribeu;
    private Menu gourmet;
    
    
    @Before
    public void criaPedido(){
        this.alfredo = new Cliente("Alfredo");
        this.beribeu = new Cliente("Beribeu");
        this.gourmet = new Menu("Macarrão", "Vinho", "Pudim");
    }
    
    
    @Test
    public void valorDaQuantidade(){
            
        Pedido primeiro = new Pedido(alfredo, gourmet, 10, 70);
        
        Venda venda = new Venda(primeiro);
       
        assertThat(primeiro.verificaQuantidade(1), equalTo(1));
        assertThat(primeiro.verificaQuantidade(5), equalTo(5));
        assertThat(primeiro.verificaQuantidade(0), equalTo(1));
       
    
    }
    
    @Test(expected=RuntimeException.class)
    public void naoPodeValidadarPedidoSemClienteOuMenu(){
        Cliente jose = null;
        Menu novo = null;
        
        Pedido primeiro = new Pedido(jose, novo, 10, 70);
        
    }
    
    @Test
    public void clienteNaoPodePedirMesmoMenuMaisQue4Vezes(){
        
        Pedido primeiro = new Pedido(alfredo, gourmet, 10, 70);
        Pedido segundo = new Pedido(alfredo, gourmet, 10, 70);
        Pedido terceiro = new Pedido(alfredo, gourmet, 10, 70);
        Pedido quarto = new Pedido(alfredo, gourmet, 10, 70);
        
     
    }
    
    @Test
    public void adicionaPedidosVips() throws SQLException{
        
        PedidoDAO pedido = mock(PedidoDAO.class);
        
        Pedido p1 = new Pedido(alfredo, gourmet, 10, 100);
        Pedido p2 = new Pedido(alfredo, gourmet, 10, 100);
        Pedido p3 = new Pedido(alfredo, gourmet, 10, 140);
        Pedido p4 = new Pedido(alfredo, gourmet, 10, 150);
        Pedido p5 = new Pedido(alfredo, gourmet, 10, 160);
        
        
        List<Pedido> pedidos = Arrays.asList(p1, p2, p3, p4, p5);
        
        
        when(pedido.listaPedidos()).thenReturn(pedidos);
        
        
        
        
        
        
    }

   
    
}
