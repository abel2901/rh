package br.com.prog3.rh.negocio;

import java.time.LocalDate;

public class Dependente {
	
	private String cpfempregado;
	private String nome;
	private String grauparentesco;
	private LocalDate dataNascimento;
	public Dependente(){}
	public String getCpfempregado() {
		return cpfempregado;
	}
	public void setCpfempregado(String cpfempregado) {
		this.cpfempregado = cpfempregado;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getGrauparentesco() {
		return grauparentesco;
	}
	public void setGrauparentesco(String grauparentesco) {
		this.grauparentesco = grauparentesco;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
