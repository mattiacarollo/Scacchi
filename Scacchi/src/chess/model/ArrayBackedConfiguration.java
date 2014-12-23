package chess.model;

public class ArrayBackedConfiguration extends AbstractConfiguration {
	private final int[][] tiles;

	private ArrayBackedConfiguration(int[][] tiles) {
		this.tiles = new int[4][];
		for (int y = 0; y < 4; y++)
			this.tiles[y] = tiles[y].clone();
	}

	public ArrayBackedConfiguration() {
		this.tiles = new int[4][4];

		int value = 1;
		for (int y = 0; y < 4; y++)
			for (int x = 0; x < 4; x++)
				if (x != 3 || y != 3)
					set(x, y, value++);
//		for (int x = 0; x < 8; x++)
//			set(x, 1, pedone_nero);
	}

	@Override
	public String at(int x, int y) {
		//return tiles[y][x];
		return pedina_xy[x][y];
	}

	private void set(int x, int y, int value) {
		tiles[y][x] = value;
	}

	@Override
	public Configuration swap(int fromX, int fromY, int intoX, int intoY) {
		ArrayBackedConfiguration result = new ArrayBackedConfiguration(tiles);

//		int intoValue = at(intoX, intoY);
//		int fromValue = at(fromX, fromY);
//		result.set(intoX, intoY, fromValue);
//		result.set(fromX, fromY, intoValue);

		return result;
	}
}