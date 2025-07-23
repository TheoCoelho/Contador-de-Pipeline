// PipelineSimulator.java
import java.util.List;

public class PipelineSimulator {
    public static int simular(List<Instrucao> instrucoes) {
        int ciclos = 0;
        String ultimoEscrita = "";
        boolean ultimaFoiDesvio = false;

        for (int i = 0; i < instrucoes.size(); i++) {
            Instrucao inst = instrucoes.get(i);
            ciclos++;

            // Conflito de dados: RAW
            if (ultimoEscrita != null && (
                inst.rs != null && inst.rs.equals(ultimoEscrita) ||
                inst.rt != null && inst.rt.equals(ultimoEscrita)
            )) {
                ciclos++; // adiciona uma bolha (NOP)
            }

            // Conflito de controle
            if (inst.isDesvio) {
                ciclos++; // adiciona 1 ciclo por desvio
            }

            // Atualiza o registrador que será escrito
            if (inst.op.equals("add") || inst.op.equals("sub") || inst.op.equals("and") || inst.op.equals("or") || inst.op.equals("xor")) {
                ultimoEscrita = inst.rd;
            } else if (inst.op.equals("lw") || inst.op.equals("addi") || inst.op.equals("andi") || inst.op.equals("ori") || inst.op.equals("xori")) {
                ultimoEscrita = inst.rt;
            } else {
                ultimoEscrita = "";
            }
        }

        return ciclos + 4; // 4 ciclos para "esvaziar" o pipeline no final
    }
}
