
public class ContraAtaque implements Movimento {
    Saint golpeador, golpeado;
    
    public ContraAtaque(Saint golpeador, Saint golpeado) {
      this.golpeador = golpeador;
      this.golpeado= golpeado;
    }

    public void executar(){
        boolean contraAtaquePossivel = new DadoD3().sortear() >= 4;
    }
}
