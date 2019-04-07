package es.uam.eps.ads.p4;

import java.util.Map;
import java.util.Set;

public interface ModeloDatos {
    public void leeFicheroPreferencias(String ruta);
    public Map<Long, Double> getPreferenciasUsuario(Long usuario);
    public Map<Long, Double> getPreferenciasItem(Long item);
    public Set<Long> getUsuariosUnicos();
    public Set<Long> getItemsUnicos();
    public boolean getCorrecto();
}