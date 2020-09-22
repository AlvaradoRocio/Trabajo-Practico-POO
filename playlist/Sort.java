package playlist;
import java.util.Comparator;
public class Sort implements Comparator<Song>{
public int compare(Song c, Song c2) {    
    int TitleCompare = c.getTitle().compareToIgnoreCase(c2.getTitle()); 
    int ArtCompare = c.getArt().compareToIgnoreCase(c2.getArt()); 

    if (ArtCompare == 0) { 
        return ((TitleCompare == 0) ? ArtCompare : TitleCompare); 
    } else { 
        return ArtCompare;
    } 
}
}

