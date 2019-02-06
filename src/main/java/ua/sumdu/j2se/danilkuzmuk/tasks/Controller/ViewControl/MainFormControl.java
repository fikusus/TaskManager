package ua.sumdu.j2se.danilkuzmuk.tasks.Controller.ViewControl;

import ua.sumdu.j2se.danilkuzmuk.tasks.View.MainForm;
import ua.sumdu.j2se.danilkuzmuk.tasks.View.ViewInterface;

import javax.swing.*;

public class  MainFormControl extends JFrame implements FormInterface {
    static MainForm Form;
    public MainFormControl() {
        Form = new MainForm();
    }

    @Override
    public JPanel getPanel() {
        return Form.getPanel();
    }
    @Override
    public ViewInterface getForm() {
        return Form;
    }
}
