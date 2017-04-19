import java.security.InvalidParameterException;
import java.util.ArrayList;

public class Saint {
    private String nome;
    private Armadura armadura; 
    private boolean armaduraVestida;
    private Gênero genero = Gênero.NAO_INFORMADO;
    private Status status = Status.VIVO;
    private double vida = 100.0;
    protected int qtdSentidosDespertados; //acesso para a classe e as subclasses
    private int acumuladorProximoGolpe = 0;
     
    //construtor
    public Saint(String nome, Armadura armadura) throws Exception {
        this.nome = nome;
        this.armadura = armadura;
        vida = 100;
        } 
    
    public String getSaint(){
        return this.nome;
    }
    
    public int getValorArmadura(){
        return this.armadura.getCategoria();
    }
    //metodo
    public void vestirArmadura(){
        this.armaduraVestida = true;
    }
    
    //metodo retorno para usar no teste pq a variavel era privada
    public boolean getArmaduraVestida(){
        return this.armaduraVestida;
    }

    public Gênero getGenero(){
    return this.genero;
    }

    public void setGenero(Gênero genero){
    this.genero=genero;
    }
    
    public Status getStatus(){
        return this.status;
    }
    
    public double getVida(){
        return this.vida;
    }
    
    public int getCategoriaArmadura(){
        return this.armadura.getCategoria();
    }
    
    public void perderVida(double dano){
       if (dano<0) {
           throw new InvalidParameterException("dano negativo");
        }
       if(this.vida - dano<1){
           this.vida=0;
           this.status = Status.MORTO;
        } else {
            this.vida -= dano;
        }
    }
   
    public int getQtdSentidosDespertados(){
        return this.qtdSentidosDespertados;
    }
    
    private Constelacao getConstelacao(){
        return this.armadura.getConstelacao();
    }
    
    public ArrayList getGolpes(){
       return this.getConstelacao().getGolpes();
    }
    
    public void aprenderGolpe(Golpe golpe){
        getConstelacao().adicionarGolpe(golpe);
    }
    
     public Golpe getProximoGolpe() {
        //ArrayList golpes = getGolpes();
        ArrayList<Golpe> golpes = new ArrayList<>();
        golpes = getGolpes();
         int posicao = this.acumuladorProximoGolpe % golpes.size();
         this.acumuladorProximoGolpe++;
         return golpes.get(posicao);
     }
    
    
}