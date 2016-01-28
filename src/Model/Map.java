package Model;

import java.util.ArrayList;

public class Map {
	
	private int gid, width, height, tilewidth, tileheight;
	private ArrayList<Tileset> tilesets;

	public Map(){
		
	}
	
	public ArrayList<Tileset> getTilesets() {
		return tilesets;
	}


	public void setTilesets(ArrayList<Tileset> tilesets) {
		this.tilesets = tilesets;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public int getTilewidth() {
		return tilewidth;
	}


	public void setTilewidth(int tilewidth) {
		this.tilewidth = tilewidth;
	}


	public int getTileheight() {
		return tileheight;
	}


	public void setTileheight(int tileheight) {
		this.tileheight = tileheight;
	}


	
}
