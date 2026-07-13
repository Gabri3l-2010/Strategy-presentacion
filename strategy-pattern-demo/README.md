# Patrón de Diseño: Strategy

Ejemplo en Java del patrón de diseño **Strategy** (Estrategia), aplicado a un
sistema de pagos de un carrito de compras que puede pagar con **tarjeta de
crédito**, **PayPal** o **efectivo**, cambiando de método en tiempo de
ejecución sin modificar el código del carrito.

## ¿Qué es el patrón Strategy?

Strategy es un patrón de diseño de **comportamiento** que define una familia
de algoritmos, encapsula cada uno en una clase independiente y los hace
intercambiables entre sí. Permite que el algoritmo varíe independientemente
de los clientes que lo usan.

## Estructura del proyecto

```
strategy-pattern-demo/
├── src/
│   ├── PaymentStrategy.java     # Interfaz Strategy
│   ├── CreditCardPayment.java   # ConcreteStrategy A
│   ├── PayPalPayment.java       # ConcreteStrategy B
│   ├── CashPayment.java         # ConcreteStrategy C
│   ├── ShoppingCart.java        # Context
│   └── Main.java                # Cliente (demo)
└── test/
    └── PaymentStrategyTest.java # Pruebas del comportamiento
```

## Cómo compilar y ejecutar

Compilar y correr la demo:

```bash
javac -d bin src/*.java
java -cp bin Main
```

Compilar y correr las pruebas (usa `assert`, por eso se habilita `-ea`):

```bash
javac -d bin src/*.java test/PaymentStrategyTest.java
java -ea -cp bin PaymentStrategyTest
```

## Participantes del patrón en este ejemplo

| Rol UML | Clase en el proyecto |
|---|---|
| Strategy (interfaz) | `PaymentStrategy` |
| ConcreteStrategy | `CreditCardPayment`, `PayPalPayment`, `CashPayment` |
| Context | `ShoppingCart` |
| Client | `Main` |

## Ventajas que demuestra este ejemplo

- Se puede agregar una nueva forma de pago (ej. transferencia bancaria) sin
  tocar `ShoppingCart`, solo creando una nueva clase que implemente
  `PaymentStrategy` (principio Abierto/Cerrado).
- `ShoppingCart` nunca usa `if/else` ni `switch` para decidir cómo cobrar.
- La estrategia se puede cambiar en tiempo de ejecución con
  `setPaymentStrategy(...)`.
