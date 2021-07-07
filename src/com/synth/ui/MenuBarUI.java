package com.synth.ui;

import com.synth.Synthesizer;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;

public class MenuBarUI {
    int MENUBAR_WIDTH = Synthesizer.SYNTH_WIDTH;
    int MENUBAR_HEIGHT = 30;
    MenuBar menuBar = new MenuBar();
    Menu menuFile = new Menu("File");
    Menu menuEdit = new Menu("Edit");
    MenuItem menuFileOpen = new MenuItem("Open...");
    MenuItem menuFileExit = new MenuItem("Exit");
    MenuItem menuEditSettings = new MenuItem("Settings");

    public MenuBarUI() {
        // Size
        menuBar.setMaxSize(MENUBAR_WIDTH, MENUBAR_HEIGHT);
        menuBar.setMinSize(MENUBAR_WIDTH, MENUBAR_HEIGHT);
        menuBar.setPrefSize(MENUBAR_WIDTH, MENUBAR_HEIGHT);

        // Create menu
        menuFile.getItems().addAll(menuFileOpen, menuFileExit);
        menuEdit.getItems().addAll(menuEditSettings);
        menuBar.getMenus().addAll(menuFile, menuEdit);
    }

    public MenuBar getUIElement() {
        return menuBar;
    }

}
