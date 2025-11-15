package controlador;

import modelo.BaseDeDatos;
import modelo.Producto;
import vista.InventarioVista;

public class ControladorInventario {

    private BaseDeDatos baseDatos;
    private InventarioVista vista;

    public ControladorInventario(BaseDeDatos baseDatos, InventarioVista vista) {
        this.baseDatos = baseDatos;
        this.vista = vista;
    }

    public void iniciar() {
        boolean salir = false;

        while (!salir) {
            int opcion = vista.mostrarMenu();

            switch (opcion) {
                case 1:
                    Producto p = vista.pedirDatosUsuario();
                    baseDatos.agregarProducto(p);
                    vista.mostrarMensaje("Producto agregado.");
                    break;

                case 2:
                    String skuBuscar = vista.pedirSku();
                    vista.mostrarProducto(baseDatos.buscarProductoSku(skuBuscar));
                    break;

                case 3:
                    vista.mostrarProductos(baseDatos.buscarTodos());
                    break;

                case 4:
                    String skuEliminar = vista.pedirSku();
                    boolean eliminado = baseDatos.eliminarProducto(skuEliminar);
                    vista.mostrarMensaje(eliminado ? "Producto eliminado." : "No se encontró el SKU.");
                    break;

                case 5:
                    salir = true;
                    break;

                default:
                    vista.mostrarMensaje("Opción inválida.");
            }
        }
    }
}
