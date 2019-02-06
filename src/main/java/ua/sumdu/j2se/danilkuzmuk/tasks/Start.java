package ua.sumdu.j2se.danilkuzmuk.tasks;

import ua.sumdu.j2se.danilkuzmuk.tasks.Controller.ViewControl.*;


import javax.swing.*;

public class Start  {
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        FormControl FormCtrl = new FormControl(new MainFormControl());
        FormCtrl.AddNewForms(new InfoFormControl());
        FormCtrl.AddNewForms(new ChangeFormControl());
        FormCtrl.AddNewForms(new DetailFormControl());
    }
}
