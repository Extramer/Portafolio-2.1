package modelo;

/**
 * Clase abstracta que representa a un cliente de la tienda.
 *
 * <p>Esta clase aplica los principios de:
 * <ul>
 *   <li><b>Abstracción:</b> define la estructura general de un cliente sin
 *       especificar el tipo concreto.</li>
 *   <li><b>Encapsulamiento:</b> los atributos son privados y se acceden
 *       únicamente mediante métodos públicos (getters/setters).</li>
 * </ul>
 *
 * @author Portafolio POO - CENFOTEC
 * @version 2.0
 */
public abstract class Cliente {

    // ---------------------------------------------------------------
    // Atributos privados — ENCAPSULAMIENTO
    // ---------------------------------------------------------------
    private String id;
    private String nombre;
    private boolean presenteFisicamente;

    // ---------------------------------------------------------------
    // Constructor
    // ---------------------------------------------------------------

    /**
     * Construye un nuevo cliente con los datos básicos.
     *
     * @param id                  identificador único del cliente
     * @param nombre              nombre completo del cliente
     * @param presenteFisicamente indica si el cliente está en la tienda
     */
    public Cliente(String id, String nombre, boolean presenteFisicamente) {
        this.id = id;
        this.nombre = nombre;
        this.presenteFisicamente = presenteFisicamente;
    }

    // ---------------------------------------------------------------
    // Getters y Setters — ENCAPSULAMIENTO
    // ---------------------------------------------------------------

    /**
     * Obtiene el identificador único del cliente.
     *
     * @return id del cliente
     */
    public String getId() {
        return id;
    }

    /**
     * Obtiene el nombre del cliente.
     *
     * @return nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Indica si el cliente se encuentra físicamente en la tienda.
     *
     * @return {@code true} si el cliente está presente
     */
    public boolean isPresenteFisicamente() {
        return presenteFisicamente;
    }

    /**
     * Actualiza la presencia física del cliente en la tienda.
     *
     * @param presenteFisicamente nuevo valor de presencia
     */
    public void setPresenteFisicamente(boolean presenteFisicamente) {
        this.presenteFisicamente = presenteFisicamente;
    }

    // ---------------------------------------------------------------
    // Método abstracto — ABSTRACCIÓN + POLIMORFISMO
    // ---------------------------------------------------------------

    /**
     * Retorna el tipo de cliente (Estándar, VIP, etc.).
     * Cada subclase debe proporcionar su propia implementación.
     *
     * @return cadena con el tipo de cliente
     */
    public abstract String obtenerTipoCliente();

    // ---------------------------------------------------------------
    // Identidad de objetos — equals y hashCode
    // ---------------------------------------------------------------

    /**
     * Compara este cliente con otro objeto por identidad de ID.
     * Dos clientes son iguales si tienen el mismo {@code id}.
     *
     * @param obj objeto a comparar
     * @return {@code true} si los clientes tienen el mismo id
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Cliente)) return false;
        Cliente otro = (Cliente) obj;
        return this.id.equals(otro.id);
    }

    /**
     * Retorna el código hash basado en el id del cliente.
     *
     * @return código hash
     */
    @Override
    public int hashCode() {
        return id.hashCode();
    }

    // ---------------------------------------------------------------
    // Sobreescritura de toString
    // ---------------------------------------------------------------

    /**
     * Representación textual del cliente.
     *
     * @return cadena con id, nombre y tipo de cliente
     */
    @Override
    public String toString() {
        return "[" + obtenerTipoCliente() + "] ID: " + id + " | Nombre: " + nombre
                + " | Presente: " + (presenteFisicamente ? "Sí" : "No");
    }
}
