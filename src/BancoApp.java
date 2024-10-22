public class BancoApp {
    public static void main(String[] args) {
        CuentaBancaria cuenta1 = new CuentaBancaria("Alice");
        CuentaBancaria cuenta2 = new CuentaBancaria("Bob");

        try {
            cuenta1.depositar(500);
            System.out.println("Saldo de Alice: " + cuenta1.getSaldo());

            cuenta1.retirar(200);
            System.out.println("Saldo de Alice después del retiro: " + cuenta1.getSaldo());

            cuenta1.transferir(cuenta2, 100);
            System.out.println("Saldo de Alice después de la transferencia: " + cuenta1.getSaldo());
            System.out.println("Saldo de Bob después de la transferencia: " + cuenta2.getSaldo());

            // Intentar retirar más de lo que hay en la cuenta
            cuenta1.retirar(300);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (MontoInvalidoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
