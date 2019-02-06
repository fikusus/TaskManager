package ua.sumdu.j2se.danilkuzmuk.tasks.Controller.ViewControl;

import ua.sumdu.j2se.danilkuzmuk.tasks.View.ChangeForm;
import ua.sumdu.j2se.danilkuzmuk.tasks.View.ViewInterface;

import javax.swing.*;

public class ChangeFormControl implements FormInterface {
    ChangeForm Form;
    public ChangeFormControl() {
        Form = new ChangeForm();
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
