package br.com.prog3.rh.controller;

import java.util.List;

import br.com.prog3.rh.negocio.Dependente;
import br.com.prog3.rh.persistencia.DependenteDAOImp;

public class DependenteController {
	public String inserir(Dependente dep) {
		DependenteDAOImp dao = new DependenteDAOImp();
		return dao.inserir(dep);
	}

	public String alterar(Dependente dep) {
		DependenteDAOImp dao = new DependenteDAOImp();
		return dao.alterar(dep);
	}

	public String excluir(Dependente dep) {
		DependenteDAOImp dao = new DependenteDAOImp();
		return dao.excluir(dep);
	}

	public List<Dependente> listarTodos() {
		DependenteDAOImp dao = new DependenteDAOImp();
		return dao.listarTodos();
	}

	public List<Dependente> pesquisarPorEmpregado(String cpf) {
		DependenteDAOImp dao = new DependenteDAOImp();
		return dao.pesquisarPorEmpregado(cpf);
	}
	
}
