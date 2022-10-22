package zeldaminiclone;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Balas extends Rectangle{
	private int direcao = 1;
	private int velocidade = 8;
	
	public int tempo = 0;
	
	public Balas(int x, int y, int direcao) {
		super(x+16, y+16, 8, 8);
		this.direcao = direcao;
	}
	
	public int getDirecao() {
		return direcao;
	}

	public void setDirecao(int direcao) {
		this.direcao = direcao;
	}

	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}

	
	
	public void tick() {
		if(direcao==1) {
			x+= velocidade+direcao;	
		}
		if(direcao==2) {
			x-= velocidade+direcao;	
		}
		if(direcao==3) {
			y-= velocidade+direcao;	
		}
		if(direcao==4) {
			y+= velocidade+direcao;	
		}
		
		
		tempo++;
		
		if(tempo==60||World.isFree(this.x-16, this.y-16)==false) {
			Player.balas.remove(this);
			tempo = 0;
			return;
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillOval(x, y, width, height);
	}
}
