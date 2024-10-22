public class CuentaBancaria {
    private String titular;
    private double saldo;

    public CuentaBancaria(String titular) {
        this.titular = titular;
        this.saldo = 10000;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double monto) throws MontoInvalidoException {
        if (monto < 0) {
            throw new MontoInvalidoException("El monto a depositar no puede ser negativo.");
        }
        saldo += monto;
    }

    public void retirar(double monto) throws SaldoInsuficienteException, MontoInvalidoException {
        if (monto < 0) {
            throw new MontoInvalidoException("El monto a retirar no puede ser negativo.");
        }
        if (monto > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar la operación.");
        }
        saldo -= monto;
    }

    public void transferir(CuentaBancaria cuentaDestino, double monto)
            throws SaldoInsuficienteException, MontoInvalidoException {
        retirar(monto);
        cuentaDestino.depositar(monto);
    }
}
