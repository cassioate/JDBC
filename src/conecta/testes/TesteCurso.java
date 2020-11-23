package conecta.testes;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import conecta.DAO.CursoDAO;
import conecta.modelBean.Aluno;
import conecta.modelBean.Curso;
import conecta.modelBean.Professor;

public class TesteCurso {

	public static void main(String[] args) {

//		testeCursoInsert();
//		testeCursoUpdate();
//		testaDelete();
//		testeSelecTodos();
//		testeSelecAlunos();
		testeSelecProfessor();

	}

	public static void testeCursoInsert() {

		Curso set = new Curso();

		@SuppressWarnings("resource")
		Scanner ler = new Scanner(System.in);

		System.out.println("Insira o id do curso: ");
		set.setId(ler.nextInt());
		System.out.println("Insira o nome do curso: ");
		set.setNome(ler.next());
		System.out.println("Insira o coordenador do curso: ");
		set.setCoordenador(ler.next());
		System.out.println("Insira o turno do curso: ");
		set.setTurno(ler.next());

		CursoDAO setDao = null;

		try {
			setDao = new CursoDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		setDao.cadastrarCurso(set);
	}

	public static void testeCursoUpdate() {

		Curso set = new Curso();

		@SuppressWarnings("resource")
		Scanner ler = new Scanner(System.in);

		System.out.println("Insira a correção do turno: ");
		set.setTurno(ler.next());
		System.out.println("Insira o nome do curso: ");
		set.setNome(ler.next());

		CursoDAO setDao = null;

		try {
			setDao = new CursoDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		setDao.updateCurso(set);
	}

	public static void testaDelete() {

		Curso set = new Curso();

		@SuppressWarnings("resource")
		Scanner ler = new Scanner(System.in);

		System.out.println("Insira o nome do curso a ser deletado: ");
		set.setNome(ler.next());
		
		CursoDAO setDao = null;

		try {
			setDao = new CursoDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		setDao.deleteCurso(set);

	}
	
	public static void testeSelecTodos() {
		CursoDAO setDao = null;
		
		try {
			setDao = new CursoDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		List<Curso> listaResultado = setDao.selectTodos();
		
		for (Curso c: listaResultado) {
			System.out.println(
					"ID: " + c.getId() + "\n" +
					"Nome: " + c.getNome() + "\n" +
					"Coordenador: " + c.getCoordenador() + "\n" +
					"Turno: " + c.getTurno() + "\n"
					);
		}
	}
	
	
	public static void testeSelecAlunos() {
		Aluno set = new Aluno();
		
		@SuppressWarnings("resource")
		Scanner ler = new Scanner(System.in);

		System.out.println("Insira a matricula: ");
		set.setMatricula(ler.nextInt());
		
		CursoDAO setDao = null;
		
		try {
			setDao = new CursoDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		List<Curso> listaResultado = setDao.selectAlunos(set);
		
		for (Curso c: listaResultado) {
			System.out.println(
					"ID: " + c.getId() + "\n" +
					"Nome: " + c.getNome() + "\n" +
					"Coordenador: " + c.getCoordenador() + "\n" +
					"Turno: " + c.getTurno() + "\n" +
					"Matricula do Aluno: " + c.getAluno().get(0).getMatricula() + "\n" +
					"Nome do Aluno: " + c.getAluno().get(0).getNome() + "\n" +
					"Curso do Aluno: " + c.getAluno().get(0).getCurso() + "\n" +
					"Turno do Aluno: " + c.getAluno().get(0).getTurno() + "\n" +
					"Periodo do Aluno: " + c.getAluno().get(0).getPeriodo() + "\n"
					);
		}
	}
	
	public static void testeSelecProfessor() {
		Professor set = new Professor();
		
		@SuppressWarnings("resource")
		Scanner ler = new Scanner(System.in);

		System.out.println("Insira a matricula: ");
		set.setMatProf(ler.nextInt());
		
		CursoDAO setDao = null;
		
		try {
			setDao = new CursoDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		List<Curso> listaResultado = setDao.selectProfessor(set);
		
		for (Curso c: listaResultado) {
			System.out.println(
					"ID: " + c.getId() + "\n" +
					"Nome: " + c.getNome() + "\n" +
					"Coordenador: " + c.getCoordenador() + "\n" +
					"Turno: " + c.getTurno() + "\n" +
					"Matricula do Professor: " + c.getProfessor().get(0).getMatProf() + "\n" +
					"Nome do Professor: " + c.getProfessor().get(0).getNome() + "\n" +
					"Curso do Professor: " + c.getProfessor().get(0).getCurso() + "\n" +
					"Salario do Professor: " + c.getProfessor().get(0).getSalario() + "\n" +
					"Carga Horaria do Professor: " + c.getProfessor().get(0).getCargaHoraria() + "\n"
					);
		}
	}
	
}
