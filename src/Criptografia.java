
import java.util.Scanner;

/*
 * Essa classe cria possui os métodos para criptografar e descriptografar a senha do jogador.
 * O método utilizado foi a cifra de substituição monoalfabética no qual o primeiro vetor possui 
 * o alfabeto maiúsculo, alfabeto minúsculo e numeros de 0 a 9, já o segundo vetor contém o 
 * primeiro vetor embaralhado para realização da substituição
 *
 *
 * @author Adriano
 */
public class Criptografia {

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
    
    public String descriptografar(String senha) {
        String resultado;
        char alfaNum[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'x', 'y', 'z', 'w', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char subst[] = {'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'x', 'y', 'z', 'w', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M'};
        int tamanho = senha.length();
        char cripto[] = new char[tamanho];
        char discripto[] = new char[tamanho];
        for (int i = 0; i < senha.length(); i++) {
            for (int j = 0; j < 61; j++) {
                if (cripto[i] == subst[j]) {
                    discripto[i] = alfaNum[j];
                }
            }
        }
        return senha;
    }
}
