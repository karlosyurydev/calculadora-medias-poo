import java.util.ArrayList;
import java.util.Scanner;

class Aluno {
    private String nome;
    private ArrayList<Double> notas;
    private double media;
    private String status;

    // Construtor
    public Aluno(String nome) {
        this.nome = nome;
        this.notas = new ArrayList<>();
    }

    // Adiciona nota
    public void adicionarNota(double nota) {
        notas.add(nota);
    }

    // Calcula média e status
    public void calcularMedia() {
        double somaNotas = 0;
        for (double nota : notas) {
            somaNotas += nota;
        }
        media = somaNotas / notas.size();

        if (media >= 6) {
            status = "Aprovado";
        } else {
            status = "Reprovado";
        }
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public double getMedia() {
        return media;
    }

    public String getStatus() {
        return status;
    }
}

public class SistemaAlunos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Aluno> turma = new ArrayList<>();

        while (true) {
            System.out.print("Digite o nome do aluno: ");
            String nome = scanner.nextLine(); // leitura de string
            Aluno aluno = new Aluno(nome);

            System.out.print("Quantas notas o aluno tem? ");
            int qtdNotas = scanner.nextInt(); // Leitura de número
            scanner.nextLine(); // Consumir a nova linha após nextInt()

            for (int i = 0; i < qtdNotas; i++) {
                System.out.print("Digite a nota " + (i + 1) + ": ");
                double nota = scanner.nextDouble(); // Leitura de número decimal
                aluno.adicionarNota(nota);
            }

            aluno.calcularMedia();
            turma.add(aluno);

            scanner.nextLine(); // Consumir a nova linha após nextDouble()
            System.out.print("Deseja adicionar outro aluno? (s/n): ");
            String continuar = scanner.nextLine(); // leitura de string
            if (!continuar.equalsIgnoreCase("s")) {
                break;
            }
        }

        // Exibir resultados finais
        System.out.println("\n--- Resultados Finais ---");
        for (Aluno aluno : turma) {
            System.out.println("Aluno: " + aluno.getNome() + ", Média: " + aluno.getMedia() + ", Status: " + aluno.getStatus());
        }

        scanner.close();
    }
}


