
import java.util.ArrayList;
import java.util.List;


public class Aluno {

    private String nome;
    private String sobrenome;
    private Integer codigoAluno;
    private List<Curso> cursosMatriculados = new ArrayList<>();




    public void pesquisarCurso(){
        System.out.println("O Aluno "+getNome() +" está matriculado nos seguintes cursos:");
        for (Curso curso: cursosMatriculados) {
            System.out.println(curso.getNome());

        }
    }


    public Aluno(String nome, String sobrenome, Integer codigoAluno) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.codigoAluno = codigoAluno;
    }





    public boolean equals(Aluno aluno) {
        return this.getCodigoAluno().equals(aluno.getCodigoAluno());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Integer getCodigoAluno() {
        return codigoAluno;
    }

    public void setCodigoAluno(Integer codigoAluno) {
        this.codigoAluno = codigoAluno;
    }

    public List<Curso> getCursosMatriculados() {
        return cursosMatriculados;
    }

    public void setCursosMatriculados(List<Curso> cursosMatriculados) {
        this.cursosMatriculados = cursosMatriculados;
    }
}
