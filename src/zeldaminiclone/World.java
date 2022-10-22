package zeldaminiclone;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class World{
	public static int quantidadeCoracao=4;
	public static List<Blocks> blocos = new ArrayList<Blocks>();
	public static List<Coracao> coracao = new ArrayList<Coracao>();
	public static GameOver go;
	public static Titulo titulo;
	public World() {

        titulo = new Titulo(100,180);
		
		//GERA AS ESTRUTURAS DOS MUROS QUE DELIMITAM A
		//ÁREA QUE O JOGADOR PODE SE MOVIMENTAR
		for(int xx = 0; xx < 15*2; xx++) {
			
			blocos.add(new Blocks(xx*32, 0));
		}
		
			go= new GameOver(100, 180);
		for(int xx = 0; xx < 15*2; xx++) {
			blocos.add(new Blocks(xx*32, 448));
		}
		for(int yy = 0; yy < 15*2; yy++) {
			blocos.add(new Blocks(0,yy*32));
		}
		for(int yy = 0; yy < 15*2; yy++) {
			blocos.add(new Blocks(640-32,yy*32));
		}
		
		for(int yy = 0; yy < 6; yy++) {
			blocos.add(new Blocks(400,yy*80));
		}

		for(int yy = 0; yy < 6; yy++) {
			blocos.add(new Blocks(400-100,yy*80));
		}
		
		for(int yy = 0; yy < 6; yy++) {
			blocos.add(new Blocks(400-200,yy*80));
		}
		
		for(int yy = 0; yy < 4; yy++) {
			coracao.add(new Coracao((yy*32)+32, 38));
		}
		
	}
	
	//RETORNA UM VALOR LÓGICO PARA O MÉTODO TICK() DO PLAYER
	//NO QUAL VERIFICAMOS SE NA FRENTE DO PLAYER EXISTE UMA
	//ESTRUTURA
	public static boolean isFree(int x, int y) {
		for(int i =0; i < blocos.size(); i++) {
			Blocks blocoAtual = blocos.get(i);
			if(blocoAtual.intersects(new Rectangle(x,y,32,32))) {
				return false;
			}
		}
		return true;
	}
	
	//RENDERIZA A QUANTIDADE DE BLOCOS INSERIDA
	public void render(Graphics g) {
		if(Game.exibirTitulo == true) {

			titulo.render(g);
		}else {
			for(int i = 0; i<blocos.size(); i++) {
				blocos.get(i).render(g);
			}
			if(Game.player.getVida()==0) {
					go.render(g);
			}
			if(Game.player.colisao(Game.player.x, Game.player.y)) {
				quantidadeCoracao = Game.player.getVida();
			}
			
			for(int i = 0; i<quantidadeCoracao; i++) {
				coracao.get(i).render(g);
			}
		}
		
		
		
	}
}