public class Pessoa
{
    private String nome;
    private int quantidadeTeleSenasCompradas;
    private TeleSena teleSenas[] = new TeleSena[15];
    private boolean premiada;
    private double premiacao;
    
    public Pessoa()
    {
    }
    
    public Pessoa(String nome)
    {
        this.nome = nome;
    }
    
    public String getNome()
    {
        return this.nome;
    }
    
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    
    public int getQuantidadeTeleSenasCompradas()
    {
        return this.quantidadeTeleSenasCompradas;
    }
    
    public void setQuantidadeTeleSenasCompradas(int quantidade)
    {
        this.quantidadeTeleSenasCompradas = quantidade;
    }
    
    public boolean getPremiada()
    {
        return this.premiada;
    }
    
    public void setPremiada()
    {
        this.premiada = true;
    }
    
    public double getPremiacao()
    {
        return this.premiacao;
    }
    
    public void setPremiacao(double premiacao)
    {
        this.premiacao = premiacao;
    }
    
    public TeleSena[] getTeleSena()
    {
        return this.teleSenas;
    }
    
    public void addTeleSena(TeleSena teleSena)
    {
        int i=0;
        
        // Bloco para encontrar o próximo espaço vazio para poder adicionar uma nova Tele Sena
        while(i<this.teleSenas.length)
        {
            if(this.teleSenas[i] == null)
            {
                this.teleSenas[i] = teleSena;
                break;
            }
            i++;
        }
        
        // Bloco para garantir que não será adicionado mais Tele Senas do que a quantidade permitida por pessoa
        if(i == this.teleSenas.length)
        {
            System.out.println("Esta pessoa já comprou seu número máximo de Tele Senas permitidas!");
        }
    }
}