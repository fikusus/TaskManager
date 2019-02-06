package ua.sumdu.j2se.danilkuzmuk.tasks.Controller.ViewControl;

import ua.sumdu.j2se.danilkuzmuk.tasks.View.DetailForm;
import ua.sumdu.j2se.danilkuzmuk.tasks.View.ViewInterface;

import javax.swing.*;

public class DetailFormControl implements FormInterface {
    DetailForm Form;
    public DetailFormControl() {
        Form = new DetailForm();
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
