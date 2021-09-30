public class App {
    public static void main(String[] args) throws Exception {
        VistaCliente vista = new VistaCliente();
        ControladorCliente Clientes = new ControladorCliente(vista);
        Clientes.menuCliente();
    }
}
