package controller;


import Factory.MoverFactory;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

class Application2048 {
    public static void main(String[] args) {
        List<JButton> buttons = new ArrayList<>();
        JFrame frame = new JFrame("2048");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 4, 20, 20));
        for (int i = 0; i < 16; i++) {
            JButton button = new JButton("");
            button.setSize(100, 100);
            button.setEnabled(false);
            buttons.add(button);
            frame.add(button);
        }

        Game2048 game2048 = new Game2048();
        game2048.gameSetup(new NumberGeneratorWithinARange(), new NumberGeneratorWithPowerOf2());
        List<Cell> grid = game2048.getGrid();
        for (int i = 0; i < grid.size(); i++) {
            if (grid.get(i).getValue() > 0) {
                buttons.get(i).setText("<html><h1>" + grid.get(i).getValue() + "</h1></html>");
            }
        }

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int code = e.getKeyCode();
                Mover mover = MoverFactory.getMover(code);
                game2048.play(mover, new NumberGeneratorWithinARange(), new NumberGeneratorWithPowerOf2());
                List<Cell> grid = game2048.getGrid();
                for (int i = 0; i < grid.size(); i++) {
                    if (grid.get(i).getValue() > 0) {
                        buttons.get(i).setText("<html><h1>" + grid.get(i).getValue() + "</h1></html>");
                    }
                }
                if (GameRules.checkWhetherTheGridContains2048(grid)) {
                    JOptionPane.showMessageDialog(frame, "You have won the game");
                }
                if (!GameRules.checkWhetherTheGridConsistsOfAnEmptyCell(grid)) {
                    JOptionPane.showMessageDialog(frame, "Game is over");
                }
            }
        });
        frame.pack();
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

}
