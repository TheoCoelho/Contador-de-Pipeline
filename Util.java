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

    // salva resultado dos ciclos
    public static void salvarResultado(String caminho, int ciclos) throws IOException {
        Path pastaResultados = Paths.get("RESULTADOS");
        String nomeArquivo = Paths.get(caminho).getFileName().toString(); 
        String nomeSaida = nomeArquivo.replace(".txt", "-RESULTADO.txt");
        Path caminhoSaida = pastaResultados.resolve(nomeSaida);
        Files.write(caminhoSaida, String.valueOf(ciclos).getBytes());
    }

}
