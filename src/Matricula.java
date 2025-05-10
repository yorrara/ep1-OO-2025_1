public class Matricula {
    private Aluno aluno;
    private Turma turma;
    private double p1;
    private double p2;
    private double p3;
    private double lista;
    private double seminario;
    private int presencas;
    private int aulas;

    public Matricula(Aluno aluno, Turma turma) {
        this.aluno = aluno;
        this.turma = turma;
        this.p1 = 0;
        this.p2 = 0;
        this.p3 = 0;
        this.lista = 0;
        this.seminario = 0;
        this.presencas = 0;
        this.aulas = turma.getCapacidadeMaxima() * 15; // Por exemplo, 15 aulas por semestre
    }

    // Getters e setters para notas e presença
    public Aluno getAluno() {
        return aluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public double getP1() {
        return p1;
    }

    public void setP1(double p1) {
        this.p1 = p1;
    }

    public double getP2() {
        return p2;
    }

    public void setP2(double p2) {
        this.p2 = p2;
    }

    public double getP3() {
        return p3;
    }

    public void setP3(double p3) {
        this.p3 = p3;
    }

    public double getLista() {
        return lista;
    }

    public void setLista(double lista) {
        this.lista = lista;
    }

    public double getSeminario() {
        return seminario;
    }

    public void setSeminario(double seminario) {
        this.seminario = seminario;
    }

    public int getPresencas() {
        return presencas;
    }

    public void setPresencas(int presencas) {
        this.presencas = presencas;
    }

    public int getAulas() {
        return aulas;
    }

    // Calcula frequência em porcentagem
    public double calcularFrequencia() {
        return (double) presencas / aulas * 100;
    }

    // Calcula média final usando forma simples: (P1 + P2 + P3 + L + S) / 5
    public double calcularMediaSimples() {
        return (p1 + p2 + p3 + lista + seminario) / 5.0;
    }

    // Calcula média final usando forma ponderada: (P1 + 2*P2 + 3*P3 + L + S) / 8
    public double calcularMediaPonderada() {
        return (p1 + 2 * p2 + 3 * p3 + lista + seminario) / 8.0;
    }

    // Verifica se aluno foi aprovado (nota >= 5 e frequência >= 75%)
    public boolean isAprovado(double mediaFinal) {
        return mediaFinal >= 5.0 && calcularFrequencia() >= 75.0;
    }
}