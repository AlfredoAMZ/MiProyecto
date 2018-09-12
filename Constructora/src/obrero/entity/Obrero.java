package obrero.entity;

public class Obrero {
	
	private int CodCliente;
	private int CICliente;
	private String NombreCompleto;
	private String FechadeNacimiento;
	private int Telefono;
	public int getCodCliente() {
		return CodCliente;
	}
	public void setCodCliente(int codCliente) {
		CodCliente = codCliente;
	}
	public int getCICliente() {
		return CICliente;
	}
	public void setCICliente(int cICliente) {
		CICliente = cICliente;
	}
	public String getNombreCompleto() {
		return NombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		NombreCompleto = nombreCompleto;
	}
	public String getFechadeNacimiento() {
		return FechadeNacimiento;
	}
	public void setFechadeNacimiento(String fechadeNacimiento) {
		FechadeNacimiento = fechadeNacimiento;
	}
	public int getTelefono() {
		return Telefono;
	}
	public void setTelefono(int telefono) {
		Telefono = telefono;
	}
	@Override
	public String toString() {
		return "Obrero [CodCliente=" + CodCliente + ", CICliente=" + CICliente + ", NombreCompleto=" + NombreCompleto
				+ ", FechadeNacimiento=" + FechadeNacimiento + ", Telefono=" + Telefono + "]";
	}
	
}
