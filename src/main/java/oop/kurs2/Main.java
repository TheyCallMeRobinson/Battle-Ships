package oop.kurs2;

import oop.kurs2.gui.DrawPanel;
import oop.kurs2.gui.MainFrame;
import oop.kurs2.services.BattleService;
import oop.kurs2.services.DrawService;
import oop.kurs2.services.GenerateService;

public class Main {

    public static void main(String[] args) {
//        MainFrame mf = new MainFrame();
//        mf.setSize(1920, 1080);
//        mf.setVisible(true);
        BattleField first = GenerateService.generateBattlefield(5, 5, "Vasya");
        BattleField second = GenerateService.generateBattlefield(5, 5, "Vasily");
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
        if(BattleService.checkDefeat(first))
            System.out.println("Second player wins");
        else
            System.out.println("First player wins");
        DrawService.printField(first);
        System.out.println("-----------------------");
        DrawService.printField(second);
    }
}
