package aplicacionesweb.proyectoinventario.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_mantenimiento")
public class TipoMantenimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_mantenimiento")
    private Integer idTipoMantenimiento;

    @Column(name = "nombre_tipo", nullable = false, length = 50)
    private String nombreTipo;

    @Column(name = "descripcion", length = 250)
    private String descripcion;

    public TipoMantenimiento() {
    }

    public TipoMantenimiento(Integer idTipoMantenimiento, String nombreTipo, String descripcion) {
        this.idTipoMantenimiento = idTipoMantenimiento;
        this.nombreTipo = nombreTipo;
        this.descripcion = descripcion;
    }

    public Integer getIdTipoMantenimiento() {
        return idTipoMantenimiento;
    }

    public void setIdTipoMantenimiento(Integer idTipoMantenimiento) {
        this.idTipoMantenimiento = idTipoMantenimiento;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
