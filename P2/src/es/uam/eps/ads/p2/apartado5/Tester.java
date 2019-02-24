package es.uam.eps.ads.p2.apartado5;

public class Tester {
    public static void main(String[] args) {
        Sistema tienda = new Sistema();

        Articulo cuna1 = new Cuna("Cuna1");
        Articulo carrito1 = new Carrito("Carrito1", "Marca1", "Modelo1", 
                                        "Color1", false, false, true);
        Articulo carrito2 = new Carrito("Carrito2", "Marca2", "Modelo2", 
                                        "Color2", false, false, true);
        Articulo silla1 = new Silla("Silla1", "Marca3", "Modelo3", "Color3", 0,
                                    100, true);
        Articulo silla2 = new Silla("Silla2", "Marca4", "Modelo4", "Color4", 50,
                                    100, true);
        Articulo silla3 = new Silla("Silla3", "Marca5", "Modelo5", "Color5", 0,
                                    50, true);
            
        //LLegada de artículos a la tienda
        tienda.anadirArticulo(cuna1);
        tienda.anadirArticulo(carrito1);
        tienda.anadirArticulo(carrito2);
        tienda.anadirArticulo(silla1);
        tienda.anadirArticulo(silla2);
        tienda.anadirArticulo(silla3);

        //Proceso de verificación
        Cuna cunaAux = (Cuna) tienda.encontrarArticulo("Cuna1");
        cunaAux.setPliegueCorrecto(true);
        cunaAux.setEsteticaCorrecta(true);

        Carrito carritoAux = (Carrito) tienda.encontrarArticulo("Carrito1");
        carritoAux.setEngancheCorrecto(true);
        carritoAux.setTieneTodasLasPiezas(true);
        carritoAux.setAnclajesCorrectos(true);
        carritoAux.setAcolchadoCorrecto(true);
        carritoAux.setEnReparacion(false);

        carritoAux = (Carrito) tienda.encontrarArticulo("Carrito2");
        carritoAux.setEngancheCorrecto(false);
        carritoAux.setTieneTodasLasPiezas(false);
        carritoAux.setAnclajesCorrectos(false);
        carritoAux.setAcolchadoCorrecto(false);
        carritoAux.setEnReparacion(false);
        
        Silla sillaAux = (Silla) tienda.encontrarArticulo("Silla1");
        sillaAux.setTieneTodasLasPiezas(false);
        sillaAux.setAnclajesCorrectos(false);
        sillaAux.setAcolchadoCorrecto(false);
        sillaAux.setEnReparacion(false);

        sillaAux = (Silla) tienda.encontrarArticulo("Silla2");
        sillaAux.setTieneTodasLasPiezas(false);
        sillaAux.setAnclajesCorrectos(true);
        sillaAux.setAcolchadoCorrecto(true);
        sillaAux.setEnReparacion(false);

        sillaAux = (Silla) tienda.encontrarArticulo("Silla3");
        sillaAux.setTieneTodasLasPiezas(true);
        sillaAux.setAnclajesCorrectos(true);
        sillaAux.setAcolchadoCorrecto(true);
        sillaAux.setEnReparacion(false);

        //Envío al fabricante de los artículos
        tienda.enviarAlFabricante("Carrito2");
        tienda.enviarAlFabricante("Silla1");
        tienda.enviarAlFabricante("Silla2");
        tienda.enviarAlFabricante("Silla3");

        //El fabricante repara los artículos y los envía de vuelta
        tienda.recibirDelFabricante("Carrito2");
        tienda.recibirDelFabricante("Silla1");
        tienda.recibirDelFabricante("Silla2");
        tienda.recibirDelFabricante("Silla3");

        //Impresión de todos los artículos del almacén
        System.out.println("Todos los articulos de la tienda:");
        tienda.imprimirArticulos();

        //Impresión de tres sillitas en perfecto estado
        System.out.println("Las tres sillas en perfecto estado son:");
        sillaAux = (Silla) tienda.encontrarArticulo("Silla1");
        System.out.println(sillaAux);
        sillaAux = (Silla) tienda.encontrarArticulo("Silla2");
        System.out.println(sillaAux);
        sillaAux = (Silla) tienda.encontrarArticulo("Silla3");
        System.out.println(sillaAux);
    }
}