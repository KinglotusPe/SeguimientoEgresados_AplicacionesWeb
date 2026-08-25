package aplicacionesweb.proyectoinventario.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sede")
public class Sede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sede")
    private Integer idSede;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_distrito_fiscal", nullable = false)
    private DistritoFiscal distritoFiscal;

    @Column(name = "nombre_sede", nullable = false, length = 150)
    private String nombreSede;

    @Column(name = "direccion", length = 300)
    private String direccion;

    public Sede() {
    }

    public Sede(Integer idSede, DistritoFiscal distritoFiscal, String nombreSede, String direccion) {
        this.idSede = idSede;
        this.distritoFiscal = distritoFiscal;
        this.nombreSede = nombreSede;
        this.direccion = direccion;
    }

    public Integer getIdSede() {
        return idSede;
    }

    public void setIdSede(Integer idSede) {
        this.idSede = idSede;
    }

    public DistritoFiscal getDistritoFiscal() {
        return distritoFiscal;
    }

    public void setDistritoFiscal(DistritoFiscal distritoFiscal) {
        this.distritoFiscal = distritoFiscal;
    }

    public String getNombreSede() {
        return nombreSede;
    }

    public void setNombreSede(String nombreSede) {
        this.nombreSede = nombreSede;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
