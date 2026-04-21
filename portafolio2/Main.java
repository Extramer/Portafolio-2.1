package ui;

import logica.IGestionTienda;
import logica.Tienda;
import modelo.Cliente;
import modelo.ClienteEstandar;
import modelo.ClienteVIP;

/**
 * Punto de entrada de la aplicación. Representa la capa de interfaz de usuario (UI).
 *
 * <p><b>Arquitectura por capas:</b></p>
 * <ul>
 *   <li><b>ui</b> — esta clase; interactúa con el usuario o demuestra el flujo.</li>
 *   <li><b>logica</b> — {@link Tienda} e {@link IGestionTienda}; reglas de negocio.</li>
 *   <li><b>modelo</b> — {@link Cliente}, {@link ClienteEstandar}, {@link ClienteVIP};
 *       entidades del dominio.</li>
 * </ul>
 *
 * @author Portafolio POO - CENFOTEC
 * @version 2.0
 */
public class Main {

    /**
     * Método principal. Demuestra el uso del sistema de gestión de apartados.
     *
     * @param args argumentos de línea de comandos (no se utilizan)
     */
    public static void main(String[] args) {

        // --- Capa de Lógica: se usa la interfaz, no la clase concreta ---
        IGestionTienda tienda = new Tienda();

        // --- Polimorfismo: ambos objetos son tratados como Cliente ---
        Cliente c1 = new ClienteEstandar("E001", "Ana López", true);
        Cliente c2 = new ClienteVIP("V001", "Carlos Mora", true);
        Cliente c3 = new ClienteEstandar("E002", "Luis Pérez", false); // no presente

        System.out.println("=== Sistema de Apartados ===");
        System.out.println("Espacios disponibles: " + tienda.getEspaciosDisponibles());
        System.out.println();

        // --- Polimorfismo en acción: obtenerTipoCliente() se resuelve en tiempo de ejecución ---
        tienda.registrarApartado(c1);
        tienda.registrarApartado(c2);
        tienda.registrarApartado(c3); // debe rechazarse

        System.out.println();

        // --- Sobrecarga: versión con String ---
        tienda.registrarApartado("E003", "María Jiménez");

        System.out.println();
        System.out.println("Espacios restantes: " + tienda.getEspaciosDisponibles());

        System.out.println();

        // --- equals: identidad de objetos ---
        Cliente copia = new ClienteEstandar("E001", "Ana López", true);
        System.out.println("¿c1 equals copia? " + c1.equals(copia)); // true — mismo id
        System.out.println("¿c1 equals c2?   " + c1.equals(c2));    // false
    }
}
