package Model;

public class Tileset {
	
	private String name;
	private int firstGid, tileWidth, tileHeight, tileCount;
	private TileImage tileImage;

	public Tileset(String name, int firstGid, int tileWidth, int tileHeight, int tileCount) {
		super();
		this.name = name;
		this.firstGid = firstGid;
		this.tileWidth = tileWidth;
		this.tileHeight = tileHeight;
		this.tileCount = tileCount;

		
	}
	
}
