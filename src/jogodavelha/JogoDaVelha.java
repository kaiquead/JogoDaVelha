import java.util.Scanner;

public class JogoDaVelha{
  public static void main (String args[]){
    //variaveis
    Scanner entrada = new Scanner (System.in);
    int jogador=0;
    int num1, num2;
    char matriz [][] = {{' ',' ',' '}, {' ',' ',' '}, {' ',' ',' '}};
    
    //mensagem inicial e impress�o do tabuleiro vazio
    System.out.println("Bem vindos ao Jogo da Velha!");
    ImprimeMatriz(matriz);
    
    //loop principal do jogo
    while(VerificaCheio(matriz) != true){
      if(jogador == 0)
        System.out.println("Vez do jogador = O");
      else
        System.out.println("Vez do jogador = X");
      
      System.out.println("Digite primeiro o  numero da linha e depois da coluna (EX: 0 2)");
      num1 = entrada.nextInt();      
      num2 = entrada.nextInt();
      
      if (InsereNaMatriz(matriz, num1, num2, jogador) == false){
        System.out.println("Essa posi��o � inv�lida. Escolha outra posi��o.");
        ImprimeMatriz(matriz);
      }
      else{
      ImprimeMatriz(matriz);
      jogador = InverteJogador (jogador);
      }
      if(CondicaoVitoria(matriz)==0){
        System.out.println("Jogador O ganhou");
        return;
      }
      if(CondicaoVitoria(matriz)==1){
        System.out.println("Jogador X ganhou");
        return;
      }
    }
    System.out.println("Deu velha!!!");
  }
  public static void ImprimeMatriz(char matriz[][]){
    for (int i=0; i<matriz.length; i++){
      for (int j=0; j<matriz[0].length; j++){
        if(j == 0 || j== 1)
          System.out.print(matriz[i][j] + "|");
        else
          System.out.print(matriz[i][j]);
      }
      System.out.println();
    }
  }
  
  public static int InverteJogador(int jogador){
    if(jogador == 0)
      return 1;
    else
      return 0;
  }
  
  public static boolean VerificaCheio(char matriz[][]){
    int cont = 0;
    for (int i=0; i<matriz.length; i++){
      for (int j=0; j<matriz[0].length; j++){
        if(matriz[i][j] == 'X' || matriz[i][j] == 'O')
          cont++;
          if(cont ==9)
            return true;
      }   
    }
   return false;
  }
  
  public static boolean InsereNaMatriz(char matriz[][], int num1, int num2, int jogador){
    //checagem para n�o tentar inserir em posi��es inv�lidas
    if(num1 > 2 || num1 < 0 || num2 > 2 || num2 < 0)
      return false;
    
    for (int i=0; i<matriz.length; i++){
      for (int j=0; j<matriz[0].length; j++){
        if(i == num1 && j == num2){
          if(matriz[i][j] == 'X' || matriz[i][j] == 'O'){
             return false;
          }
          if(jogador == 0)
            matriz[i][j] = 'O';
          else
            matriz[i][j] = 'X';
      }   
    }
    
  }
  return true;
}
  
  public static int CondicaoVitoria(char matriz[][]){
    int cont=0;
    int cont1=0;
    //esse for checa a condicao de vitoria nas horizontais
    for (int i=0; i<matriz.length; i++){
      cont = 0;
      cont1= 0;
      for (int j=0; j<matriz.length; j++){
        if(matriz[i][j]=='O'){
          cont++;
        }
        if(matriz[i][j]=='X')
          cont1++;
        if(cont==3)
          return 0;
        if(cont1==3)
          return 1;
      }
    }
    //esse for checa a condicao de vitoria nas verticais
    for (int i=0; i<matriz.length; i++){
      cont = 0;
      cont1= 0;
      for (int j=0; j<matriz.length; j++){
        if(matriz[j][i]=='O')
          cont++;
        if(matriz[j][i]=='X')
          cont1++;
        if(cont==3)
          return 0;
        if(cont1==3)
          return 1;
      }
    }
    
    //esse for checa a condicao de vitoria da primeira vertical
    for (int i=0; i<matriz.length; i++){
      cont = 0;
      cont1= 0;
      for (int j=0; j<matriz.length; j++){
        if(matriz[i][j]=='O')
          cont++;
        if(matriz[i][j]=='X')
          cont1++;
        if(cont==3)
          return 0;
        if(cont1==3)
          return 1;
        i++;
      }
    }
    
    //esse for checa a condicao de vitoria da segunda vertical
    for (int i=0; i<matriz.length; i++){
      cont = 0;
      cont1= 0;
      for (int j=2; j>=0; j--){
        if(matriz[i][j]=='O')
          cont++;
        if(matriz[i][j]=='X')
          cont1++;
        if(cont==3)
          return 0;
        if(cont1==3)
          return 1;
        i++;
      }
    }
    
    return -1;
  }
}