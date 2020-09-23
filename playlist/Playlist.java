package playlist;
import java.util.Arrays;
public class Playlist {
	private Cancion canciones[] = new Cancion[10];
	private int size;

	public void addSong(String titulo, int dur) {
		this.canciones[getSize()] = new Cancion(titulo, dur);
		this.setSize(this.getSize()+1);
	}
	public void addSong(String titulo, int dur, String album) {
		this.canciones[getSize()] = new Cancion(titulo, dur, album);
		this.setSize(this.getSize()+1);
	}
	public void addSong(String titulo, String art, int dur) {
		this.canciones[getSize()] = new Cancion(titulo, art, dur);
		this.setSize(this.getSize()+1);
	}
	public void addSong(String titulo, String album, String art, int dur) {
		this.canciones[getSize()] = new Cancion(titulo, album, art, dur);
		this.setSize(this.getSize()+1);
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public void eliminarCancion(String eliminar) {
		int i = 0, cont = 0;
		while (i < this.getSize()) {
			if (eliminar.equalsIgnoreCase(canciones[i].getTitulo()) || eliminar.equalsIgnoreCase(canciones[i].getArt())
					|| eliminar.equalsIgnoreCase(canciones[i].getAlbum())
					|| eliminar.equalsIgnoreCase(getDuracionString(canciones[i].getDur()))) {
				cont++;
				for (int j = i; j < this.getSize() - 1; j++) {
					canciones[j] = canciones[j + 1];
					i = 0;
				}
			} else {
				i++;
			}
		}
		while (0 < cont) {
			canciones[this.getSize() - 1] = null;
			this.setSize(this.getSize()-1);
			cont--;
		}
	}
	public String duracionCancion(String titulo) {
		int i, j=0;
		boolean a = false;
		String duracion= null, array[] = new String[this.getSize()]; 
		for (i = 0; i < this.getSize(); i++) {
			if (titulo.equalsIgnoreCase(canciones[i].getTitulo())) {
				a = true;
				array[j]= j+1+". Duracion de la cancion " + canciones[i].getTitulo() + ": "+
				getDuracionString(canciones[i].getDur())+ "\n";
				j++;			
			}
		}
		if (!a) {
			duracion= "-1";
		}else {
			duracion = this.arrayToString(array);
		}
		return duracion;
	}
	public String duracionPlaylist() {
		int i, total = 0;
		for (i = 0; i < this.getSize(); i++) {
			total = total + canciones[i].getDur();
		}
		return getDuracionString(total);
	}
	public String mayorMenorduracion() {
		int i, k, aux, paux[] = new int[this.getSize()];
		String mayor = null, menor = null;
		for (i = 0; i < this.getSize(); i++) {
			paux[i] = canciones[i].getDur();
		}
		for (i = 0; i < this.getSize(); i++) {
			for (k = this.getSize() - 1; k > i; k--) {
				if (paux[k] < paux[k - 1]) {
					aux = paux[k];
					paux[k] = paux[k - 1];
					paux[k - 1] = aux;
				}
			}
		}
		for (i = 0; i < this.getSize(); i++) {
			if (paux[0] == canciones[i].getDur()) {
				menor = "Cancion de menor duracion: "+ canciones[i].getTitulo() + " --> " + getDuracionString(paux[0])+ "\n";
			}
			if (paux[this.getSize() - 1] == canciones[i].getDur()) {
				mayor = "Cancion de mayor duracion: "+ canciones[i].getTitulo() + " --> " + getDuracionString(paux[this.getSize() - 1]);
			}
		}
		return menor+mayor;
	}
	public Cancion[] listaOrdenadaArtista() {	//ver como pija ponerlo en el junit	
		Arrays.sort(canciones, 0, this.getSize(), new Sort());
		//print();
		return canciones;
	}
	public Cancion[] listaOrdenadaTitulo() {		
		Arrays.sort(canciones, 0, this.getSize());
		//print();
		return canciones;
	}
	public void reproducirPlaylist() { 		
		int i = 0, range = (this.getSize() - 1 - 0) + 1, r, r2[] = new int[this.getSize()];
		for (i = 0; i < r2.length; i++) {
			boolean encontrado = false;
			r = (int) ((Math.random() * range) + 0);
			for (int j = 0; j < i; j++) {
				if (r2[j] == r) {
					encontrado = true;
				}
			}
			if (!encontrado) {
				r2[i] = r;
			} else {
				i--;
			}
		}
		for (i = 0; i < this.getSize(); i++) {
			System.out.println("Estas escuchando: " + canciones[r2[i]].getTitulo());
			System.out.println("00:0" + r2[i] + "  =======[]------------ " + getDuracionString(canciones[r2[i]].getDur()));
			System.out.println("\t   <|    >    |>");
			System.out.println("\t \t \t \t");

			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}	
	public String arrayToString(String [] a) {
		StringBuffer sb = new StringBuffer();
		int i = 0, size = 0;
		while (a[i] != null) {
			size++;
			i++;
		}
		for( i = 0; i < size; i++) {
	         sb.append(a[i]);
	      }	
		return sb.toString();
	}
	public String getDuracionString(int segundos) {
		String tiempo;
		int s = segundos % 60;
		int m = segundos % 3600 / 60;
		int h = segundos % 86400 / 3600;
		if (h == 0) {
			tiempo = String.format("%02d", m) + ":" + String.format("%02d", s);
		} else {
			tiempo = String.format("%02d", h) + ":" + String.format("%02d", m) + ":" + String.format("%02d", s);
		}
		return tiempo;
	}
/*	public void print() {
		int i;
		for (i = 0; i < this.getSize(); i++) {
			System.out.println("Titulo: " + playlist[i].getTitle());
			System.out.println("Album: " + playlist[i].getAlbum());
			System.out.println("Artista: " + playlist[i].getArt());
			System.out.println("Duracion: " + secondsToMinute(playlist[i].getSec()));
			System.out.println("\t \t \t \t"); 
		}
	}*/
}
