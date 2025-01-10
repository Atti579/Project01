import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TransfersPage extends JFrame {
    private JButton backButton = new JButton();
    private JButton buyButton = new JButton();
    private JTable playerTable;
    private JTextField nameField;
    ArrayList<Players> transferplayers;
    private SquadPage squadPage;

    public TransfersPage(){
        initializeUI();
        //this.squadPage = squadPage;
        setTitle("Transfer Market");
        setSize(600, 400);
        setForeground(new Color(210, 210, 210));

        transferplayers = new ArrayList<>();
        transferplayers.add(new Players("Edouard Mendy", 31, "Senegal", 16, 35.0, 92, 88));
        transferplayers.add(new Players("Manuel Neuer", 38, "Germany", 1, 22.0, 87, 85));
        transferplayers.add(new Players("Marc-André ter Stegen", 32, "Germany", 1, 60.0, 89, 86));
        transferplayers.add(new Players("Jan Oblak", 31, "Slovenia", 13, 50.0, 94, 90));
        transferplayers.add(new Players("Hugo Lloris", 37, "France", 1, 12.0, 80, 78));
        transferplayers.add(new Players("Mike Maignan", 28, "France", 16, 45.0, 90, 87));
        transferplayers.add(new Players("Keylor Navas", 37, "Costa Rica", 1, 8.0, 85, 82));
        transferplayers.add(new Players("Alisson Becker", 32, "Brazil", 1, 55.0, 93, 88));
        transferplayers.add(new Players("David De Gea", 33, "Spain", 1, 15.0, 83, 79));
        transferplayers.add(new Players("Kepa Arrizabalaga", 30, "Spain", 1, 12.0, 82, 80));


        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Age");
        model.addColumn("Nationality");
        model.addColumn("Shirt Number");
        model.addColumn("Price");
        model.addColumn("Fitness Level");
        model.addColumn("Happiness Level");

        playerTable = new JTable(model);
        nameField = new JTextField(15);

        add(new JScrollPane(playerTable), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(nameField);
        buttonPanel.add(backButton);
        buttonPanel.add(buyButton);
        loadPlayersData(model);
        add(buttonPanel, BorderLayout.SOUTH);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HomePage().setVisible(true);
                dispose();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initializeUI() {
        buyButton = new JButton("Buy");
        backButton = new JButton("Back");
    }

    private void loadPlayersData(DefaultTableModel model) {
        for (Players player : transferplayers) {
            model.addRow(new Object[]{
                    player.getName(),
                    player.getAge(),
                    player.getNationality(),
                    player.getShirtNumber(),
                    player.getPrice(),
                    player.getFitnessLevel(),
                    player.getHappinessLevel()
            });
        }
    }

    public void buyPlayer(Players player) {
        if (transferplayers.contains(player)) {
            transferplayers.remove(player);
            squadPage.addPlayerToSquad(player);
            JOptionPane.showMessageDialog(null, player.getName() + " has been bought and added to the squad.");
        }
    }
}
