public abstract class Professor { // <--- boa!! Classe abstrata

    private String nome;
    private String sobrenome;
    private Integer tempoDeCasa;
    private Integer codigoProfessor;


    public Professor(String nome, String sobrenome, Integer codigoProfessor) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.codigoProfessor = codigoProfessor;
    }

    public boolean equals(Professor professor) {
        return this.getCodigoProfessor().equals(professor.getCodigoProfessor());
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

    public Integer getTempoDeCasa() {
        return tempoDeCasa;
    }

    public void setTempoDeCasa(Integer tempoDeCasa) {
        this.tempoDeCasa = tempoDeCasa;
    }

    public Integer getCodigoProfessor() {
        return codigoProfessor;
    }

    public void setCodigoProfessor(Integer codigoProfessor) {
        this.codigoProfessor = codigoProfessor;
    }
}
