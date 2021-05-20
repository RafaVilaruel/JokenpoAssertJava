package jokenpoJavaLite;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class JokenpoJava{		
	
	public static void main(String[] args) {	
			
	//  Assert Tests, used to build the application. Test first, code later!!		
				//  All tests were written FIRST, before i wrote a single line of code.
				//	Due to tests, calculating became easy.	
				//	The hands became Poker, where the higher hand wins!
				//  Read testBattery() for more info.
			
				//testBattery(); Comentando os testes.
				
				// 	Testes Assert usados para criar o game. Teste primeiro, escreva dps!!
				//	Todos foram escritos PRIMEIRO, antes de eu escrever 1 linha de código.
				// 	Devido aos testes, a lógica ficou fácil.		
				// 	As mãos praticamente viraram Poker, onde a maior mão vence!
				// 	Leia o testBattery() para mais info.
				//ass
				
					
				Scanner scanner = new Scanner(System.in);
				
				// 	Draw the interface
				//	Desenhar a interface
				userInterface();
																	
				//	Math to match Ints used for tests logic + random move generator
				//	Lógica para dar match nos Ints (testes) + meu movimento aleatório
				int userChosen = scanner.nextInt()*-1;
				int pcChosen = (int) (Math.random()*-3);
				scanner.close();
					
				//	what-if scenarios rock/paper
				//	returns boolean and turns paper into newPaper
				//	checks user input
				  
				//  E-SE dos cenários pedra/papel
				// 	retorna boolean e transforma o paper no newPaper
				//  checa o input do usuário
				if (checkHands3(userChosen)) {
					System.out.println("Você estragou tudo...Escolha 1 das opções!!!");
					System.out.println("Desligando o jogo.");
					System.exit(0);}												
				if (checkHands(userChosen,pcChosen)) {
					userChosen = newPaper;}			
				if (checkHands2(userChosen,pcChosen)) {
					pcChosen = newPaper;}
					
				//	PC dialogue
				//  Diálogo da Máquina
				pcDialogue(pcChosen);
			
				//	sort and show game results to the user
				//  ajeita e mostra os resultados do jogo para o usuário
				showResults(userChosen,pcChosen);
			
		}
	
	
	private static void testBattery() {
		
/*	rock > scissors > paper > rock > scissors..
 
				   > -1 >(Scissors)
			      /      \
			     /        \     
	     (Rock) 0 <------ -2 || 3 (Paper/NewPaper)		     		     

   If its a rock/paper situation, paper == newPaper(3) 
   so that the assert (Paper > Rock), pass.  
  
   ------------------------------------------------------ 
   Notice how all tests down below are basically someone 
   explaining how jokenpo works for somebody else.   
   ------------------------------------------------------
   
   >>>> ~Create tests, then start coding to make them pass. */
		
// -----------------------------------------------------------------------------//
		
		assert rock > scissors;  //rock wins against scissors  (pedra vence tesoura)
		assert rock < newPaper;  //and loses to paper          (e perde para o papel)
		 
		assert scissors > paper; //scissors wins against paper (tesoura vence o papel)
		assert scissors < rock;  //but loses to rock 		   (mas perde para pedra)
		
		assert newPaper > rock;  //paper wins against rock     (papel vence da pedra)
		assert paper < scissors; //but loses to scissors       (mas perde para tesoura)
		
		// a draw? (rock == rock), showResults() prints a draw message.
		// Um empate? (pedra == pedra), showResults() printa uma mensagem de empate.	
		
// ---------------------------------------------------------------------------- //	
		
/*	pedra > tesoura > papel > pedra > tesoura...
		 
		       > -1 >(Tesoura)
	      	  /      \
	     	 /        \     
	(Pedra) 0 <------ -2 || 3 (Paper/NewPaper)		     		     

	Se for uma situação de pedra/papel, o paper == newPaper(3), 
	para que o teste (Paper>Rock) dê bandeira verde.
-------------------------------------------------------------------------- 
	Perceba como todos os testes acima são basicamente como se uma 
	pessoa fosse explicar como o jogo de Jokenpô funciona, para outra pessoa...
---------------------------------------------------------------------------

>>>> ~Crie testes primeiro, veja-os falhar, depois code para que eles passem!!
*/		
		
	}
	
	public static int paper = -2;
	public static int scissors = -1;		
	public static int rock = 0;
	public static int newPaper = 3;

	public static boolean checkHands2(int userChosen, int pcChosen) {
		return userChosen == rock && pcChosen == paper;		
	}


	public static boolean checkHands(int userChosen, int pcChosen) {
		return userChosen == paper && pcChosen == rock;
		
	}
	
	//static boolean b = false;
	
	public static boolean checkHands3(int userChosen) {
		boolean b = true;
		if (userChosen == -2 || userChosen == -1 || userChosen == 0 || userChosen == 3 ) {		
			b = false;
		} else {b = true;}
		
		return b;	
		
		
	}
	
	public static void userInterface(){
		System.out.println("======================================================");
		System.out.println("             Jokenpô!!!");
		System.out.println();
		System.out.println("Digite '0' para Pedra, '1' para Tesoura ou '2' para Papel!");
		System.out.println();
		System.out.println("Irei escolher meu movimento aleatóriamente. Boa sorte!!!");
		System.out.println("======================================================");
	}
	
public static String sortResults(int move) {
		
		String moves = null;
		
		switch (move) {
		case 0:
			moves = "Pedra";
		break;
		
		case -1:
			moves = "Tesoura";
		break;

		case -2:
			moves = "Papel";
		break;
		
		case 3:
			moves = "Papel";
		break;			
		
		}
		
		return moves;}
	
	public static void pcDialogue(int pcChosen) {
		
		String p2 = sortResults(pcChosen);
		
		System.out.println("Vamos lá! Jô..Ken..PÔ!!!");
		try {TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e2) {e2.printStackTrace();}
		
		System.out.println();
		System.out.print("Eu escolho...");
		
		try {TimeUnit.SECONDS.sleep(3);} 
		catch (InterruptedException e1) {e1.printStackTrace();}
		
		System.out.print("hm...");
		try {TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {e.printStackTrace();}
		
		System.out.println(p2+"!");		
		try {TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {e.printStackTrace();}
	}
	
public static void showResults(int userChosen, int pcChosen) {
		
		//sort results into strings so we can show the moves used, instead of -2/-1/0
		String p1 = "sua "+sortResults(userChosen);
		String p2 = "minha "+sortResults(pcChosen);			
			
		
		if (p1.equals("sua Papel")) {
			p1 = "seu Papel";
		}
		
		if (p2.equals("minha Papel")) {
			p2 = "meu Papel";
		}
		
		// calculate and show results
		if (userChosen > pcChosen) {
			System.out.println();
			System.out.println("Você Venceu! "+p1+" venceu "+p2+"...");
			try {TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {e.printStackTrace();}
			}				
			
			
		 if (userChosen == pcChosen) {
			 System.out.println();
			 System.out.println("Empatamos! "+p2+" empatou com "+p1+".");
			 try {TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {e.printStackTrace();}
			 }
			
		
		if (userChosen < pcChosen){
			System.out.println();
			System.out.println("Você Perdeu, Haha! "+p2+" venceu da "+p1+"!");
			try {TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {e.printStackTrace();}
		}
		
		
		
	}

	


}
