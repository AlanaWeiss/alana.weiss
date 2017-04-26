public class AtaqueDuplo implements Movimento {
    private Saint golpeador, golpeado;
    private int fatorDanoDuplo = 0;
    public AtaqueDuplo(Saint golpeador, Saint golpeado) {
       this.golpeador = golpeador;
       this.golpeado = golpeado;
    }
    
    public void executar(){
        int fatorDano = golpeador.getArmaduraVestida() ?
                (golpeador.getProximoGolpe().getDano())*(1+golpeador.getValorArmadura()) 
                : golpeador.getProximoGolpe().getDano();
        double d = Math.random() * 100;
        if (d < 33.3){
            int fatorDanoDuplo = fatorDano*2;
            this.golpeado.perderVida(fatorDanoDuplo);
        }  //TODO: else perder vida e dar ataque normal
    }
    
}
