package playlist;

public class Cancion implements Comparable <Cancion> {
	private String titulo, album, art;
	private int dur;

	public String getTitulo() {
		return titulo; 
	}
	public void setTitle(String titulo) {
		this.titulo = titulo;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getArt() {
		return art;
	}
	public void setArt(String art) {
		this.art = art;
	}
	public int getDur() {
		return dur;
	}
	public void setDur(int dur) {
		this.dur = dur;
	}

	public Cancion(String titulo, String album, String art, int dur) {
		this.setTitle(titulo);
		this.setDur(dur);
		this.setAlbum(album);
		this.setArt(art);
	}
	public Cancion(String titulo, String art,  int dur) {
		this(titulo,"Unknown", art, dur);
	
	}
	public Cancion(String titulo, int dur, String album) {
		this(titulo, album,"Unknown", dur);
		
	}	
	public Cancion(String titulo, int dur) {
		this(titulo,"Unknown", "Unknown", dur);
	}
	@Override
	public int compareTo(Cancion o) {
		return this.titulo.compareToIgnoreCase(o.getTitulo());
	}    
}