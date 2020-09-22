package playlist;
import java.util.Arrays;
public class Playlist {
	private Song playlist[] = new Song[10];
	private int size;

	public void addSong(String title, int sec) {
		this.playlist[getSize()] = new Song(title, sec);
		this.setSize(this.getSize()+1);
	}
	public void addSong(String title, int sec, String album) {
		this.playlist[getSize()] = new Song(title, sec, album);
		this.setSize(this.getSize()+1);
	}
	public void addSong(String title, String art, int sec) {
		this.playlist[getSize()] = new Song(title, art, sec);
		this.setSize(this.getSize()+1);
	}
	public void addSong(String title, String album, String art, int sec) {
		this.playlist[getSize()] = new Song(title, album, art, sec);
		this.setSize(this.getSize()+1);
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public void deleteSong(String del) {
		int i = 0, cont = 0;
		while (i < this.getSize()) {
			if (del.equalsIgnoreCase(playlist[i].getTitle()) || del.equalsIgnoreCase(playlist[i].getArt())
					|| del.equalsIgnoreCase(playlist[i].getAlbum())
					|| del.equalsIgnoreCase(secondsToMinute(playlist[i].getSec()))) {
				cont++;
				for (int j = i; j < this.getSize() - 1; j++) {
					playlist[j] = playlist[j + 1];
					i = 0;
				}
			} else {
				i++;
			}
		}
		while (0 < cont) {
			playlist[this.getSize() - 1] = null;
			this.setSize(this.getSize()-1);
			cont--;
		}
	}
	public String duracionCancion(String title) {
		int i, j=0;
		boolean a = false;
		String duracion= null, array[] = new String[this.getSize()]; 
		for (i = 0; i < this.getSize(); i++) {
			if (title.equalsIgnoreCase(playlist[i].getTitle())) {
				a = true;
				array[j]= j+1+". Duracion de la cancion " + playlist[i].getTitle() + ": "+
				secondsToMinute(playlist[i].getSec())+ "\n";
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
			total = total + playlist[i].getSec();
		}
		return secondsToMinute(total);
	}
	public String mayorMenorduracion() {
		int i, k, aux, paux[] = new int[this.getSize()];
		String mayor = null, menor = null;
		for (i = 0; i < this.getSize(); i++) {
			paux[i] = playlist[i].getSec();
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
			if (paux[0] == playlist[i].getSec()) {
				menor = "Cancion de menor duracion: "+ playlist[i].getTitle() + " --> " + secondsToMinute(paux[0])+ "\n";
			}
			if (paux[this.getSize() - 1] == playlist[i].getSec()) {
				mayor = "Cancion de mayor duracion: "+ playlist[i].getTitle() + " --> " + secondsToMinute(paux[this.getSize() - 1]);
			}
		}
		return menor+mayor;
	}
	public Song[] listaOrdenadaArtista() {	//ver como pija ponerlo en el junit	
		Arrays.sort(playlist, 0, this.getSize(), new Sort());
		//print();
		return playlist;
	}
	public Song[] listaOrdenadaTitulo() {		
		Arrays.sort(playlist, 0, this.getSize());
		//print();
		return playlist;
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
			System.out.println("Estas escuchando: " + playlist[r2[i]].getTitle());
			System.out.println("00:0" + r2[i] + "  =======[]------------ " + secondsToMinute(playlist[r2[i]].getSec()));
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
	public String secondsToMinute(int total) {
		String tiempo;
		int s = total % 60;
		int m = total % 3600 / 60;
		int h = total % 86400 / 3600;
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
