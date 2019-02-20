package es.uam.eps.ads.p2.apartado5;
import java.util.List;
import java.util.Objects;
import java.security.InvalidAlgorithmParameterException;
import java.util.ArrayList;

public class Sistema {
    public List<Articulo> articulos = new ArrayList<>();

    public void anadirArticulo(Articulo articulo) {
        articulos.add(articulo);
    }

    public Articulo encontrarArticulo(String codigoDeBarras) 
    throws InvalidAlgorithmParameterException {
        for (Articulo articulo: articulos) {
            if (Objects.equals(codigoDeBarras, articulo.getCodigoDeBarras())) {
                return articulo;
            }
        }
        throw new InvalidAlgorithmParameterException("El código de barras no"  
        + "hace referencia a ningún producto registrado en el sistema.");
    }

    public boolean codigoRegistrado(String codigoDeBarras) {
        for (Articulo articulo: articulos) {
            if (Objects.equals(codigoDeBarras, articulo.getCodigoDeBarras())) {
                return true;
            }
        }
        return false;
    }
}