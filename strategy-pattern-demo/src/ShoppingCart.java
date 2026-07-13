/**
 * Context.
 * Mantiene una referencia a una estrategia (PaymentStrategy) y delega en ella
 * el trabajo de cobrar, sin saber (ni importarle) cual es la implementacion
 * concreta que se esta usando. La estrategia se puede cambiar en tiempo de
 * ejecucion con setPaymentStrategy().
 */
public class ShoppingCart {

    private double total = 0.0;
    private PaymentStrategy paymentStrategy;

    public void addItem(double price) {
        total += price;
    }

    public double getTotal() {
        return total;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout() {
        if (paymentStrategy == null) {
            throw new IllegalStateException("Debes asignar una estrategia de pago antes de pagar.");
        }
        paymentStrategy.pay(total);
        total = 0.0;
    }
}
