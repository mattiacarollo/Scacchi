package chess.moves;

import java.util.Iterator;

import chess.moves.Rules;
import chess.model.Configuration;

public class Rules {
	private final Configuration configuration;

	public Rules(Configuration configuration) {
		this.configuration = configuration;
	}

	//servirà per controllare se la partita è vinta da qualcuno (es. scacco matto, ecc..)
	public boolean isSolved() {
//		int value = 1;
//		for (int y = 0; y < 4; y++)
//			for (int x = 0; x < 4; x++)
//				if ((x != 3 || y != 3) && configuration.at(x, y) != value++)
//					return false;

		return true;
	}
	
//	public Configuration init(int howManyTimes) {
//		if (howManyTimes <= 0)
//			return configuration;
//		else
//			return new Rules(afterMovingAt(random.nextInt(4), random.nextInt(4))).init(howManyTimes - 1);
//	}

	public Configuration afterMovingAt(int x, int y) {
		Configuration result = tryLeft(x, y);
		if (result != configuration)
			return result;

		result = tryRight(x, y);
		if (result != configuration)
			return result;

		result = tryUp(x, y);
		if (result != configuration)
			return result;

		return tryDown(x, y);
	}

	public Iterable<Configuration> nextConfigurations() {
		return new Iterable<Configuration>() {

			@Override
			public Iterator<Configuration> iterator() {
				return new Iterator<Configuration>() {

					private int x, y;
					private Configuration next = findNext();

					@Override
					public boolean hasNext() {
						return next != null;
					}

					@Override
					public Configuration next() {
						Configuration next = this.next;
						this.next = findNext();

						return next;
					}

					private Configuration findNext() {
						Configuration next = configuration;

						while (y < 4 && next == configuration) {
							next = afterMovingAt(x, y);
							if ((x = ++x % 4) == 0)
								y++;
						}

						return next != configuration ? next : null;
					}

					@Override
					public void remove() {						
					}
				};
			}
		};
	}

	private Configuration tryLeft(int x, int y) {
		Configuration result = null;
//		if (x > 0) {
//			Configuration result = tryLeft(x - 1, y);
//
//			if (result.at(x - 1, y) == 0)
//				return result.swap(x, y, x - 1, y);
//		}

		return configuration;
	}

	private Configuration tryRight(int x, int y) {
		Configuration result = null;
		
//		if (x < 3) {
//			Configuration result = tryRight(x + 1, y);
//
//			if (result.at(x + 1, y) == 0)
//				return result.swap(x, y, x + 1, y);
//		}

		return configuration;
	}

	private Configuration tryUp(int x, int y) {
		Configuration result = null;
//		if (y > 0) {
//			Configuration result = tryUp(x, y - 1);
//
//			if (result.at(x, y - 1) == 0)
//				return result.swap(x, y, x, y - 1);
//		}

		return configuration;
	}

	private Configuration tryDown(int x, int y) {
		Configuration result = null;
//		if (y < 3) {
//			Configuration result = tryDown(x, y + 1);
//
//			if (result.at(x, y + 1) == 0)
//				return result.swap(x, y, x, y + 1);
//		}

		return configuration;
	}
}