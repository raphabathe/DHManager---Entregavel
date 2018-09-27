
import java.util.ArrayList;
import java.util.List;

public class Curso {


    private String nome;
    private Integer codigoCurso;
    private ProfessorTitular professorTitular;
    private ProfessorAdjunto professorAdjunto;
    private Integer maxAlunos;
    private List<Aluno> listaDeAlunos = new ArrayList<>();


    public Curso(String nome, Integer codigoCurso, Integer maxAlunos) {
        this.nome = nome;
        this.codigoCurso = codigoCurso;
        this.maxAlunos = maxAlunos;
    }

    public Curso() {
    }

    // Entendo que o enunciado estava um pouco confuso, mas faltou adicionar os alunos ao curso na hora de matricular
    // teoricamente tem um bug no seu sistema pois poderao ter mais alunos matriculados do que o curso suporta
    public Boolean adicionarUmAluno (Aluno umAluno){
        if (listaDeAlunos.size()<maxAlunos){
            listaDeAlunos.add(umAluno);
            System.out.println("Aluno: " +umAluno.getCodigoAluno() +" adicionado ao curso " + getNome());
            return true;
        }else{
            System.out.println("Não há vagas disponíveis nesse curso.");
            return false;
        }

    }

    public void excluirAluno(Aluno umAluno){
        listaDeAlunos.remove(umAluno);

    }




    public boolean equals(Curso curso) {
        return this.getCodigoCurso().equals(curso.getCodigoCurso());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(Integer codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public ProfessorTitular getProfessorTitular() {
        return professorTitular;
    }

    public void setProfessorTitular(ProfessorTitular professorTitular) {
        this.professorTitular = professorTitular;
    }

    public ProfessorAdjunto getProfessorAdjunto() {
        return professorAdjunto;
    }

    public void setProfessorAdjunto(ProfessorAdjunto professorAdjunto) {
        this.professorAdjunto = professorAdjunto;
    }

    public Integer getMaxAlunos() {
        return maxAlunos;
    }

    public void setMaxAlunos(Integer maxAlunos) {
        this.maxAlunos = maxAlunos;
    }

    public List<Aluno> getListaDeAlunos() {
        return listaDeAlunos;
    }

    public void setListaDeAlunos(List<Aluno> listaDeAlunos) {
        this.listaDeAlunos = listaDeAlunos;
    }
}
