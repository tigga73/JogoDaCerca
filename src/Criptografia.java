
import java.util.Scanner;

/**
 * Essa classe cria possui o métodos para criptografar a senha do jogador, para
 * ser salva com mais segurança no arquivo.
 *
 * @author Adriano
 */
public class Criptografia {

    /**
     * Esté método tem a função de criptografar a senha que recebe como
     * parametro, por meio de um método de substituição monoalfabética
     *
     * @param senha
     * @return resultado
     */
    public String criptografar(String senha) {
        int i, j;
        String resultado;

        char senhaVetor[] = senha.toCharArray();
        char alfaNum[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'x', 'y', 'z', 'w', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char subst[] = {'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'x', 'y', 'z', 'w', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M'};
        int tamanho = senha.length(); //recebe o tamanho da senha para criação do vetor de criptografia
        char cripto[] = new char[tamanho];// criação do vetor de criptografia com o tamanho da senha
        char discripto[] = new char[tamanho];
        for (i = 0; i < senha.length(); i++) {  ///Estrutura para realização da criptografia
            for (j = 0; j < 61; j++) {
                if (senhaVetor[i] == alfaNum[j]) {  //Condicional para verificar se a letra da senha esta no vetor 
                    cripto[i] = subst[j];
                }
            }
        }
        resultado = new String(cripto);  //Conversão do vetor criptografado para String para ser escrito no arquivo
        return resultado; //Saída do método é o resultado da criptografia da senha
    }

}
