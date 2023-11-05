package ligafutbol;

public class Test {

	public static void main(String[] args) {
		
		 Equipo[] equipos = {
	                new Equipo(1, "Real Zaragoza"),
	                new Equipo(2, "Real Madrid"),
	                new Equipo(3, "Valencia FC"),
	                new Equipo(4, "Sevilla FC")
	        };
	        Scheduler scheduler = new Scheduler(equipos);
	        scheduler.ejecutarTemporada();
	    }
}
