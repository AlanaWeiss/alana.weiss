public class Constelacao {
    private String nome;
    private Golpe[] golpes = new Golpe[3];
    private int ultimaPosicaoPreenchida = 0;
 
    public Constelacao(String nome){
        this.nome=nome;
    }
    
    public void adicionarGolpe(Golpe golpe){
        /*for (int i = 0; i< this.golpes.length; i++){
            Golpe golpeAtual = this.golpes[i];
            if(golpeAtual == null){ 
                this.golpes[i]= golpe;
                break; //quebra o for
                //continue quebra a execução atual
                //return quebra o metodo inteiro
            }
        }*/
        golpes[ultimaPosicaoPreenchida++]=golpe;
    }
    
    public Golpe[] getGolpes(){
        return this.golpes;
    }
    
    public String getNome() {
        return this.nome;
     }
    
}
 