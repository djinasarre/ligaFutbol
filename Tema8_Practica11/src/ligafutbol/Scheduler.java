package ligafutbol;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Scheduler {

	private ArrayList<Partido> partidos;
	private Equipo[] equipos;
	private int semanaHelada;

	public Scheduler(Equipo[] equipos) {
		super();
		this.partidos = new ArrayList<>();
		this.equipos = equipos;
		this.semanaHelada = 0;
	}

	public ArrayList<Partido> getPartidos() {
		return partidos;
	}

	public void setPartidos(ArrayList<Partido> partidos) {
		this.partidos = partidos;
	}

	public Equipo[] getEquipos() {
		return equipos;
	}

	public void setEquipos(Equipo[] equipos) {
		this.equipos = equipos;
	}

	public int getSemanaHelada() {
		return semanaHelada;
	}

	public void setSemanaHelada(int semanaHelada) {
		this.semanaHelada = semanaHelada;
	}

	// Método para generar partidos recibido temperatura como prametro

	public void generarPartidos(int temperatura) {
		if (temperatura >= 40) {
			System.out.println("Demasiado calor para jugar.");
		} else if (temperatura >= 1) {
			int totalEquipos = equipos.length;
			int partidosPorSemana = totalEquipos / 2;

			Random random = new Random();

			ArrayList<Integer> indicesDisponibles = new ArrayList<>();
			for (int i = 0; i < totalEquipos; i++) {
				indicesDisponibles.add(i);
			}

			// Se generan partidos para la semana actual
			for (int i = 0; i < partidosPorSemana; i++) {
				int equipo1Index = random.nextInt(indicesDisponibles.size());
				int equipo1 = indicesDisponibles.remove(equipo1Index);
				int equipo2Index = random.nextInt(indicesDisponibles.size());
				int equipo2 = indicesDisponibles.remove(equipo2Index);

				String equipoLocal = equipos[equipo1].getNombre();
				String equipoVisitante = equipos[equipo2].getNombre();

				int maxGoles = temperatura / 6;
				int golesLocal = random.nextInt(maxGoles + 1);
				int golesVisitante = random.nextInt(maxGoles + 1);

				Partido partido = new Partido(partidos.size(), equipoLocal, equipoVisitante, temperatura);
				partido.setGolesLocal(golesLocal);
				partido.setGolesVisitante(golesVisitante);
				partidos.add(partido);
				// Se actualizan las estadisticas de los equipos basados en las estadisticas del
				// partido
				actualizarEstadisticas(partido);
			}
		} else {
			semanaHelada++;
			System.out.println("La temperatura es demasiado fria para jugar.");

		}
	}

	// Métodos para imprimir los resultados de los partidos y las estadisticas
	// generales
	   public void imprimirResultados() {
	        for (Partido partido : partidos) {
	            partido.imprimirResultado();
	        }

	        // Se muestra la temperatura más alta y la temperatura promedio de los partidos jugados
	        System.out.println("Temperatura maxima ha sido de " + obtenerTemperaturaMaxima() + " grados"); 
	        System.out.println("Temperatura media ha sido de " + obtenerTemperaturaPromedio() + " grados");
	    }

	// Método privado para actualizar las estadísticas de los equipos basado en el
	// resultado del partido
	private void actualizarEstadisticas(Partido partido) {
		Equipo equipoLocal = buscarEquipo(partido.getEquipoLocal());
		Equipo equipoVisitante = buscarEquipo(partido.getEquipoVisitante());
		// Se actualizan las estadísticas del equipo local
		equipoLocal.setGolesMarcados(equipoLocal.getGolesMarcados() + partido.getGolesLocal());
		equipoLocal.setGolesEncajados(equipoLocal.getGolesEncajados() + partido.getGolesVisitante());

		// Se actualizan las estadisticas del equipoVisitante
		equipoVisitante.setGolesMarcados(equipoVisitante.getGolesMarcados() + partido.getGolesVisitante());
		equipoVisitante.setGolesEncajados(equipoVisitante.getGolesEncajados() + partido.getGolesLocal());

		// Se actualizan las victorias derrotas y empates dependiendo del resultado del
		// partido

		if (partido.getGolesLocal() > partido.getGolesVisitante()) {
			equipoLocal.setVictorias(equipoLocal.getVictorias() + 1);
			equipoVisitante.setDerrotas(equipoVisitante.getDerrotas() + 1);
		} else if (partido.getGolesLocal() < partido.getGolesVisitante()) {
			equipoVisitante.setVictorias(equipoVisitante.getVictorias() + 1);
			equipoLocal.setDerrotas(equipoLocal.getDerrotas() + 1);
		} else {
			equipoVisitante.setEmpates(equipoVisitante.getEmpates() + 1);
			equipoLocal.setEmpates(equipoLocal.getEmpates() + 1);

		}

	}
	
	// Método privado para buscar un equipo por su nombre en el array de equipo
	private Equipo buscarEquipo (String nombreEquipo) {
		for (Equipo equipo : equipos) {
			if (equipo.getNombre().equals(nombreEquipo)) {
				return equipo;
			}
		}
		return null;
	}
	
	// Método privado para obtener la temperatura máxima registrada en los partidos
	// Se inicializa la variable MaxTemperatura con el valor mínimo posible que puede tomar un entero (Integer.MIN_VALUE)
	private double obtenerTemperaturaMaxima() {
		double maxTemperatura = Integer.MIN_VALUE;
		for (Partido partido : partidos) {
			if (partido.getTemperatura() > maxTemperatura) {
				maxTemperatura = partido.getTemperatura();
		}
		} 
		return maxTemperatura;
	}
	
	// Método privado para obtener la temperatura promedio de todos los partidos
	private double obtenerTemperaturaPromedio() {
		double totalTemperatura = 0;
		for (Partido partido : partidos) {
			totalTemperatura = totalTemperatura + partido.getTemperatura();
			
		}
		
	
	return totalTemperatura / partidos.size();
	}
	
	// Método para comprobar si la temperatura esta finalizada
	public void ejecutarTemporada() {
		Scanner scanner = new Scanner(System.in);
		int semana = 1;
		while (semanaHelada < 3) {
			try {
			System.out.println("Semana " + semana + "\n Por favor, introduzca una temperatura: " );
			generarPartidos(scanner.nextInt());
			semana++;
			} catch (java.util.InputMismatchException e) {
                System.out.println("Error: Debes ingresar un número entero válido.");
                scanner.nextLine();
			}
		}
		scanner.close();
		System.out.println("La temporada ha finalizado \n\nRESULTADOS Y ESTADISTICAS\n");
		for (Equipo equipo : equipos) {
			equipo.imprimirEstadisticas();
		}
		imprimirResultados();
			
			
		}
	}


