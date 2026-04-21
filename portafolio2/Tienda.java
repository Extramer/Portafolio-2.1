package logica;

import modelo.Cliente;
import modelo.ClienteEstandar;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa la tienda y gestiona los apartados de clientes.
 *
 * <p>Esta clase demuestra múltiples principios de POO:</p>
 * <ul>
 *   <li><b>Implementación de interfaz:</b> implementa {@link IGestionTienda}.</li>
 *   <li><b>Composición:</b> la tienda <em>está compuesta</em> por una lista de
 *       apartados ({@code List<Cliente>}). Si la tienda desaparece, los
 *       apartados también.</li>
 *   <li><b>Asociación:</b> la tienda trabaja con objetos {@link Cliente}
 *       que existen de forma independiente.</li>
 *   <li><b>Dependencia:</b> el método {@link #registrarApartado(String, String)}
 *       crea internamente un {@link ClienteEstandar}, por lo que depende de
 *       esa clase concreta solo en ese punto.</li>
 *   <li><b>Sobrecarga de métodos:</b> {@code registrarApartado} tiene dos firmas.</li>
 *   <li><b>Encapsulamiento:</b> atributos privados con acceso controlado.</li>
 * </ul>
 *
 * @author Portafolio POO - CENFOTEC
 * @version 2.0
 */
public class Tienda implements IGestionTienda {

    // ---------------------------------------------------------------
    // Constante de clase
    // ---------------------------------------------------------------

    /** Número máximo de apartados permitidos en la tienda. */
    private static final int LIMITE_APARTADOS = 50;

    // ---------------------------------------------------------------
    // Atributos — COMPOSICIÓN con la lista de apartados
    // ---------------------------------------------------------------

    /** Lista de clientes con apartado activo. Composición: el ciclo de vida
     *  de esta lista está ligado al de la Tienda. */
    private List<Cliente> apartadosRealizados;

    // ---------------------------------------------------------------
    // Constructor
    // ---------------------------------------------------------------

    /**
     * Crea una nueva instancia de Tienda con la lista de apartados vacía.
     */
    public Tienda() {
        this.apartadosRealizados = new ArrayList<>();
    }

    // ---------------------------------------------------------------
    // Métodos de interfaz — SOBRECARGA de registrarApartado
    // ---------------------------------------------------------------

    /**
     * Registra un apartado para un cliente existente.
     *
     * <p><b>Asociación:</b> recibe un {@link Cliente} ya creado fuera de
     * esta clase y lo agrega a la lista interna.</p>
     *
     * @param cliente el cliente que solicita el apartado; debe estar
     *                presente físicamente en la tienda
     * @return {@code true} si el apartado fue registrado;
     *         {@code false} si el límite fue alcanzado o el cliente
     *         no está presente
     */
    @Override
    public boolean registrarApartado(Cliente cliente) {
        if (apartadosRealizados.size() >= LIMITE_APARTADOS) {
            System.out.println("Promoción agotada.");
            return false;
        }
        if (!cliente.isPresenteFisicamente()) {
            System.out.println("El cliente " + cliente.getNombre()
                    + " no se encuentra físicamente en la tienda.");
            return false;
        }
        apartadosRealizados.add(cliente);
        System.out.println("Apartado registrado para: " + cliente);
        return true;
    }

    /**
     * Registra un apartado a partir de datos básicos, creando internamente
     * un {@link ClienteEstandar}.
     *
     * <p><b>Sobrecarga:</b> misma operación lógica, diferente firma.</p>
     * <p><b>Dependencia:</b> este método depende de {@link ClienteEstandar}
     * para construir el objeto cliente.</p>
     *
     * @param idCliente     identificador del nuevo cliente
     * @param nombreCliente nombre del nuevo cliente
     * @return {@code true} si el apartado fue registrado con éxito
     */
    @Override
    public boolean registrarApartado(String idCliente, String nombreCliente) {
        // Se asume presencia física al registrar por datos (viene al mostrador)
        Cliente nuevo = new ClienteEstandar(idCliente, nombreCliente, true);
        return registrarApartado(nuevo);
    }

    // ---------------------------------------------------------------
    // Getter de espacios disponibles
    // ---------------------------------------------------------------

    /**
     * Calcula los espacios disponibles restando los apartados ya registrados
     * del límite máximo permitido.
     *
     * @return cantidad de espacios disponibles
     */
    @Override
    public int getEspaciosDisponibles() {
        return LIMITE_APARTADOS - apartadosRealizados.size();
    }

    /**
     * Retorna una copia de la lista de clientes con apartado activo.
     * Se retorna una copia para proteger la lista interna (encapsulamiento).
     *
     * @return lista de clientes con apartado
     */
    public List<Cliente> getApartadosRealizados() {
        return new ArrayList<>(apartadosRealizados);
    }
}
