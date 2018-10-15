package br.com.prog3.rh.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.prog3.rh.negocio.Empregado;
import br.com.prog3.rh.persistencia.ConnectionFactory;
import br.com.prog3.rh.persistencia.EmpregadoDAOImp;

public class EmpregadoController {

	public String inserir(Empregado emp) {
		String sql = "insert into empregado(cpf,nome,idade,salario) values (?,?,?,?)";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, emp.getCpf());
			pst.setString(2, emp.getNome());
			pst.setInt(3, emp.getIdade());
			pst.setDouble(4, emp.getSalario());
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

	public String alterar(Empregado emp) {
		String sql = "update empregado set nome=?,idade=?,salario=? where cpf=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, emp.getNome());
			pst.setInt(2, emp.getIdade());
			pst.setDouble(3, emp.getSalario());
			pst.setString(4, emp.getCpf());
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

	public String excluir(Empregado emp) {
		String sql = "delete from empregado where cpf=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, emp.getCpf());
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

	public List<Empregado> listarTodos() {
		String sql = "select * from empregado";
		Connection con = ConnectionFactory.getConnection();
		List<Empregado> lista = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Empregado ep = new Empregado();
					ep.setCpf(rs.getString(1));
					ep.setNome(rs.getString(2));
					ep.setIdade(rs.getInt(3));
					ep.setSalario(rs.getDouble(4));
					lista.add(ep);
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

	public Empregado pesquisarPorCpf(String cpf) {
		String sql = "select * from empregado where cpf=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, cpf);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Empregado ep = new Empregado();
				ep.setCpf(rs.getString(1));
				ep.setNome(rs.getString(2));
				ep.setIdade(rs.getInt(3));
				ep.setSalario(rs.getDouble(4));
				return ep;
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
