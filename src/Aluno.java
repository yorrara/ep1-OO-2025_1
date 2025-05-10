public abstract class Aluno {
    protected String nome;
    protected String matricula;
    protected String curso;

    public Aluno(String nome, String matricula, String curso) {
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
    }

    // Getters e setters
    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getCurso() {
        return curso;
    }

    // Método abstrato para verificar se aluno é especial
    public abstract boolean isEspecial();
}