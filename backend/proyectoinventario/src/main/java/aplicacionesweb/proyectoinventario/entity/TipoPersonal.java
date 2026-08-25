package aplicacionesweb.proyectoinventario.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_personal")
public class TipoPersonal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_personal")
    private Integer idTipoPersonal;

    @Column(name = "nombre_tipo_personal", nullable = false, length = 100)
    private String nombreTipoPersonal;

    @Column(name = "descripcion", length = 250)
    private String descripcion;

    public TipoPersonal() {
    }

    public TipoPersonal(Integer idTipoPersonal, String nombreTipoPersonal, String descripcion) {
        this.idTipoPersonal = idTipoPersonal;
        this.nombreTipoPersonal = nombreTipoPersonal;
        this.descripcion = descripcion;
    }

    public Integer getIdTipoPersonal() {
        return idTipoPersonal;
    }

    public void setIdTipoPersonal(Integer idTipoPersonal) {
        this.idTipoPersonal = idTipoPersonal;
    }

    public String getNombreTipoPersonal() {
        return nombreTipoPersonal;
    }

    public void setNombreTipoPersonal(String nombreTipoPersonal) {
        this.nombreTipoPersonal = nombreTipoPersonal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
