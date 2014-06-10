package ch16_11;

//TODO 後で書き直す。

public class PlayerSmart extends Player {
	public void play(Game game){
		int i = -1;
		char[]board = game.nextHand(-1);
		
		while(board != null){
			int index = -1;
			if((index = checkColumn(board)) != -1){
				board = game.nextHand(index);
			}
			else if((index = checkRow(board)) != -1){
				board = game.nextHand(index);
			}
			else if((index = checkX(board)) != -1){
				board = game.nextHand(index);
			}
			else{
				while(board[++i] != 0){
				}
				board = game.nextHand(i);
			}
		}
	}
	public int checkColumn(char[] board){
		for(int i = 0; i < 3; i++){
			int ct = 0;
			for(int j = 0; j < 3; j++){
				int b = board[i * 3 + j];
				if(b != 0) ct += b;
			}
			if(ct == 8){
				for(int j = 0; j < 3; j++){
					if(board[i * 3 + j] == 0)	return i * 3 + j;	
				}
			}
			if(ct == 2){
				for(int j = 0; j < 3; j++){
					if(board[i * 3 + j] == 0)	return i * 3 + j;	
				}
			}
		}
		return -1;
	}
	
	public int checkRow(char[] board){
		for(int j = 0; j < 3; j++){
			int ct = 0;
			for(int i = 0; i < 3; i++){
				int b = board[i * 3 + j];
				if(b != 0) ct += b;
			}
			if(ct == 8){
				for(int i = 0; i < 3; i++){
					if(board[i * 3 + j] == 0)	return i * 3 + j;	
				}
			}
			if(ct == 2){
				for(int i = 0; i < 3; i++){
					if(board[i * 3 + j] == 0)	return i * 3 + j;	
				}
			}
		}
		return -1;
	}
	
	public int checkX(char[] board){
		// '/'のチェック
		int ct = board[2] + board[4] + board[6];
		if(ct == 8){
			for(int i = 2; i < 9; i += 2){
				if(board[i] == 0)	return i;
			}
		}
		if(ct == 2){
			for(int i = 2; i < 9; i += 2){
				if(board[i] == 0)	return i;
			}
		}
		// '\'のチェック
		ct = board[0] + board[4] + board[8];
		if(ct == 8){
			for(int i = 0; i < 9; i += 4){
				if(board[i] == 0)	return i;
			}
		}
		if(ct == 2){
			for(int i = 0; i < 9; i += 4){
				if(board[i] == 0)	return i;
			}
		}
		return -1;
	}
}