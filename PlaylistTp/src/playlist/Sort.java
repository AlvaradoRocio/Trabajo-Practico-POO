package playlist;
import java.util.Comparator;
public class Sort implements Comparator<Cancion>{
public int compare(Cancion c, Cancion c2) {    
    int TitleCompare = c.getTitulo().compareToIgnoreCase(c2.getTitulo()); 
    int ArtCompare = c.getArt().compareToIgnoreCase(c2.getArt()); 

    if (ArtCompare == 0) { 
        return ((TitleCompare == 0) ? ArtCompare : TitleCompare); 
    } else { 
        return ArtCompare;
    } 
}
}
