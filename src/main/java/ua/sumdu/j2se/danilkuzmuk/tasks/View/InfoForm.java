package ua.sumdu.j2se.danilkuzmuk.tasks.View;

import ua.sumdu.j2se.danilkuzmuk.tasks.Controller.ViewControl.FormControl;

import javax.swing.*;
import java.awt.*;

public class InfoForm extends JFrame implements ViewInterface{

    JPanel pnPanel1;
    JButton btBut7;
    JButton btBut8;
    JButton btBut9;
    JList lsList1;

    FormControl btAct;
    public InfoForm() {
        super( "TaskManager" );


        pnPanel1 = new JPanel();
        GridBagLayout gbPanel1 = new GridBagLayout();
        GridBagConstraints gbcPanel1 = new GridBagConstraints();
        pnPanel1.setLayout( gbPanel1 );

        btBut7 = new JButton( "Добавить"  );
        gbcPanel1.gridx = 3;
        gbcPanel1.gridy = 15;
        gbcPanel1.gridwidth = 3;
        gbcPanel1.gridheight = 2;
        gbcPanel1.fill = GridBagConstraints.BOTH;
        gbcPanel1.weightx = 1;
        gbcPanel1.weighty = 0;
        gbcPanel1.anchor = GridBagConstraints.NORTH;
        gbPanel1.setConstraints( btBut7, gbcPanel1 );
        pnPanel1.add( btBut7 );

        btBut8 = new JButton( "Детально"  );
        gbcPanel1.gridx = 7;
        gbcPanel1.gridy = 15;
        gbcPanel1.gridwidth = 5;
        gbcPanel1.gridheight = 2;
        gbcPanel1.fill = GridBagConstraints.BOTH;
        gbcPanel1.weightx = 1;
        gbcPanel1.weighty = 0;
        gbcPanel1.anchor = GridBagConstraints.NORTH;
        gbPanel1.setConstraints( btBut8, gbcPanel1 );
        pnPanel1.add( btBut8 );

        btBut9 = new JButton( "На главную"  );
        gbcPanel1.gridx = 13;
        gbcPanel1.gridy = 15;
        gbcPanel1.gridwidth = 2;
        gbcPanel1.gridheight = 2;
        gbcPanel1.fill = GridBagConstraints.BOTH;
        gbcPanel1.weightx = 1;
        gbcPanel1.weighty = 0;
        gbcPanel1.anchor = GridBagConstraints.NORTH;
        gbPanel1.setConstraints( btBut9, gbcPanel1 );
        pnPanel1.add( btBut9 );

        String []dataList1 = { "Chocolate", "Ice Cream", "Apple Pie" };
        lsList1 = new JList( dataList1 );
        JScrollPane scpList1 = new JScrollPane( lsList1 );
        gbcPanel1.gridx = 1;
        gbcPanel1.gridy = 1;
        gbcPanel1.gridwidth = 17;
        gbcPanel1.gridheight = 14;
        gbcPanel1.fill = GridBagConstraints.BOTH;
        gbcPanel1.weightx = 1;
        gbcPanel1.weighty = 1;
        gbcPanel1.anchor = GridBagConstraints.NORTH;
        gbPanel1.setConstraints( scpList1, gbcPanel1 );
        pnPanel1.add( scpList1 );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
    }
    @Override
    public JPanel getPanel() {

        return pnPanel1;
    }

    @Override
    public void setFormControl(FormControl formControl) {
        btAct = formControl;
        btBut7.addActionListener(btAct);
        btBut8.addActionListener(btAct);
        btBut9.addActionListener(btAct);

    }
}
