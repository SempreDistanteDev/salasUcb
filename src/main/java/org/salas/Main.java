package org.salas;

import org.salas.controller.CrudConsoleControl;
import org.salas.dao.DatabaseConfig;
import org.salas.service.DataDownloader;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Boilerplate de IA
// Funçao da classe Main apenas iniciar o programa, e fazer limpeza de fechamento

public class Main {


    public static void main(String[] args) {
        // 1. Check if we have an active console session
        Console console = System.console();

        // 2. If no console is found, relaunch via Windows CMD
        if (console == null && isRunningAsJar()) {
            try {
                relaunchInCmd(args);
                System.exit(0); // Exit the background process safely
            } catch (Exception e) {
                System.err.println("[Main.java] Falha geral ao iniciar o CMD: " + e.getMessage());
                e.printStackTrace();
            }
        }

        // 3. YOUR CLI LOGIC STARTS HERE
        System.out.println("========================================");
        System.out.println("   SalasUcb  ");
        System.out.println("   Sistema iniciando...  ");
        System.out.println("========================================");

        System.out.println("[Main.java]Chamando Download de BD...");
        // Instantiate the service layer component
        DataDownloader downloader = new DataDownloader();

        try {
            // Trigger the download business logic
            downloader.executeFullDownload();
            System.out.println("Download Completo com sucesso.");
        } catch (SQLException e) {
            System.err.println("ERRO: Falha a syncronizar com o BD!");
            e.printStackTrace();
        }

        //Iniciar sistema de CRUD
        CrudConsoleControl crudConsole = new CrudConsoleControl();
        crudConsole.start();

        /*
        if (args.length > 0) {
            System.out.println("\nArguments received:");
            for (int i = 0; i < args.length; i++) {
                System.out.printf("  [%d]: %s%n", i, args[i]);
            }
        } else {
            System.out.println("\nNo arguments provided.");
        }
         */

        // Keep the window open so it doesn't instantly close on exit
        try {
            System.out.println("\n[Main.java]Verificando conexoes com o BD.");
            boolean valid = DatabaseConfig.getConnection().isValid(3);
            System.out.println("\n[Main.java]A conexao com o BD eh: "+ valid);
            if (valid){
                Thread.sleep(1000);
                System.out.println("\n[Main.java]Fechando conexoes ativas com o BD!");
                DatabaseConfig.getConnection().close();
            };
            System.out.println("\n[Main.java]Conexoes com o BD fechadas com sucesso.");
        } catch (SQLException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\n[Main.java]Sistema encerado!");
        System.out.println("[Main.java]Aperte a tecla ENTER para sair...");
        try { System.in.read(); } catch (IOException ignored) {}
        System.exit(0);
    }

    /**
     * Helper to check if the application is running from a packaged JAR file.
     */
    private static boolean isRunningAsJar() {
        String protocol = Main.class.getResource("Main.class").getProtocol();
        return "jar".equals(protocol);
    }

    /**
     * Spawns a new Windows cmd.exe window and executes this JAR inside it.
     */
    private static void relaunchInCmd(String[] args) throws URISyntaxException, IOException {
        // Get the path of the currently executing JAR
        String jarPath = new File(Main.class.getProtectionDomain()
                .getCodeSource()
                .getLocation()
                .toURI())
                .getAbsolutePath();

        List<String> command = new ArrayList<>();
        command.add("cmd.exe");
        command.add("/c"); // Run command and then terminate the hidden parent shell
        command.add("start"); // Windows command to launch a separate window
        command.add("SalasUcb Cli"); // Title of the new CMD window
        command.add("cmd.exe"); // The target shell inside the new window
        command.add("/c"); // Keep the command prompt window open after the JAR finishes
        command.add("java");
        command.add("-jar");
        command.add(jarPath);

        // Append original arguments if any exist
        for (String arg : args) {
            command.add(arg);
        }

        // Execute the process
        new ProcessBuilder(command).start();
    }
}