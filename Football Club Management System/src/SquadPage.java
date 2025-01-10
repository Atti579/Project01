import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SquadPage extends JFrame implements Serializable{
    private static final String FILE_PATH = "players.txt";
    private JTable playerTable;
    private JTextField nameField;
    private ArrayList<Players> squadplayers;
    private JButton deleteButton;
    private JButton trainButton;
    private JButton backButton;

    public SquadPage() {
        setTitle("Squad");
        initializeUI();
        //loadPlayersFromFile();
        setSize(600, 400);
        setForeground(new Color(210, 210, 210));

        squadplayers = new ArrayList<>();
        squadplayers.add(new Players("Vinícius Júnior", 24, "Brazil", 7, 200.0, 85, 90));
        squadplayers.add(new Players("Kylian Mbappe", 25, "France", 9, 180.0, 90, 95));
        squadplayers.add(new Players("Rodrygo", 23, "Brazil", 11, 110.0, 95, 92));
        squadplayers.add(new Players("Jude Bellingham", 21, "England", 5, 180.0, 85, 90));
        squadplayers.add(new Players("Eduardo Camavinga", 22, "France", 6, 100.0, 90, 95));
        squadplayers.add(new Players("Federico Valverde", 26, "Uruguay", 8, 130.0, 95, 92));
        squadplayers.add(new Players("Fran Garcia", 25, "Spain", 20, 15.0, 85, 90));
        squadplayers.add(new Players("Antonio Rudiger", 31, "Germany", 22, 25.0, 90, 95));
        squadplayers.add(new Players("Eder Militao", 26, "Brazil", 3, 60.0, 95, 92));
        squadplayers.add(new Players("Lucas Vasquez", 33, "Spain", 17, 4.0, 90, 95));
        squadplayers.add(new Players("Andriy Lunin", 25, "Ukraine", 13, 25.0, 95, 92));


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
        buttonPanel.add(deleteButton);
        buttonPanel.add(trainButton);
        buttonPanel.add(backButton);

        add(buttonPanel, BorderLayout.SOUTH);

        loadPlayersData(model);

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String playerName = nameField.getText().trim();
                if (playerName.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a player name.");
                    return;
                }

                deletePlayerByName(playerName, model);
            }
        });

        trainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = playerTable.getSelectedRow();
                if (selectedRow >= 0) {
                    String playerName = (String) playerTable.getValueAt(selectedRow, 0);

                    for (int i = 0; i < squadplayers.size(); i++) {
                        Players p = squadplayers.get(i);
                        if (p.getName().equals(playerName)) {
                            SpecialPlayer specialPlayer = new SpecialPlayer(p.getName(), p.getAge(), p.getNationality(),
                                    p.getShirtNumber(), p.getPrice(), p.getFitnessLevel(), p.getHappinessLevel());
                            specialPlayer.trainPlayer();

                            squadplayers.set(i, specialPlayer);

                            model.setValueAt("Special", selectedRow, 5);
                            //savePlayersToFile();
                            JOptionPane.showMessageDialog(null, playerName + " is now a special player and in form!");

                            break;
                        }
                    }
                }
            }
        });



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

    private void savePlayersToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            out.writeObject(squadplayers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initializeUI() {
        deleteButton = new JButton("Delete");
        trainButton = new JButton("Train");
        backButton = new JButton("Back");
    }

    private void deletePlayerByName(String playerName, DefaultTableModel model) {
        Players playerToDelete = null;
        for (Players player : squadplayers) {
            if (player.getName().equalsIgnoreCase(playerName)) {
                playerToDelete = player;
                break;
            }
        }

        if (playerToDelete != null) {
            squadplayers.remove(playerToDelete);
            JOptionPane.showMessageDialog(null, "Player deleted successfully.");
            model.setRowCount(0);
            loadPlayersData(model);
        } else {
            JOptionPane.showMessageDialog(null, "Player not found.");
        }
    }

    private void loadPlayersFromFile() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            squadplayers = (ArrayList<Players>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void loadPlayersData(DefaultTableModel model) {
        for (Players player : squadplayers) {
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

    public void addPlayerToSquad(Players player) {
        squadplayers.add(player);
    }
}
