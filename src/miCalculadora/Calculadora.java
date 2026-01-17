package miCalculadora;

public class Calculadora {
    private float numero1;
    private float numero2;

    public Calculadora(float numero1, float numero2) {
        this.numero1 = numero1;
        this.numero2 = numero2;
    }

    public float sumar() {
        float resultado= numero1 + numero2;
        //Detectar overflow
        if(Float.isInfinite(resultado)){
            throw new OverFlowException("No es posible realizar la suma porque el resultado es demasiado grande para ser representado");
        }
        //Detectar underflow
        if (resultado == 0.0f && numero1 != 0.0f && numero2 != 0.0f) {
            throw new UnderFlowException("No es posible realizar la suma porque el resultado es demasiado pequeño para ser representado");
        }
        return resultado;
    }

    public float restar() {
        float resultado = numero1 - numero2;
        // Detectar overflow
        if (Float.isInfinite(resultado)) {
            throw new OverFlowException("No es posible realizar la resta porque el resultado es demasiado grande para ser representado");
        }
        return resultado;
}


    public float multiplicar() {
        float resultado = numero1 * numero2;

        // Detectar overflow
        if (Float.isInfinite(resultado)) {
            throw new OverFlowException("No es posible realizar la multiplicación porque el resultado es demasiado grande para ser representado");
        }
        // Detectar underflow
        if (resultado == 0.0f && numero1 != 0.0f && numero2 != 0.0f) {
            throw new UnderFlowException("No es posible realizar la multiplicación porque el resultado es demasiado pequeño para ser representado");
        }
        return resultado;
}


   public float dividir() {
        // Caso especial: 0 / 0 → indeterminación
        if (numero1 == 0 && numero2 == 0) {
            throw new ArithmeticException("No es posible realizar la división porque ambos números son cero. Esto es una indeterminación");
        }
        // División por cero
        if (numero2 == 0) {
            throw new ArithmeticException("No es posible realizar la división porque el denominador es cero. Esta operación no está permitida");
        }
        float resultado = numero1 / numero2;
        // Detectar overflow
        if (Float.isInfinite(resultado)) {
            throw new OverFlowException("No es posible realizar la división porque el resultado es demasiado grande para ser representado");
        }
        // Detectar underflow
        if (resultado == 0.0f && numero1 != 0.0f && numero2 != 0.0f) {
            throw new UnderFlowException("No es posible realizar la división porque el resultado es demasiado pequeño para ser representado");
        }
        return resultado;
}


    public float getNumero1() {
        return numero1;
    }

    public void setNumero1(float numero1) {
        this.numero1 = numero1;
    }

    public float getNumero2() {
        return numero2;
    }

    public void setNumero2(float numero2) {
        this.numero2 = numero2;
    }
}
