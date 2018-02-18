import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {

	String board[][] = new String[3][3];
	int tries;
/*
	public TicTacToe(){

	}

*/
	public void init(){
		userInput();
	}
	public void userInput() {
		boolean invalid = true;

		while (invalid) {


			String input;
			System.out.println("Enter a coordinate: ");
			Scanner scanner = new Scanner(System.in);
			input = scanner.nextLine(); //potentially fix

			String temp = Character.toString(input.charAt(0));

			int row = -1;
			boolean rowValid = true;
		
			if (temp == "A") {
				row = 0;
			}
			else if (temp == "B") {
				row = 1;
			}
			else if (temp == "C") {
				row = 2;
			}
			else {
				System.out.print("Please try again");
			}

			if (row != -1) {
				rowValid = false;
			}
		
			if (rowValid){
				String temp1 = Character.toString(input.charAt(1));
				int column = Integer.parseInt(temp);
				column = column - 1;

				if(empty(row, column)) {
					if (tries % 2 == 0) {
						board[row][column]="X";
					}
					else {
						board[row][column]="O";
					}
				}

				if (check()) {
					if (tries % 2 == 0) {
						System.out.println("Player X won");
					}
					else {
						System.out.println("Player O won");
					}
				}
			}
		}
		tries ++;
	}

	//check if user won
	public boolean check() {

		if(tries<4) {
			return false;
		}

		else if(board[0][0]==board[0][1] && board[0][1]==board[0][2] || board[1][0]==board[1][1]&&board[1][1]==board[1][2] || board[2][0]==board[2][1]&&board[2][1]==board[2][2] || board[0][0]==board[1][1]&&board[1][1]==board[2][2] || board[0][2]==board[1][1]&&board[1][1]==board[2][0] || board[0][0]==board[1][0]&&board[1][0]==board[2][0] || board[0][1]==board[1][1]&&board[1][1]==board[2][1] || board[0][2]==board[1][2]&&board[1][2]==board[2][2]) {
			return true;
		}
		return false;

	}

	public boolean empty(int row, int column) {
		if (board[row][column]==null) {
			return true;
		}
		else {
			return false;
		}
	}

	public static void main(String[] args) {
		new TicTacToe();
	}
}

