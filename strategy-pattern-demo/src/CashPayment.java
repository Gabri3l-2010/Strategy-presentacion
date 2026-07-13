/**
 * Estrategia concreta (ConcreteStrategy).
 * Implementa el algoritmo de pago en efectivo (sin datos adicionales).
 */
public class CashPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.printf("Pagando Q%.2f en efectivo%n", amount);
    }
}
