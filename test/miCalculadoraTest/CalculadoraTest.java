package miCalculadoraTest;

import static org.junit.jupiter.api.Assertions.*;

import miCalculadora.Calculadora;
import miCalculadora.OverFlowException;
import miCalculadora.UnderFlowException;
import org.junit.jupiter.api.Test;

/**
 * <p><strong>Definición: </strong>Conjunto de pruebas unitarias destinadas a verificar
 * el comportamiento de la clase {@link Calculadora}.</p>
 * <p>
 * Los casos de prueba están organizados por categorías, con el objetivo
 * de validar el comportamiento de las operaciones aritméticas bajo diferentes condiciones.
 * </p>
 *
 * <p><strong>Autora: </strong>María Inés Fernández Álvarez.</p>
 *
 * <p><strong>Categorias de casos de prueba</strong></p>
 * <ul>
 *   <li>Operaciones válidas con números positivos (valores float dentro de un rango seguro,
 *       sin riesgo de overflow ni underflow).</li>
 *   <li>Operaciones válidas con números negativos (valores float dentro de un rango seguro,
 *       sin riesgo de overflow ni underflow) e inválida (opción división) con número negativo (valor float dentro
 *       de un rango seguro, sin riesgo de overflow ni underflow) y cero.</li>
 *   <li>Operaciones con números extremadamente grandes o un número extremadamente grande y otro
 *       extremadamente pequeño provocan <strong>overflow</strong>.</li>
 *   <li>Operaciones con números extemadamente pequeños o un número extremadamente pequeño y otro
 *       seguro, provocan <strong>underflow</strong>.</li>
 *   <li>Indeterminación 0/0.</li>
 * </ul>
 *
 * <p>
 * Cada prueba verifica tanto resultados correctos como la generación de excepciones
 * adecuadas, cuando la operación no puede realizarse.
 * </p>
 */
public class CalculadoraTest {
    //Operaciones válidas con números positivos (valores float dentro de un rango seguro,
    //sin riesgo de overflow ni underflow)

    /**
     * Verifica que la suma de dos números seguros, positivos produce el resultado esperado.
     */
    @Test
    public void sumaPositivos() {
        float numero1 = 12.5F;
        float numero2 = 3.2F;
        Calculadora c= new Calculadora(numero1,numero2);
        assertEquals(15.7F, c.sumar());
    }

    /**
     * Verifica que la resta de dos números seguros, positivos produce el resultado esperado.
     */
    @Test
    public void restaPositivos() {
        float numero1 = 12.5F;
        float numero2 = 3.2F;
        Calculadora c = new Calculadora(numero1,numero2);
        assertEquals(9.3f, c.restar());
    }

    /**
     * Verifica que la multiplicación de dos números seguros, positivos produce el resultado esperado.
     */
    @Test
    public void multiplicacionPositivos() {
        float numero1 = 12.5F;
        float numero2 = 3.2F;
        Calculadora c = new Calculadora(numero1,numero2);
        assertEquals(40F, c.multiplicar());
    }

    /**
     * Verifica que la división de dos números seguros, positivos produce el resultado esperado.
     */
    @Test
    public void divisionPositivos() {
        float numero1 = 12.5F;
        float numero2 = 3.2F;
        Calculadora c = new Calculadora(numero1,numero2);
        assertEquals(3.90625F, c.dividir());
    }

    //Operaciones válidas con números negativos (valores float dentro de un rango seguro,
    //sin riesgo de overflow ni underflow) e inválida (opción división) con número negativo (valor float dentro
    //de un rango seguro, sin riesgo de overflow ni underflow) y cero

    /**
     * Verifica que la suma de un número seguro, negativo y cero produce el resultado esperado.
     */
    @Test
    public void sumaNegativoCero() {
        float numero1 = -8.5F;
        float numero2 = 0F;
        Calculadora c = new Calculadora(numero1,numero2);
        assertEquals(-8.5F, c.sumar());
    }

    /**
     * Verifica que la resta de un número seguro, negativo y cero produce el resultado esperado.
     */
    @Test
    public void restaNegativoCero() {
        float numero1 = -8.5F;
        float numero2 = 0F;
        Calculadora c = new Calculadora(numero1,numero2);
        assertEquals(-8.5F, c.restar());
    }

    /**
     * Verifica que la multiplicación de un número seguro, negativo y cero produce el resultado esperado.
     */
    @Test
    public void multiplicacionNegativoCero() {
        float numero1 = -8.5F;
        float numero2 = 0F;
        Calculadora c = new Calculadora(numero1,numero2);
        assertEquals(-0F, c.multiplicar());
    }

    /**
     * Verifica que la división de un número seguro, negativo y cero genera una {@code ArithmeticException}, resultado esperado.
     */
    @Test
    public void divisionNegativoCero() {
        float numero1 = -8.5F;
        float numero2 = 0F;
        Calculadora c = new Calculadora(numero1,numero2);
        ArithmeticException exception=assertThrows(ArithmeticException.class, ()->c.dividir());
        assertEquals("No es posible realizar la división porque el denominador es cero. Esta operación no está permitida", exception.getMessage());
    }

    //Operaciones con números extremadamente grandes o muy distantes que provocan overflow
    /**
     * Verifica que la suma de dos números extremadamente grandes provoca {@link OverFlowException}, resultado esperado.
     */
    @Test
    public void sumaOverflow() {
        float numero1 = 3.4E38F;
        float numero2 = 3.4E38F;
        Calculadora c = new Calculadora(numero1,numero2);
        OverFlowException exception=assertThrows(OverFlowException.class, ()->c.sumar());
        assertEquals("No es posible realizar la suma porque el resultado es demasiado grande para ser representado", exception.getMessage());
    }

    /**
     * Verifica que la resta de dos números extremadamente grandes provoca {@link OverFlowException}, resultado esperado.
     */
    @Test
    public void restaOverflow() {
        float numero1 = 3.4E38F;
        float numero2 = -3.4E38F;
        Calculadora c = new Calculadora(numero1,numero2);
        OverFlowException exception=assertThrows(OverFlowException.class, ()->c.restar());
        assertEquals("No es posible realizar la resta porque el resultado es demasiado grande para ser representado", exception.getMessage());
    }

    /**
     * Verifica que la multiplicación de dos números extremadamente grandes provoca {@link OverFlowException}, resultado esperado.
     */
    @Test
    public void multiplicacionOverflow() {
        float numero1 = 3.4E38F;
        float numero2 = 3.4E38F;
        Calculadora c = new Calculadora(numero1,numero2);
        OverFlowException exception=assertThrows(OverFlowException.class, ()->c.multiplicar());
        assertEquals("No es posible realizar la multiplicación porque el resultado es demasiado grande para ser representado", exception.getMessage());
    }

    /**
     * Verifica que la división de un número extremadamente grande y otro extremadamente pequeño
     * provoca {@link OverFlowException}, resultado esperado.
     */
    @Test
    public void divisionOverFlow() {
        float numero1 = 3.4E38F;
        float numero2 = 1.0E-45F;
        Calculadora c = new Calculadora(numero1,numero2);
        OverFlowException exception=assertThrows(OverFlowException.class, ()->c.dividir());
        assertEquals("No es posible realizar la división porque el resultado es demasiado grande para ser representado", exception.getMessage());
    }

    //Operaciones con números extemadamente pequeños que provocan underflow
    /**
     * Verifica que la suma de dos números extremadamente pequeños provoca {@link UnderFlowException}, resultado esperado.
     */
    @Test
    public void sumaUnderflow() {
        float numero1 = 1.5E-45F;
        float numero2 = -1.4E-45F;
        Calculadora c = new Calculadora(numero1,numero2);
        UnderFlowException exception=assertThrows(UnderFlowException.class, ()->c.sumar());
        assertEquals("No es posible realizar la suma porque el resultado es demasiado pequeño para ser representado", exception.getMessage());
    }

    /**
     * Verifica que la multiplicación de dos números extremadamente pequeños provoca {@link UnderFlowException}, resultado esperado.
     */
    @Test
    public void multiplicacionUnderflow() {
        float numero1 = 1.5E-45F;
        float numero2 = -1.4E-45F;
        Calculadora c = new Calculadora(numero1,numero2);
        UnderFlowException exception=assertThrows(UnderFlowException.class, ()->c.multiplicar());
        assertEquals("No es posible realizar la multiplicación porque el resultado es demasiado pequeño para ser representado", exception.getMessage());
    }

    /**
     * Verifica que la división de un número extremadamente pequeño y otro número, seguro,
     * provoca {@link UnderFlowException}, resultado esperado.
     */
    @Test
    public void divisionUnderflow() {
        float numero1 = 1.5E-45F;
        float numero2 = 2F;
        Calculadora c = new Calculadora(numero1,numero2);
        UnderFlowException exception=assertThrows(UnderFlowException.class, ()->c.dividir());
        assertEquals("No es posible realizar la división porque el resultado es demasiado pequeño para ser representado", exception.getMessage());
    }

    //Indeterminación 0/0
    /**
     * Verifica que la división 0/0 es una indeterminación matemática que genera {@code ArithmeticException}, resultado esperado.
    */
    @Test
    public void indeterminacionDivision() {
        float numero1 = 0F;
        float numero2 = 0F;
        Calculadora c = new Calculadora(numero1,numero2);
        ArithmeticException exception=assertThrows(ArithmeticException.class, ()->c.dividir());
        assertEquals("No es posible realizar la división porque ambos números son cero. Esto es una indeterminación", exception.getMessage());
    }
}
