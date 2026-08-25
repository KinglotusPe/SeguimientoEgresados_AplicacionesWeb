package aplicacionesweb.proyectoinventario.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "despacho")
public class Despacho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_despacho")
    private Integer idDespacho;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sede", nullable = false)
    private Sede sede;

    @Column(name = "nombre_despacho", nullable = false, length = 250)
    private String nombreDespacho;

    @Column(name = "tipo_proceso", length = 100)
    private String tipoProceso;

    public Despacho() {
    }

    public Despacho(Integer idDespacho, Sede sede, String nombreDespacho, String tipoProceso) {
        this.idDespacho = idDespacho;
        this.sede = sede;
        this.nombreDespacho = nombreDespacho;
        this.tipoProceso = tipoProceso;
    }

    public Integer getIdDespacho() {
        return idDespacho;
    }

    public void setIdDespacho(Integer idDespacho) {
        this.idDespacho = idDespacho;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public String getNombreDespacho() {
        return nombreDespacho;
    }

    public void setNombreDespacho(String nombreDespacho) {
        this.nombreDespacho = nombreDespacho;
    }

    public String getTipoProceso() {
        return tipoProceso;
    }

    public void setTipoProceso(String tipoProceso) {
        this.tipoProceso = tipoProceso;
    }
}
