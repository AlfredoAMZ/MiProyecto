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
	
	private Conexion conexi�n;
	private Scanner scanner;

	public Consultas(Conexion conexi�n, Scanner scanner) {
		super();
		this.conexi�n = conexi�n;
		this.scanner = scanner;
	}

	public void RegistroCliente() {
		Cliente cliente = ClienteIO.ingresar(scanner);
		String sql = "INSERT INTO cliente (CodCliente, `C.I`, `Nombre Completo`) VALUES (?, ?, ?)";
		try {
			conexi�n.consulta(sql);
			conexi�n.getSentencia().setInt(1, cliente.getCodCliente());
			conexi�n.getSentencia().setInt(2, cliente.getCICliente());
			conexi�n.getSentencia().setString(3, cliente.getNombreCompleto());
			conexi�n.modificacion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void RegistroHerramientas() {
		Herramienta herramienta = HerramientaIO.ingresar(scanner);
		String sql1 = "Insert into Herramienta (`Cod Herramienta`, `Cod Inventario`, Nombre, `Fecha Adquisicion`, Precio, Especificacion, `Lugar de Origen`) " + "values(?,?,?,?,?,?,?)";
		try {
		conexi�n.consulta(sql1);
		conexi�n.getSentencia().setInt(1, herramienta.getCodHerramienta());
		conexi�n.getSentencia().setInt(2, herramienta.getCodInventario());
		conexi�n.getSentencia().setString(3, herramienta.getNombre());
		conexi�n.getSentencia().setString(4, herramienta.getFechaAdquisicion());
		conexi�n.getSentencia().setDouble(5, herramienta.getPrecio());
		conexi�n.getSentencia().setString(6, herramienta.getEspecificacion());
		conexi�n.getSentencia().setString(7, herramienta.getLugarOrigen());
		conexi�n.modificacion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	public void RegistroMaterial() {
		Material material = MaterialIO.ingresar(scanner);
		String sql1 = "Insert into Material  (`Cod Material`, `Cod Inventario`, Nombre, Cantidad, Precio, Dimensiones, `Lugar de Origen`) " + "values(?,?,?,?,?,?,?)";
		try {
		conexi�n.consulta(sql1);
		conexi�n.getSentencia().setInt(1, material.getCodMaterial());
		conexi�n.getSentencia().setInt(2, material.getCodInventario());
		conexi�n.getSentencia().setString(3, material.getNombre());
		conexi�n.getSentencia().setDouble(4, material.getCantidad());
		conexi�n.getSentencia().setString(5, material.getDimensiones());
		conexi�n.getSentencia().setDouble(6, material.getPrecio());
		conexi�n.getSentencia().setString(7, material.getLugarOrigen());
		conexi�n.modificacion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void RegistroObrero() {
		Obrero obrero = ObreroIO.ingresar(scanner);
		String sql1 = "Insert into Obreros (`Cod Obrero`, CI, `Nombre Completo`, `Fecha de Nacimiento`, `Numero de Telefono`) " + "values(?,?,?,?,?)";
		try {
		conexi�n.consulta(sql1);
		conexi�n.getSentencia().setInt(1, obrero.CodObrero());
		conexi�n.getSentencia().setInt(2, obrero.getCI());
		conexi�n.getSentencia().setString(3, obrero.getNombreCompleto());
		conexi�n.getSentencia().setString(4, obrero.getFechadeNacimiento());
		conexi�n.getSentencia().setInt(5, obrero.getTelefono());
		conexi�n.modificacion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public void ObtenerInventario() throws SQLException {
		ResultSet resultSet;
		Inventario Inventario;
		String Fecha;
		int CodInventario = InputTypes.readInt("C�d Inventario: ", scanner);
		String sql = "SELECT i.`Cod Inventario`,m.`Cod Material`,h.`Cod Herramienta` From material m INNER JOIN inventario iON m.`Cod Material` = i.`Cod Inventario` INNER JOIN herramienta hON h.`Cod Herramienta` = i.`Cod Inventario`";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, CodInventario );
		resultSet = conexi�n.resultado();
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
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, NumCotizacion );
		resultSet = conexi�n.resultado();
		resultSet.next();
		Fecha = resultSet.getString("Fecha");
		Cotizacion = new Cotizacion(NumCotizacion, Fecha);
		System.out.println(Cotizacion);

		Cliente cliente;
		int CodCliente;
		int CICliente;
		String NombreCompleto;

		sql = "select * from cliente where Numero Cotizacion = ?";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, NumCotizacion);
		resultSet = conexi�n.resultado();
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
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, NumCotizacion);
		resultSet = conexi�n.resultado();
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
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, NumCotizacion);
		resultSet = conexi�n.resultado();
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
