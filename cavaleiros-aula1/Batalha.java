
public class Batalha
{
    private Saint saint1, saint2;
   
    public Batalha(Saint saint1, Saint saint2)
    {
       this.saint1 = saint1;
       this.saint2 = saint2;
    }
    
    /*public void iniciar(){
        if(saint1.getValorArmadura()>saint2.getValorArmadura()){
           saint2.perderVida(10);
        } else if(saint1.getValorArmadura()<saint2.getValorArmadura()){
                  saint1.perderVida(10);
               } else saint2.perderVida(10);
        
        if(saint1.getVida()<100) saint2.perderVida(10);
        else saint1.perderVida(10);
        
    }*/
    
    public void iniciar(){
        int valor1 = this.saint1.getValorArmadura();
        int valor2 = this.saint2.getValorArmadura();
        
        if(valor1> valor2){
            this.saint2.perderVida(10);
        } else if (valor1 == valor2){
            this.saint2.perderVida(10);
        } else this.saint1.perderVida(10);
    }
}
