
import java.util.ArrayList;
import java.util.List;

public class DigitalHouseManager {

    private List<Aluno> listaAlunos = new ArrayList<>();
    private List<Professor> listaProfessores = new ArrayList<>();
    private List<Curso> listaCursos = new ArrayList<>();
    private List<Matricula> listaMatriculas = new ArrayList<>();


    public void registrarCurso(String nome, Integer codigoCurso, Integer quantidadeMaximaDeAlunos){
        Curso curso = new Curso(nome, codigoCurso,quantidadeMaximaDeAlunos);
        listaCursos.add(curso);
    }


    public void excluirCurso(Integer codigoCurso){
        Curso cursoARemover = new Curso();
        for (Curso curso : listaCursos) {
            if (curso.getCodigoCurso().equals(codigoCurso)){
                cursoARemover  = curso;
            }
        }
        listaCursos.remove(cursoARemover);
    }

    // Os professores nunca foram registrados ne?
    public void registrarProfessorAdjunto(String nome, String sobrenome, Integer codigoDoProfessor, Integer horasMonitoria){
        ProfessorAdjunto professorAdjunto = new ProfessorAdjunto(nome, sobrenome, codigoDoProfessor, horasMonitoria);
        listaProfessores.add(professorAdjunto);

    }

    public void registrarProfessorTitular(String nome, String sobrenome, Integer codigoProfessor, String
            especialidade){
        ProfessorTitular professorTitular = new ProfessorTitular(nome,sobrenome,codigoProfessor,especialidade);
        professorTitular.setTempoDeCasa(0);
        listaProfessores.add(professorTitular);
    }


    public void excluirProfessor(Integer codigoProfessor){
        Professor professorAExcluir = null;
        for (Professor professor : listaProfessores) {
            if (professor.getCodigoProfessor().equals(codigoProfessor)){
                professorAExcluir = professor;
            }
            // este remove tem que estar fora do for. Se ficar aqui vai dar ConcurrentModificationException
            // (msm ideia do remover curso)
            listaProfessores.remove(professorAExcluir);
        }
    }


    public void registrarAluno(String nome, String sobrenome, Integer codigoAluno){
        Aluno aluno = new Aluno(nome,sobrenome,codigoAluno);
        listaAlunos.add(aluno);
    }

    public void matricularAluno(Integer codigoAluno, Integer codigoCurso){
        Curso cursoPesquisar = buscarCursoPorCodigo(codigoCurso);
        Aluno alunoPesquisar = buscarAlunoPorCodigo(codigoAluno);

        if (cursoPesquisar.getListaDeAlunos().size() < cursoPesquisar.getMaxAlunos()){
            // Aqui não precisaria dividir a declaracao da variavel e a atribuicao, poderia ser:
            // Matricula matriculaAluno = new Matricula(alunoPesquisar, cursoPesuisar);
            Matricula matriculaAluno;
            matriculaAluno = new Matricula(alunoPesquisar , cursoPesquisar);
            listaMatriculas.add(matriculaAluno);
            cursoPesquisar.getListaDeAlunos().add(alunoPesquisar);
            System.out.println("Matricula do(a) aluno(a) " +alunoPesquisar.getNome() + " " +alunoPesquisar.getSobrenome() + " realizada com sucesso no curso: "+cursoPesquisar.getNome());
            System.out.println();
            alunoPesquisar.getCursosMatriculados().add(cursoPesquisar);

        }else {
            System.out.println("Não é possível realizar matrícula do(a) aluno(a) " +alunoPesquisar.getNome() +" porque não há vagas nesse curso.");

        }

    }

    public Curso buscarCursoPorCodigo(Integer codigoCurso){
        Curso cursoPesquisar = null;
        for (Curso curso : listaCursos) {
            if (curso.getCodigoCurso().equals(codigoCurso)){
                cursoPesquisar = curso;
            }
        }
        return cursoPesquisar;
    }

    public Aluno buscarAlunoPorCodigo(Integer codigoAluno){
        Aluno alunoPesquisar = null;
        for (Aluno aluno : listaAlunos) {
            if (aluno.getCodigoAluno().equals(codigoAluno)){
                alunoPesquisar = aluno;
            }
        }
        return alunoPesquisar;
    }


    public void alocarProfessores(Integer codigoCurso, Integer codigoProfessorTitular, Integer codigoProfessorAdjunto){
        Curso cursoPesquisa = null;
        ProfessorTitular professorParaAdicionar = null;
        ProfessorAdjunto professorAdjuntoParaAdicionar = null;
        for (Curso curso : listaCursos) {
            if (curso.getCodigoCurso().equals(codigoCurso)){
                cursoPesquisa = curso;
            }
        }
        for (Professor professorTitular : listaProfessores) {
            if (professorTitular.getCodigoProfessor().equals(codigoProfessorTitular)){
                professorParaAdicionar = (ProfessorTitular) professorTitular;
            }
        }
        for (Professor professorAdjunto : listaProfessores) {
            if (professorAdjunto.getCodigoProfessor().equals(codigoProfessorAdjunto)){
                professorAdjuntoParaAdicionar = (ProfessorAdjunto) professorAdjunto;
            }
        }
        // Estas linhas pode gerar um NullPointerException caso o codigo do curso consultado nao exista
        // poderia tratar com um try and catch ou um if(cursoPesquisa != null)
        cursoPesquisa.setProfessorAdjunto(professorAdjuntoParaAdicionar);
        cursoPesquisa.setProfessorTitular(professorParaAdicionar);
    }


    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public void setListaAlunos(List<Aluno> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }

    public List<Professor> getListaProfessores() {
        return listaProfessores;
    }

    public void setListaProfessores(List<Professor> listaProfessores) {
        this.listaProfessores = listaProfessores;
    }

    public List<Curso> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(List<Curso> listaCursos) {
        this.listaCursos = listaCursos;
    }

    public List<Matricula> getListaMatriculas() {
        return listaMatriculas;
    }

    public void setListaMatriculas(List<Matricula> listaMatriculas) {
        this.listaMatriculas = listaMatriculas;
    }
}
