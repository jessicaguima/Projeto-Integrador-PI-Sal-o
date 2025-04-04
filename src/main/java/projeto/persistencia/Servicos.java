package projeto.persistencia;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/* @Entity representa que no banco de dados haverá uma tabela relacionado diretamente com essa classe */
@Entity

public class Servicos {
    
    /* @Id indica que o atributo id representa um indentificador na tabela */
    @Id
    /* Como esse identifacor é AUTO_INCREMENT */
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    
    /* Atributos */
    private int id;
    private String tipo;
    private double preco;
    
    /* Gets e Sets */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    @Override
    public String toString() {
        return tipo + " - R$ " + String.format("%.2f", preco);        
    }
    
}
