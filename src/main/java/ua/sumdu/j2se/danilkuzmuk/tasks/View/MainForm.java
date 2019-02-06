package ua.sumdu.j2se.danilkuzmuk.tasks.View;

import ua.sumdu.j2se.danilkuzmuk.tasks.Controller.ViewControl.FormControl;

import javax.swing.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;


public class MainForm extends JFrame implements ViewInterface{

    JPanel pnPanel0;
    JButton btBut0;
    JButton btBut2;
    JButton btBut4;
    JButton btBut5;
    JButton btBut6;
    JList lsList0;

    FormControl btAct;
    public MainForm() {
        super( "TaskManager" );

        pnPanel0 = new JPanel();
        GridBagLayout gbPanel0 = new GridBagLayout();
        GridBagConstraints gbcPanel0 = new GridBagConstraints();

        pnPanel0.setLayout( gbPanel0 );

        btBut0 = new JButton( "Выход"  );
        gbcPanel0.gridx = 0;
        gbcPanel0.gridy = 18;
        gbcPanel0.gridwidth = 3;
        gbcPanel0.gridheight = 2;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( btBut0, gbcPanel0 );
        pnPanel0.add( btBut0 );

        btBut2 = new JButton( "Добавить"  );
        gbcPanel0.gridx = 3;
        gbcPanel0.gridy = 15;
        gbcPanel0.gridwidth = 3;
        gbcPanel0.gridheight = 2;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( btBut2, gbcPanel0 );
        pnPanel0.add( btBut2 );

        btBut4 = new JButton( "Детально"  );
        gbcPanel0.gridx = 7;
        gbcPanel0.gridy = 15;
        gbcPanel0.gridwidth = 5;
        gbcPanel0.gridheight = 2;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( btBut4, gbcPanel0 );
        pnPanel0.add( btBut4 );

        btBut5 = new JButton( "На сегодня"  );
        gbcPanel0.gridx = 13;
        gbcPanel0.gridy = 15;
        gbcPanel0.gridwidth = 2;
        gbcPanel0.gridheight = 2;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( btBut5, gbcPanel0 );
        pnPanel0.add( btBut5 );

        btBut6 = new JButton( "На неделю"  );
        gbcPanel0.gridx = 16;
        gbcPanel0.gridy = 15;
        gbcPanel0.gridwidth = 2;
        gbcPanel0.gridheight = 2;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( btBut6, gbcPanel0 );
        pnPanel0.add( btBut6 );

        String []dataList0 = {"1","2"};
        lsList0 = new JList( dataList0 );
        JScrollPane scpList0 = new JScrollPane( lsList0 );
        gbcPanel0.gridx = 1;
        gbcPanel0.gridy = 1;
        gbcPanel0.gridwidth = 17;
        gbcPanel0.gridheight = 14;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( scpList0, gbcPanel0 );
        pnPanel0.add( scpList0 );

        setDefaultCloseOperation( EXIT_ON_CLOSE );

    }
    public JPanel getPanel() {
        return pnPanel0;
    }
    @Override
    public void setFormControl(FormControl formControl) {
        btAct = formControl;
        btBut0.addActionListener(btAct);
        btBut2.addActionListener(btAct);
        btBut4.addActionListener(btAct);
        btBut5.addActionListener(btAct);
        btBut6.addActionListener(btAct);
    }
}
