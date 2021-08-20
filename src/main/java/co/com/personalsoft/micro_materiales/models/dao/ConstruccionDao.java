package co.com.personalsoft.micro_materiales.models.dao;

import co.com.personalsoft.micro_materiales.models.entity.Construccion;
import co.com.personalsoft.micro_materiales.models.entity.Material;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ConstruccionDao extends CrudRepository<Construccion,Long> {
    /*
    @Query(value = "SELECT * FROM materiales p where p.nombre = ?", nativeQuery = true)
    Material findByName(String name);
     */
    @Query(value = "SELECT * FROM construcciones P WHERE P.coordenada = ?", nativeQuery = true)
    Construccion findByCoordenada(String coordenada);
}
