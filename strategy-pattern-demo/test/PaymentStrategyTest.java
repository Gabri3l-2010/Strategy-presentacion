import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Pruebas del patron Strategy.
 * No usa JUnit para mantener el ejemplo simple y ejecutable con el JDK puro.
 * Se ejecuta habilitando aserciones: java -ea PaymentStrategyTest
 */
public class PaymentStrategyTest {

    public static void main(String[] args) {
        testCartAccumulatesTotal();
        testCreditCardStrategyIsUsed();
        testStrategyCanBeSwappedAtRuntime();
        testCheckoutWithoutStrategyThrows();

        System.out.println("Todas las pruebas pasaron correctamente.");
    }

    static void testCartAccumulatesTotal() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(100.0);
        cart.addItem(50.0);
        assert cart.getTotal() == 150.0 : "El total del carrito deberia ser 150.0";
    }

    static void testCreditCardStrategyIsUsed() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(200.0);
        cart.setPaymentStrategy(new CreditCardPayment("4111111111111234", "Test User"));

        String output = captureOutput(cart::checkout);
        assert output.contains("tarjeta de credito") : "Debio usarse la estrategia de tarjeta de credito";
        assert cart.getTotal() == 0.0 : "El total debe reiniciarse a 0 despues del checkout";
    }

    static void testStrategyCanBeSwappedAtRuntime() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(75.0);
        cart.setPaymentStrategy(new PayPalPayment("user@test.com"));
        String firstOutput = captureOutput(cart::checkout);
        assert firstOutput.contains("PayPal") : "Primera estrategia debio ser PayPal";

        cart.addItem(30.0);
        cart.setPaymentStrategy(new CashPayment());
        String secondOutput = captureOutput(cart::checkout);
        assert secondOutput.contains("efectivo") : "Segunda estrategia debio ser efectivo";
    }

    static void testCheckoutWithoutStrategyThrows() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(10.0);
        boolean threw = false;
        try {
            cart.checkout();
        } catch (IllegalStateException e) {
            threw = true;
        }
        assert threw : "checkout() sin estrategia asignada debe lanzar IllegalStateException";
    }

    /** Utilidad para capturar lo que imprime System.out durante la ejecucion de una accion. */
    static String captureOutput(Runnable action) {
        PrintStream original = System.out;
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
        try {
            action.run();
        } finally {
            System.setOut(original);
        }
        return buffer.toString();
    }
}
