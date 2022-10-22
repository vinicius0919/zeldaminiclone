package zeldaminiclone;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Player extends Rectangle{
	private int vida = 4;
	public int direcaoTiro = 0;
	
	private int spd = 4;  
	public boolean right, up, down, left;
	
	public static List<Balas> balas = new ArrayList<Balas>();
	
	public int indiceSprite =0;
	public int frames = 0, velocidadeAnimacao =5;
	public boolean shoot = false;
	boolean moveu= false;
	
	public Player(int x, int y){
		super(x,y,32,32);
	}
	
	public int getSpd() {
		return this.spd;
	}
	public void setSpd(int spd) {
		this.spd = spd;
	}
	
	public void tick() {
		moveu = false;
		//VERIFICA SE O PLAYER PODE SE MOVIMENTAR NO AMBIENTE
		//CASO SEJA VERDADEIRO
		if(right && World.isFree(x+spd, y)) {
			x+= spd;
			moveu = true;
			direcaoTiro = 1;
		}else if(left && World.isFree(x-spd, y)) {
			x-=spd;
			moveu = true;
			direcaoTiro = 2;
		}
		if(up && World.isFree(x, y-spd)) {
			y-= spd;
			moveu = true;
			direcaoTiro = 3;
		}else if(down && World.isFree(x, y+spd)) {
			y+=spd;
			moveu = true;
			direcaoTiro = 4;
		}
		if(moveu) {
			frames++;
			if(frames==velocidadeAnimacao) {
				frames=0;
				indiceSprite++;
				if(indiceSprite== Spritesheet.player_front.length) {
					indiceSprite=0;
				}
			}
		}
		
		if(shoot) {
			shoot = false;
			balas.add(new Balas(x, y, direcaoTiro));
		}
		for(int i = 0; i< balas.size(); i++) {
			balas.get(i).tick();
		}
	}
	
	
	public boolean colisao(int x, int y) {
		Player player = new Player(x, y);
		for(int i = 0; i<Game.octoroks.size();i++) {
			if(player.intersects(Game.octoroks.get(i))) {
	    		return true;
	    	}	
		}
		return false;
    }
	
	public void render(Graphics g) {
		
		for(int i = 0; i< balas.size(); i++) {
			balas.get(i).render(g);
		}
		//RENDERIZA A SPRITE DO PLAYER DE FRENTE
		if(moveu ==false) {
			g.drawImage(Spritesheet.player_front[indiceSprite], x, y, 32, 32,null);	
		}
		
		//RENDERIZA AS SPRITES DO PLAYER DE ACORDO COM
		//A DIREÇÃO EM QUE ELE SE MOVE
		if(right) {
			g.drawImage(Spritesheet.player_lado_direito[indiceSprite], x, y, 32, 32,null);
		}
		if(left) {
			g.drawImage(Spritesheet.player_lado_esquerdo[indiceSprite], x, y, 32, 32,null);
		}
		if(up) {
			g.drawImage(Spritesheet.player_costa[indiceSprite], x, y, 32, 32,null);
		}
		if(down) {
			g.drawImage(Spritesheet.player_front[indiceSprite], x, y, 32, 32,null);	
		}
		
		}

	public int getVida() {
		return vida;
	}

	public void setVida(int dano) {
		this.vida = this.vida - dano;
	}

}