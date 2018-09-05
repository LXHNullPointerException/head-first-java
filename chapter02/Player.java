class Player{
	int guessNumber = 0;

	int guess(){
		this.guessNumber = (int) (Math.random() * 10);
		System.out.println("I am guessing the number :" + guessNumber);
		return this.guessNumber;
	}
}
