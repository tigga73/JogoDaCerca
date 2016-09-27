

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**Classe que manipula o arquivo de texto com a escrita do cadastro 
 * e leitura do arquivo para verificação no login
 *
 * @author Adriano, Tiago
 */

public class ManipularArquivo {
    
    /**Método que recebe o nome e a senha do jogador cadastrado no jogo
     * e escreve os dados no arquivo 
     * 
     * @param nome
     * @param senha 
     */
    
    public void cadastro(String nome, String senha) {
        //objeto que cria o diretório do arquivo
        File diretorio = new File("Arquivos Jogador");
        //verificação se o diretório já esta criado
        if (!diretorio.exists()) {
            diretorio.mkdir();
        }
        //objeto que cria o arquivo dentro do diretório
        File arquivo = new File("Arquivos Jogador/Jogadores.txt");
        //verificação se o arquivo já esta criado
        if (!arquivo.exists()) {
            try {
                arquivo.createNewFile();
            } catch (IOException ex) {

            }
        }
        try {
            //objeto que faz interação com o arquivo, o parametro é para que seja possível
            //continuar escrevendo no arquivo
            Criptografia c = new Criptografia();
            FileWriter arquivoEscreva = new FileWriter(arquivo, true);
            //objeto que faz a escrita no arquivo
            BufferedWriter escreva = new BufferedWriter(arquivoEscreva);
            
            senha = c.criptografar(senha);
            escreva.write(nome+":"+senha);
            escreva.newLine();

            escreva.close();
            arquivoEscreva.close();

        } catch (IOException ex) {
            System.out.println("Falha na escrita do nome");
        }
    }
    
    /**Método que efetua a leitura do arquivo para verificação de login
     * e retorna um boolean para o jogo indicando que o login foi validado 
     * ou não foi validado
     * 
     * @param nome
     * @param senha
     * @return Boolean  
     */
    
    public boolean login(String nome, String senha) {
        Criptografia criptografa = new Criptografia();
        File diretorio = new File("Arquivos Jogador");
        if (!diretorio.exists()) {
            diretorio.mkdir();
        }
        File arquivo = new File("Arquivos Jogador/Jogadores.txt");
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
            //aqui a senha recebida é criptografada para comparar com a senha já criptografada do arquivo
            String senha2 = criptografa.criptografar(senha);
            do {
                String[] user = linha.split(":");
                if(user[0].equals(nome) && user[1].equals(senha2)) {
                    return true;
                }
                linha = leitura_buff.readLine();
            } while (linha != null);//a leitura acontece até o resultado da linha for igual ao recebido pelo método
                                    //ou a linha ser igual a null
        } catch (IOException ex) {

        }
        return false;
    }
}
