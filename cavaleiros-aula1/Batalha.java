public class Batalha
{
    private Saint saint1, saint2; 
   
    public Batalha(Saint saint1, Saint saint2)
    {
       this.saint1 = saint1;
       this.saint2 = saint2;
    }
    
    public void iniciar() throws Exception{
        int valor1 = this.saint1.getValorArmadura();
        int valor2 = this.saint2.getValorArmadura();
        final double dano = 10;
        Saint atacaPrimeiro, atacaDepois = null;
        Movimento movimento;

        if (valor1 >= valor2) {
            atacaPrimeiro = this.saint1;
            atacaDepois = this.saint2;
            this.saint2.perderVida(dano);
        } else {
            atacaPrimeiro = this.saint2;
            atacaDepois = this.saint1;
            this.saint1.perderVida(dano);
        }
        boolean estaoVivos = true;
        while (estaoVivos){
            movimento = atacaPrimeiro.getProximoMovimento();
            movimento.executar();
            if(atacaDepois.getStatus() != Status.MORTO){
                movimento = atacaDepois.getProximoMovimento();
                movimento.executar();
            }
            estaoVivos = this.saint1.getStatus() != Status.MORTO && this.saint2.getStatus() != Status.MORTO;
        }
    }
}
