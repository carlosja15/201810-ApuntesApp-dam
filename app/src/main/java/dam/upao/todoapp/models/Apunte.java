package dam.upao.todoapp.models;

/**
 * Created by Upao on 05/04/2018.
 */

public class Apunte {
    private String titulo;
    private String contenido;
    private String etiquetas;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(String etiquetas) {
        this.etiquetas = etiquetas;
    }

    @Override
    public String toString() {
        return titulo;
    }
}
