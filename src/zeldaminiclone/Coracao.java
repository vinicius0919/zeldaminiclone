package zeldaminiclone;

import java.awt.Graphics;

public class Coracao extends Blocks {

public Coracao(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

@Override
public void render(Graphics g) {
		
		g.drawImage(Spritesheet.coracao, x, y, width, height, null);
		
	}
	
}
