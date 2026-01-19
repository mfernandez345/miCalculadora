package miCalculadora;
/**
 * Excepción lanzada cuando una operación aritmética produce un overflow
 * y el resultado no puede ser representado como {@code float}.
 *
 <p><strong>Autora: </strong>María Inés Fernández Álvarez.</p>
 */
public class OverFlowException extends RuntimeException {
    public OverFlowException(String mensaje) {
        super(mensaje);
    }
}

