
package classes;

import java.util.ArrayList;

public class Cliente {
    private String nome;
    private int telefone;
    
    public Cliente(String nome){
        this.nome = nome;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

   
    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
    
    @Override
	public String toString() {
		return " " + this.nome;
	}
    

    
}
