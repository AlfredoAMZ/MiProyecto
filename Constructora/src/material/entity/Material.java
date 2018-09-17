package material.entity;

public class Material {
	
	private int CodMaterial;
	private int CodInventario;
	private String Nombre;
	private double Cantidad;
	private String Dimensiones;
	private double Precio;
	private String LugarOrigen;
	public Material(int codMaterial, int codInventario, String nombre, double cantidad, String dimensiones,
			double precio, String lugarOrigen) {
		super();
		CodMaterial = codMaterial;
		CodInventario = codInventario;
		Nombre = nombre;
		Cantidad = cantidad;
		Dimensiones = dimensiones;
		Precio = precio;
		LugarOrigen = lugarOrigen;
	}
	public int getCodMaterial() {
		return CodMaterial;
	}
	public void setCodMaterial(int codMaterial) {
		CodMaterial = codMaterial;
	}
	public int getCodInventario() {
		return CodInventario;
	}
	public void setCodInventario(int codInventario) {
		CodInventario = codInventario;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public double getCantidad() {
		return Cantidad;
	}
	public void setCantidad(double cantidad) {
		Cantidad = cantidad;
	}
	public String getDimensiones() {
		return Dimensiones;
	}
	public void setDimensiones(String dimensiones) {
		Dimensiones = dimensiones;
	}
	public double getPrecio() {
		return Precio;
	}
	public void setPrecio(double precio) {
		Precio = precio;
	}
	public String getLugarOrigen() {
		return LugarOrigen;
	}
	public void setLugarOrigen(String lugarOrigen) {
		LugarOrigen = lugarOrigen;
	}
	@Override
	public String toString() {
		return "Material [CodMaterial=" + CodMaterial + ", CodInventario=" + CodInventario + ", Nombre=" + Nombre
				+ ", Cantidad=" + Cantidad + ", Dimensiones=" + Dimensiones + ", Precio=" + Precio + ", LugarOrigen="
				+ LugarOrigen + "]";
	}

	
}
