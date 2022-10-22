package zeldaminiclone;

import java.awt.Graphics;

public class GameOver extends Titulo{
	
	public GameOver(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	//INSERE A IMAGEM "GAMEOVER" RETIRADA DA SPRITE2
	@Override
	public void render(Graphics g) {
		
		g.drawImage(Spritesheet.gameover, x, y, width, height, null);
		
	}
}
