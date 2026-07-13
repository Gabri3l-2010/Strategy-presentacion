/**
 * Estrategia concreta (ConcreteStrategy).
 * Implementa el algoritmo de pago mediante PayPal.
 */
public class PayPalPayment implements PaymentStrategy {

    private final String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.printf("Pagando Q%.2f mediante PayPal, cuenta asociada a %s%n", amount, email);
    }
}
