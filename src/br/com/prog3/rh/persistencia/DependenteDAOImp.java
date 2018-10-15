package br.com.prog3.rh.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.prog3.rh.controller.DependenteController;
import br.com.prog3.rh.negocio.Dependente;

public class DependenteDAOImp implements DependenteDAO {

	@Override
	public String inserir(Dependente dep) {
		StringBuilder sql = new StringBuilder();
		sql.append(
				"insert into dependente(cpfEmpregado," + "nome,grauParentesco,dataNascimento) " + "values (?,?,?,?)");
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setString(1, dep.getCpfempregado());
			pst.setString(2, dep.getNome());
			pst.setString(3, dep.getGrauparentesco());
			pst.setObject(4, dep.getDataNascimento());
			int res = pst.executeUpdate();
			if (res > 0) {
				return "Inserido com sucesso.";
			} else {
				return "Erro ao inserir.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		} finally {
			ConnectionFactory.close(con);
		}
	}

	@Override
	public String alterar(Dependente dep) {
		StringBuilder sql = new StringBuilder();
		sql.append("update dependente set grauParentesco=?," + "dataNascimento=? where nome=? " + "and cpfEmpregado=?");
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setString(1, dep.getGrauparentesco());
			pst.setObject(2, dep.getDataNascimento());
			pst.setString(3, dep.getNome());
			pst.setString(4, dep.getCpfempregado());
			int res = pst.executeUpdate();
			if (res > 0) {
				return "Alterado com sucesso.";
			} else {
				return "Erro ao alterar.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		} finally {
			ConnectionFactory.close(con);
		}
	}

	@Override
	public String excluir(Dependente dep) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from dependente where nome=? " + "and cpfEmpregado=?");
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setString(1, dep.getNome());
			pst.setString(2, dep.getCpfempregado());
			int res = pst.executeUpdate();
			if (res > 0) {
				return "Excluído com sucesso.";
			} else {
				return "Erro ao excluir.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		} finally {
			ConnectionFactory.close(con);
		}
	}

	@Override
	public List<Dependente> listarTodos() {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from dependente order by nome");
		Connection con = ConnectionFactory.getConnection();
		List<Dependente> lista = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			ResultSet rs = pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Dependente dep = new Dependente();
					dep.setCpfempregado(rs.getString(1));
					dep.setNome(rs.getString(2));
					dep.setGrauparentesco(rs.getString(3));
					dep.setDataNascimento(rs.getObject(4, LocalDate.class));
					lista.add(dep);
				}
				return lista;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		} finally {
			ConnectionFactory.close(con);
		}
	}

	@Override
	public List<Dependente> pesquisarPorEmpregado(String cpf) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from dependente where cpfempregado = ? order by nome");
		Connection con = ConnectionFactory.getConnection();
		List<Dependente> lista = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setString(1, cpf);
			ResultSet rs = pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Dependente dep = new Dependente();
					dep.setCpfempregado(rs.getString(1));
					dep.setNome(rs.getString(2));
					dep.setGrauparentesco(rs.getString(3));
					dep.setDataNascimento(rs.getObject(4, LocalDate.class));
					lista.add(dep);
				}
				return lista;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		} finally {
			ConnectionFactory.close(con);
		}
	}

}
