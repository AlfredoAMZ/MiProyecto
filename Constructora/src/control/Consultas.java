package control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import cliente.entity.Cliente;
import cliente.view.ClienteIO;
import cotizacion.entity.Cotizacion;
import herramienta.entity.Herramienta;
import herrramienta.view.HerramientaIO;
import inventario.entity.Inventario;
import material.entity.Material;
import material.view.MaterialIO;
import obrero.entity.Obrero;
import obrero.view.ObreroIO;
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
		String sql = "INSERT INTO cliente (CodCliente, `C.I`, `Nombre Completo`) VALUES (?, ?, ?)";
		try {
			conexión.consulta(sql);
			conexión.getSentencia().setInt(1, cliente.getCodCliente());
			conexión.getSentencia().setInt(2, cliente.getCICliente());
			conexión.getSentencia().setString(3, cliente.getNombreCompleto());
			conexión.modificacion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void RegistroHerramientas() {
		Herramienta herramienta = HerramientaIO.ingresar(scanner);
		String sql1 = "Insert into Herramienta (`Cod Herramienta`, `Cod Inventario`, Nombre, `Fecha Adquisicion`, Precio, Especificacion, `Lugar de Origen`) " + "values(?,?,?,?,?,?,?)";
		try {
		conexión.consulta(sql1);
		conexión.getSentencia().setInt(1, herramienta.getCodHerramienta());
		conexión.getSentencia().setInt(2, herramienta.getCodInventario());
		conexión.getSentencia().setString(3, herramienta.getNombre());
		conexión.getSentencia().setString(4, herramienta.getFechaAdquisicion());
		conexión.getSentencia().setDouble(5, herramienta.getPrecio());
		conexión.getSentencia().setString(6, herramienta.getEspecificacion());
		conexión.getSentencia().setString(7, herramienta.getLugarOrigen());
		conexión.modificacion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	public void RegistroMaterial() {
		Material material = MaterialIO.ingresar(scanner);
		String sql1 = "Insert into Material  (`Cod Material`, `Cod Inventario`, Nombre, Cantidad, Precio, Dimensiones, `Lugar de Origen`) " + "values(?,?,?,?,?,?,?)";
		try {
		conexión.consulta(sql1);
		conexión.getSentencia().setInt(1, material.getCodMaterial());
		conexión.getSentencia().setInt(2, material.getCodInventario());
		conexión.getSentencia().setString(3, material.getNombre());
		conexión.getSentencia().setDouble(4, material.getCantidad());
		conexión.getSentencia().setString(5, material.getDimensiones());
		conexión.getSentencia().setDouble(6, material.getPrecio());
		conexión.getSentencia().setString(7, material.getLugarOrigen());
		conexión.modificacion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void RegistroObrero() {
		Obrero obrero = ObreroIO.ingresar(scanner);
		String sql1 = "Insert into Obreros (`Cod Obrero`, CI, `Nombre Completo`, `Fecha de Nacimiento`, `Numero de Telefono`) " + "values(?,?,?,?,?)";
		try {
		conexión.consulta(sql1);
		conexión.getSentencia().setInt(1, obrero.CodObrero());
		conexión.getSentencia().setInt(2, obrero.getCI());
		conexión.getSentencia().setString(3, obrero.getNombreCompleto());
		conexión.getSentencia().setString(4, obrero.getFechadeNacimiento());
		conexión.getSentencia().setInt(5, obrero.getTelefono());
		conexión.modificacion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public void ObtenerInventario() throws SQLException {
		ResultSet resultSet;
		Inventario Inventario;
		String Fecha;
		int CodInventario = InputTypes.readInt("Cód Inventario: ", scanner);
		String sql = "SELECT i.`Cod Inventario`,m.`Cod Material`,h.`Cod Herramienta` From material m INNER JOIN inventario iON m.`Cod Material` = i.`Cod Inventario` INNER JOIN herramienta hON h.`Cod Herramienta` = i.`Cod Inventario`";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, CodInventario );
		resultSet = conexión.resultado();
		resultSet.next();
		Fecha = resultSet.getString("Fecha Ultima Revision");
		Inventario = new Inventario(CodInventario, Fecha);
		System.out.println(Inventario);

		
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
		int CodInventario;
		String Nombre;
		Double cantidad;
		String dimensiones;
		Double precio;
		String LugarOrigen;

		sql = "select * from material where Numero Cotizacion = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, NumCotizacion);
		resultSet = conexión.resultado();
		resultSet.next();
		CodMaterial = resultSet.getInt("Cod Material");
		CodInventario= resultSet.getInt("Cod Inventario");
		Nombre=resultSet.getString("Nombre");
		cantidad = resultSet.getDouble("Cantidad");
		dimensiones = resultSet.getString("Dimensiones");
		precio = resultSet.getDouble("Precio");
		LugarOrigen = resultSet.getString("Lugar de Origen");
				
		material = new Material(CodMaterial, CodInventario,Nombre, cantidad, dimensiones, precio, LugarOrigen);
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
