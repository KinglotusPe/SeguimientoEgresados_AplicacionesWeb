package aplicacionesweb.proyectoinventario.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "distrito_fiscal")
public class DistritoFiscal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_distrito_fiscal")
    private Integer idDistritoFiscal;

    @Column(name = "nombre_distrito", nullable = false, length = 150)
    private String nombreDistrito;

    public DistritoFiscal() {
    }

    public DistritoFiscal(Integer idDistritoFiscal, String nombreDistrito) {
        this.idDistritoFiscal = idDistritoFiscal;
        this.nombreDistrito = nombreDistrito;
    }

    public Integer getIdDistritoFiscal() {
        return idDistritoFiscal;
    }

    public void setIdDistritoFiscal(Integer idDistritoFiscal) {
        this.idDistritoFiscal = idDistritoFiscal;
    }

    public String getNombreDistrito() {
        return nombreDistrito;
    }

    public void setNombreDistrito(String nombreDistrito) {
        this.nombreDistrito = nombreDistrito;
    }
}
