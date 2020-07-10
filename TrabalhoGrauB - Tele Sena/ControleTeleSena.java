public class ControleTeleSena
{
    private static Pessoa pessoas[] = new Pessoa[20];
    private static int numerosPremiados[] = new int[60];
    private static int quantidadeTeleSenasVendidas;
    private static int quantidadeGanhadores;
    private static double premioPorGanhador;
    private static double lucroSilvioSantos;
    
    public static Pessoa[] getPessoa()
    {
        return pessoas;
    }
    
    public static void addPessoa(Pessoa pessoa)
    {
        int i=0;
        
        // Bloco para encontrar o próximo espaço vazio para poder adicionar uma nova pessoa
        while(i<pessoas.length)
        {
            if(pessoas[i] == null)
            {
                pessoas[i] = pessoa;
                break;
            }
            i++;
        }
        
        // Bloco para garantir que não será adicionado mais pessoas do que a quantidade permitida por pessoa
        if(i == pessoas.length)
        {
            System.out.println("Já foi adicionado o número máximo de pessoas permitidas!");
        }
    }
    
    public static int[] getNumerosPremiados()
    {
        return numerosPremiados;
    }
    
    public static void imprimeNumerosPremiados()
    {
        for(int i=0; i<numerosPremiados.length; i++)
        {
            if(numerosPremiados[i]!=0)
            {
                System.out.print(String.format("%2d ",i+1));
            }
        }
    }
    
    public static void imprimeGanhadores()
    {
        for(int i=0; i<pessoas.length; i++)
        {
            if(pessoas[i].getPremiada())
            {
                System.out.print(ControleTeleSena.getPessoa()[i].getNome() + " ");
            }
        }
    }
    
    public static int getQuantidadeTeleSenasVendidas()
    {
        return quantidadeTeleSenasVendidas;
    }
    
    public static int getQuantidadeGanhadores()
    {
        return quantidadeGanhadores;
    }
    
    public static double getPremioPorGanhador()
    {
        return premioPorGanhador;
    }
    
    public static double getLucroSilvioSantos()
    {
        return lucroSilvioSantos;
    }
    
    public static void vendeTeleSenas()
    {
        // Percorre cada pessoa
        for(int i=0; i<pessoas.length; i++)
        {
            // Vai criando Tele Sena e vendendo, de acordo com a quantidade que cada pessoa desejou comprar
            for(int j=0; j<pessoas[i].getQuantidadeTeleSenasCompradas(); j++)
            {
                TeleSena teleSena = new TeleSena(sorteiaConjuntoDeNumeros(),sorteiaConjuntoDeNumeros());
                pessoas[i].addTeleSena(teleSena);
                quantidadeTeleSenasVendidas++;
            }
        }
    }
    
    // Método para sortear os 25 números de um conjunto de uma Tele Sena
    private static int[] sorteiaConjuntoDeNumeros()
    {
        int conjunto[] = new int[60], numero, i=0;
        
        while(i<25)
        {
            numero = (int)(Math.random() * 60 + 1);
            if(conjunto[numero-1] == 0)
            {
                conjunto[numero-1] = 1;
                i++;
            }
        }
        return conjunto;
    }
   
    public static void realizaSorteio()
    {
        // Sorteia os números premiados
        numerosPremiados = sorteiaConjuntoDeNumeros();
        
        boolean houveUmGanhador = false, numeroNaoSorteado = false;
        int numero;
        
        while(!houveUmGanhador)
        {
            // Percorre o array dos número sorteados, sendo i um número sorteado
            for(int i=0; i<numerosPremiados.length; i++)
            {
                // Realiza a verificação para os números que foram sorteados, sendo i um número sorteado
                if(numerosPremiados[i]==1)
                {
                    // Percorre as pessoas
                    for(int j=0; j<pessoas.length; j++)
                    {
                        // Percorre as Tele Senas compradas por cada pessoa
                        for(int k=0; k<pessoas[j].getQuantidadeTeleSenasCompradas(); k++)
                        {
                            // Se o número sorteado i está no conjunto 1 desta Tele Sena, incrementa o contador de números sorteados
                            if(pessoas[j].getTeleSena()[k].getNumeroConjunto1()[i] == 1)
                            {
                                pessoas[j].getTeleSena()[k].incrementaNumerosSorteadosConjunto1();
                            }
                            // Se o número sorteado i está no conjunto 2 desta Tele Sena, incrementa o contador de números sorteados
                            if(pessoas[j].getTeleSena()[k].getNumeroConjunto2()[i] == 1)
                            {
                                pessoas[j].getTeleSena()[k].incrementaNumerosSorteadosConjunto2();
                            }
                            // Verifica se houve um ganhador
                            if(pessoas[j].getTeleSena()[k].getNumerosSorteadosConjunto1()==25 || pessoas[j].getTeleSena()[k].getNumerosSorteadosConjunto2()==25)
                            {
                                houveUmGanhador = true;
                                pessoas[j].setPremiada();
                            }
                        }
                    }
                }
            }
            
            // Se ainda não houve um ganhador
            if(!houveUmGanhador)
            {
                // Sorteia mais um número
                numeroNaoSorteado = false;
                while(!numeroNaoSorteado)
                {
                    numero = (int)(Math.random() * 60 + 1);
                    if(numerosPremiados[numero-1] == 0)
                    {
                        numerosPremiados[numero-1] = 1;
                        numeroNaoSorteado = true;
                    }
                }
                
                // Zera os contadores de números sorteados de todas as Tele Senas, pois será conferido tudo novamente
                for(int j=0; j<pessoas.length; j++)
                {
                    // Percorre as Tele Senas compradas por cada pessoa
                    for(int k=0; k<pessoas[j].getQuantidadeTeleSenasCompradas(); k++)
                    {
                        pessoas[j].getTeleSena()[k].zeraNumerosSorteados();
                    }
                }
            }
        }
    }
    
    public static void realizaDistribuicaoPremiacoes()
    {
        // Conta quantos ganhadores houveram
        for(int i=0; i<pessoas.length; i++)
        {
            if(pessoas[i].getPremiada())
            {
                quantidadeGanhadores++;
            }
        }
        // Divide o prêmio igualmente entre os ganhadores
        premioPorGanhador = quantidadeTeleSenasVendidas * 8 / quantidadeGanhadores;
        for(int i=0; i<pessoas.length; i++)
        {
            if(pessoas[i].getPremiada())
            {
                pessoas[i].setPremiacao(premioPorGanhador);
            }
        }
        // Calcula o lucro do silvio santos
        lucroSilvioSantos = quantidadeTeleSenasVendidas * 2;
    }
}
