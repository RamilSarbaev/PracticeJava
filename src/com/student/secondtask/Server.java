package com.student.secondtask;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Server {
    private String directory;

    public Server(String directory) {
        this.directory = directory;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            return;
        }

        Server server = new Server(args[0]);
        start(server);
    }

    public static void start(Server server) {
        System.out.println("Server started.");
        System.out.println("Waiting for a client...");

        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New client connected!");

            InputStream input = clientSocket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            OutputStream output = clientSocket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            String request = reader.readLine();

            if (server.isFirstCommand(request)) {
                server.sendFiles(writer);
            } else if (server.isSecondCommand(request)) {
                String[] s = request.split("\\s+");
                server.sendFile(writer, s[1]);
            } else {
                System.out.println("Wrong request!");
            }

            System.out.println("Closing connection.");
        } catch (FileNotFoundException ex) {
            System.out.println("File access exception: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
        }
    }

    private void sendFiles(PrintWriter writer) throws IOException {
        DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(directory));

        for (Path path : directoryStream) {
            writer.println(path.getFileName().toString());
        }
    }

    private void sendFile(PrintWriter writer, String fileName) throws IOException {
        Path sourcePath = Paths.get(directory + fileName);

        if (Files.exists(sourcePath)) {
            writer.println("error");
            return;
        }

        writer.println("ok");

        List<String> lines = Files.readAllLines(sourcePath);
        for (String line : lines) {
            writer.println(line);
        }
    }

    private boolean isFirstCommand(String s) {
        return s.equals("index");
    }

    private boolean isSecondCommand(String s) {
        String[] arguments = s.split("\\s+");

        if (arguments.length != 2) {
            return false;
        }

        return arguments[0].equals("get");
    }
}
