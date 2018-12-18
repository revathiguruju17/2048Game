package controller;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Application2048 {
    public static void main(String[] args) {
        List<JButton> buttons = new ArrayList<>();
        JFrame frame = new JFrame( "2048" );
        frame.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        frame.setLayout( new GridLayout( 4, 4, 20, 20 ) );
        for (int i = 0; i < 16; i++) {
            JButton button = new JButton( "" );
            button.setSize( 100, 100 );
            button.setEnabled( false );
            buttons.add( button );
            frame.add( button );
        }
        frame.addKeyListener( new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int code = e.getKeyCode();
                if (code == KeyEvent.VK_DOWN) {
                    //LeftMover leftMover = new LeftMover();
                    //leftMover.move();
                    System.out.println( "down" );
                } else if (code == KeyEvent.VK_UP) {
                    System.out.println( "up" );
                } else if (code == KeyEvent.VK_LEFT) {
                    System.out.println( "left" );
                } else if (code == KeyEvent.VK_RIGHT) {
                    System.out.println( "right" );
                }

                List<String> list = Arrays.asList(
                        "2048", "", "", "",
                        "2", "", "", "",
                        "2", "", "", "",
                        "2", "", "", "" );
                for (int i = 0; i < list.size(); i++) {
                    buttons.get( i ).setText( "<html><h1>" + list.get( i ) + "</h1></html>" );
                }
                if (list.contains( "2048" )) {
                    JOptionPane.showMessageDialog( frame, "You have won the game" );
                }
            }
        } );
        frame.pack();
        frame.setSize( 500, 500 );
        frame.setVisible( true );
    }
}
