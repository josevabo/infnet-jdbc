package br.edu.infnet.pedido.model.persistencia;

import br.edu.infnet.pedido.model.entidade.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicoDAO extends JdbcDAO<Medico>{

	public MedicoDAO() {
	}

	@Override
	public Boolean salvar(Medico medico) {
		String sql = "insert into medico(codigo, nome, especialidade_codigo, crm) values (null, ?, ?,?)";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, medico.getNome());
			pstm.setLong(2, medico.getEspecialidade().getCodigo());
			pstm.setString(3, medico.getCrm());
			return pstm.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public Boolean atualizar(Medico medico) {
		String sql = "update medico set nome = ?, crm = ?, especialidade_codigo = ?  where codigo = ?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, medico.getNome());
			pstm.setString(2, medico.getCrm());
			pstm.setLong(3, medico.getEspecialidade().getCodigo());
			pstm.setLong(4, medico.getCodigo());
			return pstm.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean deletar(Medico medico) {
		String sql = "delete from medico where codigo = ?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setLong(1, medico.getCodigo());
			return pstm.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}



	@Override
	public Medico obter(Long codigo){
		String sql = "select m.codigo, m.nome, m.crm, e.codigo as especialidade_codigo, e.nome as especialidade_nome from medico m join especialidade e on m.especialidade_codigo = e.codigo where m.codigo = ? ";
		Medico medico = new Medico("medico novo", "12345rj", new Especialidade(1L));
		try {
			pstm = con.prepareStatement(sql);
			pstm.setLong(1, codigo);
			rs = pstm.executeQuery();
			if(rs.next()) {
				String nome = rs.getString("nome");
				String crm = rs.getString("crm");
				Long especialidade_codigo = rs.getLong("especialidade_codigo");
				String especialidade_nome = rs.getString("especialidade_nome");
				Long codigoDB = rs.getLong("codigo");
				medico = new Medico(codigoDB, nome, crm, new Especialidade(especialidade_codigo, especialidade_nome));
			}
			return medico;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public List<Medico> listarTodos(){
		String sql = "select m.codigo, m.nome, m.crm, m.especialidade_codigo, e.nome as especialidade_nome from medico m join especialidade e on m.especialidade_codigo = e.codigo";
		List<Medico> medicos = new ArrayList<>();
		try {
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next()) {
				String nome = rs.getString("nome");
				String crm = rs.getString("crm");
				Long especialidade_codigo = rs.getLong("especialidade_codigo");
				String especialidade_nome = rs.getString("especialidade_nome");
				Long codigoDB = rs.getLong("codigo");
				Medico medico = new Medico(codigoDB, nome, crm, new Especialidade(especialidade_codigo, especialidade_nome));
				medicos.add(medico);
			}
			return medicos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

}
