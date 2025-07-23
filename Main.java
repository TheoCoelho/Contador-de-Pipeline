// Main.java
import java.util.List;

public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            String nomeArquivo = String.format("TESTE-%02d.txt", i);
            try {
                List<Instrucao> instrucoes = Util.lerInstrucoes(nomeArquivo);
                int ciclos = PipelineSimulator.simular(instrucoes);
                Util.salvarResultado(nomeArquivo, ciclos);
                System.out.println(nomeArquivo + " -> " + ciclos + " ciclos");
            } catch (Exception e) {
                System.out.println("Erro ao processar " + nomeArquivo + ": " + e.getMessage());
            }
        }
    }
}
