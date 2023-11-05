package ligafutbol;

import java.util.ArrayList;

public class Partido {
	
private static ArrayList<Partido> todoslosPartidos = new ArrayList<>();
// Declaracion de las variables privadas que representan las caracteristicas de los partidos
private int id;
private String equipoLocal;
private String equipoVisitante;
private int golesLocal;
private int golesVisitante;
private double temperatura;

//Constructor de la clase Partido que recibe el los nombres de los equipos y la temperatura como parametros
public Partido(int id, String equipoLocal, String equipoVisitante, int temperatura) {
	super();
	this.id = id;
	this.equipoLocal = equipoLocal;
	this.equipoVisitante = equipoVisitante;
	this.golesLocal = 0;
	this.golesVisitante = 0;
	this.temperatura = temperatura;
}

public static ArrayList<Partido> getTodoslosPartidos() {
	return todoslosPartidos;
}

public static void setTodoslosPartidos(ArrayList<Partido> todoslosPartidos) {
	Partido.todoslosPartidos = todoslosPartidos;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getEquipoLocal() {
	return equipoLocal;
}

public void setEquipoLocal(String equipoLocal) {
	this.equipoLocal = equipoLocal;
}

public String getEquipoVisitante() {
	return equipoVisitante;
}

public void setEquipoVisitante(String equipoVisitante) {
	this.equipoVisitante = equipoVisitante;
}

public int getGolesLocal() {
	return golesLocal;
}

public void setGolesLocal(int golesLocal) {
	this.golesLocal = golesLocal;
}

public int getGolesVisitante() {
	return golesVisitante;
}

public void setGolesVisitante(int golesVisitante) {
	this.golesVisitante = golesVisitante;
}

public double getTemperatura() {
	return temperatura;
}

public void setTemperatura(double temperatura) {
	this.temperatura = temperatura;
}

public void imprimirResultado() {
	System.out.println("Partido " + id);
	System.out.println("Temperatura: " + temperatura + " grados");
	System.out.println("Equipo Local: " + equipoLocal);
	System.out.println("Equipo Visitante: " + equipoVisitante);
	System.out.println("Resultado: " + golesLocal + " - " + golesVisitante);
	System.out.println(" ");
	
}
}







