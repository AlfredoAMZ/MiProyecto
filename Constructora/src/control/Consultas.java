package control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import cliente.entity.Cliente;
import cliente.view.ClienteIO;
import cotizacion.entity.Cotizacion;
import cotizacion.view.CotizacionIO;
import herramienta.entity.Herramienta;
import herrramienta.view.HerramientaIO;
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

		String sql = "SELECT i.`Cod Inventario`,m.`Cod Material`,m. Nombre, m.Cantidad, h.`Cod Herramienta` , H.NombreH, H.Especificacion From material m INNER JOIN inventario i ON m.`Cod Material` = i.`Cod Inventario` INNER JOIN herramienta h ON h.`Cod Herramienta` = i.`Cod Inventario`";
		conexión.consulta(sql);
		resultSet = conexión.resultado();
		
		while (resultSet.next())
		{
			System.out.print("--Codigo de Inventario: ");
			System.out.println(resultSet.getInt("Cod Inventario"));
			System.out.print("-Codigo de Material: ");
			System.out.println(resultSet.getInt("Cod Material"));
			System.out.print("Nombre: ");
			System.out.println(resultSet.getString("Nombre"));
			System.out.print("Cantidad Existente: ");
			System.out.println(resultSet.getDouble("Cantidad"));
			System.out.print("-Codigo de Herrramienta: ");
			System.out.println(resultSet.getInt("Cod Herramienta"));
			System.out.print("Nombre: ");
			System.out.println(resultSet.getString("NombreH"));
			System.out.print("Especificacion: ");
			System.out.println(resultSet.getString("Especificacion"));
		}
		
		resultSet.close();
	}
	
	public void ObtenerRecibo() throws SQLException {
		
		ResultSet resultSet;

		String sql = "SELECT c1.`Numero Cotizacion`, c.CodCliente , c.`Nombre Completo` , c.`C.I` , o.`Cod Obrero` , o.`Nombre CompletoO`, o.CI , o.`Numero de Telefono` , m.`Cod Material` , m.Nombre, m.Cantidad, m.Precio  FROM cliente c INNER JOIN cotizacion c1 ON c.CodCliente = c1.`Numero Cotizacion` INNER JOIN obreros o ON O.`Cod Obrero` = C1.`Numero Cotizacion` INNER JOIN material m ON m.`Cod Material`= c1.`Numero Cotizacion`";
		conexión.consulta(sql);
		resultSet = conexión.resultado();
		
		while (resultSet.next())
		{
			System.out.print("--Numero de Cotizacion: ");
			System.out.println(resultSet.getInt("Numero Cotizacion"));
			System.out.print("-Codigo del Cliente: ");
			System.out.println(resultSet.getInt("CodCliente"));
			System.out.print("Nombre del Cliente: ");
			System.out.println(resultSet.getString("Nombre Completo"));
			System.out.print("CI: ");
			System.out.println(resultSet.getInt("C.I"));
			System.out.print("-Codigo del Obrero Asignado para el Trabajo: ");
			System.out.println(resultSet.getString("Cod Obrero"));
			System.out.print("Nombre del Obrero: ");
			System.out.println(resultSet.getString("Nombre CompletoO"));
			System.out.print("CI: ");
			System.out.println(resultSet.getInt("CI"));
			System.out.print("Numero de Telefono: ");
			System.out.println(resultSet.getInt("Numero de Telefono"));
			System.out.print("-Codigo del Material que se usará en el trabajo:  ");
			System.out.println(resultSet.getInt("Cod Material"));
			System.out.print("Material: ");
			System.out.println(resultSet.getString("Nombre"));
			System.out.print("Cantidad: ");
			System.out.println(resultSet.getDouble("Cantidad"));
			System.out.print("Precio: ");
			System.out.println(resultSet.getDouble("Precio"));
		}
		
		resultSet.close();
	}
	public void SacarCotizacion() {
		Cotizacion cotizacion = CotizacionIO.ingresar(scanner);
		String sql1 = "INSERT INTO cotizacion (`Numero Cotizacion`, `Cod Cliente`, `Cod Obrero`, `Cod Materiales`, Fecha)" + "values(?,?,?,?,?)";
		try {
		conexión.consulta(sql1);
		conexión.getSentencia().setInt(1, cotizacion.getCodMaterial());
		conexión.getSentencia().setInt(2, cotizacion.getCodCliente());
		conexión.getSentencia().setInt(3, cotizacion.getCodObrero());
		conexión.getSentencia().setInt(4, cotizacion.getCodMaterial());
		conexión.getSentencia().setString(5, cotizacion.getFecha());
		conexión.modificacion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void ModificarInventario(){
		
		try {
		conexión.consulta("UPDATE inventario i SET i.`Cod Herramientas` = ? , i.`Cod Material` =?, i.`Fecha Ultima revision` = ? WHERE i.`Cod Inventario` LIKE ? ");
		int CodI = InputTypes.readInt("Ingrese el Codigo del Inventario a Modificar:", scanner);
		int CodM = InputTypes.readInt("Ingrese el nuevo codigo de Material:", scanner);
		int CodHe = InputTypes.readInt("Ingrese el nuevo codigo de Herramienta:", scanner);
		String fecha = InputTypes.readString("Fecha de esta Modificacion:", scanner);
		
		conexión.getSentencia().setInt(1, CodHe);
		conexión.getSentencia().setInt(2, CodM);
		conexión.getSentencia().setString(3, fecha);
		conexión.getSentencia().setInt(4, CodI);
		conexión.modificacion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
