package model;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author Gibson
 */
public class Exame {

    private Long id;
    private Long pacienteId;
    private String numAcesso;
    private String visita;
    private Date dataExame;
    private String modalidade;
    private String tipoExame;
    private String numero;
    private String estado;
    private String medicoSolicitante;
    private String laudo;
    private String especial;
    private String urgente;
    private String restaurado;

    public Exame(Long id, Long pacienteId, String numAcesso, String visita, Date dataExame,
            String modalidade, String tipoExame, String numero, String estado,
            String medicoSolicitante, String laudo, String especial, String urgente, String restaurado) {
        this.id = id;
        this.pacienteId = pacienteId;
        this.numAcesso = numAcesso;
        this.visita = visita;
        this.dataExame = dataExame;
        this.modalidade = modalidade;
        this.tipoExame = tipoExame;
        this.numero = numero;
        this.estado = estado;
        this.medicoSolicitante = medicoSolicitante;
        this.laudo = laudo;
        this.especial = especial;
        this.urgente = urgente;
        this.restaurado = restaurado;
    }

    public Long getId() {
        return id;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public String getNumAcesso() {
        return numAcesso;
    }

    public String getVisita() {
        return visita;
    }

    public Date getDataExame() {
        return dataExame;
    }

    public String getModalidade() {
        return modalidade;
    }

    public String getTipoExame() {
        return tipoExame;
    }

    public String getNumero() {
        return numero;
    }

    public String getEstado() {
        return estado;
    }

    public String getMedicoSolicitante() {
        return medicoSolicitante;
    }

    public String getLaudo() {
        return laudo;
    }

    public String getEspecial() {
        return especial;
    }

    public String getUrgente() {
        return urgente;
    }

    public String getRestaurado() {
        return restaurado;
    }

    @Override
    public String toString() {
        return "Exame{" + "id=" + id + ", pacienteId=" + pacienteId + ", numAcesso=" + numAcesso + ", visita=" + visita + ", dataExame=" + dataExame + ", modalidade=" + modalidade + ", tipoExame=" + tipoExame + ", numero=" + numero + ", estado=" + estado + ", medicoSolicitante=" + medicoSolicitante + ", laudo=" + laudo + ", especial=" + especial + ", urgente=" + urgente + ", restaurado=" + restaurado + '}';
    }
    
    
}
