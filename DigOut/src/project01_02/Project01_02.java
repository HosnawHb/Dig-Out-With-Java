package project01_02;

import java.util.Random;
import java.util.Scanner;

public class Project01_02 {
	public static void main(String[] args) {
		game();
	}
	/*
	 * print board function
	 */
	public static String PrintBoard(int l, int w, int c) {
		int e = 0, n = 1, m = 0, sprite;
		String random_string = "", newstring = "0", newstring2 = "0";
		for (int i = 0; i < l; i++) {
			int random_string_length = w; // qarar ddne ye reshte 5 harfi random va zakhire krdnesh
			String[] all_characters = { "#", " ", "@", "#" }; // moshakhas krdne char haye mojaz
			int all_characters_length = all_characters.length; // peyda krdn tule string
			int min = 0;
			int max = all_characters_length - 1;

			for (int x = 1; x < random_string_length + 1; x++) {
				Random r = new Random(); // rand grftn
				int random_number = r.nextInt(max - min + 1) + min;
				String random_character = all_characters[random_number]; // meghdar dehi
				random_string += random_character; // ezafe shodn

			}
			random_string = random_string + "O"; // ezafe krdne yk char braye split

		}
		
		sprite = (l - 1) * (w + 1); // mahale qarar girie sprite
		for (int i = 0; i < c; i++) {
			Random rand = new Random();
			e = 0 + rand.nextInt((l * w - 0) + 1);
			if(random_string.charAt(e)=='O'||e==(l-1)*(w+1))
			{
				e--;
			}
			/*
			 * qrre ddne n seke dr mahale random dr board
			 */
			
			newstring = random_string.substring(0, e) + '$' + random_string.substring(e + 1);
			random_string = newstring;
		}
		/*
		 * qrr ddne sprite
		 */

		newstring2 = newstring.substring(0, sprite) + '!' + newstring.substring(sprite + 1);
		String[] arrOfStr = newstring2.split("O");
		for (String a : arrOfStr)
			System.out.println(a);
		return newstring2;
	}

	/*
	 * dig up function
	 */
	public static String DigUp(String board, int w, int l) {
		int i, k, d;
		String board2 = "";
		String allert = "This digging is not possible!";
		char c;
		for (i = 0; i < board.length(); i++) { // bdst avrdne jaygah sprite
			if (board.charAt(i) == '!') {
				break;
			}
		}
		k = i - (w + 1); // move up
		c = board.charAt(k);
		
		if (board.charAt(k) == 'O' || c != '#') {
			System.out.println(allert);
			return "no";
		}

		else {

			board2 = board.substring(0, k) + '.' + board.substring(k+1); // dig
			if(k> (2*w)+1) {
				d = k - (w + 1); // check agr @ bshd jazebe aml kond
			if (board.charAt(d) == '@') {
				board2 = board.substring(0, d) + '.' + board.substring(d + 1); // dig va emale jazebe
				board = board2;
				board2 = board.substring(0, k) + '@' + board.substring(k + 1);
			}}
			String[] arrOfStr = board2.split("O"); // split
			for (String a : arrOfStr)
				System.out.println(a);
			return board2;
		}

	}

// move up function
	public static String Up(String board, int w, int l) {
		int i, k;
		String board2 = "", board3 = "";
		String allert = "This movement is not possible!";
		for (i = 0; i < board.length(); i++) {
			if (board.charAt(i) == '!') {
				break;
			}
		}
		k = i - (w + 1); // move up
		if (board.charAt(k) == 'O' || board.charAt(k) == '@' || board.charAt(k) == '#') {
			System.out.println(allert);
			return "no";
		} else {
			board2 = board.substring(0, k) + '!' + board.substring(k + 1); // replace ! dr jaye jadid
			board3 = board2.substring(0, i) + '.' + board2.substring(i + 1);
			String[] arrOfStr = board3.split("O");
			for (String a : arrOfStr)
				System.out.println(a);
			return board3;
		}

	}

	public static String DigDown(String board, int w, int l) {
		int i, k;
		String board2 = "";
		String allert = "This digging is not possible!";
		char c;
		for (i = 0; i < board.length(); i++) {
			if (board.charAt(i) == '!') {
				break;
			}
		}
		k = i + (w + 1);
		c = board.charAt(k);
		if (board.charAt(k) == 'O' || c != '#') {
			System.out.println(allert);
			return "no";
		} else {

			board2 = board.substring(0, k) + '.' + board.substring(k + 1);
			String[] arrOfStr = board2.split("O");
			for (String a : arrOfStr)
				System.out.println(a);
			return board2;
		}

	}

	public static String Down(String board, int w, int l) {
		int i, k;
		String board2 = "", board3 = "";
		String allert = "This movement is not possible!";
		for (i = 0; i < board.length(); i++) {
			if (board.charAt(i) == '!') {
				break;
			}
		}
		k = i + (w + 1);
		if (board.charAt(k) == 'O' || board.charAt(k) == '@' || board.charAt(k) == '#') {
			System.out.println(allert);
			return "no";
		}

		else {
			board2 = board.substring(0, k) + '!' + board.substring(k + 1);
			board3 = board2.substring(0, i) + '.' + board2.substring(i + 1);
			String[] arrOfStr = board3.split("O");
			for (String a : arrOfStr)
				System.out.println(a);
			return board3;
		}

	}

	public static String DigRight(String board, int w, int l) {
		int i, k, d;
		String board2 = "";
		String allert = "This digging is not possible!";
		char c;
		for (i = 0; i < board.length(); i++) {
			if (board.charAt(i) == '!') {
				break;
			}
		}
		k = i + 1;
		d = k - (w + 1);
		c = board.charAt(k);
		if (board.charAt(k) == 'O' || c != '#') {
			System.out.println(allert);
			return "no";
		}

		else {

			board2 = board.substring(0, k) + '.' + board.substring(k + 1);
			if(k> (2*w)+1) { //dr lineE yeki mande be akahr char yeki balatar ndrim
				d = k - (w + 1); // check agr @ bshd jazebe aml kond
			if (board.charAt(d) == '@') {
				board2 = board.substring(0, d) + '.' + board.substring(d + 1);
				board = board2;
				board2 = board.substring(0, k) + '@' + board.substring(k + 1);
			}}
			String[] arrOfStr = board2.split("O");
			for (String a : arrOfStr)
				System.out.println(a);
			return board2;
		}

	}

	public static String Right(String board, int w, int l) {
		int i, k;
		String board2 = "", board3 = "";
		String allert = "This movement is not possible!";
		for (i = 0; i < board.length(); i++) {
			if (board.charAt(i) == '!') {
				break;
			}
		}
		k = i + 1;
		if (board.charAt(k) == 'O' || board.charAt(k) == '@' || board.charAt(k) == '#') {
			System.out.println(allert);
			return "no";
		}

		else {
			board2 = board.substring(0, k) + '!' + board.substring(k + 1);
			board3 = board2.substring(0, i) + '.' + board2.substring(i + 1);
			String[] arrOfStr = board3.split("O");
			for (String a : arrOfStr)
				System.out.println(a);
			return board3;
		}

	}

	public static String DigLeft(String board, int w, int l) {
		int i, k, d;
		String board2 = "";
		String allert = "This digging is not possible!";
		char c;
		for (i = 0; i < board.length(); i++) {
			if (board.charAt(i) == '!') {
				break;
			}
		}
		k = i - 1;
		d = k - (w + 1);
		c = board.charAt(k);
		if (board.charAt(k) == 'O' || c != '#') {
			System.out.println(allert);
			return "no";
		}

		else {

			board2 = board.substring(0, k) + '.' + board.substring(k + 1);
			if(k> (2*w)+1) {
				d = k - (w + 1); // check agr @ bshd jazebe aml kond
			if (board.charAt(d) == '@') {
				board2 = board.substring(0, d) + '.' + board.substring(d + 1);
				board = board2;
				board2 = board.substring(0, k) + '@' + board.substring(k + 1);
			}}
			String[] arrOfStr = board2.split("O");
			for (String a : arrOfStr)
				System.out.println(a);
			return board2;
		}

	}

	public static String Left(String board, int w, int l) {
		int i, k;
		String board2 = "", board3 = "";
		String allert = "This movement is not possible!";
		for (i = 0; i < board.length(); i++) {
			if (board.charAt(i) == '!') {
				break;
			}
		}
		k = i - 1;
		if (board.charAt(k) == 'O' || board.charAt(k) == '@' || board.charAt(k) == '#') {
			System.out.println(allert);
			return "no";
		} else {
			board2 = board.substring(0, k) + '!' + board.substring(k + 1);
			board3 = board2.substring(0, i) + '.' + board2.substring(i + 1);
			String[] arrOfStr = board3.split("O");
			for (String a : arrOfStr)
				System.out.println(a);
			return board3;
		}

	}
	public static void game() {
	   String name, board = "", b2 = "", b3 = "";
		int length, width, coins, p = 0, play_again;
		char move;
		System.out.println("Please enter your name: ");
		Scanner scanner = new Scanner(System.in);
		name = scanner.nextLine();
		System.out.println("Please enter two numbers between 4 & 10 for the length: ");
		Scanner scanner1 = new Scanner(System.in);
		length = scanner1.nextInt();
		width = scanner1.nextInt();
		System.out.println("Please enter number of coins: ");
		Scanner scanner2 = new Scanner(System.in);
		coins = scanner2.nextInt();
		board = PrintBoard(length, width, coins);
		Scanner scanner3 = new Scanner(System.in);
		// grftne jahat b onvane input
		while (true) {
			move = scanner3.next().charAt(0);
			if (move == 'u') { // digup
				b2 = DigUp(board, width, length);
				if (b2 == "no") { // dr surate return shodane no az tabe p=1;
					p = 1;
				} else {
					board = b2;
					b2 = "";
					p = 0;
				}
			}

			if (move == 'U') { // moveup
				b3 = Up(board, width, length);
				if (b3 == "no") {
					p = 1;
				} else {
					board = b3;
					b3 = "";
					p = 0;
				}

			}
			if (move == 'd') { // digdown
				b2 = DigDown(board, width, length);
				if (b2 == "no") {
					p = 1;
				} else {
					board = b2;
					b2 = "";
					p = 0;
				}
			}
			if (move == 'D') { // movedown
				b3 = Down(board, width, length);
				if (b3 == "no") {
					p = 1;
				} else {
					board = b3;
					b3 = "";
					p = 0;
				}

			}
			if (move == 'r') { // digright
				b2 = DigRight(board, width, length);
				if (b2 == "no") {
					p = 1;
				} else {
					board = b2;
					b2 = "";
					p = 0;
				}
			}
			if (move == 'R') { // moveright
				b3 = Right(board, width, length);
				if (b3 == "no") {
					p = 1;
				} else {
					board = b3;
					b3 = "";
					p = 0;
				}

			}
			if (move == 'l') { // digleft
				b2 = DigLeft(board, width, length);
				if (b2 == "no") {
					p = 1;
				} else {
					board = b2;
					b2 = "";
					p = 0;
				}
			}
			if (move == 'L') { // moveleft
				b3 = Left(board, width, length);
				if (b3 == "no") {
					p = 1;
				} else {
					board = b3;
					b3 = "";
				}

			}
			if (p == 0 && board.contains("$") == false) {
				System.out.println("YOU WON!");
				break;
			}
			
		}
		if (p == 0 && board.contains("$") == false) {
			System.out.println("Do you wanna play again? If yes enter 1! If not enter 0");
			Scanner scanner4 = new Scanner(System.in);
			play_again = scanner4.nextInt();
			if(play_again==1)
			{
				game();
			}
			if(play_again==0) {
				return;
			}
		}
	}
	
}
