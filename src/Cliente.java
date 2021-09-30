public class Cliente {
    private String nombre;
    private String apellido;
    private Integer numeroDeCuenta;
    private double saldo;

    Cliente() {
    }

    // Constructor
    Cliente(String nombre, String apellido, Integer numeroDeCuenta, double saldo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroDeCuenta = numeroDeCuenta;
        this.saldo = saldo;
    }

    //Setters y getters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setNumeroDeCuenta(Integer numeroDeCuenta) {
        this.numeroDeCuenta = numeroDeCuenta;
    }

    public Integer getNumeroDeCuenta() {
        return this.numeroDeCuenta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return this.saldo;
    }
}
