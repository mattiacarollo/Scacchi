package chess.model;

public class LongBackedConfiguration extends AbstractConfiguration {
	//private long tiles;

//	private LongBackedConfiguration(long tiles) {
//		this.tiles = tiles;
//	}

//	public LongBackedConfiguration() {
//		this.tiles = 0L;
//
//		int value = 1;
//		for (int y = 0; y < 4; y++)
//			for (int x = 0; x < 4; x++)
//				if (x != 3 || y != 3)
//					set(x, y, value++);
//	}	
	public LongBackedConfiguration() {
			
		pedina_xy[0][0] = torre_nero;
		pedina_xy[1][0] = cavallo_nero;
		pedina_xy[2][0] = alfiere_nero;
		pedina_xy[3][0] = re_nero;
		pedina_xy[4][0] = regina_nero;
		pedina_xy[5][0] = alfiere_nero;
		pedina_xy[6][0] = cavallo_nero;
		pedina_xy[7][0] = torre_nero;
		for (int x = 0; x < 8; x++){
			pedina_xy[x][1] = pedone_nero;
		}
		for (int y = 2; y < 6; y++){
			for (int x = 0; x < 8; x++){
				pedina_xy[x][y] = " ";
			}
		}
		for (int x = 0; x < 8; x++){
			pedina_xy[x][6] = pedone_bianco;
		}
		pedina_xy[0][7] = torre_bianco;
		pedina_xy[1][7] = cavallo_bianco;
		pedina_xy[2][7] = alfiere_bianco;
		pedina_xy[3][7] = re_bianco;
		pedina_xy[4][7] = regina_bianco;
		pedina_xy[5][7] = alfiere_bianco;
		pedina_xy[6][7] = cavallo_bianco;
		pedina_xy[7][7] = torre_bianco;
	}

	@Override
	//restituisce il valore della tile
	public String at(int x, int y) {
		return pedina_xy[x][y];
	}

//	//setta una codifica per x,y,valore in un unico intero
//	private void set(int x, int y, int value) {
//		tiles ^= tiles & (0x0000000fL << (y * 16 + x * 4));
//		tiles |= ((long) value) << (y * 16 + x * 4);
//	}

	@Override
	public Configuration swap(int fromX, int fromY, int intoX, int intoY) {
//		LongBackedConfiguration result = new LongBackedConfiguration(tiles);
		LongBackedConfiguration result = null;

//		int intoValue = at(intoX, intoY);
//		int fromValue = at(fromX, fromY);
//		result.set(intoX, intoY, fromValue);
//		result.set(fromX, fromY, intoValue);

		return result;
	}

//	@Override
//	public boolean equals(Object other) {
//		if (other instanceof LongBackedConfiguration)
//			return tiles == ((LongBackedConfiguration) other).tiles;
//		else
//			return super.equals(other);
//	}
}