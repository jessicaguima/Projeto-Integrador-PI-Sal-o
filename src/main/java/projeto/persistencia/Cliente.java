package projeto.persistencia;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/* @Entity representa que no banco de dados haverá uma tabela relacionado diretamente com essa classe */
@Entity
public class Cliente {
    
    /* @Id indica que o atributo id representa um indentificador na tabela */
    @Id
    /* Como esse identifacor é AUTO_INCREMENT */
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    
    /* Atributos */
    private int id;
    private String nome;
    private int idade;
    private String telefone;
    
    /* Gets e Sets */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
}
