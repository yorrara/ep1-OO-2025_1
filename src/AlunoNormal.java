public class AlunoNormal extends Aluno {
    public AlunoNormal(String nome, String matricula, String curso) {
        super(nome, matricula, curso);
    }

    @Override
    public boolean isEspecial() {
        return false;
    }
}