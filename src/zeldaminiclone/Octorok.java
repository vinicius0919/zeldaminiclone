package zeldaminiclone;

import java.util.Random;

public class Octorok extends Inimigo{
	public Octorok(int tipo, int x, int y) {
		super(x, y);
		switch(tipo) {
		case 0:
			this.setSprite(Spritesheet.octorokAzul);
		break;
		case 1:
			this.setSprite(Spritesheet.octorokVermelho);
		break;
		}
	}
	public Octorok(int tipo, int x, int y, int velocidade) {
		super(x, y);
		setSpd(velocidade);
		switch(tipo) {
		case 0:
			this.setSprite(Spritesheet.octorokAzul);
		break;
		case 1:
			this.setSprite(Spritesheet.octorokVermelho);
		break;
		}
	}
	public void setCorOctorok(int tipo) {
		switch(tipo) {
		case 0:
			this.setSprite(Spritesheet.octorokAzul);
		break;
		case 1:
			this.setSprite(Spritesheet.octorokVermelho);
		break;
	}
	}
	
	@Override
	public void tick() {
		super.tick();
		
		if(colisaoBalas(this.x, this.y)) {
			Game.octoroks.remove(this);
			int cor = new Random().nextInt(2);
			if(cor==0) {
				Game.octoroks.add(new Octorok(cor,32,32, 2));
			}else {
				Game.octoroks.add(new Octorok(cor,32,32));
			}
		}
	}
	
	
}
