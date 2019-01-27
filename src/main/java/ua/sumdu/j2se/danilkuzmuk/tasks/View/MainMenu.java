package ua.sumdu.j2se.danilkuzmuk.tasks.View;

import javax.swing.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame
{
    static MainMenu theMain;

    JPanel pnPanel0;
    JButton btBut0;
    JButton btBut2;
    JButton btBut4;
    JButton btBut5;
    JButton btBut6;
    JList lsList0;


    JPanel pnPanel1;
    JButton btBut7;
    JButton btBut8;
    JButton btBut9;
    JList lsList1;

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

    JPanel pnInfoMenu;
    JButton btBut12;
    JButton btBut13;
    JTable tbTable0;

    public static void main( String args[] )
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch ( ClassNotFoundException e )
        {
        }
        catch ( InstantiationException e )
        {
        }
        catch ( IllegalAccessException e )
        {
        }
        catch ( UnsupportedLookAndFeelException e )
        {
        }
        theMain = new MainMenu();
    }


    public MainMenu()
    {
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

        ActionListener actionListener = new TestActionListener();
        btBut0.addActionListener(actionListener);
        btBut2.addActionListener(actionListener);
        btBut4.addActionListener(actionListener);
        btBut5.addActionListener(actionListener);
        btBut6.addActionListener(actionListener);

///////////////////////////////////////////////////

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
        btBut7.addActionListener(actionListener);
        btBut8.addActionListener(actionListener);
        btBut9.addActionListener(actionListener);


        ///////////////////////////////////////////


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

        btBut10.addActionListener(actionListener);
        btBut11.addActionListener(actionListener);

        ////////////////////////////////////////////////

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

        btBut12.addActionListener(actionListener);
        btBut13.addActionListener(actionListener);

        setDefaultCloseOperation( EXIT_ON_CLOSE );

        setContentPane( pnPanel0 );
        pack();
        setVisible( true );

    }

    public class TestActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
           switch (e.getActionCommand()){
               case "На сегодня":
                   setContentPane( pnPanel1 );
                   pack();
                   setVisible( true );
                   break;
               case "На главную":
                   setContentPane( pnPanel0 );
                   pack();
                   setVisible( true );
                   break;
               case "На неделю":
                   setContentPane( pnPanel1 );
                   pack();
                   setVisible( true );
                   break;
               case "Добавить":
                   setContentPane( pnAddMenu);
                   pack();
                   setVisible( true );
                   break;
               case "Сохранить задачу":
                   setContentPane( pnPanel0 );
                   pack();
                   setVisible( true );
                   break;
               case "Детально":
                   setContentPane( pnInfoMenu);
                   pack();
                   setVisible( true );
                   break;
               case "Изменить задачу":
                   setContentPane( pnAddMenu);
                   pack();
                   setVisible( true );
                   break;
           }
        }
    }
}
