// Util.java
import java.nio.file.*;
import java.util.*;
import java.io.*;

public class Util {
    public static List<Instrucao> lerInstrucoes(String caminho) throws IOException {
        List<String> linhas = Files.readAllLines(Paths.get(caminho));
        List<Instrucao> instrucoes = new ArrayList<>();
        for (String linha : linhas) {
            if (!linha.trim().isEmpty()) {
                instrucoes.add(new Instrucao(linha));
            }
        }
        return instrucoes;
    }

    public static void salvarResultado(String caminho, int ciclos) throws IOException {
        String nomeSaida = caminho.replace(".txt", "-RESULTADO.txt");
        Files.write(Paths.get(nomeSaida), String.valueOf(ciclos).getBytes());
    }
}
