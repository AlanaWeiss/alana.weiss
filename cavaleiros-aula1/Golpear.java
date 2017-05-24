public class Golpear implements Movimento{
    Saint golpeador, golpeado;
    private Golpe golpe;
    private int fatorDano;
    
    public Golpear(Saint golpeador, Saint golpeado){
        this.golpeador = golpeador;
        this.golpeado = golpeado;
        this.golpe = golpeador.getProximoGolpe();
    }
    
    public void executar(){
        int fatorDano = golpeador.getArmaduraVestida() ?
                (golpeador.getProximoGolpe().getDano())*(1+golpeador.getValorArmadura()) 
                : golpeador.getProximoGolpe().getDano();
                   
        this.golpeado.perderVida(fatorDano);
    }
}
