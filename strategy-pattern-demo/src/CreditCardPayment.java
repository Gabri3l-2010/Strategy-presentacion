/**
 * Estrategia concreta (ConcreteStrategy).
 * Implementa el algoritmo de pago con tarjeta de credito.
 */
public class CreditCardPayment implements PaymentStrategy {

    private final String cardNumber;
    private final String cardHolder;

    public CreditCardPayment(String cardNumber, String cardHolder) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }

    @Override
    public void pay(double amount) {
        String masked = cardNumber.substring(cardNumber.length() - 4);
        System.out.printf("Pagando Q%.2f con tarjeta de credito terminada en %s (titular: %s)%n",
                amount, masked, cardHolder);
    }
}
