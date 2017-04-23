public class Batalha
{
    private Saint saint1, saint2; 
   
    public Batalha(Saint saint1, Saint saint2)
    {
       this.saint1 = saint1;
       this.saint2 = saint2;
    }
    
    public void iniciar() throws Exception{
        double dano = 10;
        Movimento movimento;
        Saint atacaPrimeiro = this.saint1;
        Saint atacaDepois = this.saint2;
        if(saint1.getValorArmadura() < saint2.getValorArmadura()){
            atacaPrimeiro = this.saint2;
            atacaDepois = this.saint1;
        }
        while (saint1.getStatus() != Status.MORTO && saint2.getStatus() != Status.MORTO){
            movimento = atacaPrimeiro.getProximoMovimento();
            movimento.executar();
            if(atacaDepois.getStatus() != Status.MORTO){
                movimento = atacaDepois.getProximoMovimento();
                movimento.executar();
            }
        }
    }
}
