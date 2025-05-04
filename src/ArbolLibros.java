class ArbolLibros {
    NodoLibro raiz;

    public void insertar(Libro libro) {
        raiz = insertarRec(raiz, libro);
    }

    private NodoLibro insertarRec(NodoLibro nodo, Libro libro) {
        if (nodo == null) return new NodoLibro(libro);
        if (libro.titulo.toLowerCase().compareTo(nodo.libro.titulo.toLowerCase()) < 0)
            nodo.izquierda = insertarRec(nodo.izquierda, libro);
        else
            nodo.derecha = insertarRec(nodo.derecha, libro);
        return nodo;
    }

    public Libro buscar(String titulo) {
        return buscarRec(raiz, titulo.toLowerCase());
    }

    private Libro buscarRec(NodoLibro nodo, String titulo) {
        if (nodo == null) return null;
        String actual = nodo.libro.titulo.toLowerCase();
        if (titulo.equals(actual)) return nodo.libro;
        if (titulo.compareTo(actual) < 0)
            return buscarRec(nodo.izquierda, titulo);
        else
            return buscarRec(nodo.derecha, titulo);
    }

    public void mostrarInorden() {
        mostrarInordenRec(raiz);
    }

    private void mostrarInordenRec(NodoLibro nodo) {
        if (nodo != null) {
            mostrarInordenRec(nodo.izquierda);
            System.out.println(nodo.libro);
            mostrarInordenRec(nodo.derecha);
        }
    }
}

class Usuario {
    String nombre;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }
}

class NodoUsuario {
    Usuario usuario;
    NodoUsuario izquierda, derecha;

    public NodoUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
