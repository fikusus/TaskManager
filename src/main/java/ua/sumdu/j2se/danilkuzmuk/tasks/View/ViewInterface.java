package ua.sumdu.j2se.danilkuzmuk.tasks.View;

import ua.sumdu.j2se.danilkuzmuk.tasks.Controller.ViewControl.FormControl;

import javax.swing.*;

public interface ViewInterface {
    public JPanel getPanel();
    public void setFormControl(FormControl formControl);
}
