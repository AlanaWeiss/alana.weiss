public class BronzeSaint extends Saint{
    public BronzeSaint(String nome, String constelacao)throws Exception{
        super(nome, constelacao);
        this.armadura = new Armadura(new Constelacao(constelacao), Categoria.BRONZE);
        this.qtdSentidosDespertados = 5;
    }
}