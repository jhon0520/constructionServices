package co.com.personalsoft.micro_materiales.models.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "materiales")
public class Material implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @Column(name = "nombre_alterno")
    private String altNombre;

    private int cantidad;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAltNombre() {
        return altNombre;
    }

    public void setAltNombre(String altNombre) {
        this.altNombre = altNombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
