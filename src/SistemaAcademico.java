import java.util.ArrayList;
import java.util.List;

public class SistemaAcademico {
    private List<Aluno> alunos;
    private List<Disciplina> disciplinas;
    private List<Turma> turmas;

    public SistemaAcademico() {
        this.alunos = new ArrayList<>();
        this.disciplinas = new ArrayList<>();
        this.turmas = new ArrayList<>();
    }

    // Adiciona aluno se matrícula não existir
    public boolean addAluno(Aluno aluno) {
        for (Aluno a : alunos) {
            if (a.getMatricula().equals(aluno.getMatricula())) {
                return false; // Matrícula duplicada
            }
        }
        alunos.add(aluno);
        return true;
    }

    // Listar alunos
    public List<Aluno> getAlunos() {
        return alunos;
    }

    // Adicionar disciplina
    public void addDisciplina(Disciplina d) {
        disciplinas.add(d);
    }

    // Listar disciplinas
    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    // Adicionar turma
    public void addTurma(Turma t) {
        turmas.add(t);
    }

    // Listar turmas
    public List<Turma> getTurmas() {
        return turmas;
    }

    // Matricular aluno em turma, respeitando regras
    public boolean matricularAluno(Aluno aluno, Turma turma) {
        // Verificar vaga
        if (turma.getMatriculas().size() >= turma.getCapacidadeMaxima()) {
            return false;
        }

        // Verificar pré-requisitos
        for (String pre : turma.getDisciplina().getPreRequisitos()) {
            boolean preOk = false;
            for (Matricula m : getMatriculasAluno(aluno)) {
                if (m.getTurma().getDisciplina().getCodigo().equals(pre)) {
                    // Verificar se foi aprovado nessa disciplina
                    double media = 0;
                    if (m.getTurma().getFormaAvaliacao().equals("Simples")) {
                        media = m.calcularMediaSimples();
                    } else {
                        media = m.calcularMediaPonderada();
                    }
                    if (media >= 5) {
                        preOk = true;
                        break;
                    }
                }
            }
            if (!preOk) return false;
        }

        // Restrição para Aluno Especial: no máximo 2 disciplinas
        if (aluno.isEspecial()) {
            int qtd = 0;
            for (Matricula m : getMatriculasAluno(aluno)) {
                if (m.getTurma().getSemestre().equals(turma.getSemestre())) {
                    qtd++;
                }
            }
            if (qtd >= 2) {
                return false;
            }
        }

        Matricula matricula = new Matricula(aluno, turma);
        turma.adicionarMatricula(matricula);
        return true;
    }

    // Obter matrículas de um aluno
    public List<Matricula> getMatriculasAluno(Aluno aluno) {
        List<Matricula> lista = new ArrayList<>();
        for (Turma t : turmas) {
            for (Matricula m : t.getMatriculas()) {
                if (m.getAluno().equals(aluno)) {
                    lista.add(m);
                }
            }
        }
        return lista;
    }
}