public class SilverSaint extends Saint{
    
    public SilverSaint(String nome, String constelacao)throws Exception{
        super(nome, constelacao);
        this.armadura = new Armadura(new Constelacao(constelacao), Categoria.BRONZE);
        this.qtdSentidosDespertados = 6;
    }
}