public class Principal
{
    public static void main(String[] args)
    {
        
        System.out.println("Bem vindo ao meu programa da Tele Sena!");

        // Cria as pessoas
        for(int i=0; i<20; i++)
        {
            Pessoa pessoa = new Pessoa();
            // Arbitra o nome
            pessoa.setNome("Pessoa" + (i+1));
            // Sorteia a quantidade de Tele Senas que serão compradas
            pessoa.setQuantidadeTeleSenasCompradas((int)(Math.random() * 15 + 1));
            // Adiciona a pessoa ao ControleTeleSena
            ControleTeleSena.addPessoa(pessoa);
        }
        
        System.out.print("\nVendendo as Tele Senas");
        animacaoTresPontinhos();
        ControleTeleSena.vendeTeleSenas();
        System.out.print("\nRealizando o sorteio");
        animacaoTresPontinhos();
        ControleTeleSena.realizaSorteio();
        System.out.print("\nRealizando a distribuição da premiação");
        animacaoTresPontinhos();
        ControleTeleSena.realizaDistribuicaoPremiacoes();
        
        System.out.print("\n\nNúmeros sorteados na Tele Sena: ");
        ControleTeleSena.imprimeNumerosPremiados();
        System.out.println("\nQuantidade de Tele Senas vendidas: " + ControleTeleSena.getQuantidadeTeleSenasVendidas());
        System.out.println("Quantidade de ganhadores: " + ControleTeleSena.getQuantidadeGanhadores());
        System.out.print("Nome(s) do(s) ganhador(es): ");
        ControleTeleSena.imprimeGanhadores();
        System.out.println("\nValor do prêmio para cada ganhador: R$ " + String.format("%.2f",ControleTeleSena.getPremioPorGanhador()));
        System.out.println("Valor total das Tele Senas vendida: R$ " + String.format("%.2f",(double)ControleTeleSena.getQuantidadeTeleSenasVendidas()*10));
        System.out.println("Lucro obtido pelo Silvio Santos com a Tele Sena: R$ " + String.format("%.2f",ControleTeleSena.getLucroSilvioSantos()));
    }
    
    private static void animacaoTresPontinhos()
    {
        delay(0.5);
        for(int i=0; i<3; i++)
        {
            System.out.print(" .");
            delay(0.5);
        }
    }
    
    private static void delay(double s)
    {
        try {
            Thread.sleep((int)(s*1000));
        } catch (Exception e) {}
    }
}