public class ProfessorAdjunto extends Professor{



    private Integer horasMonitoria;


    public ProfessorAdjunto(String nome, String sobrenome, Integer codigoProfessor, Integer horasMonitoria) {
        super(nome, sobrenome, codigoProfessor);
        this.horasMonitoria = horasMonitoria;
    }

    public Integer getHorasMonitoria() {
        return horasMonitoria;
    }

    public void setHorasMonitoria(Integer horasMonitoria) {
        this.horasMonitoria = horasMonitoria;
    }
}
