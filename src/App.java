/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adriano Sena, Tiago Cardoso
 */
import java.util.Scanner;
import java.io.Console;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        //Início da seção de variáveis
        Console console = System.console();
        Scanner entrada = new Scanner(System.in);
        ManipularArquivo me = new ManipularArquivo();
        Matriz m = new Matriz();
        Ranking ranki = new Ranking();

        int inicio;
        int linha;
        int coluna;
        int[] coordenada = new int[2];

        char senha[];
        char senha2[];

        String passPlayer1 = " ";
        String passPlayer2;
        String namePlayer1 = " ";
        String namePlayer2;
        String testPass1;
        String testPass2;

        String loginPlayer1;
        String loginPassPlayer1;
        String loginPlayer2;
        String loginPassPlayer2;

        String coo;

//        VARIAVEIS QUE CONFEREM SE O JOGADOR PONTUOU
        boolean teste1 = false;
        boolean teste2 = false;
//        VARIAVEIS QUE CONFEREM SE A COORDENADA ESTA VAZIA
        boolean existe1 = false;
        boolean existe2 = false;
//        VARIAVEIS QUE CONFEREM SE O JOGO CHEGOU AO FIM
        boolean acabou1 = false;
        boolean acabou2 = false;
        //Escolha da opção inicial do jogador
        do {
            System.out.println("==========================JogoDaCerca=========================");
            System.out.println("");
            System.out.println("            Faça o cadastro dos jogadores para inicar, aperte:");
            System.out.println("            1 para cadastrar");
            System.out.println("            2 para fazer login e iniciar o jogo");
            System.out.println("            3 para visualizar o ranking");
            System.out.println("            0 para sair.");
            inicio = entrada.nextInt();
            //Caso para decidir a ação inicial do jogador
            switch (inicio) {
                case 1:
                    System.out.println("Digite o nome do player 1:");
                    namePlayer1 = entrada.next();
//                    me.escreverNome(namePlayer1);
                    //Validação da senha do jogador 1
                    do {
                        System.out.println("Digite a senha do jogador 1:");
                        senha = console.readPassword();
                        System.out.println("Por favor confirme a senha do jogador 1:");
                        senha2 = console.readPassword();
                        if (!Arrays.equals(senha, senha2)) {
                            System.out.println("As senhas não conferem, por favor digite novamente.");
                        }
                    } while (!Arrays.equals(senha, senha2));
                    passPlayer1 = new String(senha); //Conversão da senha escrita de char[] para String
                    //ESCRITA DO LOGIN E SENHA DO JOGADOR 1 NO ARQUIVO
                    me.cadastro(namePlayer1, passPlayer1);
                    System.out.println("Jogador cadastrado com sucesso!");
                    System.out.println("Deseja cadastrar o próximo jogador? s para avançar ou qualquer tecla+enter para sair.");
                    String continuarCad = entrada.next();
                    Matriz.clearScreen();
                    switch (continuarCad) {
                        case "s":
                            System.out.println("Por favor cadastre o jogador 2:");
                            System.out.println("Digite o nome do player 2:");
                            namePlayer2 = entrada.next();
                            do {
                                System.out.println("Digite a senha do jogardor 2:");
                                senha = console.readPassword();
                                System.out.println("Por favor confirme a senha do jogador 2:");
                                senha2 = console.readPassword();
                                if (!Arrays.equals(senha, senha2)) {
                                    System.out.println("As senhas não conferem, por favor digite novamente.");
                                }
                            } while (!Arrays.equals(senha, senha2));
                            passPlayer2 = new String(senha);
//                            ESCRITA DO LOGIN E SENHA DO JOGADOR 2 NO ARQUIVO
                            me.cadastro(namePlayer2, passPlayer2);
                            Matriz.clearScreen();
                            System.out.println("Jogador cadastrado com sucesso!");
                            break;
                        case "n":
                            break;
                    }
                    break;
                case 2:
//                    lOGIN DO PRIMEIRO JOGADOR
                    System.out.println("Faça o login jogador 1");
                    do {
                        System.out.println("Usuário:");
                        loginPlayer1 = entrada.next();
                        System.out.println("Senha:");
                        senha = console.readPassword();
                        loginPassPlayer1 = new String(senha);
//                        O MÉTODO LOGIN É BOOLEANO, CASO NÃO RETORNO TRUE O LOGIN NÃO É VÁLIDO
                        if (me.login(loginPlayer1, loginPassPlayer1) != true) {
                            System.out.println("Usuário ou senha incorreto, por favor tente novamente.");
                        }
                    } while (me.login(loginPlayer1, loginPassPlayer1) != true);
                    System.out.println("Login efetuado com sucesso");
//                    LOGIN DO SEGUNDO JOGADOR
                    System.out.println("Faça o login jogador 2");
                    do {
                        System.out.println("Usuário:");
                        loginPlayer2 = entrada.next();
                        System.out.println("Senha:");
                        senha = console.readPassword();
                        loginPassPlayer2 = new String(senha);
//                        O MÉTODO LOGIN É BOOLEANO, CASO NÃO RETORNO TRUE O LOGIN NÃO É VÁLIDO
                        if (me.login(loginPlayer2, loginPassPlayer2) != true) {
                            System.out.println("Usuário ou senha incorreto, por favor tente novamente.");
                        }
                    } while (me.login(loginPlayer2, loginPassPlayer2) != true);
                    Matriz.clearScreen();
                    System.out.println("Login efetuado com sucesso, bem vindo ao Jogo da Cerca");
                    /*DOIS OBJETOS DA CLASSE JOGADOR SÃO CRIADOS, POIS ELES QUE 
                    IRÃO INTERAGIR COM O MÉTODO JOGADA*/
                    Jogador jogador1 = new Jogador(loginPlayer1);
                    Jogador jogador2 = new Jogador(loginPlayer2);
//                    MÉTODO QUE IMPRIME A MATRIZ DO JOGO
                    m.imprime();
                    do {
                        do {
                            System.out.print("Turno de "+jogador1.getNome()+":");
                            coo = entrada.next();
                            coordenada = jogador1.jogada(coo);
//                            CASO O VALOR DA COORDENADA SEJA -1 A JOGADA NÃO É VÁLIDA
                            if (coordenada[0] != -1) {
                                linha = coordenada[0];
                                coluna = coordenada[1];
                                existe1 = m.existe(linha, coluna);
                                if (existe1 != true) {
                                    m.insere(linha, coluna);
                                    Matriz.clearScreen();
                                    teste1 = m.pontuacao(jogador1);
                                    m.imprime();
                                    acabou1 = m.confere();
                                } else {
                                    System.out.println("Jogada inválida, por favor tente novamente.");
                                }
                            } else {
                                System.out.println("Jogada inválida, por favor tente novamente.");
                            }
//                            CASO O VALOR DA COORDENADA SEJA -1 A JOGADA NÃO É VÁLIDA
                        } while (coordenada[0] == -1 || teste1 && !acabou1 || existe1);
                        do {
                            if (acabou1 == false) {
                                System.out.print("Turno de "+jogador2.getNome()+":");
                                coo = entrada.next();
                                coordenada = jogador2.jogada(coo);
                                if (coordenada[0] != -1) {
                                    linha = coordenada[0];
                                    coluna = coordenada[1];
                                    existe2 = m.existe(linha, coluna);
                                    if (existe2 != true) {
                                        m.insere(linha, coluna);
                                        Matriz.clearScreen();
                                        teste2 = m.pontuacao(jogador2);
                                        m.imprime();
                                        acabou2 = m.confere();
                                    } else {
                                        System.out.println("Jogada inválida, por favor tente novamente.");
                                    }
                                } else {
                                    System.out.println("Jogada inválida, por favor tente novamente.");
                                }
                            }
//                            CASO O VALOR DA COORDENADA SEJA -1 A JOGADA NÃO É VÁLIDA
                        } while (coordenada[0] == -1 || teste2 && !acabou2 || existe2);

                        /*AS JOGADAS DEVEM CONTINUAR ATÉ QUE NÃO TENHA NENHUMA POSIÇÃO VAZIA NA MATRIZ
                        PRA ISSO O MÉTODO CONFERE*/
                    } while (m.confere() != true);
                    System.out.println("");
                    System.out.println("O jogo chegou ao fim!");
                    System.out.println("");
                    System.out.println(jogador1.getNome()+":"+jogador1.getRanking()+" pontos");
                    System.out.println(jogador2.getNome()+":"+jogador2.getRanking()+" pontos");
                    if(jogador1.getRanking() > jogador2.getRanking()) {
                        System.out.println(jogador1.getNome()+" venceu!");
                        ranki.OrdenarRanking(jogador1);
                    } else {
                        System.out.println(jogador2.getNome()+" venceu!");
                        ranki.OrdenarRanking(jogador2);
                    }
                    break;
                case 3:
                    Matriz.clearScreen();
                    System.out.println("Os melhores serão para sempre lembrados aqui");
                    ranki.exibirRanking();
                    System.out.println("\n\n\n");
                    break;
                case 0:
                    System.out.println("Obrigado por conhecer nosso aplicativo, sinta-se a vontade para voltar :D");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        } while (inicio != 0);
        //Fim de jogo
    }
}
