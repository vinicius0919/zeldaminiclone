package zeldaminiclone;

import javax.swing.JFrame;

public class Principal {
	
public static void main(String[] args) {
	Game game = new Game();
	JFrame frame = new JFrame();
	
	//ADICIONA O OBJETO "GAME" NA JANELA
    frame.add(game);
    //ADICIONA UM T�TULO NA JANELA
    frame.setTitle("Mini Zelda");
    
    frame.pack();
    //CENTRALIZA A JANELA
    frame.setLocationRelativeTo(null);
    //BLOQUEIA A MAXIMIZA��O
    frame.setResizable(false);
    //GARANTE QUE A JANELA SER� FECHADA AO CLICAR NO
    //BOT�O "x"
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //FAZ COM QUE A JANELA SEJA VIS�VEL
    frame.setVisible(true);
    
    
    new Thread(game).start();
    
}

}