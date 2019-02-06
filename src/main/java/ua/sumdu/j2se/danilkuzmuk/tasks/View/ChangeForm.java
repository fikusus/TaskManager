package ua.sumdu.j2se.danilkuzmuk.tasks.View;

import ua.sumdu.j2se.danilkuzmuk.tasks.Controller.ViewControl.FormControl;

import javax.swing.*;
import java.awt.*;

public class ChangeForm extends JFrame implements ViewInterface {
    JPanel pnAddMenu;
    JTextField tfTitle;
    JCheckBox cbBox0;
    JTextField tfText1;
    JTextField tfText3;
    JTextField tfText4;
    JTextField tfText5;
    JCheckBox cbBox1;
    JButton btBut10;
    JButton btBut11;

    FormControl btAct;

    public ChangeForm() throws HeadlessException {
        super( "TaskManager" );


        pnAddMenu = new JPanel();
        GridBagLayout gbAddMenu = new GridBagLayout();
        GridBagConstraints gbcAddMenu = new GridBagConstraints();
        pnAddMenu.setLayout( gbAddMenu );

        tfTitle = new JTextField( );
        gbcAddMenu.gridx = 1;
        gbcAddMenu.gridy = 5;
        gbcAddMenu.gridwidth = 5;
        gbcAddMenu.gridheight = 2;
        gbcAddMenu.fill = GridBagConstraints.BOTH;
        gbcAddMenu.weightx = 1;
        gbcAddMenu.weighty = 0;
        gbcAddMenu.anchor = GridBagConstraints.NORTH;
        gbAddMenu.setConstraints( tfTitle, gbcAddMenu );
        pnAddMenu.add( tfTitle );

        cbBox0 = new JCheckBox( ""  );
        gbcAddMenu.gridx = 7;
        gbcAddMenu.gridy = 5;
        gbcAddMenu.gridwidth = 2;
        gbcAddMenu.gridheight = 2;
        gbcAddMenu.fill = GridBagConstraints.BOTH;
        gbcAddMenu.weightx = 1;
        gbcAddMenu.weighty = 0;
        gbcAddMenu.anchor = GridBagConstraints.NORTH;
        gbAddMenu.setConstraints( cbBox0, gbcAddMenu );
        pnAddMenu.add( cbBox0 );

        tfText1 = new JTextField( );
        gbcAddMenu.gridx = 10;
        gbcAddMenu.gridy = 5;
        gbcAddMenu.gridwidth = 5;
        gbcAddMenu.gridheight = 2;
        gbcAddMenu.fill = GridBagConstraints.BOTH;
        gbcAddMenu.weightx = 1;
        gbcAddMenu.weighty = 0;
        gbcAddMenu.anchor = GridBagConstraints.NORTH;
        gbAddMenu.setConstraints( tfText1, gbcAddMenu );
        pnAddMenu.add( tfText1 );

        tfText3 = new JTextField( );
        gbcAddMenu.gridx = 10;
        gbcAddMenu.gridy = 7;
        gbcAddMenu.gridwidth = 5;
        gbcAddMenu.gridheight = 2;
        gbcAddMenu.fill = GridBagConstraints.BOTH;
        gbcAddMenu.weightx = 1;
        gbcAddMenu.weighty = 0;
        gbcAddMenu.anchor = GridBagConstraints.NORTH;
        gbAddMenu.setConstraints( tfText3, gbcAddMenu );
        pnAddMenu.add( tfText3 );

        tfText4 = new JTextField( );
        gbcAddMenu.gridx = 10;
        gbcAddMenu.gridy = 9;
        gbcAddMenu.gridwidth = 5;
        gbcAddMenu.gridheight = 2;
        gbcAddMenu.fill = GridBagConstraints.BOTH;
        gbcAddMenu.weightx = 1;
        gbcAddMenu.weighty = 0;
        gbcAddMenu.anchor = GridBagConstraints.NORTH;
        gbAddMenu.setConstraints( tfText4, gbcAddMenu );
        pnAddMenu.add( tfText4 );

        tfText5 = new JTextField( );
        gbcAddMenu.gridx = 12;
        gbcAddMenu.gridy = 5;
        gbcAddMenu.gridwidth = 4;
        gbcAddMenu.gridheight = 2;
        gbcAddMenu.fill = GridBagConstraints.BOTH;
        gbcAddMenu.weightx = 1;
        gbcAddMenu.weighty = 0;
        gbcAddMenu.anchor = GridBagConstraints.NORTH;
        gbAddMenu.setConstraints( tfText5, gbcAddMenu );
        pnAddMenu.add( tfText5 );

        cbBox1 = new JCheckBox( ""  );
        gbcAddMenu.gridx = 17;
        gbcAddMenu.gridy = 5;
        gbcAddMenu.gridwidth = 2;
        gbcAddMenu.gridheight = 2;
        gbcAddMenu.fill = GridBagConstraints.BOTH;
        gbcAddMenu.weightx = 1;
        gbcAddMenu.weighty = 0;
        gbcAddMenu.anchor = GridBagConstraints.NORTH;
        gbAddMenu.setConstraints( cbBox1, gbcAddMenu );
        pnAddMenu.add( cbBox1 );

        btBut10 = new JButton( "Сохранить задачу"  );
        gbcAddMenu.gridx = 1;
        gbcAddMenu.gridy = 16;
        gbcAddMenu.gridwidth = 5;
        gbcAddMenu.gridheight = 2;
        gbcAddMenu.fill = GridBagConstraints.BOTH;
        gbcAddMenu.weightx = 1;
        gbcAddMenu.weighty = 0;
        gbcAddMenu.anchor = GridBagConstraints.NORTH;
        gbAddMenu.setConstraints( btBut10, gbcAddMenu );
        pnAddMenu.add( btBut10 );

        btBut11 = new JButton( "На главную"  );
        gbcAddMenu.gridx = 14;
        gbcAddMenu.gridy = 16;
        gbcAddMenu.gridwidth = 5;
        gbcAddMenu.gridheight = 2;
        gbcAddMenu.fill = GridBagConstraints.BOTH;
        gbcAddMenu.weightx = 1;
        gbcAddMenu.weighty = 0;
        gbcAddMenu.anchor = GridBagConstraints.NORTH;
        gbAddMenu.setConstraints( btBut11, gbcAddMenu );
        pnAddMenu.add( btBut11 );

        setDefaultCloseOperation( EXIT_ON_CLOSE );
    }
    public JPanel getPanel() {
        return pnAddMenu;
    }
    @Override
    public void setFormControl(FormControl formControl) {
        btAct = formControl;
        btBut10.addActionListener(btAct);
        btBut11.addActionListener(btAct);
    }
}
