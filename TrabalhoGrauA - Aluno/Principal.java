public class Principal
{
    public static void main(String[] args)
    {
        System.out.println("Bem vindo!\n"); 
        
        Aluno[] aluno = new Aluno[10];
        for(int i=0; i<10; i++)
        {
            aluno[i] = criaAluno();
            avaliaAluno(aluno[i]);
            aluno[i].calculaMediaFinal();
            System.out.println(aluno[i]);
        }
    }
    
    public static Aluno criaAluno()
    {
        String nome = Teclado.leString("Nome: ");
        String dataNascimento = Teclado.leString("Data de nascimento: ");
        int codigoMatricula = Teclado.leInt("Matrícula: ");
        String curso = Teclado.leString("Curso: ");
        int semestreAtual = Teclado.leInt("Semestre: ");
        
        Aluno aluno = new Aluno(nome, codigoMatricula, curso, semestreAtual, dataNascimento);
        return aluno;
    }
    
    public static void avaliaAluno(Aluno aluno)
    {
        aluno.setTA(Teclado.leDouble("Nota trabalho GA: "));
        aluno.setPA(Teclado.leDouble("Nota trabalho PA: "));
        aluno.setTB(Teclado.leDouble("Nota trabalho GB: "));
        aluno.setPB(Teclado.leDouble("Nota trabalho PB: "));
    }
}