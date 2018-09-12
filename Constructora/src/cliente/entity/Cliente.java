package cliente.entity;

public class Cliente {
	
	private int CodCliente;
	private int CICliente;
	private String NombreCompleto;
	
	public Cliente(int codCliente, int cICliente, String nombreCompleto) {
		super();
		CodCliente = codCliente;
		CICliente = cICliente;
		NombreCompleto = nombreCompleto;
	}

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

	@Override
	public String toString() {
		return "Cliente [CodCliente=" + CodCliente + ", CICliente=" + CICliente + ", NombreCompleto=" + NombreCompleto
				+ "]";
	}

	public boolean equals(Object o) {
		boolean respuesta = false;
		if ( o != null) {
			Cliente categoría = (Cliente) o;
			if(this.getCodCliente()==categoría.getCodCliente()) {
				respuesta = !respuesta;
			}
		}
		return respuesta;
	}

}
