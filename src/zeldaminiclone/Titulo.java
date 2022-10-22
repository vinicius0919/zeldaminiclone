package zeldaminiclone;

import java.awt.Graphics;

public class Titulo extends Blocks {
	public Titulo(int x, int y) {
		//CHAMA O CONSTRUTOR DA SUPERCLASSE RECTANGLE
		//PRA DEFINIR O TAMANHO DOS BLOCOS E POSIÇÃO
		//X E Y SÃO A POSIÇÃO DO LOCO NA TELA
		super(x, y, 450, 122);
	}
	
	//INSERE AS SPRITES DOS BLOCOS QUE COMPÕEM O MURO
	@Override
	public void render(Graphics g) {
		
		g.drawImage(Spritesheet.legend, x, y, width, height, null);
		
	}
}
