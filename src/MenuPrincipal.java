import java.util.Scanner;

public class MenuPrincipal {
    private SistemaAcademico sistema;
    private Scanner scanner;

    public MenuPrincipal() {
        sistema = new SistemaAcademico();
        scanner = new Scanner(System.in);
    }

    public void iniciar() {
        boolean rodando = true;
        while (rodando) {
            System.out.println("\n=== Sistema Acadêmico ===");
            System.out.println("1 - Modo Aluno");
            System.out.println("2 - Modo Disciplina/Turma");
            System.out.println("3 - Modo Avaliação/Frequência");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            int opc = scanner.nextInt();
            scanner.nextLine();

            switch (opc) {
                case 1:
                    modoAluno();
                    break;
                case 2:
                    modoDisciplinaTurma();
                    break;
                case 3:
                    modoAvaliacaoFrequencia();
                    break;
                case 0:
                    rodando = false;
                    System.out.println("Encerrando sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
        scanner.close();
    }

    private void modoAluno() {
        System.out.println("Modo Aluno ainda em desenvolvimento...");
        // Aqui implementar cadastro, listagem e matrícula
    }

    private void modoDisciplinaTurma() {
        System.out.println("Modo Disciplina/Turma ainda em desenvolvimento...");
        // Aqui implementar cadastro de disciplinas e turmas, listagens
    }

    private void modoAvaliacaoFrequencia() {
        System.out.println("Modo Avaliação/Frequência ainda em desenvolvimento...");
        // Aqui implementar lançamento de notas e presenças e relatórios
    }

    public static void main(String[] args) {
        MenuPrincipal menu = new MenuPrincipal();
        menu.iniciar();
    }
}