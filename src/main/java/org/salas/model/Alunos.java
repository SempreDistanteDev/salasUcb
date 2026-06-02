package org.salas.model;


public class Alunos {
    private int idAluno;
    private String nomeAluno;
    private int fkRelacaoTurma;

    public Alunos() {}

    public Alunos(int idAluno, String nomeAluno, int fkRelacaoTurma) {
        this.idAluno = idAluno;
        this.nomeAluno = nomeAluno;
        this.fkRelacaoTurma = fkRelacaoTurma;
    }

    public int getIdAluno() { return idAluno; }
    public void setIdAluno(int idAluno) { this.idAluno = idAluno; }

    public String getNomeAluno() { return nomeAluno; }
    public void setNomeAluno(String nomeAluno) { this.nomeAluno = nomeAluno; }

    public int getFkRelacaoTurma() { return fkRelacaoTurma; }
    public void setFkRelacaoTurma(int fkRelacaoTurma) { this.fkRelacaoTurma = fkRelacaoTurma; }
}
