
package classes;

import java.sql.*;
import java.sql.PreparedStatement;

import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {
    
    private Connection conexao;
    private String cliente;
    private String comida;
    private String bebida;
    private String sobremesa;
    private double valor;
    private int quantidade;
    private List<Pedido> pedidosvips = new ArrayList<>();
    
    public PedidoDAO() throws SQLException{
        this.conexao = new Conexao().getConnection();
    }
    
    public void salvarPedido(Pedido pedido) throws SQLException{
        String sql = "INSERT INTO pedidos (cliente, comida, bebida, sobremesa, valor, quantidade)"
                + "VALUES (?, ?, ?, ?, ?, ?)";
        
        PreparedStatement sqlt = conexao.prepareStatement(sql);
        
        sqlt.setString(1, pedido.getCliente().getNome());
        sqlt.setString(2, pedido.getMenu().getComida());
        sqlt.setString(3, pedido.getMenu().getBebida());
        sqlt.setString(4, pedido.getMenu().getSobremesa());
        sqlt.setDouble(5, pedido.getValorPedido());
        sqlt.setInt(6, pedido.getQuantidade());
        sqlt.execute();
        sqlt.close();
        
        
        
    }
    
    public List<Pedido> pedidosVips() throws SQLException{
        List<Pedido> vips = new ArrayList<>();
        
        for(Pedido pedido: pedidosvips){
            if(pedido.getValorPedido() > 100){
                salvarPedido(pedido);
            }
        }
        
        return listaPedidos();
        
    }
    
    
    public List<Pedido> listaPedidos() throws SQLException{     
        List pedidos = new ArrayList<>();
        
        PreparedStatement stmt = conexao.prepareStatement("Select *from pedidos where valor > 100");
        
        ResultSet valor = stmt.executeQuery();
        
        int q = quantidadePedidos();
        
        Cliente [] auxiliar = null;
        Menu [] cardapio = null;
        Pedido [] p = null;
        
        int i = 0;
        
        while (valor.next()) {
            String cliente = valor.getString("cliente");
            String comida = valor.getString("comida");
            String bebida = valor.getString("bebida");
            String sobremesa = valor.getString("sobremesa");
            double valorPedido = valor.getDouble("valor");
            int quantidade = valor.getInt("quantidade");
                
            
            
            
            auxiliar[i] = new Cliente(cliente);
            cardapio[i] = new Menu(comida, bebida, sobremesa);
            
            p[i] = new Pedido(auxiliar[i], cardapio[i], quantidade, valorPedido);  
            
            pedidos.add(p[i]);
            
            i++;
            
        }
        
        
        return pedidos;
        
    }
    
    public int quantidadePedidos() throws SQLException{
        PreparedStatement stmt = conexao.prepareStatement("Select COUNT (id) from pedidos");
        
        ResultSet valor = stmt.executeQuery();
        
        int quantidadePedidos = valor.getFetchSize();
        
        
        return quantidadePedidos;
    }

    public Connection getConexao() {
        return conexao;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }
    
    
   
    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
    
   
   
    
    
}
