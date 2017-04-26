
public class DadoFalso implements Sorteador{
    int valor;
    public DadoFalso (int valor) {
        this.valor = valor;
    }

    public int sortear(){
        return this.valor;
    }
}
