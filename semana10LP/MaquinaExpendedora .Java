import java.util.Scanner;

public class MaquinaExpendedora {


    static String[] productos = {"Coca-Cola", "Pepsi", "Agua", "Galletas"};
    static double[] precios = {2.5, 2.0, 1.5, 1.0};
    static int[] cantidades = {10, 15, 20, 12};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        while (true) {
            mostrarMenu();

            System.out.print("Ingrese el nombre del producto que desea comprar (o 'salir' para terminar): ");
            String producto = scanner.nextLine();

            if (producto.equalsIgnoreCase("salir")) {
                System.out.println("Gracias por usar la máquina expendedora.");
                break;
            }

            int indice = seleccionarProducto(producto);
            if (indice != -1) {
                System.out.print("Ingrese la cantidad de dinero: ");
                double dinero = scanner.nextDouble();
                scanner.nextLine(); 

                if (verificarPago(indice, dinero)) {
                    entregarProducto(indice);
                    double cambio = calcularCambio(indice, dinero);
                    System.out.println("Cambio: " + cambio);
                } else {
                    System.out.println("Pago insuficiente. Por favor ingrese suficiente dinero.");
                }
            } else {
                System.out.println("Producto no encontrado. Intente con otro producto.");
            }
        }

        scanner.close();
    }


    public static void mostrarMenu() {
        System.out.println("\n--- Menú de Productos ---");
        for (int i = 0; i < productos.length; i++) {
            System.out.println(productos[i] + " - $" + precios[i] + " (" + cantidades[i] + " en stock)");
        }
        System.out.println("-------------------------");
    }


    public static int seleccionarProducto(String producto) {
        for (int i = 0; i < productos.length; i++) {
            if (productos[i].equalsIgnoreCase(producto)) {
                return i;
            }
        }
        return -1;
    }

 
    public static boolean verificarPago(int indice, double dinero) {
        return dinero >= precios[indice];
    }

    // Función para calcular el cambio
    public static double calcularCambio(int indice, double dinero) {
        return dinero - precios[indice];
    }


    public static void entregarProducto(int indice) {
        if (cantidades[indice] > 0) {
            cantidades[indice]--;
            System.out.println("Producto entregado: " + productos[indice]);
        } else {
            System.out.println("Lo sentimos, el producto " + productos[indice] + " está agotado.");
        }
    }
}
