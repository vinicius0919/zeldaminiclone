package zeldaminiclone;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Inimigo extends Rectangle{
	private int direcao = 1;
	
	boolean moveu= false;
	
	
	private BufferedImage[] sprite;
	private int spd = 1;
	
	boolean movimento = true;
	
	private static Player jogador = Game.player;
	
	
	public Inimigo(int x, int y) {
		super(x, y, 32, 32);
	}
	public int getSpd() {
		return spd;
	}
	public void setSpd(int velocidade) {
		spd = velocidade;
	}
	
	public void setSprite(BufferedImage[] image) {
		this.sprite = image;
	}
	public void perseguirPlayer() {
		if(x < jogador.x && World.isFree(x+1, y)) {
			x+=this.spd;
			direcao = 2;
			this.moveu = true;
		}
		if(x>jogador.x&& World.isFree(x-1, y)) {
			x-=this.spd;
			direcao = 1;
			this.moveu = true;
		}
		if(y < jogador.y&& World.isFree(x, y+1)) {
			y+=this.spd;
			direcao  = 0;
			this.moveu = true;
		}
		if(y>jogador.y&& World.isFree(x, y-1)) {
			y-=this.spd;
			direcao =3;
			this.moveu = true;
		}
		
		
		if(x < jogador.x&&(y <jogador.y||y>jogador.y)) {
			direcao = 2;
		}
		if(x>jogador.x&&(y <jogador.y||y>jogador.y)) {
			direcao = 1;
		}
		
	}
	public void tick() {
		//VERIFICA SE O INIMIGO PODE SE MOVIMENTAR NO AMBIENTE
		//CASO SEJA VERDADEIRO
			perseguirPlayer();	
			
	}
	
	
	

	public static boolean colisaoBalas(int x, int y) {
		Player player = new Player(x, y);
		for(int i = 0; i<Player.balas.size();i++) {
			if(player.intersects(Player.balas.get(i))) {
	    		return true;
	    	}	
		}
		return false;
    }
	
	
	
	public void render(Graphics g) {
		//RENDERIZA A SPRITE DO PLAYER DE FRENTE
		
		
		//RENDERIZA AS SPRITES DO PLAYER DE ACORDO COM
		//A DIREÇÃO EM QUE ELE SE MOVE
			g.drawImage(sprite[direcao], x, y, 32, 32,null);
		}
	
}