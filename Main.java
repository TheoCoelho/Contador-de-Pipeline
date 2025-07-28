import java.util.List;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        try {
            Files.createDirectories(Paths.get("RESULTADOS"));
        } catch (Exception e) {
            return;
        }
        for (int i = 1; i <= 10; i++) {
            String nomeArquivo = Paths.get(String.format("TESTE-%02d.txt", i)).toString();
            String resultadoArquivo = Paths.get("RESULTADOS", String.format("TESTE-%02d.txt", i)).toString();
            try {
                List<Instrucao> instrucoes = Util.lerInstrucoes(nomeArquivo);
                int ciclos = Contador.simular(instrucoes);
                Util.salvarResultado(resultadoArquivo, ciclos);
            }
            catch (Exception e) {
            }
        }
    }
}
