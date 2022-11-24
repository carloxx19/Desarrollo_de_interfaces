package cafe;

public class Cafe {

    //variables
    public String nombre;
    public String tamanio;
    public int cantidad;
    public int valor;
    public int total;

    //getter and setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Cafe() {
        this.nombre = nombre;
        this.tamanio = tamanio;
        this.cantidad = cantidad;
        this.valor = valor;
        this.total = total;
    }
}