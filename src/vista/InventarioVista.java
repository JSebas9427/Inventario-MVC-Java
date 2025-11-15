package vista;

import modelo.Producto;
import java.util.List;
import java.util.Scanner;

public class InventarioVista {

    private Scanner sc = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n--- MENÚ DE INVENTARIO ---");
        System.out.println("1. Agregar producto");
        System.out.println("2. Buscar producto por SKU");
        System.out.println("3. Mostrar todos los productos");
        System.out.println("4. Eliminar producto");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
        return sc.nextInt();
    }

    public Producto pedirDatosUsuario() {
        sc.nextLine(); // limpiar buffer
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("SKU: ");
        String sku = sc.nextLine();
        System.out.print("Cantidad: ");
        int cantidad = sc.nextInt();
        System.out.print("Precio: ");
        double precio = sc.nextDouble();
        return new Producto(nombre, sku, cantidad, precio);
    }

    public String pedirSku() {
        sc.nextLine(); // limpiar buffer
        System.out.print("Ingrese el SKU: ");
        return sc.nextLine();
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
