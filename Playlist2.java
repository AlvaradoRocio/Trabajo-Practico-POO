package canciones;

public class Playlist {

    private Cancion canciones[] = new Cancion[10];
    private int size;

    public void addSong(String titulo, int dur) {
        this.canciones[getSize()] = new Cancion(titulo, dur);
        this.setSize(this.getSize() + 1);
    }

    public void addSong(String titulo, int dur, String album) {
        this.canciones[getSize()] = new Cancion(titulo, dur, album);
        this.setSize(this.getSize() + 1);
    }

    public void addSong(String titulo, String art, int dur) {
        this.canciones[getSize()] = new Cancion(titulo, art, dur);
        this.setSize(this.getSize() + 1);
    }

    public void addSong(String titulo, String album, String art, int dur) {
        this.canciones[getSize()] = new Cancion(titulo, album, art, dur);
        this.setSize(this.getSize() + 1);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void eliminarCancion(String eliminar) {
        int i=0, cont = 0;
        while(i<this.getSize()) {
            if (eliminar.equalsIgnoreCase(canciones[i].getTitulo()) || eliminar.equalsIgnoreCase(canciones[i].getArt())
                    || eliminar.equalsIgnoreCase(canciones[i].getAlbum())
                    || eliminar.equalsIgnoreCase(getDuracionString(canciones[i].getDur()))) {
                cont++;
                for (int j = i; j < this.getSize() - 1; j++) {
                    canciones[j] = canciones[j + 1];
                    
                }
            canciones[this.getSize()-1] = null;
            this.setSize(this.getSize() - 1);  
            i=0;
            } else {
                i ++;
            }
        }
        
            
        
    }

    public String[] duracionCancion(String titulo) {
        int duracion = 0;
        int f = 0;
        for (int x = 0; x < size; x++) {
            if (canciones[x].getTitulo().equalsIgnoreCase(titulo)) {
                duracion = duracion + 1;
            }
        }
        String[] cancionDuracion = new String[duracion];
        if (duracion == 0) {
            cancionDuracion[f] = " -1 ";
        } else {
            if (duracion >= 1) {
                for (int s = 0; s < size; s++) {
                    if (canciones[s].getTitulo().equalsIgnoreCase(titulo)) {
                        cancionDuracion[f] = this.getDuracionString(canciones[s].getDur());
                        f++;
                    }
                }
            }
        }
        return cancionDuracion;
    }

    public String duracionPlaylist() {
        int i, total = 0;
        for (i = 0; i < this.getSize(); i++) {
            total = total + canciones[i].getDur();
        }
        return getDuracionString(total);
    }

    public String[] mayorMenorduracion() {
        int i, k, aux, paux[] = new int[this.getSize()];
        String[] menorMayor = new String[2];
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
                menorMayor[0] =  canciones[i].getTitulo();
            }
            if (paux[this.getSize() - 1] == canciones[i].getDur()) {
                menorMayor[1] = "Cancion de mayor duracion: " + canciones[i].getTitulo();
            }
        }
        return menorMayor;
    }

    public Cancion[] listaOrdenadaArtista() {	//ver como pija ponerlo en el junit	
        int intercambio = 0;
        Cancion auxiliar;
        Cancion[] aux2 = new Cancion[size];
        boolean ordenado = false;
        while (!ordenado) {
            for (int x = 0; x < size - 1; x++) {
                if ((canciones[x].getArt() + canciones[x].getTitulo()).compareToIgnoreCase(canciones[x + 1].getArt() + canciones[x + 1].getTitulo()) > 0) {

                    auxiliar = canciones[x];
                    canciones[x] = canciones[x + 1];
                    canciones[x + 1] = auxiliar;
                    intercambio++;
                }
            }
            if (intercambio == 0) {
                ordenado = true;
            }
            intercambio = 0;
        }
        for (int d = 0; d < size; d++) {
            aux2[d] = canciones[d];
        }
        return aux2;
    }

    public Cancion[] listaOrdenadaTitulo() {
        int intercambio = 0;
        Cancion auxiliar;
        boolean ordenado = false;
        while (!ordenado) {
            for (int x = 0; x < size - 1; x++) {
                if (canciones[x].getTitulo().compareToIgnoreCase(canciones[x + 1].getTitulo()) > 0) {
                    auxiliar = canciones[x];
                    canciones[x] = canciones[x + 1];
                    canciones[x + 1] = auxiliar;
                    intercambio++;
                }
            }
            if (intercambio == 0) {
                ordenado = true;
            }
            intercambio = 0;
        }
        Cancion[] prueba = new Cancion[size];
        for (int d = 0; d < size; d++) {
            prueba[d] = canciones[d];
        }
        return prueba;
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

        }
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

}

class Prueba{
    public static void main(String[] args) {
        Playlist nueva = new Playlist();
        nueva.addSong("lala", 200);
        nueva.addSong("lala", 222, "Adele");
        nueva.addSong("lala", "Madonna y Justin Timberlake", "Madonna", 240);
        nueva.addSong("estoy", 120, "Ricky Martin");
        nueva.addSong("hello", 211, "Shakira");
        nueva.addSong("lala", 118, "Me");
        System.out.println(nueva.getSize());
        nueva.eliminarCancion("Lala");
        System.out.println(nueva.getSize());
        
    }
    
}