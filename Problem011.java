/*
 * File: Problem 11
 * What is the greatest product of four numbers on the same straight line in the 20 by 20 grid?
 * -----------------------
 */

import acm.program.*;
import java.io.*;
import java.util.*;

public class Problem011 extends ConsoleProgram {

	public void run() {
		try {
			largestProduct = horizontal(new BufferedReader(new FileReader("Number 011.txt")));
			largestProduct = vertical(new BufferedReader(new FileReader("Number 011.txt")));
			largestProduct = forwardDiagonal(new BufferedReader(new FileReader("Number 011.txt")));
			largestProduct = backwardDiagonal(new BufferedReader(new FileReader("Number 011.txt")));
			println("The greatest product of four adjacent numbers in any direction is " + largestProduct);
			println("The product is made of " + number1 + ", " + number2 + ", " + number3 + ", and " + number4 + " and is found " + direction);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	private int horizontal(BufferedReader rd) throws IOException {
		String line = rd.readLine();
		while (line != null) {
			StringTokenizer token = new StringTokenizer(line);
			ArrayList<Integer> ints = new ArrayList<Integer>();
			for (int i = 0; i < 4; i++) {
				ints.add(Integer.parseInt(token.nextToken()));
			}
			if (createProduct(ints) > largestProduct) {
				storeVariables(ints, largestProduct, createProduct(ints));
				direction = "horizontally";
			}
			while (token.hasMoreTokens()) {
				ints.remove(0);
				ints.add(Integer.parseInt(token.nextToken()));
				if (createProduct(ints) > largestProduct) {
					storeVariables(ints, largestProduct, createProduct(ints));
					direction = "horizontally";
				}
			}
			line = rd.readLine();
		}
		return largestProduct;
	}
	
	private int vertical(BufferedReader rd) throws IOException {
		ArrayList<Integer> ints = new ArrayList<Integer>();
		ArrayList<String> lines = new ArrayList<String>();
		ArrayList<StringTokenizer> tokens = new ArrayList<StringTokenizer>();
		for (int i = 0; i < 4; i++) {
			lines.add(rd.readLine());
			tokens.add(new StringTokenizer(lines.get(i)));
			ints.add(Integer.parseInt(tokens.get(i).nextToken()));
		}
		if (createProduct(ints) > largestProduct) {
			storeVariables(ints, largestProduct, createProduct(ints));
			direction = "vertically";
		}
		while (tokens.get(0).hasMoreTokens()) {
			ints.clear();
			for (int i = 0; i < 4; i++) {
				ints.add(Integer.parseInt(tokens.get(i).nextToken()));
			}
			if (createProduct(ints) > largestProduct) {
				storeVariables(ints, largestProduct, createProduct(ints));
				direction = "vertically";
			}
		}
		String line = rd.readLine();
		while (line != null) {
			lines.remove(0);
			lines.add(line);
			tokens.clear();
			for (int i = 0; i < 4; i++) {
				lines.add(rd.readLine());
				tokens.add(new StringTokenizer(lines.get(i)));
			}
			while (tokens.get(0).hasMoreTokens()) {
				ints.clear();
				for (int i = 0; i < 4; i++) {
					ints.add(Integer.parseInt(tokens.get(i).nextToken()));
				}
				if (createProduct(ints) > largestProduct) {
					storeVariables(ints, largestProduct, createProduct(ints));
					direction = "vertically";
				}
			}
			line = rd.readLine();
		}
		return largestProduct;
	}
	
	private int forwardDiagonal(BufferedReader rd) throws IOException {
		ArrayList<Integer> ints = new ArrayList<Integer>();
		ArrayList<String> lines = new ArrayList<String>();
		ArrayList<StringTokenizer> tokens = new ArrayList<StringTokenizer>();
		for (int i = 0; i < 4; i++) {
			lines.add(rd.readLine());
			tokens.add(new StringTokenizer(lines.get(i)));
			for (int j = 0; j < i; j++) {
				tokens.get(i).nextToken();
			}
			ints.add(Integer.parseInt(tokens.get(i).nextToken()));
		}
		if (createProduct(ints) > largestProduct) {
			storeVariables(ints, largestProduct, createProduct(ints));
			direction = "forward diagonally";
		}
		while (tokens.get(3).hasMoreTokens()) {
			ints.clear();
			for (int i = 0; i < 4; i++) {
				ints.add(Integer.parseInt(tokens.get(i).nextToken()));
			}
			if (createProduct(ints) > largestProduct) {
				storeVariables(ints, largestProduct, createProduct(ints));
				direction = "forward diagonally";
			}
		}
		String line = rd.readLine();
		while (line != null) {
			lines.remove(0);
			lines.add(line);
			tokens.clear();
			for (int i = 0; i < 4; i++) {
				tokens.add(new StringTokenizer(lines.get(i)));
			}
			ints.clear();
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < i; j++) {
					tokens.get(i).nextToken();
				}
				ints.add(Integer.parseInt(tokens.get(i).nextToken()));
			}
			while (tokens.get(3).hasMoreTokens()) {
				ints.clear();
				for (int i = 0; i < 4; i++) {
					ints.add(Integer.parseInt(tokens.get(i).nextToken()));
				}
				if (createProduct(ints) > largestProduct) {
					storeVariables(ints, largestProduct, createProduct(ints));
					direction = "forward diagonally";
				}
			}
			line = rd.readLine();
		}
		return largestProduct;
	}
	
	private int backwardDiagonal(BufferedReader rd) throws IOException {
		ArrayList<Integer> ints = new ArrayList<Integer>();
		ArrayList<String> lines = new ArrayList<String>();
		ArrayList<StringTokenizer> tokens = new ArrayList<StringTokenizer>();
		for (int i = 0; i < 4; i++) {
			lines.add(rd.readLine());
			tokens.add(new StringTokenizer(lines.get(i)));
			for (int j = 4; j > i; j--) {
				tokens.get(i).nextToken();
			}
			ints.add(Integer.parseInt(tokens.get(i).nextToken()));
		}
		if (createProduct(ints) > largestProduct) {
			storeVariables(ints, largestProduct, createProduct(ints));
			direction = "forward diagonally";
		}
		while (tokens.get(0).hasMoreTokens()) {
			ints.clear();
			for (int i = 0; i < 4; i++) {
				ints.add(Integer.parseInt(tokens.get(i).nextToken()));
			}
			if (createProduct(ints) > largestProduct) {
				storeVariables(ints, largestProduct, createProduct(ints));
				direction = "backward diagonally";
			}
		}
		String line = rd.readLine();
		while (line != null) {
			lines.remove(0);
			lines.add(line);
			tokens.clear();
			for (int i = 0; i < 4; i++) {
				tokens.add(new StringTokenizer(lines.get(i)));
			}
			ints.clear();
			for (int i = 0; i < 4; i++) {
				for (int j = 4; j > i; j--) {
					tokens.get(i).nextToken();
				}
				ints.add(Integer.parseInt(tokens.get(i).nextToken()));
			}
			while (tokens.get(0).hasMoreTokens()) {
				ints.clear();
				for (int i = 0; i < 4; i++) {
					ints.add(Integer.parseInt(tokens.get(i).nextToken()));
				}
				if (createProduct(ints) > largestProduct) {
					storeVariables(ints, largestProduct, createProduct(ints));
					direction = "backward diagonally";
				}
			}
			line = rd.readLine();
		}
		return largestProduct;
	}
	
	private int createProduct(ArrayList<Integer> ints) {
		int product = 1;
		for (int i = 0; i < ints.size(); i++) {
			product *= ints.get(i);
		}
		return product;
	}
	
	private void storeVariables(ArrayList<Integer> ints, int product, int temp) {
		largestProduct = temp;
		number1 = ints.get(0);
		number2 = ints.get(1);
		number3 = ints.get(2);
		number4 = ints.get(3);
	}
	
	private int largestProduct = 1;
	private int number1;
	private int number2;
	private int number3;
	private int number4;
	private String direction;
 }