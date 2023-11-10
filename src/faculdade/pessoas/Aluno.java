package faculdade.pessoas;

import java.util.ArrayList;

public class Aluno extends Pessoa {

	private static ArrayList<Aluno> alunos = new ArrayList<>();
	
	public static ArrayList<Aluno> getAlunos() {
		return alunos;
	}
	
	public static Aluno getAluno(int code) {
		
		if (code >= 0 && code < alunos.size()) {
            return alunos.get(code);
        } else {
            System.err.println("Erro: Aluno não encontrada com código " + code);
            return null;
        }
	}
	
	private String curso;
	private int AlunoCode;
	
	public Aluno(Pessoa pessoa, String curso) {
		super(pessoa.getNome(), pessoa.getIdade());
		this.curso = curso;
		

	}
	
	
	public boolean save() {
		
		if(alunos.contains(this)) return false;
		
		int AlunoCode = alunos.size();
		
		this.AlunoCode = AlunoCode;
		
		alunos.add(AlunoCode, this);
		
		return true;
		
	}
	
	public int getAlunoCode() {
		return AlunoCode;
	}
	
	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		if(curso != null && !curso.isEmpty()) {
			this.curso = curso;
			return;
		}
		
		System.err.println("Erro: Curso inválido");
	}
	
    @Override
    public String toString() {
        return super.toString() + ", Curso: " + getCurso();
    }
	

}
