import java.util.*;

public class StringRNA {
    
    private String rna;

    // Mapa de códons para aminoácidos (nome e símbolo)
    private static final Map<String, String> CODON_TO_NAME = new HashMap<>();
    private static final Map<String, String> CODON_TO_SYMBOL = new HashMap<>();

    static {
        // Alanine
        CODON_TO_NAME.put("GCU", "Alanine");
        CODON_TO_NAME.put("GCC", "Alanine");
        CODON_TO_NAME.put("GCA", "Alanine");
        CODON_TO_NAME.put("GCG", "Alanine");
        CODON_TO_SYMBOL.put("GCU", "A");
        CODON_TO_SYMBOL.put("GCC", "A");
        CODON_TO_SYMBOL.put("GCA", "A");
        CODON_TO_SYMBOL.put("GCG", "A");

        // Arginine
        for (String codon : new String[]{"CGU","CGC","CGA","CGG","AGA","AGG"}) {
            CODON_TO_NAME.put(codon, "Arginine");
            CODON_TO_SYMBOL.put(codon, "R");
        }

        // Aspartic Acid
        for (String codon : new String[]{"GAU","GAC"}) {
            CODON_TO_NAME.put(codon, "Aspartic Acid");
            CODON_TO_SYMBOL.put(codon, "D");
        }

        // Asparagine
        for (String codon : new String[]{"AAU","AAC"}) {
            CODON_TO_NAME.put(codon, "Asparagine");
            CODON_TO_SYMBOL.put(codon, "N");
        }

        // Cysteine
        for (String codon : new String[]{"UGU","UGC"}) {
            CODON_TO_NAME.put(codon, "Cysteine");
            CODON_TO_SYMBOL.put(codon, "C");
        }

        // Glutamic Acid
        for (String codon : new String[]{"GAA","GAG"}) {
            CODON_TO_NAME.put(codon, "Glutamic Acid");
            CODON_TO_SYMBOL.put(codon, "E");
        }

        // Glutamine
        for (String codon : new String[]{"CAA","CAG"}) {
            CODON_TO_NAME.put(codon, "Glutamine");
            CODON_TO_SYMBOL.put(codon, "Q");
        }

        // Glycine
        for (String codon : new String[]{"GGU","GGC","GGA","GGG"}) {
            CODON_TO_NAME.put(codon, "Glycine");
            CODON_TO_SYMBOL.put(codon, "G");
        }

        // Histidine
        for (String codon : new String[]{"CAU","CAC"}) {
            CODON_TO_NAME.put(codon, "Histidine");
            CODON_TO_SYMBOL.put(codon, "H");
        }

        // Isoleucine
        for (String codon : new String[]{"AUU","AUC","AUA"}) {
            CODON_TO_NAME.put(codon, "Isoleucine");
            CODON_TO_SYMBOL.put(codon, "I");
        }

        // Leucine
        for (String codon : new String[]{"UUA","UUG","CUU","CUC","CUA","CUG"}) {
            CODON_TO_NAME.put(codon, "Leucine");
            CODON_TO_SYMBOL.put(codon, "L");
        }

        // Lysine
        for (String codon : new String[]{"AAA","AAG"}) {
            CODON_TO_NAME.put(codon, "Lysine");
            CODON_TO_SYMBOL.put(codon, "K");
        }

        // Methionine
        CODON_TO_NAME.put("AUG", "Methionine");
        CODON_TO_SYMBOL.put("AUG", "M");

        // Phenylalanine
        for (String codon : new String[]{"UUU","UUC"}) {
            CODON_TO_NAME.put(codon, "Phenylalanine");
            CODON_TO_SYMBOL.put(codon, "F");
        }

        // Proline
        for (String codon : new String[]{"CCU","CCC","CCA","CCG"}) {
            CODON_TO_NAME.put(codon, "Proline");
            CODON_TO_SYMBOL.put(codon, "P");
        }

        // Serine
        for (String codon : new String[]{"AGU","AGC","UCU","UCC","UCA","UCG"}) {
            CODON_TO_NAME.put(codon, "Serine");
            CODON_TO_SYMBOL.put(codon, "S");
        }

        // Threonine
        for (String codon : new String[]{"ACU","ACC","ACA","ACG"}) {
            CODON_TO_NAME.put(codon, "Threonine");
            CODON_TO_SYMBOL.put(codon, "T");
        }

        // Tryptophan
        CODON_TO_NAME.put("UGG", "Tryptophan");
        CODON_TO_SYMBOL.put("UGG", "W");

        // Tyrosine
        for (String codon : new String[]{"UAU","UAC"}) {
            CODON_TO_NAME.put(codon, "Tyrosine");
            CODON_TO_SYMBOL.put(codon, "X");
        }

        // Valine
        for (String codon : new String[]{"GUU","GUC","GUA","GUG"}) {
            CODON_TO_NAME.put(codon, "Valine");
            CODON_TO_SYMBOL.put(codon, "V");
        }

        // STOP codons
        for (String codon : new String[]{"UAA","UAG","UGA"}) {
            CODON_TO_NAME.put(codon, "STOP");
            CODON_TO_SYMBOL.put(codon, ".");
        }
    }

    // Construtor
    public StringRNA(String input) {
        if (input.matches("[ACGU]+")) {
            this.rna = input;
        } else {
            this.rna = "";
        }
    }

    public String toString() {
        return rna;
    }

    public char charAt(int pos) {
        return rna.charAt(pos);
    }

    public int quantosA() { return (int) rna.chars().filter(c -> c == 'A').count(); }
    public int quantosC() { return (int) rna.chars().filter(c -> c == 'C').count(); }
    public int quantosG() { return (int) rna.chars().filter(c -> c == 'G').count(); }
    public int quantosU() { return (int) rna.chars().filter(c -> c == 'U').count(); }

    public int length() { return rna.length(); }

    // Retorna nomes dos aminoácidos
    public String traduzirPorNome() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i + 2 < rna.length(); i += 3) {
            String codon = rna.substring(i, i + 3);
            String amino = CODON_TO_NAME.getOrDefault(codon, "?");
            sb.append(amino).append(" ");
        }
        return sb.toString().trim();
    }

    // Retorna símbolos dos aminoácidos
    public String traduzirPorSimbolo() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i + 2 < rna.length(); i += 3) {
            String codon = rna.substring(i, i + 3);
            String symbol = CODON_TO_SYMBOL.getOrDefault(codon, "?");
            sb.append(symbol);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        StringRNA rna = new StringRNA("AUGGCCAUGGCGCCCAGAACUGAGAUCAAUAGUACCCGUAUUAACGGGUGA");
        System.out.println("RNA: " + rna);
        System.out.println("A: " + rna.quantosA());
        System.out.println("C: " + rna.quantosC());
        System.out.println("G: " + rna.quantosG());
        System.out.println("U: " + rna.quantosU());
        System.out.println("Length: " + rna.length());
        System.out.println("Tradução por nome: " + rna.traduzirPorNome());
        System.out.println("Tradução por símbolo: " + rna.traduzirPorSimbolo());
    }
}
