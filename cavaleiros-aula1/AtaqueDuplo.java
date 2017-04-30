public class AtaqueDuplo implements Movimento {
    private Saint golpeador, golpeado;
    private int fatorDanoDuplo = 0;
    public AtaqueDuplo(Saint golpeador, Saint golpeado) {
       this.golpeador = golpeador;
       this.golpeado = golpeado;
    }
    
    public void executar(){
        boolean ataqueDuploPossivel = new DadoD3().sortear() < 2;
        boolean armuaduraEstaVestida = golpeador.getArmaduraVestida();
         int fatorDano;
         double cincoPorcentoDaVida = golpeador.getVida()*0.05;
        if(armuaduraEstaVestida){
             fatorDano = ataqueDuploPossivel ?
                ((golpeador.getProximoGolpe().getDano())*(1+golpeador.getValorArmadura()))*2 
                : golpeador.getProximoGolpe().getDano();
        } else {
            fatorDano = ataqueDuploPossivel ?
                ((golpeador.getProximoGolpe().getDano()))*2 
                : golpeador.getProximoGolpe().getDano();
            }
         golpeado.perderVida(fatorDano);
        if (!ataqueDuploPossivel){
            golpeador.perderVida(cincoPorcentoDaVida);
        }
    }  
    
    
}
