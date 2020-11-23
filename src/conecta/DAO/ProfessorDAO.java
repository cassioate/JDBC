package conecta.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conecta.Conecta;
import conecta.modelBean.Professor;

public class ProfessorDAO {

	private Connection con;
	
	public ProfessorDAO() throws SQLException, ClassNotFoundException {
		con = Conecta.criarConexão();
	}
	
	public void cadastrarProfessor (Professor prof) {
		String sql = "INSERT INTO professor (matProf, nome, curso, salario, cargaHoraria) VALUES (?,?,?,?,?)";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, prof.getMatProf() );
			preparador.setString(2, prof.getNome());
			preparador.setInt(3, prof.getCurso());
			preparador.setBigDecimal(4, prof.getSalario());
			preparador.setInt(5, prof.getCargaHoraria());
			
			preparador.execute();
			preparador.close();
			
			System.out.println("Inserção realizada com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
		}
	}
	
	public void updateProfessor(Professor prof) {

		String sql = "UPDATE professor SET salario = ? WHERE nome = ?";

		try {

		PreparedStatement preparador = con.prepareStatement(sql);

		preparador.setBigDecimal(1, prof.getSalario());

		preparador.setString(2, prof.getNome());

		preparador.execute();

		preparador.close();

		System.out.println("Alteração realizada!");
		

		} catch (SQLException e) {

		System.out.println("Erro - "+ e.getMessage());

		}
	}
	
	public void deleteProfessor(Professor professor) {

		String sql = "DELETE FROM professor WHERE nome = ?";

		try {

		PreparedStatement preparador = con.prepareStatement(sql);

		preparador.setString(1, professor.getNome());

		preparador.execute();

		preparador.close();

		System.out.println("Deleção realizada!");

		} catch (SQLException e) {

		System.out.println("Erro - "+ e.getMessage());

		}
	}
	
	public List<Professor> selectTodos() {

		String sql = "SELECT * FROM Professor";

		List<Professor> lista = new ArrayList<Professor>();

		try {

			PreparedStatement preparador = con.prepareStatement(sql);

			ResultSet resultados = preparador.executeQuery();

			while (resultados.next()) {
				Professor professor2 = new Professor();

				professor2.setMatProf(resultados.getInt("matprof"));
				professor2.setNome(resultados.getString("nome"));
				professor2.setCurso(resultados.getInt("curso"));
				professor2.setSalario(resultados.getBigDecimal("salario"));
				professor2.setCargaHoraria(resultados.getInt("cargahoraria"));

				lista.add(professor2);
			}

		} catch (SQLException e) {

			System.out.println("Erro - " + e.getMessage());

		}
		return lista;
	}
}
