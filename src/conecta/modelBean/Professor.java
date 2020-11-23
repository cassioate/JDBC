package conecta.modelBean;

import java.math.BigDecimal;

public class Professor {

	private int matProf;
	private String nome;
	private int curso;
	private BigDecimal salario;
	private int cargaHoraria;
	
	public int getMatProf() {
		return matProf;
	}
	public void setMatProf(int matProf) {
		this.matProf = matProf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCurso() {
		return curso;
	}
	public void setCurso(int curso) {
		this.curso = curso;
	}
	public BigDecimal getSalario() {
		return salario;
	}
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	public int getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	
}
