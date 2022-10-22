package zeldaminiclone;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spritesheet{
	
	public static BufferedImage spritesheet;
	
	public static BufferedImage spritesheet2;
	
	public static BufferedImage[] player_front;
	public static BufferedImage[] player_costa;
	public static BufferedImage[] player_lado_direito;
	public static BufferedImage[] player_lado_esquerdo;
	
	public static BufferedImage[] octorokAzul;
	public static BufferedImage[] octorokVermelho;
	
	public static BufferedImage muro;
	public static BufferedImage coracao;
	public static BufferedImage gameover;
	public static BufferedImage legend;
	
	
	public Spritesheet() {
		//ENCONTRAR O ARQUIVO .PNG
		try {
			spritesheet = ImageIO.read(getClass().getResource("/spritesheetaula.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			spritesheet2 = ImageIO.read(getClass().getResource("/gameover.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//SPRITES DO PLAYER
		//(COORDENADA X, COORDENADA Y, ALTURA, LARGURA)
		player_front = new BufferedImage[2];
		player_front[0] = Spritesheet.getSprite(0,11, 16, 16);
		player_front[1] = Spritesheet.getSprite(16,11, 16, 16);
		
		player_costa =  new BufferedImage[2];
		player_costa[0] = Spritesheet.getSprite(71, 11, 16, 16);
		player_costa[1] = Spritesheet.getSprite(88, 11, 16, 16);
		
		player_lado_direito = new BufferedImage[2];
		player_lado_direito[0] = Spritesheet.getSprite(35, 11, 16, 16);
		player_lado_direito[1] = Spritesheet.getSprite(51, 11, 16, 16);
		
		player_lado_esquerdo = new BufferedImage[2];
		player_lado_esquerdo[0] = Spritesheet.getSprite(323, 11, 16, 16);
		player_lado_esquerdo[1] = Spritesheet.getSprite(340, 11, 16, 16);
		
		//SPRITES DO AMBIENTE
		muro = Spritesheet.getSprite(336, 222, 16, 16);
		
		coracao = Spritesheet.getSprite(253, 259, 16, 16);
		gameover = Spritesheet.getSprite2(65, 134, 197, 36);
		legend = Spritesheet.getSprite2(77, 66, 189, 63);
		//SPRITES DO INIMIGO
		
		octorokAzul = new BufferedImage[4];
		octorokAzul[0] = Spritesheet.getSprite(317, 154, 16, 16);
		octorokAzul[1] = Spritesheet.getSprite(317, 170, 16, 16);
		octorokAzul[2] = Spritesheet.getSprite(317, 187, 16, 16);
		octorokAzul[3] = Spritesheet.getSprite(319, 204, 16, 16);
		
		octorokVermelho = new BufferedImage[4];
		octorokVermelho[0] = Spritesheet.getSprite(337, 155, 16, 16);
		octorokVermelho[1] = Spritesheet.getSprite(337, 169, 16, 16);
		octorokVermelho[2] = Spritesheet.getSprite(337, 187, 16, 16);
		octorokVermelho[3] = Spritesheet.getSprite(337, 204, 16, 16);
		
	}
	
	//MÉTODO ESTÁTICO QUE RETORNA UMA ÁREA DA IMAGEM .PNG
	public static BufferedImage getSprite(int x, int y, int widht, int height) {
		return spritesheet.getSubimage(x, y, widht, height);
	}
	public static BufferedImage getSprite2(int x, int y, int widht, int height) {
		return spritesheet2.getSubimage(x, y, widht, height);
	}
}