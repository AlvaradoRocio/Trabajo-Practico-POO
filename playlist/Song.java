package playlist;

public class Song implements Comparable <Song> {
	private String title, album, art;
	private int sec;

	public String getTitle() {
		return title; 
	}
	public void setTitle(String title) {
		this.title = title;
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
	public int getSec() {
		return sec;
	}
	public void setSec(int sec) {
		this.sec = sec;
	}

	public Song(String title, String album, String art, int sec) {
		this.setTitle(title);
		this.setSec(sec);
		this.setAlbum(album);
		this.setArt(art);
	}
	public Song(String title, String art,  int sec) {
		this(title,"Unknown", art, sec);
	
	}
	public Song(String title, int sec, String album) {
		this(title, album,"Unknown", sec);
		
	}	
	public Song(String title, int sec) {
		this(title,"Unknown", "Unknown", sec);
	}
	@Override
	public int compareTo(Song o) {
		return this.title.compareToIgnoreCase(o.getTitle());
	}    
}
