package me.dio.academia.digital.excepions;

public class AlunoNotFoundExcepition extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public AlunoNotFoundExcepition(Long id) {
		super("O aluno com o id: " + id + " não está cadastrado no banco");
	}

}
