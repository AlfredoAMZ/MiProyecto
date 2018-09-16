package control;

import java.sql.SQLException;
import java.util.Scanner;

import cliente.entity.Cliente;
import cliente.view.ClienteIO;

public class Consultas {
	
	private Conexion conexi�n;
	private Scanner scanner;

	public Consultas(Conexion conexi�n, Scanner scanner) {
		super();
		this.conexi�n = conexi�n;
		this.scanner = scanner;
	}

	public void RegistroCliente() {
		Cliente cliente = ClienteIO.ingresar(scanner);
		String sql = "Insert into Cliente (CodCliente, CICliente, NombreCompleto) " + "values(?,?,?)";
		try {
			conexi�n.consulta(sql);
			conexi�n.getSentencia().setInt(1, cliente.getCodCliente());
			conexi�n.getSentencia().setInt(2, cliente.getCICliente());
			conexi�n.getSentencia().setString(3, cliente.getNombreCompleto());
			conexi�n.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}
	
	

}
