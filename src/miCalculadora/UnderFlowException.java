package miCalculadora;
/**
 * Excepción lanzada cuando una operación aritmética produce un underflow
 * y el resultado se redondea a cero sin que los operandos sean cero.
 *
 <p><strong>Autora: </strong>María Inés Fernández Álvarez.</p>
 */
public class UnderFlowException extends RuntimeException {
    public UnderFlowException(String mensaje) {
        super(mensaje);
    }
}

