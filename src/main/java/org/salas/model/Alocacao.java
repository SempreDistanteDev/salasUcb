package org.salas.model;

public class Alocacao {
    private int idAlocacao;
    private int fkIdTurma;
    private int fkIdSala;
    private int fkIdProfessor;

    // Default constructor
    public Alocacao() {}

    // Full constructor
    public Alocacao(int idAlocacao, int fkIdTurma, int fkIdSala, int fkIdProfessor) {
        this.idAlocacao = idAlocacao;
        this.fkIdTurma = fkIdTurma;
        this.fkIdSala = fkIdSala;
        this.fkIdProfessor = fkIdProfessor;
    }

    // Getters and Setters
    public int getIdAlocacao() { return idAlocacao; }
    public void setIdAlocacao(int idAlocacao) { this.idAlocacao = idAlocacao; }

    public int getFkIdTurma() { return fkIdTurma; }
    public void setFkIdTurma(int fkIdTurma) { this.fkIdTurma = fkIdTurma; }

    public int getFkIdSala() { return fkIdSala; }
    public void setFkIdSala(int fkIdSala) { this.fkIdSala = fkIdSala; }

    public int getFkIdProfessor() { return fkIdProfessor; }
    public void setFkIdProfessor(int fkIdProfessor) { this.fkIdProfessor = fkIdProfessor; }
}
