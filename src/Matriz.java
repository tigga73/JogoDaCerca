

/**Classe que possui os tabuleiros do jogo, 
 * e os métodos de verificação dela
 *
 * @author Tiago
 */
public class Matriz {

    /**Matriz principal do jogo, na qual são realizadas as jogadas
     * 
     */
    private String[][] m = {
        {"+", "1", "+", "2", "+", "3", "+", "4"},
        {"a", "o", " ", "o", " ", "o", " ", "o"},
        {"+", " ", " ", " ", " ", " ", " ", " "},
        {"b", "o", " ", "o", " ", "o", " ", "o"},
        {"+", " ", " ", " ", " ", " ", " ", " "},
        {"c", "o", " ", "o", " ", "o", " ", "o"},
        {"+", " ", " ", " ", " ", " ", " ", " "},
        {"d", "o", " ", "o", " ", "o", " ", "o"}
    };

    /**Matriz utilizada para resetar o jogo
     * 
     */
    public String[][] m1 = {
        {"+", "1", "+", "2", "+", "3", "+", "4"},
        {"a", "o", " ", "o", " ", "o", " ", "o"},
        {"+", " ", " ", " ", " ", " ", " ", " "},
        {"b", "o", " ", "o", " ", "o", " ", "o"},
        {"+", " ", " ", " ", " ", " ", " ", " "},
        {"c", "o", " ", "o", " ", "o", " ", "o"},
        {"+", " ", " ", " ", " ", " ", " ", " "},
        {"d", "o", " ", "o", " ", "o", " ", "o"}
    };

    
    /**Método utilizado para imprimir a matriz na tela
     * 
     */
    public void imprime() {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j].equals("+")) {
                    System.out.print("  ");
                } else {
                    System.out.print(m[i][j] + " ");
                }
            }
            System.out.println(" ");
        }
    }

    /**Método que confere se a matriz está completa
     * 
     * @return 
     */
    public boolean confere() {
        int cont = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (m[i][j].equals(" ")) {
                    cont++;
                }
            }
        }
        if (cont > 0) {
            return false;
        } else {
            return true;
        }
    }

    /**MÉTODO QUE INSERE AS JOGADAS NA MATRIZ BASEADO NOS PONTOS QUE SÃO EXTRAÍDOS DO MÉTODO JOGADA
     * 
     * @param i
     * @param j 
     */
    public void insere(int i, int j) {
        if (j % 2 != 0) {
            m[i][j] = "|";
        } else {
            m[i][j] = "-";
        }
    }

    /**Método que confere se a cordenada já foi jogada  
     * 
     * @param i
     * @param j
     * @return 
     */
    public boolean existe(int i, int j) {
        return m[i][j].equals("-") || m[i][j].equals("|");
    }

   /**MÉTODO QUE CONFERE SE UM QUADRADO FOI FECHADA E COLOCA A PRIMEIRA LETRA DO JOGADOR 
    *DENTRO DO QUADRADO PRA MARCAR PONTO,UTILIZA RECURSIVIDADE PARA REALIZAR A VERIFICAÇÃO
    * DA PONTUAÇÃO EM OUTROS QUADRANTES DA MATRIZ
    * 
    * @param jogador
    * @return 
    */
    public boolean pontuacao(Jogador jogador) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j].equals("-")) {
                    if (i == 1 || i == 3 || i == 5) {
                        if (m[i + 2][j].equals("-") && m[i + 1][j - 1].equals("|") && m[i + 1][j + 1].equals("|")) {
                            String nome = jogador.getNome();
                            char letra = nome.charAt(0);
                            if (m[i + 1][j].equals(" ")) {
                                m[i + 1][j] = Character.toString(letra);
                                jogador.setRanking(10);
                                System.out.println(jogador.getNome() + " recebe +10 pontos e pode jogar novamente");
//                                RECURSIVIDADE
                                pontuacao(jogador);
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /**Método que realiza a limpeza da tela do console no windows 
     * 
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**Método que reseta a matriz do jogo, para uma nova partida
     * 
     */
    public void reset() {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = m1[i][j];
            }
        }
    }
}
