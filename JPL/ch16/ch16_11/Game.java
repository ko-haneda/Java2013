package ch16_11;

import java.util.*;

/*ゲームの詳細（○×ゲームの実装）はこのクラス内で行う*/
/*Playerクラスは戦略のみを記載すべきである。*/
public class Game {
	private Random rnd;
	private char[] board = null; 
	private static int score = 0;
	private static PriorityQueue<String> que = new PriorityQueue<String>(); 
	private static final int TRIAL = 5000;
	private final boolean logFLAG = false;
	
	Game(){
		board = new char[9];
		rnd = new Random();
	}
	
	public static void main(String[] args) {
		for(String arg : args){
			que.add(arg);
		}
		System.out.println("試合数" + TRIAL + ": win +1pt, drow 0pt, lose -1pt");
		String name;
		while ((name = getNextPlayer()) != null) {
			score = 0;
			try {
				Game game = null;
				for(int i = 0; i < TRIAL; i++){
					PlayerLoader loader = new PlayerLoader();
					Class<? extends Player> classOf = loader.loadClass("ch16_11." + name).asSubclass(Player.class);
					Player player = classOf.newInstance();
					game = new Game();
					player.play(game);
				}
				game.reportScore(name);
			} catch (Exception e) {
				reportException(name, e);
			}
		}
	}
	
	// ゲームのスコアを出力する
	public void reportScore(String name){
		System.out.println(name + "のスコア : " + score + "pt");
	}
	
	// ゲーム中に起きたエラーの詳細を出力する
	private static void reportException(String name, Exception e){
		System.err.println(name + "中にエラーが発生しました。");
		System.err.println(e.getMessage());
	}
	
	//戦略を取得する。
	//（本文中の言葉を用いるならば、）戦略をメールで受け取る。
	public static String getNextPlayer(){
		try{
			return que.poll();
		} catch(EmptyStackException e){
			return null;
		}
	}
	
	//TODO　マジックナンバーは使わない　enumを使用する
	public char[] nextHand(int index){
		int hand;
		if(index >= 0) board[index] = 4;	//自分自身の手を4とする
		if(finGame()) return null;
		do{
			hand = rnd.nextInt(9);
		}while(board[hand] != 0);
		board[hand] = 1;	//COMの手を１とする。
		if(finGame()) return null;
		return board;
	}
	
	public boolean win(char p){
		if((board[0] == p && board[1] == p && board[2] == p) ||
		   (board[3] == p && board[4] == p && board[5] == p) ||
		   (board[6] == p && board[7] == p && board[8] == p) ||
		   (board[0] == p && board[3] == p && board[6] == p) ||
		   (board[1] == p && board[4] == p && board[7] == p) ||
		   (board[2] == p && board[5] == p && board[8] == p) ||
		   (board[0] == p && board[4] == p && board[8] == p) ||
		   (board[2] == p && board[4] == p && board[6] == p)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean isDrow(){
		for(char b : board){
			if(b == 0) return false;
		}
		return true;
	}
	
	public boolean finGame(){
		if(logFLAG)	log();
		if(win((char)1)){
			score--;
			return true;
		}
		if(win((char)4)){
			score++;
			return true;
		}
		if(isDrow()){
			return true;
		}
		return false;
	}
	
	public void log(){
		for(int i = 0; i < 3; i++){
			if(i != 0)	System.out.println("-------");
			for(int j = 0; j < 3; j++){
				char c = board[i * 3 + j];
				if(c == 1)	System.out.print("|o");
				if(c == 4)	System.out.print("|x");
				if(c == 0)	System.out.print("| ");
			}
			System.out.println("|");
		}
		System.out.println();
		System.out.println();
	}
	
}