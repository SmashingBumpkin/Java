public class MyAgent implements Agent {
    private String nome;


    MyAgent(String nome){
        this.nome = nome;
    }

    public void action(){
        System.out.println("Agent "+nome+" does action!");
    }

    public String getName(){
        return this.nome;
    }

    public void beSilly(){

    }
}
