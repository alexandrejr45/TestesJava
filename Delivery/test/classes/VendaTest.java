
package classes;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class VendaTest {
    private Cliente alfredo;
    private Cliente beribeu;
    private Menu gourmet;
    
    
    @Before
    public void criaVenda(){
        this.alfredo = new Cliente("Alfredo");
        this.beribeu = new Cliente("Beribeu");
        this.gourmet = new Menu("Macarrão", "Vinho", "Pudim");
    }
    
    
   @Test
    public void valorDaVendaCorreto(){
        
        Pedido primeiro = new Pedido(alfredo, gourmet, 2, 70);
        
        Venda venda = new Venda(primeiro);
        
        assertEquals(30, venda.concluiVenda(alfredo, primeiro, 100), 0.0001);
        assertEquals(0, venda.concluiVenda(alfredo, primeiro, 0), 0.0001);
    
    }
    
  
  
}
