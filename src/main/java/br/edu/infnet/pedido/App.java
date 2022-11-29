package br.edu.infnet.pedido;

import java.sql.SQLException;
import java.util.List;

import br.edu.infnet.pedido.model.entidade.Especialidade;
import br.edu.infnet.pedido.model.entidade.Medico;
import br.edu.infnet.pedido.model.persistencia.MedicoDAO;

public class App
{
    public static void main( String[] args )
    {
        MedicoDAO medicoDAO = new MedicoDAO();
        System.out.println("Lista inicial de médicos:");
        List<Medico> medicos = medicoDAO.listarTodos();
        System.out.println(medicos);

		System.out.println( "Inserindo novo médico!" );
        Medico novoMedico = new Medico("medico novo", "12345rj", new Especialidade(1L));
        medicoDAO.salvar(novoMedico);

        medicos = medicoDAO.listarTodos();
        System.out.println(medicos);

        System.out.println("Alterando último médico:");
        int lastIndex = medicos.size() - 1;
        Medico ultimoMedico = medicos.get(lastIndex);
        ultimoMedico.setNome("nome alterado");
        medicoDAO.atualizar(ultimoMedico);

        System.out.println(medicoDAO.obter(ultimoMedico.getCodigo()));

        System.out.println("Removendo último médico:");
        medicoDAO.deletar(ultimoMedico);

        System.out.println("Lista final:");
        medicos = medicoDAO.listarTodos();
        System.out.println(medicos);
    }
}
