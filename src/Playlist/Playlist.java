package Playlist;

import java.util.Arrays;

public class Playlist {
	private int i = 0;
	Canciones reproductor[]= new Canciones[1000];
	
	public void metodoMostrar() {
		for(int j = 0; j < getI() ; j++) {
			System.out.println("TITULO:" +reproductor[j].getTitulo());
			System.out.println("ALBUM:" +reproductor[j].getAlbum());
			System.out.println("ARTISTA:" +reproductor[j].getArtista());
			System.out.println("DURACION:" +duracionAtiempo(reproductor[j].getDuracion()));
			System.out.println("\t\t\t");
		}
	} 
	
	
	//METODOS PARA AGREGAR CANCIONES
	public void agregarCancion(String titulo, int duracion) {
		reproductor[i] = new Canciones(titulo, duracion);
		i++;
	}
	
	public void agregarCancion(String titulo, String album, int duracion) {
		reproductor[i] = new Canciones(titulo, album, duracion);
		i++;
	}
	
	public void agregarCancion(String titulo, int duracion, String artista) {
		reproductor[i] = new Canciones(titulo, duracion, artista);
		i++;
	}
	
	public void agregarCancion(String titulo, String album, String artista, int duracion) {
		reproductor[i] = new Canciones(titulo, album, artista, duracion);
		i++;

	}
	
	
	
	
	//CONSULTAR DURACION DE CANCION
	public int[] consultarDuracion(String titulo) {
		int dur = 0;
		int x = 0;
		for(int j = 0; j < getI(); j++) {
			if(reproductor[j].getTitulo().equalsIgnoreCase(titulo)) {
				dur++;
			}
		}
		int duraciones[] = new int[dur];
		if(dur != 0) {
			for(int y = 0; y < getI() ; y++ ) {
				duraciones[y] = reproductor[y].getDuracion();
			}
			
		}else {
			duraciones[x] = -1;
			
		}
		
		return duraciones;
	}
	
	//CANTIDAD CANCIONES
	public int consultarCantidadCanciones() {
		return getI();
	}
	
	//ELIMINAR CANCION
	public void eliminarCancion(String eliminar,int duracion) {
		
		
	}
	
	//DURACION PLAYLIST
	public int consultarDuracionPlaylist() {
		int duracion_total=0;
		
		for(int j = 0 ; j < i; j++) {
			duracion_total += reproductor[j].getDuracion();
			
		}
		
		System.out.println("\nDuracion total de la playlist : " +duracionAtiempo(duracion_total));
		return duracion_total;
	}
	
	
	//CANCION CON MAYOR DURACION
	public String cancionMayorDuracion() {
		int bandera = 1;
		int max = 0;
		String titumax = null;
		for(int j = 0; j < getI() ; j++) {
			if(bandera == 1 ) {
				max = reproductor[j].getDuracion();
				titumax = reproductor[j].getTitulo();
				bandera = 0;
				
			}else {
				if(reproductor[j].getDuracion() > max) {
					max = reproductor[j].getDuracion();
					titumax = reproductor[j].getTitulo();
				}
			}
			
	
		}
		
	    return titumax;
	}
	
	
	
	
	//CANCION CON MENOR DURACION
	public String cancionMenorDuracion() {
		int bandera = 1;
		int men = 0;
		String titumen = null;
		for(int j = 0; j < getI() ; j++) {
			if(bandera == 1 ) {
				men = reproductor[j].getDuracion();
				titumen = reproductor[j].getTitulo();
				bandera = 0;
				
			}else {
				if(reproductor[j].getDuracion() < men) {
					men = reproductor[j].getDuracion();
					titumen = reproductor[j].getTitulo();
				}
			}
			
		}
		
		return titumen;
		
	}
	
	
	
	public String duracionAtiempo(int duracion) {
		String tiempo;
		int horas = duracion/3600;
		int minutos = (duracion - horas*3600)/60;
		int segundos = (duracion - horas*3600 - minutos*60);
		tiempo = String.format("%02d", horas) + ":" + String.format("%02d", minutos) + ":" + String.format("%02d", segundos);
		return tiempo;
	}
	
	
	
	
	
	public void listaOrdenadaArtista() {
		
	}
		
		
	
	public String[] listaOrdenadaTitulo() {
		String[] titu = new String[getI()];
		for(int j = 0; j < getI() ; j++ ) {
			titu[j] = reproductor[j].getTitulo();
		}
		Arrays.sort(titu);
		for(int j = 0; j < getI() ; j++ ) {
			System.out.println(""+titu[j]);
		}
		
		return titu;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
	
	

}
