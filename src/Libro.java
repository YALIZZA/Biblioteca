class Libro {
    String isbn, titulo, autor;
    boolean disponible;

    public Libro(String isbn, String titulo, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = true;
    }

    public String toString() {
        String estado = disponible ? "Disponible" : "Prestado";
        return isbn + " - " + titulo + " (" + autor + ") [" + estado + "]";
    }
}

class NodoLibro {
    Libro libro;
    NodoLibro izquierda, derecha;

    public NodoLibro(Libro libro) {
        this.libro = libro;
    }
}


