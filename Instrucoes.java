// Instrucao.java
public class Instrucao {
    public String tipo;
    public String op;
    public String rd, rs, rt;
    public boolean isDesvio;
    
    public Instrucao(String linha) {
        linha = linha.replace(",", "")
                     .replace("(", " ")
                     .replace(")", "")
                     .replaceAll("\\s+", " ").trim();
        String[] partes = linha.split(" ");
        op = partes[0].toLowerCase();
        isDesvio = op.equals("beq") || op.equals("bne") || op.equals("j") || op.equals("jr");

        switch (op) {
            case "add":
            case "sub":
            case "and":
            case "or":
            case "xor":
                tipo = "R";
                rd = partes[1];
                rs = partes[2];
                rt = partes[3];
                break;
            case "lw":
            case "sw":
                tipo = "I";
                rt = partes[1];
                rs = partes[2];
                break;
            case "beq":
            case "bne":
                tipo = "I";
                rs = partes[1];
                rt = partes[2];
                break;
            case "addi":
            case "andi":
            case "ori":
            case "xori":
                tipo = "I";
                rt = partes[1];
                rs = partes[2];
                break;
            default:
                tipo = "OUTRO";
        }
    }
}
