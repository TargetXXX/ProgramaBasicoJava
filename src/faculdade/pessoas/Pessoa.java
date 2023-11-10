package faculdade.pessoas;

import java.util.ArrayList;

public class Pessoa {

	private static ArrayList<Pessoa> pessoas = new ArrayList<>();
	
	public static ArrayList<Pessoa> getPessoas() {
		return pessoas;
	}
	
	public static Pessoa getPessoa(int code) {
		
		if (code >= 0 && code < pessoas.size()) {
            return pessoas.get(code);
        } else {
            System.err.println("Erro: Pessoa não encontrada com código " + code);
            return null;
        }
	}
	
	private String nome;
	private int idade;
	private int code;
	
	public Pessoa(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;

	}
	
	public boolean save() {
		if(pessoas.contains(this)) return false;
		
			int code = pessoas.size();
			
			this.code = code;
			
			pessoas.add(code, this);
		
		return true;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public int getCode() {
		return code;
	}

	
	public void setIdade(int idade) {
		
		if(idade > 0) {
			this.idade = idade;
			return;
		}
		System.err.println("Erro: Idade inválida ");
		
		
		
		
	}
	
	public void setNome(String nome) {
		
		if(nome != null && !nome.isEmpty()) {
			this.nome = nome;
			return;
		}
		
		System.err.println("Erro: Nome inválido ");
	}
	
    @Override
    public String toString() {
        return "Nome: " + getNome() + ", Idade: " + getIdade();
    }
	
}
