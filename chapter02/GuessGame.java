class GuessGame{
	Player p1;
	Player p2;
	Player p3;

	void startGame(){
		p1 = new Player();
		p2 = new Player();
		p3 = new Player();

		int guessNumberP1;
		int guessNumberP2;
		int guessNumberP3;

		boolean guessP1Result = false;
		boolean guessP2Result = false;
		boolean guessP3Result = false;
	
		int targetNumber = (int) (Math.random() * 10);
		System.out.println("I am producing a number between 0 to 9:" + targetNumber);

		while(true){
			guessNumberP1 = p1.guess();
			guessNumberP2 = p2.guess();
			guessNumberP3 = p3.guess();
			
			if(targetNumber == guessNumberP1){
				guessP1Result = true;	
			}
			if(targetNumber == guessNumberP2){
				guessP2Result = true;
			}
			if(targetNumber == guessNumberP3){
				guessP3Result = true;
			}

			if(guessP1Result || guessP2Result || guessP3Result){
				System.out.println("we have a winner!");
				System.out.println("player1 guess right?"+guessP1Result);
				System.out.println("player2 guess right?"+guessP2Result);
				System.out.println("player3 guess right?"+guessP3Result);
				break;
			} else {
				System.out.println("try to guess again!");
			}
		}
	}
}
