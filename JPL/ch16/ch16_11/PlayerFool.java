package ch16_11;

public class PlayerFool extends Player {

	public void play(Game game){
		int i = -1;
		char[]board = game.nextHand(-1);
		while(board != null){
			while(board[++i] != 0){
			}
			board = game.nextHand(i);
		}
	}
}