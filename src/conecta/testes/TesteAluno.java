package conecta.testes;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import conecta.DAO.AlunoDAO;
import conecta.modelBean.Aluno;

public class TesteAluno {

	public static void main(String[] args) {
		
//		testeAlunoInsert();
//		testeAlunoUpdate();
//		testaDelete();
		testeSelecTodos();
			
	}
	
		public static void testeAlunoInsert() {
			
			Aluno set = new Aluno();
			
			@SuppressWarnings("resource")
			Scanner ler = new Scanner(System.in);
			
			System.out.println("Insira a matricula do aluno: ");
			set.setMatricula(ler.nextInt());
			System.out.println("Insira o nome do aluno: ");
			set.setNome(ler.next());
			System.out.println("Insira o id do curso: ");
			set.setCurso(ler.nextInt());
			System.out.println("Insira o turno de estudo do aluno: ");
			set.setTurno(ler.next());
			System.out.println("Insira o periodo: ");
			set.setTurno(ler.next());
			
			
			AlunoDAO setDao = null;
			
			try {
				setDao = new AlunoDAO();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			setDao.cadastrarAluno(set);
	}
		
		public static void testeAlunoUpdate() {
			
			Aluno set = new Aluno();
			
			@SuppressWarnings("resource")
			Scanner ler = new Scanner(System.in);
			
			System.out.println("Insira a correção do periodo: ");
			set.setPeriodo(ler.next());
			System.out.println("Insira o nome do aluno: ");
			set.setNome(ler.next());
			
			AlunoDAO setDao = null;
				
			try {
				setDao = new AlunoDAO();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			setDao.updateAluno(set);
	}
		
		public static void testaDelete() {

			Aluno set = new Aluno();

			@SuppressWarnings("resource")
			Scanner ler = new Scanner(System.in);

			System.out.println("Insira o nome do aluno a ser deletado: ");
			set.setNome(ler.next());
			
			AlunoDAO setDao = null;

			try {
				setDao = new AlunoDAO();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			setDao.deleteAluno(set);

		}
		
		public static void testeSelecTodos() {
			AlunoDAO setDao = null;
			
			try {
				setDao = new AlunoDAO();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			List<Aluno> listaResultado = setDao.selectTodos();
			
			for (Aluno a: listaResultado) {
				System.out.println(
						"Matricula: " + a.getMatricula() + "\n" +
						"Nome: " + a.getNome() + "\n" +
						"Curso: " + a.getCurso() + "\n" +
						"Turno: " + a.getTurno() + "\n" +
						"Periodo: " + a.getPeriodo() + "\n"
						);
			}
		}
}
