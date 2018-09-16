package control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import cliente.entity.Cliente;
import cliente.view.ClienteIO;
import cotizacion.entity.Cotizacion;
import herramienta.entity.Herramienta;
import inventario.entity.Inventario;
import material.entity.Material;
import obrero.entity.Obrero;
import view.InputTypes;

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
	
	public void ObtenerInventario() throws SQLException {
		ResultSet resultSet;
		Inventario Inventario;
		String Fecha;
		int CodInventario = InputTypes.readInt("Cód Inventario: ", scanner);
		String sql = "select * from Inventario where código = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, CodInventario );
		resultSet = conexión.resultado();
		resultSet.next();
		Fecha = resultSet.getString("Fecha Ultima Revision");
		Inventario = new Inventario(CodInventario, Fecha);
		System.out.println(Inventario);

		Herramienta herramienta;
		Double precio;
		int CodHerramienta;
		String FechaAdquisicion;
		String Especificacion;
		String LugarOrigen;

		sql = "select * from herramienta where Cod Inventario = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, CodInventario);
		resultSet = conexión.resultado();
		resultSet.next();
		CodHerramienta = resultSet.getInt("Cod Herramienta");
		FechaAdquisicion = resultSet.getString("Fecha de Aquisicion");
		precio = resultSet.getDouble("Precio");
		Especificacion = resultSet.getString("Especificacion");
		LugarOrigen = resultSet.getString("Lugar de Origen");
			
		herramienta = new Herramienta(CodHerramienta, FechaAdquisicion, precio, Especificacion, LugarOrigen);
		System.out.println(herramienta);
			
		Material material;
		int CodMaterial;
		Double cantidad;
		Double dimensiones;
		Double precio1;
		String LugarOrigen1;

		sql = "select * from material where Cod Inventario = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, CodInventario);
		resultSet = conexión.resultado();
		resultSet.next();
		CodMaterial = resultSet.getInt("Cod Material");
		cantidad = resultSet.getDouble("Cantidad");
		dimensiones = resultSet.getDouble("Dimensiones");
		precio1 = resultSet.getDouble("Precio");
		LugarOrigen1 = resultSet.getString("Lugar de Origen");
				
		material = new Material(CodMaterial, cantidad, dimensiones, precio1, LugarOrigen1);
		System.out.println(material);
				
	}
	
	public void ObtenerCotizacion() throws SQLException {
		ResultSet resultSet;
		Cotizacion Cotizacion;
		String Fecha;
		int NumCotizacion = InputTypes.readInt("Cod Cotizacion: ", scanner);
		String sql = "select * from Cotizacion where Numero Cotizacion = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, NumCotizacion );
		resultSet = conexión.resultado();
		resultSet.next();
		Fecha = resultSet.getString("Fecha");
		Cotizacion = new Cotizacion(NumCotizacion, Fecha);
		System.out.println(Cotizacion);

		Cliente cliente;
		int CodCliente;
		int CICliente;
		String NombreCompleto;

		sql = "select * from cliente where Numero Cotizacion = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, NumCotizacion);
		resultSet = conexión.resultado();
		resultSet.next();
		CodCliente = resultSet.getInt("Cod Cliente");
		CICliente = resultSet.getInt("C.I");
		NombreCompleto = resultSet.getString("Nombre Completo");
			
		cliente = new Cliente(CodCliente, CICliente, NombreCompleto);
		System.out.println(cliente);
			
		Material material;
		int CodMaterial;
		Double cantidad;
		Double dimensiones;
		Double precio;
		String LugarOrigen;

		sql = "select * from material where Numero Cotizacion = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, NumCotizacion);
		resultSet = conexión.resultado();
		resultSet.next();
		CodMaterial = resultSet.getInt("Cod Material");
		cantidad = resultSet.getDouble("Cantidad");
		dimensiones = resultSet.getDouble("Dimensiones");
		precio = resultSet.getDouble("Precio");
		LugarOrigen = resultSet.getString("Lugar de Origen");
				
		material = new Material(CodMaterial, cantidad, dimensiones, precio, LugarOrigen);
		System.out.println(material);
		
		Obrero Obrero;
		int CodObrero;
		int CI;
		String NombreCompletoO;
		String FechadeNacimiento;
		int Telefono;

		sql = "select * from obrero where Numero Cotizacion = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, NumCotizacion);
		resultSet = conexión.resultado();
		resultSet.next();
		CodObrero = resultSet.getInt("Cod Cliente");
		CI = resultSet.getInt("CI");
		NombreCompletoO = resultSet.getString("Nombre Completo");
		FechadeNacimiento = resultSet.getString("Fecha de Nacimiento");
		Telefono = resultSet.getInt("Numero de Telefono");
			
		Obrero = new Obrero(CodObrero, CI, NombreCompletoO,FechadeNacimiento,Telefono);
		System.out.println(Obrero);
			
	
				
	}

}
