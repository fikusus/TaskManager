package ua.sumdu.j2se.danilkuzmuk.tasks.Controller.ViewControl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FormControl extends JFrame implements ActionListener {
    ArrayList<FormInterface> forms = new ArrayList<>();

    public FormControl(FormInterface form) throws HeadlessException {
        AddNewForms(form);
        setContentPane(form.getPanel());
        pack();
        setVisible( true );
    }

    //forms[0]-Main
    //forms[1]-Info
    //forms[2]-Change
    //forms[3]-Detale
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        switch (e.getActionCommand()){
            case "На сегодня":
                setContentPane( forms.get(1).getPanel() );
                pack();
                setVisible( true );
                break;
            case "На главную":
                setContentPane(forms.get(0).getPanel() );
                pack();
                setVisible( true );
                break;
            case "На неделю":
                setContentPane( forms.get(1).getPanel() );
                pack();
                setVisible( true );
                break;
            case "Добавить":
                setContentPane( forms.get(2).getPanel() );
                pack();
                setVisible( true );
                break;
            case "Сохранить задачу":
                setContentPane( forms.get(0).getPanel() );
                pack();
                setVisible( true );
                break;
            case "Детально":
                setContentPane( forms.get(3).getPanel() );
                pack();
                setVisible( true );
                break;
            case "Изменить задачу":
                setContentPane( forms.get(2).getPanel() );
                pack();
                setVisible( true );
                break;
        }
    }

    public void AddNewForms(FormInterface form){
        form.getForm().setFormControl(this);
        forms.add(form);
    }
}
