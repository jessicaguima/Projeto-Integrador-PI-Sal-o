package projeto.persistencia;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/* @Entity representa que no banco de dados haverá uma tabela relacionado diretamente com essa classe */
@Entity
public class Agendamentos {
    
    /* @Id indica que o atributo id representa um indentificador na tabela */
    @Id
    /* Como esse identifacor é AUTO_INCREMENT */
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    
    /* Atributos */
    private int id;
    private String data;
    private String hora;
    private String status;
    
    @ManyToOne
    @JoinColumn(name = "id_cliente") 
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name = "id_servicos")
    private Servicos servico;
    
    /* Gets e Sets */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servicos getServico() {
        return servico;
    }

    public void setServico(Servicos servico) {
        this.servico = servico;
    }
    
    
}
