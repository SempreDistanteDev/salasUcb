package org.salas.model;

public class Professores {
    private int idProfessor;
    private String nomeProfessor;

    public Professores() {}

    public Professores(int idProfessor, String nomeProfessor) {
        this.idProfessor = idProfessor;
        this.nomeProfessor = nomeProfessor;
    }

    public int getIdProfessor() { return idProfessor; }
    public void setIdProfessor(int idProfessor) { this.idProfessor = idProfessor; }

    public String getNomeProfessor() { return nomeProfessor; }
    public void setNomeProfessor(String nomeProfessor) { this.nomeProfessor = nomeProfessor; }
}
