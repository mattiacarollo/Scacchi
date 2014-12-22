package chess;

import chess.model.LongBackedConfiguration;
import chess.moves.Rules;

public class Evaluator {

	private final static int NUMBER_OF_TESTS = 100;

	public static void main(String[] args) {
		int sum = 0;
		int count = 0;

		long start = System.currentTimeMillis();
		while (count++ < NUMBER_OF_TESTS) {
//			Steps solution = new Solution(new Rules(new LongBackedConfiguration()).randomize(1000)).getSequenceOfSteps();
//			int length = solution.length();
//			sum += length;
//			System.out.println("found solution of length " + length);
		}
		long elapsed = System.currentTimeMillis() - start;
		System.out.println("average solution length: " + ((float) sum / NUMBER_OF_TESTS));
		System.out.println("average time for each solution: " + elapsed / NUMBER_OF_TESTS + "ms");
	}
}