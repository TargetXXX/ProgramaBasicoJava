package rpg.personagens;

public class Personagem {

    private String nome;
    private int vida, poder;
    private boolean defendendo;

    public Personagem(String nome, int vida, int poder) {
        this.nome = nome;
        this.vida = vida;
        this.poder = poder;
        this.defendendo = false;
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public int getVida() {
        return vida;
    }

    public String getNome() {
        return nome;
    }

    public int getPoder() {
        return poder;
    }

    public void setNome(String nome) {
        if (nome != null && !nome.isEmpty()) {
            this.nome = nome;
        } else {
            System.err.println("Erro: Nome inválido ");
        }
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public boolean estaDefendendo() {
        return defendendo;
    }

    public void defender() {
        if (estaVivo()) {
            defendendo = true;
            System.out.println(getNome() + " está defendendo.");
        }
    }
	
	   @Override
	    public String toString() {
	        return "Personagem{" +
	                "nome='" + nome + '\'' +
	                ", vida=" + vida +
	                ", poder=" + poder +
	                '}';
	    }
	
}
