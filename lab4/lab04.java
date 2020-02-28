import java.util.Random;


public class lab04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game my_game = new Game(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]));
		
		my_game.run();
	}

}
