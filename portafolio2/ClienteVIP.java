package modelo;

/**
 * Representa a un cliente VIP de la tienda.
 *
 * <p>Aplica <b>herencia</b> extendiendo {@link Cliente} y
 * <b>polimorfismo</b> sobreescribiendo {@code obtenerTipoCliente()}.
 * Los clientes VIP tienen prioridad en el registro de apartados.
 *
 * @author Portafolio POO - CENFOTEC
 * @version 2.0
 */
public class ClienteVIP extends Cliente {

    /**
     * Construye un cliente VIP.
     *
     * @param id                  identificador único
     * @param nombre              nombre del cliente
     * @param presenteFisicamente presencia física en tienda
     */
    public ClienteVIP(String id, String nombre, boolean presenteFisicamente) {
        super(id, nombre, presenteFisicamente);
    }

    /**
     * Retorna el tipo de cliente.
     * <p>Sobreescritura del método abstracto de {@link Cliente}.</p>
     *
     * @return "VIP"
     */
    @Override
    public String obtenerTipoCliente() {
        return "VIP";
    }
}
