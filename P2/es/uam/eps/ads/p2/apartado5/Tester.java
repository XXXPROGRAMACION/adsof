package es.uam.eps.ads.p2.apartado5;

public class Tester {
    public static void main(String[] args) {
        Sistema tienda = new Sistema();

        Articulo cuna1 = new Cuna("Cuna1");
        Articulo carrito1 = new Carrito("Carrito1", "Marca1", "Modelo1", "Color1", 
                                        false, false, true);
        Articulo carrito2 = new Carrito("Carrito2", "Marca2", "Modelo2", "Color2", 
                                        true, true, false);
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
        Cuna cuna_aux = (Cuna) tienda.encontrarArticulo("Cuna1");
        cuna_aux.setPliegueCorrecto(true);
        cuna_aux.setEsteticaCorrecta(true);

        Carrito carrito_aux = (Carrito) tienda.encontrarArticulo("Carrito1");
        carrito_aux.setEngancheCorrecto(true);
        carrito_aux.setTieneTodasLasPiezas(true);
        carrito_aux.setAnclajesCorrectos(true);
        carrito_aux.setAcolchadoCorrecto(true);
        carrito_aux.setEnReparacion(false);
        carrito_aux = (Carrito) tienda.encontrarArticulo("Carrito2");
        carrito_aux.setEngancheCorrecto(false);
        carrito_aux.setTieneTodasLasPiezas(false);
        carrito_aux.setAnclajesCorrectos(false);
        carrito_aux.setAcolchadoCorrecto(false);
        carrito_aux.setEnReparacion(false);
        
        Silla silla_aux = (Silla) tienda.encontrarArticulo("Silla1");
        silla_aux.setTieneTodasLasPiezas(false);
        silla_aux.setAnclajesCorrectos(false);
        silla_aux.setAcolchadoCorrecto(false);
        silla_aux.setEnReparacion(false);
        silla_aux = (Silla) tienda.encontrarArticulo("Silla2");
        silla_aux.setTieneTodasLasPiezas(false);
        silla_aux.setAnclajesCorrectos(true);
        silla_aux.setAcolchadoCorrecto(true);
        silla_aux.setEnReparacion(false);
        silla_aux = (Silla) tienda.encontrarArticulo("Silla3");
        silla_aux.setTieneTodasLasPiezas(true);
        silla_aux.setAnclajesCorrectos(true);
        silla_aux.setAcolchadoCorrecto(true);
        silla_aux.setEnReparacion(false);

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
        tienda.imprimirArticulos();
    }
           
}