package inventario.entity;


public class Inventario {

	private int CodInventario;
	private String Fecha;
	
	public Inventario(int codInventario, String fecha) {
		super();
		CodInventario = codInventario;
		Fecha = fecha;
	}
	public int getCodInventario() {
		return CodInventario;
	}
	public void setCodInventario(int codInventario) {
		CodInventario = codInventario;
	}
	public String getFecha() {
		return Fecha;
	}
	public void setFecha(String fecha) {
		Fecha = fecha;
	}
	@Override
	public String toString() {
		return "Inventario [CodInventario=" + CodInventario + ", Fecha=" + Fecha + "]";
	}
		
}
