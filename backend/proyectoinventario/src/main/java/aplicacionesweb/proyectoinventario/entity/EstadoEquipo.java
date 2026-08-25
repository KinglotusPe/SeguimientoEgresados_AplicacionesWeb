package aplicacionesweb.proyectoinventario.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "estado_equipo")
public class EstadoEquipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado_equipo")
    private Integer idEstadoEquipo;

    @Column(name = "nombre_estado", nullable = false, length = 50)
    private String nombreEstado;

    @Column(name = "descripcion", length = 250)
    private String descripcion;

    public EstadoEquipo() {
    }

    public EstadoEquipo(Integer idEstadoEquipo, String nombreEstado, String descripcion) {
        this.idEstadoEquipo = idEstadoEquipo;
        this.nombreEstado = nombreEstado;
        this.descripcion = descripcion;
    }

    public Integer getIdEstadoEquipo() {
        return idEstadoEquipo;
    }

    public void setIdEstadoEquipo(Integer idEstadoEquipo) {
        this.idEstadoEquipo = idEstadoEquipo;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
