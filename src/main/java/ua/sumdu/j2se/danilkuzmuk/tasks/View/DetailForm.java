package ua.sumdu.j2se.danilkuzmuk.tasks.View;

import ua.sumdu.j2se.danilkuzmuk.tasks.Controller.ViewControl.FormControl;

import javax.swing.*;
import java.awt.*;

public class DetailForm extends JFrame implements ViewInterface {
    JPanel pnInfoMenu;
    JButton btBut12;
    JButton btBut13;
    JTable tbTable0;

    FormControl btAct;
    public DetailForm() throws HeadlessException {
        super( "TaskManager" );
        pnInfoMenu = new JPanel();
        GridBagLayout gbInfoMenu = new GridBagLayout();
        GridBagConstraints gbcInfoMenu = new GridBagConstraints();
        pnInfoMenu.setLayout( gbInfoMenu );

        btBut12 = new JButton( "Изменить задачу"  );
        gbcInfoMenu.gridx = 1;
        gbcInfoMenu.gridy = 16;
        gbcInfoMenu.gridwidth = 5;
        gbcInfoMenu.gridheight = 2;
        gbcInfoMenu.fill = GridBagConstraints.BOTH;
        gbcInfoMenu.weightx = 1;
        gbcInfoMenu.weighty = 0;
        gbcInfoMenu.anchor = GridBagConstraints.NORTH;
        gbInfoMenu.setConstraints( btBut12, gbcInfoMenu );
        pnInfoMenu.add( btBut12 );

        btBut13 = new JButton( "На главную"  );
        gbcInfoMenu.gridx = 14;
        gbcInfoMenu.gridy = 16;
        gbcInfoMenu.gridwidth = 5;
        gbcInfoMenu.gridheight = 2;
        gbcInfoMenu.fill = GridBagConstraints.BOTH;
        gbcInfoMenu.weightx = 1;
        gbcInfoMenu.weighty = 0;
        gbcInfoMenu.anchor = GridBagConstraints.NORTH;
        gbInfoMenu.setConstraints( btBut13, gbcInfoMenu );
        pnInfoMenu.add( btBut13 );

        String []colsTable0 = new String[] { "title", "time", "start", "end", "interval", "active", "repeated"};
        String [][]dataTable0 = { new String[] {"", "", "", "", "", "", ""}};
        tbTable0 = new JTable( dataTable0, colsTable0 );
        JScrollPane scpTable0 = new JScrollPane( tbTable0 );
        gbcInfoMenu.gridx = 2;
        gbcInfoMenu.gridy = 2;
        gbcInfoMenu.gridwidth = 16;
        gbcInfoMenu.gridheight = 13;
        gbcInfoMenu.fill = GridBagConstraints.BOTH;
        gbcInfoMenu.weightx = 1;
        gbcInfoMenu.weighty = 1;
        gbcInfoMenu.anchor = GridBagConstraints.NORTH;
        gbInfoMenu.setConstraints( scpTable0, gbcInfoMenu );
        pnInfoMenu.add( scpTable0 );

        setDefaultCloseOperation( EXIT_ON_CLOSE );

    }
    public JPanel getPanel() {

        return pnInfoMenu;
    }
    @Override
    public void setFormControl(FormControl formControl) {
        btAct = formControl;
        btBut12.addActionListener(btAct);
        btBut13.addActionListener(btAct);
    }
}
