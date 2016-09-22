/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ranking {

    public static Ranking rank = new Ranking();

    //Método mara ordenar o vetor de jogadores
    void ordenacao(Jogador[] vet, int cont) {
        Jogador aux = new Jogador();
        for (int i = 0; i < cont; i++) {
            for (int j = i + 1; j < cont; j++) {
                if (vet[i] != null) {
                    if (vet[i].ranking < vet[j].ranking) {
                        aux = vet[i];
                        vet[i] = vet[j];
                        vet[j] = aux;
                    }
                }
            }
        }
    }

    //Método que le o arquivo salva os jogadores em um vetor, ordena e escreve o ranking
    void OrdenarRanking(Jogador player1) {

        Jogador[] vetRanking = new Jogador[11];
        int cont = 0;

        File diretorio = new File("Arquivos Jogador");
        if (!diretorio.exists()) {
            diretorio.mkdir();
        }
        File arquivo = new File("Arquivos Jogador/Ranking.txt");
        if (!arquivo.exists()) {
            try {
                arquivo.createNewFile();
            } catch (IOException ex) {
                System.out.println("Erro na leitura");
            }
        }

        try {
            FileReader leitura = new FileReader(arquivo);
            BufferedReader leitura_buff = new BufferedReader(leitura);
            String linha = leitura_buff.readLine();
            if (linha != null) {
                while (linha != null) {
                    if ((!linha.isEmpty()) && (cont < 10)) {
                        Jogador user = new Jogador();
                        String[] line = linha.split(":");
                        user.nome = line[0];
                        user.ranking = Integer.parseInt(line[1]);
                        vetRanking[cont] = user;
                        cont++;
                    }
                    linha = leitura_buff.readLine();
                } //para quando a linha for igual a null
            }
        } catch (IOException ex) {
            System.out.println("Erro na leitura");
        }

        //condição para escrever o primeiro jogador do ranking se o arquivo estiver vazio
        if (cont == 0) {
            vetRanking[0] = player1;
            //cont++;
        } else {
            vetRanking[cont] = player1;//Adição do novo jogador campeão para o ranking para comparação com os demais
            cont++;
            rank.ordenacao(vetRanking, cont);///ordenação do vetor com a chamada do método
        }

        try {
            //objeto que faz interação com o arquivo, o parametro é para que seja possível
            FileWriter arquivoEscreva = new FileWriter(arquivo);
            //objeto que faz a escrita no arquivo
            BufferedWriter escreva = new BufferedWriter(arquivoEscreva);

            if (cont == 0) {
                escreva.write(vetRanking[cont].nome + ":" + vetRanking[cont].ranking);
            } else if (cont <= 10) {
                for (int i = 0; i < cont; i++) {
                    if (vetRanking[i] != null) {
                        escreva.write(vetRanking[i].nome + ":" + vetRanking[i].ranking);
                        escreva.newLine();
                    }
                }
            } else if (cont > 10) {
                for (int i = 0; i < cont - 1; i++) {
                    if (vetRanking[i] != null) {
                        escreva.write(vetRanking[i].nome + ":" + vetRanking[i].ranking);
                        escreva.newLine();
                    }
                }
            }
            escreva.close();
            arquivoEscreva.close();
        } catch (IOException ex) {
            System.out.println("Falha na escrita do Arquivo");
        }
    }

    void exibirRanking() {

        File diretorio = new File("Arquivos Jogador");
        if (!diretorio.exists()) {
            diretorio.mkdir();
        }
        File arquivo = new File("Arquivos Jogador/Ranking.txt");
        if (!arquivo.exists()) {
            try {
                arquivo.createNewFile();
            } catch (IOException ex) {
                System.out.println("Erro na leitura");
            }
        }

        try {
            FileReader leitura = new FileReader(arquivo);
            BufferedReader leitura_buff = new BufferedReader(leitura);
            String linha = leitura_buff.readLine();
            while (linha != null) {
                System.out.println(linha);
                linha = leitura_buff.readLine();
            }

            //para quando a linha for igual a null
        } catch (IOException ex) {
            System.out.println("Erro na leitura");
        }

    }
}
