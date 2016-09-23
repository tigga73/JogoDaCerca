
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author MARDOM
 */
public class Jogador {

    String nome;
    int ranking = 0;

//    CONSTRUTOR INICIALIZA UM JOGADOR SOMENTO COM O NOME
    public Jogador(String nome) {
        this.nome = nome;
    }

    Jogador() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNome() {
        return nome;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking += ranking;
    }

    /*ESTE MÉTODO RETORNA UM VETOR DE 2 POSIÇÕES QUE CONTÉM A LINHA E A COLUNA 
    PASSADA PELO JOGADOR NA APLICAÇÃO*/
    public int[] jogada(String coo) {
        boolean split = false;
        char[] traco = {'-'};
        String[] parts;
        String coo1 = "";
        String coo2 = "";
        int[] coordenada = new int[2];
        int[] coordenadaFalha = new int[1];
//        VERIFICA SE  EXISTE UM TRAÇO NA COORDENADA PASSADA
        for (int i = 0; i < coo.length(); i++) {
//            SE O TRAÇO EXISTIR É DADO SPLIT NA COORDENADA PASSADA
            if (coo.charAt(i) == traco[0]) {
                parts = coo.split("-");
                coo1 = parts[0];
                coo2 = parts[1];
                split = true;
            }
        }
//        SE O TRAÇO NÃO EXISTIR É RETORNADO -1 PARA À APLICAÇÃO
        if (!split) {
            coordenadaFalha[0] = -1;
            return coordenadaFalha;
        }

        String linha1 = coo1.substring(0, 1);
        String coluna1 = coo1.substring(1);
        String linha2 = coo2.substring(0, 1);
        String coluna2 = coo2.substring(1);

        boolean teste = true;

        int linhaInt1 = 0;
        switch (linha1) {
            case "a":
                linhaInt1 = 1;
                break;
            case "b":
                linhaInt1 = 3;
                break;
            case "c":
                linhaInt1 = 5;
                break;
            case "d":
                linhaInt1 = 7;
                break;
            default:
                teste = false;
                break;
        }
        int colunaInt1 = 0;
        switch (coluna1) {
            case "1":
                colunaInt1 = 1;
                break;
            case "2":
                colunaInt1 = 3;
                break;
            case "3":
                colunaInt1 = 5;
                break;
            case "4":
                colunaInt1 = 7;
                break;
            default:
                teste = false;
                break;
        }
        int linhaInt2 = 0;
        switch (linha2) {
            case "a":
                linhaInt2 = 1;
                break;
            case "b":
                linhaInt2 = 3;
                break;
            case "c":
                linhaInt2 = 5;
                break;
            case "d":
                linhaInt2 = 7;
                break;
            default:
                teste = false;
                break;
        }
        int colunaInt2 = 0;
        switch (coluna2) {
            case "1":
                colunaInt2 = 1;
                break;
            case "2":
                colunaInt2 = 3;
                break;
            case "3":
                colunaInt2 = 5;
                break;
            case "4":
                colunaInt2 = 7;
                break;
            default:
                teste = false;
                break;
        }
//        AQUI É VERIFICADA A POSIÇÃO DO MEIO (EX: LINHA2 - LINHA1, O RESULTADO DISSO É ONDE SE DEVE INSERIR A JOGADA)
        if (teste == true) {
            int linhaJogada = linhaInt2 - linhaInt1;

            int colunaJogada = colunaInt2 - colunaInt1;

            if (linhaJogada == colunaJogada) {
                coordenadaFalha[0] = -1;
                return coordenadaFalha;
            }

            if (linhaInt2 - linhaInt1 == 0) {
                linhaJogada = linhaInt1;
            }
            if (linhaInt1 == 1 && linhaInt2 == 3) {
                linhaJogada = 2;
            }
            if (linhaInt1 == 3 && linhaInt2 == 5) {
                linhaJogada = 4;
            }
            if (linhaInt1 == 5 && linhaInt2 == 7) {
                linhaJogada = 6;
            }
            if (linhaInt2 - linhaInt1 > 2 || linhaInt2 - linhaInt1 < 0) {
                coordenadaFalha[0] = -1;
                return coordenadaFalha;
            }
            if (colunaInt2 - colunaInt1 == 0) {
                colunaJogada = colunaInt1;
            }
            if (colunaInt1 == 1 && colunaInt2 == 3) {
                colunaJogada = 2;
            }
            if (colunaInt1 == 3 && colunaInt2 == 5) {
                colunaJogada = 4;
            }
            if (colunaInt1 == 5 && colunaInt2 == 7) {
                colunaJogada = 6;
            }
            if (colunaInt2 - colunaInt1 > 2 || colunaInt2 - colunaInt1 < 0) {
                coordenadaFalha[0] = -1;
                return coordenadaFalha;
            }
            coordenada[0] = linhaJogada;
            coordenada[1] = colunaJogada;
            return coordenada;
        }
//        CASO SEJA RETORNADO -1 A JOGADA IRÁ FALHAR NA APLICAÇÃO
        coordenadaFalha[0] = -1;
        return coordenadaFalha;
    }
}
