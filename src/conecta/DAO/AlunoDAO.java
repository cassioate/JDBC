package conecta.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conecta.Conecta;
import conecta.modelBean.Aluno;

public class AlunoDAO {

	private Connection con;
	
	public AlunoDAO() throws SQLException, ClassNotFoundException {
		con = Conecta.criarConexão();
	}

	public void cadastrarAluno (Aluno aluno) {
		String sql = "INSERT INTO aluno (matricula, nome, curso, turno, periodo) VALUES (?,?,?,?,?)";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, aluno.getMatricula());
			preparador.setString(2, aluno.getNome());
			preparador.setInt(3, aluno.getCurso());
			preparador.setString(4, aluno.getTurno());
			preparador.setString(5, aluno.getPeriodo());
			
			preparador.execute();
			preparador.close();
			
			System.out.println("Inserção realizada com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
		}
	}
	
	public void updateAluno(Aluno aluno) {

		String sql = "UPDATE aluno SET periodo = ? WHERE nome = ?";

		try {

		PreparedStatement preparador = con.prepareStatement(sql);

		preparador.setString(1, aluno.getPeriodo());

		preparador.setString(2, aluno.getNome());

		preparador.execute();

		preparador.close();

		System.out.println("Alteração realizada!");
		

		} catch (SQLException e) {

		System.out.println("Erro - "+ e.getMessage());

		}
	}
	
	public void deleteAluno(Aluno aluno) {

		String sql = "DELETE FROM aluno WHERE nome = ?";

		try {

		PreparedStatement preparador = con.prepareStatement(sql);

		preparador.setString(1, aluno.getNome());

		preparador.execute();

		preparador.close();

		System.out.println("Deleção realizada!");

		} catch (SQLException e) {

		System.out.println("Erro - "+ e.getMessage());

		}
	}
	
	public List<Aluno> selectTodos() {

		String sql = "SELECT * FROM Aluno";

		List<Aluno> lista = new ArrayList<Aluno>();

		try {

			PreparedStatement preparador = con.prepareStatement(sql);

			ResultSet resultados = preparador.executeQuery();

			while (resultados.next()) {
				Aluno aluno2 = new Aluno();

				aluno2.setMatricula(resultados.getInt("matricula"));
				aluno2.setNome(resultados.getString("nome"));
				aluno2.setCurso(resultados.getInt("curso"));
				aluno2.setTurno(resultados.getString("turno"));
				aluno2.setPeriodo(resultados.getString("periodo"));

				lista.add(aluno2);
			}

		} catch (SQLException e) {

			System.out.println("Erro - " + e.getMessage());

		}
		return lista;
	}
	
}
