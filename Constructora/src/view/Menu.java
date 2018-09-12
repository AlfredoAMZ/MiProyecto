package view;

import java.sql.SQLException;
import java.util.Scanner;

import control.Conexion;
import view.InputTypes;

public class Menu {

	/****************************
	 * Encabezado del men� *
	 ****************************/

	public static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Registrar Cliente");
			System.out.println("2. Obtener Cotizacion ");
			System.out.println("3. Sacar Recibo ");
			System.out.println("4. Revisar Inventario");
			System.out.println("5. Ver Ganancias");
			
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("�Su opci�n? ", scanner);

			if (opcion >= 0 && opcion <= 5) {
				return opcion;
			}
		}
	}

	/****************************
	 * Opciones del men� 
	 * @throws SQLException 
	 * @throws ClassNotFoundException *
	 ****************************/

	public static void men�(Scanner scanner) throws ClassNotFoundException, SQLException {
		boolean salir = false;
		
		Conexion conexi�n = new Conexion("root","","Tienda");
		CategoriasIO categor�asIO = new CategoriasIO(conexi�n, scanner);
		ProductosIO productosIO = new ProductosIO(conexi�n, scanner);
		
		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				try {
					categoria.view.Menu.men�(scanner, categor�asIO);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 2:
			{
				producto.view.Menu.men�(scanner, productosIO);
				break;
			}
			case 3:
			{
				
			break;
			}
			case 4:
			{
				
			break;
			}
			case 5:
			{
				
			break;
			}
		}
		conexi�n.close();
	}
}
}
