package aplicacionesweb.proyectoinventario.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "clasificacion")
public class Clasificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_clasificacion")
    private Integer idClasificacion;

    @Column(name = "nombre_clasificacion", nullable = false, length = 100)
    private String nombreClasificacion;

    @Column(name = "descripcion", length = 250)
    private String descripcion;

    public Clasificacion() {
    }

    public Clasificacion(Integer idClasificacion, String nombreClasificacion, String descripcion) {
        this.idClasificacion = idClasificacion;
        this.nombreClasificacion = nombreClasificacion;
        this.descripcion = descripcion;
    }

    public Integer getIdClasificacion() {
        return idClasificacion;
    }

    public void setIdClasificacion(Integer idClasificacion) {
        this.idClasificacion = idClasificacion;
    }

    public String getNombreClasificacion() {
        return nombreClasificacion;
    }

    public void setNombreClasificacion(String nombreClasificacion) {
        this.nombreClasificacion = nombreClasificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
