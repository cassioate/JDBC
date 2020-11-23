package conecta.testes;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import conecta.DAO.ProfessorDAO;
import conecta.modelBean.Professor;

public class TesteProfessor {

	public static void main(String[] args) {
		
//		testeProfessorInsert();
//		testeProfessorUpdate();
//		testaDelete();
		testeSelecTodos();
	
	}
	
		public static void testeProfessorInsert() {
			
			Professor set = new Professor();
			
			@SuppressWarnings("resource")
			Scanner ler = new Scanner(System.in);
			
			System.out.println("Insira a matricula do Professor: ");
			set.setMatProf(ler.nextInt());
			System.out.println("Insira o nome do Professor: ");
			set.setNome(ler.next());
			System.out.println("Insira o id do curso do Professor: ");
			set.setCurso(ler.nextInt());
			System.out.println("Insira o salario do Professor: ");
			set.setSalario(ler.nextBigDecimal());
			System.out.println("Insira a cargaHoraria do Professor: ");
			set.setCargaHoraria(ler.nextInt());
			
			
			ProfessorDAO setDao = null;
				
			try {
				setDao = new ProfessorDAO();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			setDao.cadastrarProfessor(set);
	}
		
		public static void testeProfessorUpdate() {
			
			Professor set = new Professor();
			
			@SuppressWarnings("resource")
			Scanner ler = new Scanner(System.in);
			
			System.out.println("Insira o valor do salario: ");
			set.setSalario(ler.nextBigDecimal());
			System.out.println("Insira o nome do Professor: ");
			set.setNome(ler.next());
			
			ProfessorDAO setDao = null;
				
			try {
				setDao = new ProfessorDAO();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			setDao.updateProfessor(set);
	}
		
		public static void testaDelete() {

			Professor set = new Professor();

			@SuppressWarnings("resource")
			Scanner ler = new Scanner(System.in);

			System.out.println("Insira o nome do professor a ser deletado: ");
			set.setNome(ler.next());
			
			ProfessorDAO setDao = null;

			try {
				setDao = new ProfessorDAO();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			setDao.deleteProfessor(set);

		}
		
		public static void testeSelecTodos() {
			ProfessorDAO setDao = null;
			
			try {
				setDao = new ProfessorDAO();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			List<Professor> listaResultado = setDao.selectTodos();
			
			for (Professor p: listaResultado) {
				System.out.println(
						"Matricula: " + p.getMatProf() + "\n" +
						"Nome: " + p.getNome() + "\n" +
						"Curso: " + p.getCurso() + "\n" +
						"Salario: " + p.getSalario() + "\n" +
						"Carga Horaria: " + p.getCargaHoraria() + "\n"
						);
			}
		}
	
}
