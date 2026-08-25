package aplicacionesweb.proyectoinventario.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "mantenimiento")
public class Mantenimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mantenimiento")
    private Integer idMantenimiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_equipo", nullable = false)
    private Equipo equipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_mantenimiento", nullable = false)
    private TipoMantenimiento tipoMantenimiento;

    @Column(name = "fecha_mantenimiento", nullable = false)
    private LocalDate fechaMantenimiento;

    @Column(name = "diagnostico", columnDefinition = "TEXT")
    private String diagnostico;

    @Column(name = "trabajo_realizado", columnDefinition = "TEXT")
    private String trabajoRealizado;

    @Column(name = "repuesto", columnDefinition = "TEXT")
    private String repuesto;

    @Column(name = "responsable_mantenimiento", length = 150)
    private String responsableMantenimiento;

    @Column(name = "observacion", columnDefinition = "TEXT")
    private String observacion;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    @PrePersist
    public void prePersist() {
        if (this.fechaRegistro == null) {
            this.fechaRegistro = LocalDateTime.now();
        }
    }

    public Mantenimiento() {
    }

    public Mantenimiento(Integer idMantenimiento, Equipo equipo, TipoMantenimiento tipoMantenimiento, LocalDate fechaMantenimiento, String diagnostico, String trabajoRealizado, String repuesto, String responsableMantenimiento, String observacion, LocalDateTime fechaRegistro) {
        this.idMantenimiento = idMantenimiento;
        this.equipo = equipo;
        this.tipoMantenimiento = tipoMantenimiento;
        this.fechaMantenimiento = fechaMantenimiento;
        this.diagnostico = diagnostico;
        this.trabajoRealizado = trabajoRealizado;
        this.repuesto = repuesto;
        this.responsableMantenimiento = responsableMantenimiento;
        this.observacion = observacion;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdMantenimiento() {
        return idMantenimiento;
    }

    public void setIdMantenimiento(Integer idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public TipoMantenimiento getTipoMantenimiento() {
        return tipoMantenimiento;
    }

    public void setTipoMantenimiento(TipoMantenimiento tipoMantenimiento) {
        this.tipoMantenimiento = tipoMantenimiento;
    }

    public LocalDate getFechaMantenimiento() {
        return fechaMantenimiento;
    }

    public void setFechaMantenimiento(LocalDate fechaMantenimiento) {
        this.fechaMantenimiento = fechaMantenimiento;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTrabajoRealizado() {
        return trabajoRealizado;
    }

    public void setTrabajoRealizado(String trabajoRealizado) {
        this.trabajoRealizado = trabajoRealizado;
    }

    public String getRepuesto() {
        return repuesto;
    }

    public void setRepuesto(String repuesto) {
        this.repuesto = repuesto;
    }

    public String getResponsableMantenimiento() {
        return responsableMantenimiento;
    }

    public void setResponsableMantenimiento(String responsableMantenimiento) {
        this.responsableMantenimiento = responsableMantenimiento;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
