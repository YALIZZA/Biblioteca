class ArbolUsuarios {
    NodoUsuario raiz;

    public void insertar(Usuario usuario) {
        raiz = insertarRec(raiz, usuario);
    }

    private NodoUsuario insertarRec(NodoUsuario nodo, Usuario usuario) {
        if (nodo == null) return new NodoUsuario(usuario);
        if (usuario.nombre.toLowerCase().compareTo(nodo.usuario.nombre.toLowerCase()) < 0)
            nodo.izquierda = insertarRec(nodo.izquierda, usuario);
        else
            nodo.derecha = insertarRec(nodo.derecha, usuario);
        return nodo;
    }

    public Usuario buscar(String nombre) {
        return buscarRec(raiz, nombre.toLowerCase());
    }

    private Usuario buscarRec(NodoUsuario nodo, String nombre) {
        if (nodo == null) return null;
        String actual = nodo.usuario.nombre.toLowerCase();
        if (nombre.equals(actual)) return nodo.usuario;
        if (nombre.compareTo(actual) < 0)
            return buscarRec(nodo.izquierda, nombre);
        else
            return buscarRec(nodo.derecha, nombre);
    }
}
