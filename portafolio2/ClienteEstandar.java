package modelo;

/**
 * Representa a un cliente estándar de la tienda.
 *
 * <p>Aplica <b>herencia</b> extendiendo {@link Cliente} y
 * <b>polimorfismo</b> sobreescribiendo {@code obtenerTipoCliente()}.
 *
 * @author Portafolio POO - CENFOTEC
 * @version 2.0
 */
public class ClienteEstandar extends Cliente {

    /**
     * Construye un cliente estándar.
     *
     * @param id                  identificador único
     * @param nombre              nombre del cliente
     * @param presenteFisicamente presencia física en tienda
     */
    public ClienteEstandar(String id, String nombre, boolean presenteFisicamente) {
        super(id, nombre, presenteFisicamente);
    }

    /**
     * Retorna el tipo de cliente.
     * <p>Sobreescritura del método abstracto de {@link Cliente}.</p>
     *
     * @return "Estándar"
     */
    @Override
    public String obtenerTipoCliente() {
        return "Estándar";
    }
}
