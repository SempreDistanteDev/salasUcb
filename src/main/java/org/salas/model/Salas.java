package org.salas.model;

public class Salas {
    private int idSala;
    private String nome;
    private int fkStatusId;

    public Salas() {}

    public Salas(int idSala, String nome, int fkStatusId) {
        this.idSala = idSala;
        this.nome = nome;
        this.fkStatusId = fkStatusId;
    }

    public int getIdSala() { return idSala; }
    public void setIdSala(int idSala) { this.idSala = idSala; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getFkStatusId() { return fkStatusId; }
    public void setFkStatusId(int fkStatusId) { this.fkStatusId = fkStatusId; }
}
