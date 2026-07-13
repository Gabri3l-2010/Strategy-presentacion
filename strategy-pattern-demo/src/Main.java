/**
 * Cliente.
 * Decide en tiempo de ejecucion que estrategia concreta usar,
 * y se la asigna al Context (ShoppingCart).
 */
public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(120.0);
        cart.addItem(45.5);

        System.out.println("Total acumulado: Q" + cart.getTotal());
        System.out.println("--- Cliente elige pagar con tarjeta ---");
        cart.setPaymentStrategy(new CreditCardPayment("4111111111111234", "Maria Lopez"));
        cart.checkout();

        cart.addItem(80.0);
        System.out.println("--- Cliente cambia de estrategia y paga con PayPal ---");
        cart.setPaymentStrategy(new PayPalPayment("maria.lopez@email.com"));
        cart.checkout();

        cart.addItem(25.0);
        System.out.println("--- Cliente cambia de estrategia y paga en efectivo ---");
        cart.setPaymentStrategy(new CashPayment());
        cart.checkout();
    }
}
