import java.util.ArrayList;

public class ControladorCliente {
    private ArrayList<Cliente> clienteList;
    VistaCliente vista;

    ControladorCliente(VistaCliente vista) {
        clienteList = new ArrayList<Cliente>();
        this.vista = vista;
    }

    public void menuCliente() {
        Integer opcion = 0;
        Integer numeroDeCuenta;
        Cliente cliente;
        Integer respuesta;

        while (opcion != 6) {
            switch (vista.menu()) {
                case 1:
                    addCliente();
                    break;
                case 2:
                    numeroDeCuenta = vista.pedirNumeroDeCuenta();
                    cliente = buscarCliente(numeroDeCuenta);
                    respuesta = depositar(cliente, numeroDeCuenta);
                    vista.mensajeDeposito(cliente, respuesta);
                    break;
                case 3:
                    numeroDeCuenta = vista.pedirNumeroDeCuenta();
                    cliente = buscarCliente(numeroDeCuenta);
                    respuesta = retirar(cliente, numeroDeCuenta);
                    vista.mensajeRetiro(cliente, respuesta);
                    break;
                case 4:
                    Integer numeroDeCuentaOrigen = vista.pedirNumeroDeCuenta();
                    Cliente clienteOrigen = buscarCliente(numeroDeCuentaOrigen);
                    respuesta = transferencia(clienteOrigen, numeroDeCuentaOrigen);
                    vista.mensajeTransferencia(clienteOrigen, respuesta);
                    break;
                case 5:
                    numeroDeCuenta = vista.pedirNumeroDeCuenta();   
                    vista.imprimirInfoCliente(buscarCliente(numeroDeCuenta));
                    break;
                case 6:
                    opcion = 6;
                    break;
            }
        }
    }

    public void addCliente() {
        clienteList.add(0, new Cliente(vista.pedirNombre(), vista.pedirApellido(), vista.pedirNumeroDeCuenta(), vista.pedirSaldo()));
    }

    public Cliente buscarCliente(Integer numeroDeCuenta) {
        for (int i = 0; i < clienteList.size(); i++) {
            if (clienteList.get(i).getNumeroDeCuenta() == numeroDeCuenta) {
                return clienteList.get(i);
            }
        }
        return null;
    }

    public Integer depositar(Cliente obj1, Integer numeroDeCuenta) {
        Integer res = 0; 
        if (obj1 != null) {
            double monto = vista.pedirMontoDeposito();
            Cliente indice = buscarCliente(numeroDeCuenta); //Obtiene el indice del cliente para poder realizar las operaciones
            double saldo = indice.getSaldo(); //Obtiene el saldo del cliente
            indice.setSaldo(saldo + monto); //Aumenta al saldo del cliente el monto del depósito
            res = 1; //Deposito realizado
        }   
        return res;
    }

    public Integer retirar(Cliente obj1, Integer numeroDeCuenta) {
        Integer res = 0;
        if (obj1 != null) {
            double monto = vista.pedirMontoRetiro();
            Cliente indice = buscarCliente(numeroDeCuenta); //Obtiene el indice del cliente para poder realizar las operaciones
            double saldo = indice.getSaldo(); //Obtiene el saldo del cliente
            if (monto <= saldo) {
                indice.setSaldo(saldo - monto); //Descuenta al saldo del cliente el monto del retiro
                res = 1; //Retiro realizado
            }else{
                res = 2; //No cuenta con saldo suficiente
            }
        }
        return res;
    }

    public Integer transferencia(Cliente obj1, Integer numeroDeCuentaOrigen) {
        Integer res = 0;
        if (obj1 != null) {
            Integer numeroDeCuentaDestino = vista.pedirNumeroDeCuentaDestino();
            Cliente clienteDestino = buscarCliente(numeroDeCuentaDestino);
            if (clienteDestino != null) {
                double monto = vista.pedirMontoTransferencia();
                Cliente indiceClienteOrigen = buscarCliente(numeroDeCuentaOrigen); //Obtiene el indice del cliente origen para poder realizar las operaciones
                double saldoClienteOrigen = indiceClienteOrigen.getSaldo(); //Obtiene el saldo del cliente origen
                if (monto <= saldoClienteOrigen){
                    indiceClienteOrigen.setSaldo(saldoClienteOrigen - monto);
                    Cliente indiceClienteDestino = buscarCliente(numeroDeCuentaDestino); //Obtiene el indice del cliente destino para poder realizar las operaciones
                    double saldoClienteDestino = indiceClienteDestino.getSaldo(); //Obtiene el saldo del cliente destino
                    indiceClienteDestino.setSaldo(saldoClienteDestino + monto);
                    res = 1; //Transferencia realizada
                }else {
                    res = 2; //No cuenta con saldo suficiente
                }
            }
        }
        return res;
    }
}