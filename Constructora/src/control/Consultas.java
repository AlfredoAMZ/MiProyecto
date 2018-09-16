package control;

import java.sql.SQLException;
import java.util.Scanner;

import cliente.entity.Cliente;
import cliente.view.ClienteIO;

public class Consultas {
	
	private Conexion conexión;
	private Scanner scanner;

	public Consultas(Conexion conexión, Scanner scanner) {
		super();
		this.conexión = conexión;
		this.scanner = scanner;
	}

	public void RegistroCliente() {
		Cliente cliente = ClienteIO.ingresar(scanner);
		String sql = "Insert into Cliente (CodCliente, CICliente, NombreCompleto) " + "values(?,?,?)";
		try {
			conexión.consulta(sql);
			conexión.getSentencia().setInt(1, cliente.getCodCliente());
			conexión.getSentencia().setInt(2, cliente.getCICliente());
			conexión.getSentencia().setString(3, cliente.getNombreCompleto());
			conexión.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}
	
	

}
