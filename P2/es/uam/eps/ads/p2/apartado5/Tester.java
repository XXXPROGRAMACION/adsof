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

        Carrito carrito_aux = (Carrito) tienda.encontrarArticulo("Carrito1");
        carrito_aux.setEngancheCorrecto(true);
        carrito_aux = (Carrito) tienda.encontrarArticulo("Carrito2");
        carrito_aux.setEngancheCorrecto(false);
        
        Silla silla_aux = (Silla) tienda.encontrarArticulo("Silla1"); 
    }
           
}