package material.entity;

public class Material {
	
	private int CodMaterial;
	private double Cantidad;
	private double Dimensiones;
	private double Precio;
	private String LugarOrigen;
	
	public Material(int codMaterial, double cantidad, double dimensiones, double precio, String lugarOrigen) {
		super();
		CodMaterial = codMaterial;
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
	public double getCantidad() {
		return Cantidad;
	}
	public void setCantidad(double cantidad) {
		Cantidad = cantidad;
	}
	public double getDimensiones() {
		return Dimensiones;
	}
	public void setDimensiones(double dimensiones) {
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
		return "Material [CodMaterial=" + CodMaterial + ", Cantidad=" + Cantidad + ", Dimensiones=" + Dimensiones
				+ ", Precio=" + Precio + ", LugarOrigen=" + LugarOrigen + "]";
	}
	
	

}
