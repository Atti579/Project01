import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends JFrame {

    public HomePage() {
        setTitle("Home Page");
        setSize(600, 400);

        //SquadPage squadPage = new SquadPage();
        //TransfersPage transfersPage = new TransfersPage(squadPage);
        //Players playerToBuy = transfersPage.transferplayers.get(3);
        //transfersPage.buyPlayer(playerToBuy);
        BackgroundPanel backgroundPanel2 = new BackgroundPanel("realhomepage.jpeg");
        backgroundPanel2.setLayout(null);
        setContentPane(backgroundPanel2);
        JButton squadButton = new JButton("Squad");
        squadButton.setBounds(450,300,100,30);
        squadButton.setPreferredSize(new Dimension(120,40));
        backgroundPanel2.add(squadButton);

        squadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SquadPage squadPage = new SquadPage();
                squadPage.setVisible(true);
            }
        });

        JButton ticketsButton = new JButton("Tickets");
        ticketsButton.setBounds(245,300,100,30);
        ticketsButton.setPreferredSize(new Dimension(120,40));
        backgroundPanel2.add(ticketsButton);

        ticketsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                TicketsPage ticketsPage = new TicketsPage();
                ticketsPage.setVisible(true);
            }
        });

        JButton trasfersButton = new JButton("Transfers");
        trasfersButton.setBounds(50,300,100,30);
        trasfersButton.setPreferredSize(new Dimension(120,40));
        backgroundPanel2.add(trasfersButton);

        trasfersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                TransfersPage transfersPage = new TransfersPage();
                transfersPage.setVisible(true);
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}


