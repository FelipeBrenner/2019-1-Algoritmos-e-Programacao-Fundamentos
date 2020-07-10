public class TeleSena
{
    private static double preco;
    private int conjuntoDeNumeros1[] = new int[60];
    private int numerosSorteadosConjunto1;
    private int conjuntoDeNumeros2[] = new int[60];
    private int numerosSorteadosConjunto2;
    
    public TeleSena(int[] conjuntoDeNumeros1, int[] conjuntoDeNumeros2)
    {
        this.conjuntoDeNumeros1 = conjuntoDeNumeros1;
        this.conjuntoDeNumeros2 = conjuntoDeNumeros2;
        preco = 10;
        this.numerosSorteadosConjunto1 = 0;
        this.numerosSorteadosConjunto2 = 0;
    }
    
    public int getNumerosSorteadosConjunto1()
    {
        return this.numerosSorteadosConjunto1;
    }
    
    public void incrementaNumerosSorteadosConjunto1()
    {
        this.numerosSorteadosConjunto1++;
    }
    
    public int getNumerosSorteadosConjunto2()
    {
        return this.numerosSorteadosConjunto2;
    }
    
    public void incrementaNumerosSorteadosConjunto2()
    {
        this.numerosSorteadosConjunto2++;
    }
    
    public void zeraNumerosSorteados()
    {
        this.numerosSorteadosConjunto1 = 0;
        this.numerosSorteadosConjunto2 = 0;
    }
    
    public int[] getNumeroConjunto1()
    {
        return this.conjuntoDeNumeros1;
    }
    
    public int[] getNumeroConjunto2()
    {
        return this.conjuntoDeNumeros2;
    }
    
    public void imprimeTeleSena()
    {
        System.out.print("\nConjunto 1: ");
        for(int i=0; i<this.conjuntoDeNumeros1.length; i++)
        {
            if(this.conjuntoDeNumeros1[i]!=0)
            {
                System.out.print(String.format("%2d ",i+1));
            }
        }
        System.out.print("\nConjunto 2: ");
        for(int i=0; i<this.conjuntoDeNumeros2.length; i++)
        {
            if(this.conjuntoDeNumeros2[i]!=0)
            {
                System.out.print(String.format("%2d ",i+1));
            }
        }
    }
}