package ligafutbol;

public class Equipo {
	
// Declaracion de variables privadas
private int id;
private String nombre;
private int victorias;
private int derrotas;
private int empates;
private int golesMarcados;
private int golesEncajados;


//Constructor de clase equipo recibe el id y el nombre de equipo como parametros

public Equipo(int id, String nombre) {
	super();
	this.id = id;
	this.nombre = nombre;
	this.victorias = 0;
	this.derrotas = 0;
	this.empates = 0;
	this.golesMarcados = 0;
	this.golesEncajados = 0;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public int getVictorias() {
	return victorias;
}

public void setVictorias(int victorias) {
	this.victorias = victorias;
}

public int getDerrotas() {
	return derrotas;
}

public void setDerrotas(int derrotas) {
	this.derrotas = derrotas;
}

public int getEmpates() {
	return empates;
}

public void setEmpates(int empates) {
	this.empates = empates;
}

public int getGolesMarcados() {
	return golesMarcados;
}

public void setGolesMarcados(int golesMarcados) {
	this.golesMarcados = golesMarcados;
}

public int getGolesEncajados() {
	return golesEncajados;
}

public void setGolesEncajados(int golesEncajados) {
	this.golesEncajados = golesEncajados;
}

public void imprimirEstadisticas() {
	System.out.println("Equipo " + id);
	System.out.println("Nombre " + nombre);
	System.out.println("Victorias " + victorias);
	System.out.println("Derrotas " + derrotas);
	System.out.println("Empates " + empates);
	System.out.println("Goles a favor " + golesMarcados
			);
	System.out.println("Goles en contra " + golesEncajados);
	System.out.println(" ");
}





}
