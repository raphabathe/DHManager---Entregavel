
public class Main {

    public static void main(String[] args) {




        DigitalHouseManager manager = new DigitalHouseManager();



        ProfessorAdjunto professorAdjunto1 = new ProfessorAdjunto("Guilherme", "Sartori", 002, 0);
        ProfessorAdjunto professorAdjunto2 = new ProfessorAdjunto("Joaozio", "Maluco", 003, 0);
        ProfessorTitular professorTitular1 = new ProfessorTitular("Fabio", "Tadashi", 001, "Android / Java");
        ProfessorTitular professorTitular2 = new ProfessorTitular("Amauri", "Bathe", 004, "Full Stack");



        manager.registrarCurso("Full Stack",20001,3);
        manager.registrarCurso("Android",20002,2);

        manager.alocarProfessores(20001,004,003);
        manager.alocarProfessores(20002,001,002);




        manager.registrarAluno("Raphael", "Bathe", 001);
        manager.registrarAluno("Thiago", "Gonçalves", 002);
        manager.registrarAluno("Andreza", "deLucca", 003);
        manager.registrarAluno("Joana", "Bathe", 004);
        manager.registrarAluno("Gabriel", "Nader", 005);

        manager.matricularAluno(003,20001);
        manager.matricularAluno(004,20001);
        manager.matricularAluno(001,20002);
        manager.matricularAluno(002,20002);



        manager.matricularAluno(005,20002);
        manager.matricularAluno(003,20002);
        manager.matricularAluno(001,20001);






        manager.getListaAlunos().get(0).pesquisarCurso();










    }
}
