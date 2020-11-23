package conecta.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conecta.Conecta;
import conecta.modelBean.Aluno;
import conecta.modelBean.Curso;
import conecta.modelBean.Professor;

public class CursoDAO {

	private Connection con;

	public CursoDAO() throws SQLException, ClassNotFoundException {
		con = Conecta.criarConexão();
	}

	public void cadastrarCurso(Curso curso) {
		String sql = "INSERT INTO curso (id, nome, coordenador, turno) VALUES (?,?,?,?)";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, curso.getId());
			preparador.setString(2, curso.getNome());
			preparador.setString(3, curso.getCoordenador());
			preparador.setString(4, curso.getTurno());

			preparador.execute();
			preparador.close();

			System.out.println("Inserção realizada com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
		}
	}

	public void updateCurso(Curso curso) {

		String sql = "UPDATE curso SET turno = ? WHERE nome = ?";

		try {

			PreparedStatement preparador = con.prepareStatement(sql);

			preparador.setString(1, curso.getTurno());

			preparador.setString(2, curso.getNome());

			preparador.execute();

			preparador.close();

			System.out.println("Alteração realizada!");

		} catch (SQLException e) {

			System.out.println("Erro - " + e.getMessage());

		}
	}

	public void deleteCurso(Curso curso) {

		String sql = "DELETE FROM curso WHERE nome = ?";

		try {

			PreparedStatement preparador = con.prepareStatement(sql);

			preparador.setString(1, curso.getNome());

			preparador.execute();

			preparador.close();

			System.out.println("Deleção realizada!");

		} catch (SQLException e) {

			System.out.println("Erro - " + e.getMessage());

		}
	}

	public List<Curso> selectTodos() {

		String sql = "SELECT * FROM Curso";

		List<Curso> lista = new ArrayList<Curso>();

		try {

			PreparedStatement preparador = con.prepareStatement(sql);

			ResultSet resultados = preparador.executeQuery();

			while (resultados.next()) {
				Curso curso2 = new Curso();

				curso2.setId(resultados.getInt("id"));
				curso2.setNome(resultados.getString("nome"));
				curso2.setCoordenador(resultados.getString("coordenador"));
				curso2.setTurno(resultados.getString("turno"));

				lista.add(curso2);
			}

		} catch (SQLException e) {

			System.out.println("Erro - " + e.getMessage());

		}
		return lista;
	}
	
	public List<Curso> selectAlunos(Aluno aluno) {

		String sql = "SELECT a.*, c.id, c.nome as CursoNome, c.coordenador, c.turno as CursoTurno FROM Curso c, Aluno a WHERE a.curso = c.id AND a.matricula = ?";

		List<Curso> lista = new ArrayList<Curso>();

		try {
			
			PreparedStatement preparador = con.prepareStatement(sql);
			
			preparador.setInt(1, aluno.getMatricula());

			ResultSet resultados = preparador.executeQuery();

			while (resultados.next()) {
				Curso curso2 = new Curso();
				Aluno aluno2 = new Aluno();

				curso2.setId(resultados.getInt("id"));
				curso2.setNome(resultados.getString("CursoNome"));
				curso2.setCoordenador(resultados.getString("coordenador"));
				curso2.setTurno(resultados.getString("CursoTurno"));
				
				aluno2.setMatricula(resultados.getInt("matricula"));
				aluno2.setNome(resultados.getString("nome"));
				aluno2.setCurso(resultados.getInt("curso"));
				aluno2.setTurno(resultados.getString("turno"));
				aluno2.setPeriodo(resultados.getString("periodo"));
				
				curso2.getAluno().add(aluno2);

				lista.add(curso2);
			}

		} catch (SQLException e) {

			System.out.println("Erro - " + e.getMessage());

		}
		return lista;
	}
	
	public List<Curso> selectProfessor(Professor professor) {

		String sql = "SELECT p.*, c.id, c.nome as CursoNome, c.coordenador, "
				+ "c.turno as CursoTurno "
				+ "FROM Curso c, Professor p "
				+ "WHERE p.curso = c.id "
				+ "AND p.matProf = ?";

		List<Curso> lista = new ArrayList<Curso>();

		try {
			
			PreparedStatement preparador = con.prepareStatement(sql);
			
			preparador.setInt(1, professor.getMatProf());

			ResultSet resultados = preparador.executeQuery();

			while (resultados.next()) {
				Curso curso2 = new Curso();
				Professor prof2 = new Professor();

				curso2.setId(resultados.getInt("id"));
				curso2.setNome(resultados.getString("CursoNome"));
				curso2.setCoordenador(resultados.getString("coordenador"));
				curso2.setTurno(resultados.getString("CursoTurno"));
				
				prof2.setMatProf(resultados.getInt("matprof"));
				prof2.setNome(resultados.getString("nome"));
				prof2.setCurso(resultados.getInt("curso"));
				prof2.setSalario(resultados.getBigDecimal("salario"));
				prof2.setCargaHoraria(resultados.getInt("cargahoraria"));
				
				curso2.getProfessor().add(prof2);

				lista.add(curso2);
			}

		} catch (SQLException e) {

			System.out.println("Erro - " + e.getMessage());

		}
		return lista;
	}

}
