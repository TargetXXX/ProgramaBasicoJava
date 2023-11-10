package rpg.personagens;

public class BombaMan extends Personagem implements Jogavel {

	public BombaMan(String nome, int vida, int poder) {
		super(nome, vida, poder);
		
	}

	@Override
	public void atacar(Personagem personagem) {
		
		if(!estaVivo()) {
			System.err.println("Erro: Seu personagem não está vivo.");
			return;
		}
		
		if(!personagem.estaVivo()) {
			System.err.println("Erro: O alvo já não está vivo.");
			return;
		}
		
		int dano = personagem.estaDefendendo() ? getPoder() / 2 : getPoder();
		
		personagem.setVida(personagem.getVida() - dano);
		
		String status = personagem.estaVivo() ? "com " + personagem.getVida() + " de HP" : "morto";
		
		System.err.println("Você deu " + dano + " de dano! Seu oponente está " + status);
		
	}

	@Override
	public void defender() {
		super.defender();
	}



	
	
}
