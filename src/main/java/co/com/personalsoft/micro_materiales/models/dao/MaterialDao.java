package co.com.personalsoft.micro_materiales.models.dao;

import co.com.personalsoft.micro_materiales.models.entity.Material;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.jpa.repository.Query;


public interface MaterialDao extends CrudRepository<Material, Long> {

    @Query(value = "SELECT * FROM materiales p where p.nombre = ?", nativeQuery = true)
    Material findByName(String name);



    //"update User u set u.firstname = ?1 where u.lastname = ?2"
    @Modifying
    @Query(value = "UPDATE materiales SET cantidad = ? where id = ?", nativeQuery = true)
    void updateQuantity(int cantidad, Long id);
}
