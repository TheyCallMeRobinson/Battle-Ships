package oop.kurs2;

import oop.kurs2.gui.DrawPanel;
import oop.kurs2.gui.MainFrame;
import oop.kurs2.services.BattleService;
import oop.kurs2.services.DrawService;
import oop.kurs2.services.GenerateService;

public class Main {

    public static void main(String[] args) {
        BattleField first = GenerateService.generateBattlefield(5, 5, "Vasya");
        BattleField second = GenerateService.generateBattlefield(5, 5, "Vasily");
        MainFrame mf = new MainFrame();
        mf.setSize(1920, 1080);
        mf.setVisible(true);
        for(int i = 0; BattleService.hasNextMove(first, second); i++) {
            System.out.println("Step " + i);
            DrawService.printField(first);
            System.out.println("-----------------------");
            DrawService.printField(second);
            System.out.println("-----------------------");
            System.out.println("-----------------------");
            if(i%2 == 0)
                BattleService.nextMove(first, second);
            else
                BattleService.nextMove(second, first);
        }
        DrawService.printField(first);
        DrawService.printField(second);
    }
}
