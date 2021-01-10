package oop.kurs2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import oop.kurs2.gui.DrawPanel;
import oop.kurs2.gui.MainFrame;
import oop.kurs2.services.BattleService;
import oop.kurs2.services.DrawService;
import oop.kurs2.services.GenerateService;

public class Main {

    public static void main(String[] args) {
        MainFrame mf = new MainFrame();
        mf.setSize(1920, 1080);
        mf.setVisible(true);
    }
}
