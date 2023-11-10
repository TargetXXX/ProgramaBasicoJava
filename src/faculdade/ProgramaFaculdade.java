package faculdade;

import faculdade.pessoas.Aluno;
import faculdade.pessoas.Pessoa;

import java.util.Scanner;

public class ProgramaFaculdade {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenu();
            opcao = obterOpcao();

            switch (opcao) {
                case 1:
                    adicionarPessoa();
                    break;
                case 2:
                    adicionarAluno();
                    break;
                case 3:
                    visualizarPessoa();
                    break;
                case 4:
                    visualizarAluno();
                    break;
                case 5:
                    atualizarPessoa();
                    break;
                case 6:
                    atualizarAluno();
                    break;
                case 7:
                    excluirPessoa();
                    break;
                case 8:
                    excluirAluno();
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);


        
    }

    private static void exibirMenu() {
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Adicionar Pessoa");
        System.out.println("2 - Adicionar Aluno");
        System.out.println("3 - Visualizar Pessoa");
        System.out.println("4 - Visualizar Aluno");
        System.out.println("5 - Atualizar Pessoa");
        System.out.println("6 - Atualizar Aluno");
        System.out.println("7 - Excluir Pessoa");
        System.out.println("8 - Excluir Aluno");
        System.out.println("0 - Sair");
    }

    private static int obterOpcao() {
        int opcao = -1;

        try {
            opcao = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Erro: Opção inválida. Digite um número.");
        }

        return opcao;
    }

    private static void adicionarPessoa() {
        System.out.println("Digite o nome da pessoa:");
        String nome = scanner.nextLine();

        try {
            System.out.println("Digite a idade da pessoa:");
            int idade = Integer.parseInt(scanner.nextLine());
            new Pessoa(nome, idade).save();
            System.out.println("Pessoa adicionada com sucesso!");
        } catch (NumberFormatException e) {
            System.out.println("Erro: Idade inválida. Digite um número.");
        }
    }

    private static void adicionarAluno() {
        System.out.println("Digite o código da pessoa (para associar ao aluno):");

        try {
            int pessoaCode = Integer.parseInt(scanner.nextLine());
            Pessoa pessoa = Pessoa.getPessoa(pessoaCode);

            if (pessoa != null) {
                System.out.println("Digite o curso do aluno:");
                String curso = scanner.nextLine();

                new Aluno(Pessoa.getPessoa(pessoaCode), curso).save();
                System.out.println("Aluno adicionado com sucesso!");
            } else {
                System.out.println("Erro: Pessoa não encontrada.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro: Código inválido. Digite um número.");
        }
    }

    private static void visualizarPessoa() {
        System.out.println("Digite o código da pessoa (-1 para todas):");

        try {
            int pessoaCode = Integer.parseInt(scanner.nextLine());

            if (pessoaCode == -1) {
                if (Pessoa.getPessoas().isEmpty()) {
                    System.out.println("Nenhuma pessoa encontrada");
                } else {
                    System.out.println("Pessoas cadastradas:");
                    for (Pessoa pessoa : Pessoa.getPessoas()) {
                        System.out.println(pessoa);
                    }
                }
            } else {
                Pessoa pessoa = Pessoa.getPessoa(pessoaCode);

                if (pessoa != null) {
                    System.out.println(pessoa);
                } else {
                    System.out.println("Erro: Pessoa não encontrada.");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro: Código inválido. Digite um número.");
        }
    }

    private static void visualizarAluno() {
        System.out.println("Digite o código do aluno (-1 para todas):");

        try {
            int alunoCode = Integer.parseInt(scanner.nextLine());

            if (alunoCode == -1) {
                if (Aluno.getAlunos().isEmpty()) {
                    System.out.println("Nenhum aluno encontrado");
                } else {
                    System.out.println("Alunos encontrados:");
                    for (Aluno aluno : Aluno.getAlunos()) {
                        System.out.println(aluno);
                    }
                }
            } else {
                Aluno aluno = Aluno.getAluno(alunoCode);

                if (aluno != null) {
                    System.out.println(aluno);
                } else {
                    System.out.println("Erro: Aluno não encontrado.");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro: Código inválido. Digite um número.");
        }
    }

    private static void atualizarPessoa() {
        System.out.println("Digite o código da pessoa:");

        try {
            int pessoaCode = Integer.parseInt(scanner.nextLine());
            Pessoa pessoa = Pessoa.getPessoa(pessoaCode);

            if (pessoa != null) {
                System.out.println("Digite o novo nome da pessoa:");
                String novoNome = scanner.nextLine();

                System.out.println("Digite a nova idade da pessoa:");

                try {
                    int novaIdade = Integer.parseInt(scanner.nextLine());
                    pessoa.setNome(novoNome);
                    pessoa.setIdade(novaIdade);

                    System.out.println("Pessoa atualizada com sucesso!");
                } catch (NumberFormatException e) {
                    System.out.println("Erro: Idade inválida. Digite um número.");
                }
            } else {
                System.out.println("Erro: Pessoa não encontrada.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro: Código inválido. Digite um número.");
        }
    }

    private static void atualizarAluno() {
        System.out.println("Digite o código do aluno:");

        try {
            int pessoaCode = Integer.parseInt(scanner.nextLine());
            Pessoa pessoa = Pessoa.getPessoa(pessoaCode);

            if (pessoa != null && pessoa instanceof Aluno) {
                Aluno aluno = (Aluno) pessoa;

                System.out.println("Digite o novo curso do aluno:");
                String novoCurso = scanner.nextLine();

                aluno.setCurso(novoCurso);

                System.out.println("Aluno atualizado com sucesso!");
            } else {
                System.out.println("Erro: Aluno não encontrado.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro: Código inválido. Digite um número.");
        }
    }

    private static void excluirPessoa() {
        System.out.println("Digite o código da pessoa:");

        try {
            int pessoaCode = Integer.parseInt(scanner.nextLine());
            Pessoa pessoa = Pessoa.getPessoa(pessoaCode);

            if (pessoa != null) {
                Pessoa.getPessoas().remove(pessoa);
                System.out.println("Pessoa excluída com sucesso!");
            } else {
                System.out.println("Erro: Pessoa não encontrada.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro: Código inválido. Digite um número.");
        }
    }

    private static void excluirAluno() {
        System.out.println("Digite o código do aluno:");

        try {
            int pessoaCode = Integer.parseInt(scanner.nextLine());
            Pessoa pessoa = Pessoa.getPessoa(pessoaCode);

            if (pessoa != null && pessoa instanceof Aluno) {
                Pessoa.getPessoas().remove(pessoa);
                System.out.println("Aluno excluído com sucesso!");
            } else {
                System.out.println("Erro: Aluno não encontrado.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro: Código inválido. Digite um número.");
        }
    }
}
