package miCalculadora;
/**
 * <p><strong>Definición: </strong>Estructura formada por dos valores de tipo {@code float}
 * sobre los que se realizan operaciones aritméticas básicas. Las operaciones disponibles están implementadas siguiendo
 * la lista de condiciones definidas en las Historias de Usuario del proyecto.
 * </p>
 *
 * <p><strong>Autora: </strong>María Inés Fernández Álvarez.</p>
 *
 * <p><strong>Historias de Usuario: Lista de condiciones</strong></p>
 * <ul>
 *   <li><strong>HU1 – Suma:</strong> Como usuario de la calculadora quiero sumar dos números reales
 *       para obtener el resultado con dos decimales, siempre que no se produzca overflow o underflow.</li>
 *
 *   <li><strong>HU2 – Resta:</strong> Como usuario de la calculadora quiero restar dos números reales
 *       para obtener el resultado con dos decimales, siempre que no se produzca overflow.</li>
 *
 *   <li><strong>HU3 – Multiplicación:</strong> Como usuario de la calculadora quiero multiplicar dos números reales
 *       para obtener el resultado con dos decimales, siempre que no se produzca overflow o underflow.</li>
 *
 *   <li><strong>HU4 – División:</strong> Como usuario de la calculadora quiero dividir dos números reales
 *       para obtener el resultado con dos decimales, siempre que no haya división por cero,
 *       indeterminación 0/0, overflow o underflow.</li>
 * </ul>
 *
 * <p><strong>Historias de Usuario: Criterios de aceptación</strong></p>
 * <p>Se encuentran recogidos en cada uno de los métodos.</p>
 */
public class Calculadora {
    /**
     * El sistema debe permitir al usuario elegir dos números reales
     */
    private float numero1;
    private float numero2;

    /**
     * Constructor con parámetros: crea una nueva instancia de la clase Calculadora con dos valores iniciales
     * @param numero1 el primer número que usará la calculadora
     * @param numero2 el segundo número que usará la calculadora
     */
    public Calculadora(float numero1, float numero2) {
        this.numero1 = numero1;
        this.numero2 = numero2;
    }

    /**
     * Realiza la suma de los dos números reales almacenados en la calculadora, aplicando todas
     * las validaciones necesarias para garantizar un resultado correcto
     * <p>
     * Criterios de aceptación implementados:
     * </p>
     * <ul>
     *     <li>El sistema permite operar con dos números reales previamente seleccionados.</li>
     *     <li>Se valida que la operación no produzca <strong>overflow</strong>; si el resultado
     *         excede el rango representable por {@code float}, se lanza una {@link OverFlowException}
     *         con un mensaje descriptivo.</li>
     *      <li>Se valida que la operación no produzca <strong>underflow</strong>; si el resultado
     *          se redondea a cero aun cuando los operandos no son cero, se lanza una
     *          {@link UnderFlowException}.</li>
     *     <li>Tras una validación exitosa, el resultado puede mostrarse con formato fijo
     *         de dos decimales y usando coma como separador decimal (formateo realizado
     *         externamente por la capa de presentación).</li>
     *     <li>En caso de error, se generan las excepciones adecuadas para que el sistema
     *         pueda continuar funcionando con normalidad.</li>
     * </ul>
     *
     * @return El resultado numérico de la suma como un valor {@code float}
     * @throws OverFlowException si el resultado es demasiado grande para ser representado
     * @throws UnderFlowException si el resultado es demasiado pequeño para ser representado
     */
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

    /**
     * Realiza la resta entre los dos números reales almacenados en la calculadora,
     * aplicando las validaciones necesarias para garantizar un resultado correcto.
     * <p>
     * Criterios de aceptación implementados:
     * </p>
     * <ul>
     *   <li>El sistema permite operar con dos números reales previamente seleccionados.</li>
     *   <li>Se valida que la operación no produzca <strong>overflow</strong>; si el resultado
     *       excede el rango representable por {@code float}, se lanza una
     *       {@link  OverFlowException} con un mensaje descriptivo.</li>
     *   <li>Tras una validación exitosa, el resultado puede mostrarse con formato fijo
     *       de dos decimales y usando coma como separador decimal (formateo realizado
     *       externamente por la capa de presentación).</li>
     *   <li>En caso de error por overflow, se genera la excepción adecuada para que el
     *       sistema pueda continuar funcionando con normalidad.</li>
     * </ul>
     *
     * @return El resultado numérico de la resta como un valor {@code float}
     * @throws OverFlowException si el resultado es demasiado grande para ser representado
     */
    public float restar() {
        float resultado = numero1 - numero2;
        // Detectar overflow
        if (Float.isInfinite(resultado)) {
            throw new OverFlowException("No es posible realizar la resta porque el resultado es demasiado grande para ser representado");
        }
        return resultado;
    }

    /**
     * Realiza la multiplicación entre los dos números reales almacenados en la calculadora,
     * aplicando las validaciones necesarias para garantizar un resultado correcto.
     * <p>
     * Criterios de aceptación implementados:
     * </p>
     * <ul>
     *   <li>El sistema permite operar con dos números reales previamente seleccionados.</li>
     *   <li>Se valida que la operación no produzca <strong>overflow</strong>; si el resultado
     *       excede el rango representable por {@code float}, se lanza una
     *       {@link OverFlowException} con un mensaje descriptivo.</li>
     *   <li>Se valida que la operación no produzca <strong>underflow</strong>; si el resultado
     *       se redondea a cero aun cuando los operandos no son cero, se lanza una
     *       {@link UnderFlowException}.</li>
     *   <li>Tras una validación exitosa, el resultado puede mostrarse con formato fijo
     *       de dos decimales y usando coma como separador decimal (formateo realizado
     *       externamente por la capa de presentación).</li>
     *   <li>En caso de error por overflow o underflow, se generan las excepciones adecuadas
     *       para que el sistema pueda continuar funcionando con normalidad.</li>
     * </ul>
     *
     * @return El resultado numérico de la multiplicación como un valor {@code float}
     * @throws OverFlowException si el resultado es demasiado grande para ser representado
     * @throws UnderFlowException si el resultado es demasiado pequeño para ser representado
     */
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

    /**
     * Realiza la división entre los dos números reales almacenados en la calculadora,
     * aplicando todas las validaciones necesarias para garantizar un resultado correcto.
     * <p>
     * Criterios de aceptación implementados:
     * </p>
     * <ul>
     *   <li>El sistema permite operar con dos números reales previamente seleccionados.</li>
     *   <li>Se valida que la operación no produzca <strong>división por cero</strong>;
     *       si el divisor es cero, se lanza una {@code ArithmeticException}.</li>
     *   <li>Se valida la condición de <strong>indeterminación</strong> (0 dividido entre 0);
     *       en ese caso se lanza una {@code ArithmeticException}.</li>
     *   <li>Se valida que la operación no produzca <strong>overflow</strong>; si el resultado
     *       excede el rango representable por {@code float}, se lanza una
     *       {@link OverFlowException}.</li>
     *   <li>Se valida que la operación no produzca <strong>underflow</strong>; si el resultado
     *       se redondea a cero aun cuando los operandos no son cero, se lanza una
     *       {@link UnderFlowException}.</li>
     *   <li>Tras una validación exitosa, el resultado puede mostrarse con formato fijo
     *       de dos decimales y usando coma como separador decimal (formateo realizado
     *       externamente por la capa de presentación).</li>
     *   <li>En caso de error por división por cero, indeterminación, overflow o underflow,
     *       se generan las excepciones adecuadas para que el sistema pueda continuar
     *       funcionando con normalidad.</li>
     * </ul>
     *
     * @return El resultado numérico de la división como un valor {@code float}
     * @throws ArithmeticException si el divisor es cero
     * @throws ArithmeticException si ambos operandos son cero (0/0)
     * @throws OverFlowException si el resultado es demasiado grande para ser representado
     * @throws UnderFlowException si el resultado es demasiado pequeño para ser representado
     */
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

    /**
     * Devuelve el primer número almacenado en la calculadora.
     *
     * @return El valor actual de {@code numero1}
     */
    public float getNumero1() {
        return numero1;
    }

    /**
     * Establece el valor del primer número de la calculadora.
     *
     * @param numero1 nuevo valor para {@code numero1}
     */
    public void setNumero1(float numero1) {
        this.numero1 = numero1;
    }

    /**
     * Devuelve el segundo número almacenado en la calculadora.
     *
     * @return El valor actual de {@code numero2}
     */
    public float getNumero2() {
        return numero2;
    }

    /**
     * Establece el valor del segundo número de la calculadora.
     *
     * @param numero2 nuevo valor para {@code numero2}
     */
    public void setNumero2(float numero2) {
        this.numero2 = numero2;
    }
}
