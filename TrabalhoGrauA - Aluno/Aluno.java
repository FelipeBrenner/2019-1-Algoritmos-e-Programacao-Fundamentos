public class Aluno
{
    private String nome;
    private int codigoMatricula;
    private String curso;
    private int semestreAtual;
    private String dataNascimento;
    private double TA;
    private double PA;
    private double TB;
    private double PB;
    private double MF;
    
   public Aluno(String nome, int codigoMatricula, String curso, int semestreAtual, String dataNascimento)
   {
        this.nome = nome;
        this.codigoMatricula = codigoMatricula;
        this.curso = curso;
        this.semestreAtual = semestreAtual;
        this.dataNascimento = dataNascimento;
        this.TA = 0;
        this.PA= 0;
        this.TB = 0;
        this.PB = 0;
   }
   
   public String toString()
   {
       return 
       "\n========================================" +
       "\nNome: " + nome +
       "\nData de nascimento: " + dataNascimento +
       "\nMatricula: " + codigoMatricula +
       "\nCurso: " + curso + "(" + semestreAtual + "º semestre)" +
       "\nNota trabalho GA: " + TA +
       "\nNota prova GA: " + PA+
       "\nNota trabalho GB: " + TB +
       "\nNota prova GB: " + PB +
       "\nMédia final: " + MF +
       "\n========================================\n";
   }

   public String getNome()
   {
       return nome;
   }
    
   public int getCodigoMatricula()
   {
       return codigoMatricula;
   }
    
   public String getCurso()
   {
       return curso;
   }
    
   public int getSemestreAtual()
   {
       return semestreAtual;
   }
   
   public String getDataNascimento()
   {
       return dataNascimento;
   }
   
   public double getTA()
   {
       return TA;
   }
   
   public double getPA()
   {
       return PA;
   }
   
   public double getTB()
   {
       return TB;
   }
   
   public double getPB()
   {
       return PB;
   }
   
   public double getMF()
   {
       return MF;
   }
   
   public void setTA(double TA)
   {
       this.TA = TA;
   }
   
   public void setPA(double PA)
   {
       this.PA= PA;
   }
   
   public void setTB(double TB)
   {
       this.TB = TB;
   }
   
   public void setPB(double PB)
   {
       this.PB = PB;
   }
   
   public void calculaMediaFinal()
   {
       MF = (TA*0.4 + PA*0.6 + (TB*0.4 + PB*0.6)*2)/3;    
   }
}
