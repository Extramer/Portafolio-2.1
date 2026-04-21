package logica;

import modelo.Cliente;

/**
 * Interfaz que define el contrato de gestión de la tienda.
 *
 * <p>Aplica el principio de <b>abstracción</b> al definir qué operaciones
 * debe ofrecer cualquier implementación de una tienda, sin determinar cómo
 * se llevan a cabo internamente.</p>
 *
 * <p>También establece una <b>dependencia</b> con {@link Cliente}: la interfaz
 * conoce a Cliente pero no depende de ninguna subclase concreta.</p>
 *
 * @author Portafolio POO - CENFOTEC
 * @version 2.0
 */
public interface IGestionTienda {

    /**
     * Registra un apartado para el cliente indicado.
     *
     * @param cliente el cliente que solicita el apartado
     * @return {@code true} si el apartado fue registrado con éxito
     */
    boolean registrarApartado(Cliente cliente);

    /**
     * Registra un apartado a partir de datos básicos del cliente
     * (sobrecarga del método {@link #registrarApartado(Cliente)}).
     *
     * @param idCliente  identificador del cliente
     * @param nombreCliente nombre del cliente
     * @return {@code true} si el apartado fue registrado con éxito
     */
    boolean registrarApartado(String idCliente, String nombreCliente);

    /**
     * Retorna la cantidad de espacios disponibles para nuevos apartados.
     *
     * @return número de espacios disponibles
     */
    int getEspaciosDisponibles();
}
