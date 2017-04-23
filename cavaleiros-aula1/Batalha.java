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
        double dano = 10;
        
        if(valor1>= valor2){
            saint2.perderVida(dano);
        } else{ 
             saint1.perderVida(dano);
               }
    }
}
