/**
 * Interfaz "Strategy".
 * Declara el metodo comun que todas las estrategias concretas de pago
 * deben implementar. El Context (ShoppingCart) solo conoce esta interfaz,
 * nunca las clases concretas.
 */
public interface PaymentStrategy {
    void pay(double amount);
}
