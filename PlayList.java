package trabajo;

import java.util.Arrays;

public class PlayList {

	
	private String[] titulo = new String [10000];
	private String[] album = new String [10000];
	private String[] artista = new String [10000];				
	private double[] duracion = new double [10000];
	
	private double acumuladorduracion = 0;
	private int contadorcancion=0;

		public PlayList() {
		}
		
		public void CargaDatos(String titu, double dura, String artis, String alb) { 

			for(int i = 0; i < 10000 ; i++ ) {
				if(this.titulo[i] == null) {

					this.titulo[i] = titu;
					this.duracion[i] = dura;	

					if(dura > 0  & titu != null ) {

						this.artista[i] = artis;
						this.album[i] = alb;

						System.out.println("La cancion: "+ titu +" con una duracion de: "+dura +" se a cargado con exito.");
						this.contadorcancion++;
						this.acumuladorduracion = this.acumuladorduracion + dura;
						break;
					}
				}
			}	

		}
		
		public void ConsultarDuracion(String titu) {
			
			boolean existe = true;
			
			for(int i = 0; i < 10000 ; i++ ) {
				if(this.titulo[i] != null) {
					if(this.titulo[i].equalsIgnoreCase(titu)) {		
						existe = false;
						ConsultarDuracion(this.titulo[i], this.duracion[i]);
					}			
				}
			}
			if(existe) 
			System.out.println(titu+": -1");
			
		}	
		
		public void ConsultarDuracion(String titu, double dura) {
			System.out.println("La duracion de: "+ titu + " es de: "+ dura);
			
		}
		
		private void QuitarCancion(int puesto) {
		
			System.out.println("La cancion : "+this.titulo[puesto]+" con una duracion de: "+this.duracion[puesto]+ " a sido borrada.");
			this.acumuladorduracion = this.acumuladorduracion - this.duracion[puesto];
			this.titulo[puesto] = null;
			this.album[puesto] = null;
			this.artista[puesto] = null;
			this.duracion[puesto] = 0;
			this.contadorcancion--;
		}
		
		public void QuitarCancion(String titu, double dura) {
			for(int i = 0; i < 10000 ; i++ ) {
				if(this.titulo[i] != null) {
					if(this.titulo[i].equalsIgnoreCase(titu)) {
						if(this.duracion[i] == dura) {
							QuitarCancion(i);
						}
					}
				}
			}
		}
	
		public void QuitarCancion(String titu) {
			for(int i = 0; i < 10000 ; i++ ) {
				if(this.titulo[i] != null) {
					if(this.titulo[i].equalsIgnoreCase(titu)) {
							QuitarCancion(i);
					}
				}
			}
		}
		
		public int CantidadDeCanciones() {
			return this.contadorcancion++;	
		}
		
		public double DuracionTotalDeLaPlaylist() {
			return this.acumuladorduracion;
		}
		
		public void ConsultarMenorDuracion() {
			int min= 0;
			boolean verificar = true;
			for(int i = 0; i < 10000 ; i++ ) {	
				if(this.duracion[i] != 0 & verificar == true) {
					min=i;
					verificar = false;
				}
				if(this.duracion[i] != 0 & this.duracion[i] < this.duracion[min] & verificar == false) {
					min=i;
				}
			}				
			System.out.println("La cancion de menor duracion es: "+this.titulo[min]+" con una duracion de: "+this.duracion[min]);
		}	
		
		public void ConsultarMayorDuracion() {
			int max=0;
			for(int i = 0; i < 10000 ; i++ ) {	

				if(this.duracion[i] > this.duracion[max]) {
					max=i;
				}
			}
			System.out.println("La cancion de mayor duracion es: "+this.titulo[max]+" con una duracion de: "+this.duracion[max]);	
		}
		
		public void MostrarListaOrdenada() {

			String[] titulocopia = this.titulo; 
			for(int i = 0; i < 10000 ; i++ ) {
				if(titulocopia[i]== null) {
					titulocopia[i] = "";
				}
			}
			Arrays.sort(titulocopia);
			for(int i = 0; i < 10000 ; i++ ) {
				if(titulocopia[i] != "") {
					System.out.println(". "+titulocopia[i]);	
				}
			}	
		}
		
		public void Reproducir() {

			for(int i = 0; i < 10000 ; i++ ) {
				int numeroAleatorio = (int) (Math.random()*10000+1);
				if(this.titulo[numeroAleatorio] != null) {				
					System.out.println("Reproduciendo ... "+this.titulo[numeroAleatorio]+ " " + this.duracion);
					break;
				}		
			}	
		}
		

}
