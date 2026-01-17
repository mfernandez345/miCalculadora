import static org.junit.jupiter.api.Assertions.*;

import miCalculadora.Calculadora;
import miCalculadora.OverFlowException;
import miCalculadora.UnderFlowException;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {
    //Casos de prueba1. Operaciones válidas con números positivos
    //Opción 1
    @Test
    public void sumaPositivos() {
        float numero1 = 12.5F;
        float numero2 = 3.2F;
        Calculadora c= new Calculadora(numero1,numero2);
        assertEquals(15.7F, c.sumar());
    }

    //Opción 2
    @Test
    public void restaPositivos() {
        float numero1 = 12.5F;
        float numero2 = 3.2F;
        Calculadora c = new Calculadora(numero1,numero2);
        assertEquals(9.3f, c.restar());
    }

    //Opción 3
    @Test
    public void multiplicacionPositivos() {
        float numero1 = 12.5F;
        float numero2 = 3.2F;
        Calculadora c = new Calculadora(numero1,numero2);
        assertEquals(40F, c.multiplicar());
    }

   //Opción 4
    @Test
    public void divisionPositivos() {
        float numero1 = 12.5F;
        float numero2 = 3.2F;
        Calculadora c = new Calculadora(numero1,numero2);
        assertEquals(3.90625F, c.dividir());
    }

    //Casos de prueba 2. Operaciones válidas e inválida (división) con números negativo y cero
    //Opción 1
    @Test
    public void sumaNegativoCero() {
        float numero1 = -8.5F;
        float numero2 = 0F;
        Calculadora c = new Calculadora(numero1,numero2);
        assertEquals(-8.5F, c.sumar());
    }

    //Opción 2
    @Test
    public void restaNegativoCero() {
        float numero1 = -8.5F;
        float numero2 = 0F;
        Calculadora c = new Calculadora(numero1,numero2);
        assertEquals(-8.5F, c.restar());
    }

    //Opción 3

    @Test
    public void multiplicacionNegativoCero() {
        float numero1 = -8.5F;
        float numero2 = 0F;
        Calculadora c = new Calculadora(numero1,numero2);
        assertEquals(-0F, c.multiplicar());
    }

    //Opción 4
    @Test
    public void divisionNegativoCero() {
        float numero1 = -8.5F;
        float numero2 = 0F;
        Calculadora c = new Calculadora(numero1,numero2);
        ArithmeticException exception=assertThrows(ArithmeticException.class, ()->c.dividir());
        assertEquals("No es posible realizar la división porque el denominador es cero. Esta operación no está permitida", exception.getMessage());
    }

    //Casos de prueba 3. Operaciones con números grandes o muy distantes que provocan overflow
    //Opción 1
    @Test
    public void sumaOverflow() {
        float numero1 = 3.4E38F;
        float numero2 = 3.4E38F;
        Calculadora c = new Calculadora(numero1,numero2);
        OverFlowException exception=assertThrows(OverFlowException.class, ()->c.sumar());
        assertEquals("No es posible realizar la suma porque el resultado es demasiado grande para ser representado", exception.getMessage());
    }

   //Opción 2
    @Test
    public void restaOverflow() {
        float numero1 = 3.4E38F;
        float numero2 = -3.4E38F;
        Calculadora c = new Calculadora(numero1,numero2);
        OverFlowException exception=assertThrows(OverFlowException.class, ()->c.restar());
        assertEquals("No es posible realizar la resta porque el resultado es demasiado grande para ser representado", exception.getMessage());
    }

    //Opción 3
    @Test
    public void multiplicacionOverflow() {
        float numero1 = 3.4E38F;
        float numero2 = 3.4E38F;
        Calculadora c = new Calculadora(numero1,numero2);
        OverFlowException exception=assertThrows(OverFlowException.class, ()->c.multiplicar());
        assertEquals("No es posible realizar la multiplicación porque el resultado es demasiado grande para ser representado", exception.getMessage());
    }

   // Opción 4
    @Test
    public void divisionOverFlow() {
        float numero1 = 3.4E38F;
        float numero2 = 1.0E-45F;
        Calculadora c = new Calculadora(numero1,numero2);
        OverFlowException exception=assertThrows(OverFlowException.class, ()->c.dividir());
        assertEquals("No es posible realizar la división porque el resultado es demasiado grande para ser representado", exception.getMessage());
    }

    //Casos de prueba 4. Operaciones con números pequeños que provocan underflow
    //Opción 1
    @Test
    public void sumaUnderflow() {
        float numero1 = 1.5E-45F;
        float numero2 = -1.4E-45F;
        Calculadora c = new Calculadora(numero1,numero2);
        UnderFlowException exception=assertThrows(UnderFlowException.class, ()->c.sumar());
        assertEquals("No es posible realizar la suma porque el resultado es demasiado pequeño para ser representado", exception.getMessage());
    }

    //Opción 2
    @Test
    public void multiplicacionUnderflow() {
        float numero1 = 1.5E-45F;
        float numero2 = -1.4E-45F;
        Calculadora c = new Calculadora(numero1,numero2);
        UnderFlowException exception=assertThrows(UnderFlowException.class, ()->c.multiplicar());
        assertEquals("No es posible realizar la multiplicación porque el resultado es demasiado pequeño para ser representado", exception.getMessage());
    }

    //Opción 3
    @Test
    public void divisionUnderflow() {
        float numero1 = 1.5E-45F;
        float numero2 = 2F;
        Calculadora c = new Calculadora(numero1,numero2);
        UnderFlowException exception=assertThrows(UnderFlowException.class, ()->c.dividir());
        assertEquals("No es posible realizar la división porque el resultado es demasiado pequeño para ser representado", exception.getMessage());
    }

    //Casos de prueba 5. Indeterminación 0/0
    //Opción 1

    @Test
    public void indeterminacionDivision() {
        float numero1 = 0F;
        float numero2 = 0F;
        Calculadora c = new Calculadora(numero1,numero2);
        ArithmeticException exception=assertThrows(ArithmeticException.class, ()->c.dividir());
        assertEquals("No es posible realizar la división porque ambos números son cero. Esto es una indeterminación", exception.getMessage());
    }
}
