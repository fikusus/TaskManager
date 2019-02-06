package ua.sumdu.j2se.danilkuzmuk.tasks.Controller.ViewControl;

import ua.sumdu.j2se.danilkuzmuk.tasks.View.InfoForm;
import ua.sumdu.j2se.danilkuzmuk.tasks.View.ViewInterface;

import javax.swing.*;

public class InfoFormControl implements FormInterface{
    InfoForm Form;
    public InfoFormControl() {
        Form = new InfoForm();
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
