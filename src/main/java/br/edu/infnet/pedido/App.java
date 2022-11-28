package br.edu.infnet.pedido;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.edu.infnet.pedido.model.JdbcUtil;
import br.edu.infnet.pedido.model.entidade.Especialidade;
import br.edu.infnet.pedido.model.entidade.Medico;
import br.edu.infnet.pedido.model.persistencia.MedicoDAO;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException, ClassNotFoundException
    {
//    	Connection con = JdbcUtil.obterConexao();
        MedicoDAO medicoDAO = new MedicoDAO();

        List<Medico> medicos = medicoDAO.listarTodos();
        System.out.println(medicos);

		System.out.println( "Inserindo novo médico!" );
        Medico novoMedico = new Medico("medico novo", "12345rj", new Especialidade(1L));
        medicoDAO.salvar(novoMedico);

        medicos = medicoDAO.listarTodos();
        System.out.println(medicos);
    }
}
