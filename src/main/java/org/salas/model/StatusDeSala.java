package org.salas.model;

public class StatusDeSala {
    private int idStatus;
    private String nomeStatus;

    public StatusDeSala() {}

    public StatusDeSala(int idStatus, String nomeStatus) {
        this.idStatus = idStatus;
        this.nomeStatus = nomeStatus;
    }

    public int getIdStatus() { return idStatus; }
    public void setIdStatus(int idStatus) { this.idStatus = idStatus; }

    public String getNomeStatus() { return nomeStatus; }
    public void setNomeStatus(String nomeStatus) { this.nomeStatus = nomeStatus; }
}
