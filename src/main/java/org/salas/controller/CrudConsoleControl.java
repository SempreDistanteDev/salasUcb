package org.salas.controller;

import org.salas.dao.ProfessoresDAO;
import org.salas.dao.SalasDAO;
import org.salas.dao.StatusDeSalaDAO;
import org.salas.model.Professores;
import org.salas.model.Salas;
import org.salas.model.StatusDeSala;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class CrudConsoleControl {

    private final Scanner scanner = new Scanner(System.in);
    private final ProfessoresDAO professoresDAO = new ProfessoresDAO();
    private final SalasDAO salasDAO = new SalasDAO();
    private final StatusDeSalaDAO statusDeSalaDAO = new StatusDeSalaDAO();

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("\n====================================");
            System.out.println("       CRUD        ");
            System.out.println("====================================");
            System.out.println("1. Gerenciar Status de Sala");
            System.out.println("2. Gerenciar Professores");
            System.out.println("3. Gerenciar Salas");
            System.out.println("0. Sair");
            System.out.print("Digite uma opçao: ");

            int choice = readInteger();
            switch (choice) {
                case 1 -> menuStatusDeSala();
                case 2 -> menuProfessores();
                case 3 -> menuSalas();
                case 0 -> {
                    running = false;
                    System.out.println("Saido do CRUD...");
                }
                default -> System.out.println("Opçao digitada: " + choice + " eh invalida, tente novamente.");
            }
        }
    }

    // --- 1. STATUS DE SALA CRUD ---
    private void menuStatusDeSala() {
        System.out.println("\n--- [STATUS DE SALA CRUD] ---");
        System.out.println("1. Criar Status | 2. Listar Todos | 3. Atualizar um Status | 4. Sair");
        int op = readInteger();
        try {
            switch (op) {
                case 1 -> {
                    System.out.print("Digite um ID para o Status de Sala: ");
                    int id = readInteger();
                    System.out.print("Digite o Nome do Status de Sala: ");
                    String name = scanner.nextLine();
                    statusDeSalaDAO.insert(id, name);
                    System.out.println("Status de Sala criado com sucesso!");
                }
                case 2 -> {
                    List<StatusDeSala> list = statusDeSalaDAO.findAll();
                    list.forEach(s -> System.out.println("ID: " + s.getIdStatus() + " | Nome: " + s.getNomeStatus()));
                }
                case 3 -> {
                    System.out.print("Digite um ID para atualizar: ");
                    int id = readInteger();
                    System.out.print("Digite o novo Nome do Status: ");
                    String name = scanner.nextLine();
                    statusDeSalaDAO.update(id, name);
                    System.out.println("Status atualizado com sucesso!");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro de SQL: " + e.getMessage());
        }
    }

    // --- 2. PROFESSORES CRUD ---
    private void menuProfessores() {
        System.out.println("\n--- [PROFESSORES CRUD] ---");
        System.out.println("1. Criar Professor | 2. Listar Todos | 3. Atualizar um Professor | 4. Sair");
        int op = readInteger();
        try {
            switch (op) {
                case 1 -> {
                    System.out.print("Digite o ID do novo Professor: ");
                    int id = readInteger();
                    System.out.print("Digite o Nome do novo Professor: ");
                    String name = scanner.nextLine();
                    professoresDAO.insert(id, name);
                    System.out.println("Criado um novo Professor!");
                }
                case 2 -> {
                    List<Professores> list = professoresDAO.findAll();
                    list.forEach(p -> System.out.println("ID: " + p.getIdProfessor() + " | Name: " + p.getNomeProfessor()));
                }
                case 3 -> {
                    System.out.print("Digite um ID de Professor para atualizar: ");
                    int id = readInteger();
                    System.out.print("Digite o novo nome do Professor: ");
                    String name = scanner.nextLine();
                    professoresDAO.update(id, name);
                    System.out.println("Professor atualizado com sucesso!");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro de SQL: " + e.getMessage());
        }
    }

    // --- 3. SALAS CRUD ---
    private void menuSalas() {
        System.out.println("\n--- [SALAS CRUD] ---");
        System.out.println("1. Criar Sala | 2. Listar Todas | 3. Atualizar uma Sala | 4. Sair");
        int op = readInteger();
        try {
            switch (op) {
                case 1 -> {
                    System.out.print("Digite um ID para a nova Sala: ");
                    int id = readInteger();
                    System.out.print("Digite o nome para a Sala: ");
                    String name = scanner.nextLine();
                    System.out.print("Digite o ID de Status de Sala para a nova sala: ");
                    int statusId = readInteger();
                    salasDAO.insert(id, name, statusId);
                    System.out.println("Nova Sala criada!");
                }
                case 2 -> {
                    List<Salas> list = salasDAO.findAll();
                    list.forEach(s -> System.out.println("ID: " + s.getIdSala() + " | Name: " + s.getNome() + " | Status ID: " + s.getFkStatusId()));
                }
                case 3 -> {
                    System.out.print("Digite um ID de Sala para atualizar: ");
                    int id = readInteger();
                    System.out.print("Digite o novo nome da Sala: ");
                    String name = scanner.nextLine();
                    System.out.print("Digite um ID de Status de Sala para a sala: ");
                    int statusId = readInteger();
                    salasDAO.update(id, name, statusId);
                    System.out.println("Sala atualizada com sucesso!");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro de SQL: " + e.getMessage());
        }
    }

    // Input Validation helper to avoid scanner skips and exceptions
    private int readInteger() {
        while (!scanner.hasNextInt()) {
            System.out.print("Entrada invalida. Digite um INTEIRO: ");
            scanner.next();
        }
        int num = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        return num;
    }
}