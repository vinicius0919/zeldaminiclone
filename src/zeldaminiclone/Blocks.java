package zeldaminiclone;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Blocks extends Rectangle{
	public Blocks(int x, int y) {
		//CHAMA O CONSTRUTOR DA SUPERCLASSE RECTANGLE
		//PRA DEFINIR O TAMANHO DOS BLOCOS E POSIÇÃO
		//X E Y SÃO A POSIÇÃO DO LOCO NA TELA
		super(x, y, 32, 32);
	}
	
	public Blocks(int x, int y, int i, int j) {
		super(x,y,i,j);
	}

	//INSERE AS SPRITES DOS BLOCOS QUE COMPÕEM O MURO
	public void render(Graphics g) {
		
		g.drawImage(Spritesheet.muro, x, y, width, height, null);
		
	}
}