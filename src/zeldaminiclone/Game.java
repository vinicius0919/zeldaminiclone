package zeldaminiclone;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

public class Game extends Canvas implements Runnable, KeyListener {
    public static int WIDHT = 640, HEIGHT = 480;
    public static int ESCALA =  3;
    private static int tempoColisao = 0;
    
    public static int tempoSpawn = 0;
    
    public static Player player;
    public World world;
    public static List <Octorok> octoroks = new ArrayList<Octorok>();
    
	public static boolean exibirTitulo = true;
    
    public Game(){
    	this.addKeyListener(this);
        this.setPreferredSize(new Dimension(WIDHT, HEIGHT));
        new Spritesheet();
        
        //INICIALIZA O PLAYER NA POSIÇÃO X = 320 E Y = 320
        player = new Player(220,355); 
     
        //INICIALIZA O OCTOROK NA POSIÇÃO X =32 E Y =32
        octoroks.add(new Octorok(0,32,32));
        octoroks.add(new Octorok(1, 340,340));	
        octoroks.get(0).setSpd(3); 
        octoroks.get(0).setCorOctorok(1);
        
        
        world = new World();
    }

    public void tick(){
    	player.tick();
    	tempoColisao++;
    	tempoSpawn++;
    	
    	if(tempoSpawn>550) {
    		for(int i = 0; i< octoroks.size(); i++) {
	        	octoroks.get(i).tick();
	        	//MUDA A COR DO INIMIGO OCTOROK
	    }
    		exibirTitulo = false;
    	}
			
		
    	
    	if(Game.player.colisao(Game.player.x, Game.player.y)&&tempoColisao>100) {
			Game.player.setVida(1);
			tempoColisao =0;
		}
    }
    public void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null) {
        	this.createBufferStrategy(3);
        	return;
        }
        
        Graphics g = bs.getDrawGraphics();
        
        g.setColor(new Color(0, 135, 13));
        g.fillRect(0,0, WIDHT, HEIGHT);
        
        if(exibirTitulo==false) {
        	player.render(g);
            
			for(int i = 0; i< octoroks.size(); i++) {
		    	octoroks.get(i).render(g);	
			}
        
        }
        
		
        world.render(g);
        
        bs.show();
        
    }
    
    @Override
    public void run() {
    	while(player.getVida()>0) {
    		tick();
            render();
            //FAZ COM QUE O JOGO RODE A 60 FPS
            try {
            Thread.sleep(1000/60);   
            } catch (InterruptedException e) {
                e.printStackTrace();
            }	
            
    	}
    	
    }

    
    
  //TODOS OS MÉTODOS ABAIXO INSEREM OS EVENTOS DE TECLADO

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
		@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
			player.right = true;
		} else if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
			player.left = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP|| e.getKeyCode() == KeyEvent.VK_W) {
			player.up = true;
		} else if(e.getKeyCode() == KeyEvent.VK_DOWN|| e.getKeyCode() == KeyEvent.VK_S) {
			player.down = true;
		}
		if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			player.shoot = true;
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT|| e.getKeyCode() == KeyEvent.VK_D) {
			player.right = false;
		} else if(e.getKeyCode() == KeyEvent.VK_LEFT|| e.getKeyCode() == KeyEvent.VK_A) {
			player.left = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP|| e.getKeyCode() == KeyEvent.VK_W) {
			player.up = false;
		} else if(e.getKeyCode() == KeyEvent.VK_DOWN|| e.getKeyCode() == KeyEvent.VK_S) {
			player.down = false;
		}
		if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			player.shoot = false;
		}
	}

   
}