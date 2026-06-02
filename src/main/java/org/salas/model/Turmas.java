package org.salas.model;

public class Turmas {
    private int idTurma;
    private String nomeTurma;

    public Turmas() {}

    public Turmas(int idTurma, String nomeTurma) {
        this.idTurma = idTurma;
        this.nomeTurma = nomeTurma;
    }

    public int getIdTurma() { return idTurma; }
    public void setIdTurma(int idTurma) { this.idTurma = idTurma; }

    public String getNomeTurma() { return nomeTurma; }
    public void setNomeTurma(String nomeTurma) { this.nomeTurma = nomeTurma; }
}