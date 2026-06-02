package org.salas.service;

import org.salas.dao.*;
import org.salas.model.*;

import java.sql.SQLException;
import java.util.List;

//Boilerplate de ia
//Funçao de baixar tudo do banco de dados baseado nas clases dos packs .dao e .model e salvar na memoria

public class DataDownloader {

    // Declare DAOs dependencies
    private final AlocacaoDAO alocacaoDAO;
    private final AlunosDAO alunosDAO;
    private final ProfessoresDAO professoresDAO;
    private final SalasDAO salasDAO;
    private final StatusDeSalaDAO statusDeSalaDAO;
    private final TurmasDAO turmasDAO;

    // Constructor initializes all required DAOs
    public DataDownloader() {
        this.alocacaoDAO = new AlocacaoDAO();
        this.alunosDAO = new AlunosDAO();
        this.professoresDAO = new ProfessoresDAO();
        this.salasDAO = new SalasDAO();
        this.statusDeSalaDAO = new StatusDeSalaDAO();
        this.turmasDAO = new TurmasDAO();
    }

    /**
     * Executes a complete download of the database schema into memory.
     * Throws SQLException so that the calling controller/application layer
     * can decide how to gracefully handle database interruptions.
     */
    public void executeFullDownload() throws SQLException {
        System.out.println("Baixando dados do BD...");

        // 1. Download data into Model Collections
        List<StatusDeSala> statuses = statusDeSalaDAO.findAll();
        List<Turmas> turmas = turmasDAO.findAll();
        List<Professores> professores = professoresDAO.findAll();
        List<Salas> salas = salasDAO.findAll();
        List<Alunos> alunos = alunosDAO.findAll();
        List<Alocacao> alocacoes = alocacaoDAO.findAll();

        // 2. Perform business logs / verification metrics
        printDownloadMetrics(statuses, turmas, professores, salas, alunos, alocacoes);
    }

    // Helper method to display download stats cleanly
    private void printDownloadMetrics(List<StatusDeSala> statuses, List<Turmas> turmas,
                                      List<Professores> professores, List<Salas> salas,
                                      List<Alunos> alunos, List<Alocacao> alocacoes) {
        System.out.println("\n=== Resumo de Sync com o BD ===");
        System.out.printf("-> %-15s: %d linhas baixadas.%n", "Status De Sala", statuses.size());
        System.out.printf("-> %-15s: %d linhas baixadas.%n", "Turmas", turmas.size());
        System.out.printf("-> %-15s: %d linhas baixadas.%n", "Professores", professores.size());
        System.out.printf("-> %-15s: %d linhas baixadas.%n", "Salas", salas.size());
        System.out.printf("-> %-15s: %d linhas baixadas.%n", "Alunos", alunos.size());
        System.out.printf("-> %-15s: %d linhas baixadas.%n", "Alocacoes", alocacoes.size());
        System.out.println("============================================\n");
    }
}