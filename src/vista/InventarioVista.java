package vista;

import modelo.Producto;
import java.util.List;
import java.util.Scanner;

public class InventarioVista {

    private Scanner leer = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n--- MENÚ DE INVENTARIO ---");
        System.out.println("1. Agregar producto");
        System.out.println("2. Buscar producto por SKU");
        System.out.println("3. Mostrar todos los productos");
        System.out.println("4. Eliminar producto");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
        return leer.nextInt();
    }

    public Producto pedirDatosUsuario() {
        leer.nextLine(); // limpiar buffer
        System.out.print("Nombre: ");
        String nombre = leer.nextLine();
        System.out.print("SKU: ");
        String sku = leer.nextLine();
        System.out.print("Cantidad: ");
        int cantidad = leer.nextInt();
        System.out.print("Precio: ");
        double precio = leer.nextDouble();
        return new Producto(nombre, sku, cantidad, precio);
    }

    public String pedirSku() {
        leer.nextLine(); // limpiar buffer
        System.out.print("Ingrese el SKU: ");
        return leer.nextLine();
    }

    public void mostrarProducto(Producto producto) {
        if (producto == null) {
            System.out.println("Producto no encontrado.");
        } else {
            System.out.println(producto);
        }
    }

    public void mostrarProductos(List<Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            for (Producto p : productos) {
                System.out.println(p);
            }
        }
    }

    public void mostrarMensaje(String msg) {
        System.out.println(msg);
    }
}
