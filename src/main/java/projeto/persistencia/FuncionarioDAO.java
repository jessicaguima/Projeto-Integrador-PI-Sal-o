package projeto.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FuncionarioDAO {
    public static Funcionario validarFuncionario(Funcionario funcionario) {
    // Criando consulta parametrizada
    String sql = "SELECT * FROM Funcionario WHERE nome = ? AND senha = ?";
    Funcionario funcionarioEncontrado = null;
                      
    try {
        Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/salao", "root", "papainoel");
        PreparedStatement statement = conexao.prepareStatement(sql);
                                  
        // Atribuindo os valores na consulta
        statement.setString(1, funcionario.getNome());
        statement.setString(2, funcionario.getSenha());
        ResultSet rs = statement.executeQuery();
                      
        while (rs.next()) {
            funcionarioEncontrado = new Funcionario();
            funcionarioEncontrado.setId(rs.getInt("id"));
            funcionarioEncontrado.setNome(rs.getString("nome"));
            funcionarioEncontrado.setSenha(rs.getString("senha"));            
            }
        
            rs.close();
            statement.close();
            conexao.close();
        }catch (SQLException ex) {
            System.out.println("Sintaxe de comando invalida");
        }      
                                  
        return funcionarioEncontrado;
    }
}
