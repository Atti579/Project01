import javax.swing.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TicketsPage extends JFrame{
    private ArrayList<Tickets> tickets;
    private JTable ticketTable;
    private JTextField textField;
    private JButton buyButton;
    private JButton changePriceButton;
    private JButton backButton;

    public TicketsPage() {
        tickets = new ArrayList<>();
        initializeUI();
        setTitle("Tickets");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initializeUI() {
        tickets.add(new Tickets(30, "Behind Goal", "Real Sociedad-Real Madrid"));
        tickets.add(new Tickets(50, "Left Side of Goal", "Real Sociedad-Real Madrid"));
        tickets.add(new Tickets(75, "Right Side of Middle Part", "Real Sociedad-Real Madrid"));
        tickets.add(new Tickets(110, "Middle", "Real Sociedad-Real Madrid"));
        tickets.add(new Tickets(150, "VIP", "Real Sociedad-Real Madrid"));

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Price");
        model.addColumn("Seat");
        model.addColumn("Match");

        for (Tickets ticket : tickets) {
            model.addRow(new Object[]{ticket.getPrice(), ticket.getType(), ticket.getMatch()});
        }

        ticketTable = new JTable(model);
        ticketTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        textField = new JTextField(15);
        buyButton = new JButton("Buy Ticket");
        changePriceButton = new JButton("Change Price");
        backButton = new JButton("Back");

        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = ticketTable.getSelectedRow();
                if (selectedRow != -1) {
                    String seat = (String) model.getValueAt(selectedRow, 1);
                    JOptionPane.showMessageDialog(TicketsPage.this,
                            "Ticket for seat " + seat + " purchased successfully!");
                } else {
                    JOptionPane.showMessageDialog(TicketsPage.this,
                            "Please select a ticket to buy.");
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

        changePriceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = ticketTable.getSelectedRow();
                if (selectedRow != -1) {
                    String inputPrice = JOptionPane.showInputDialog("Enter new price:");
                    try {
                        double newPrice = Double.parseDouble(inputPrice);
                        tickets.get(selectedRow).changePrice(newPrice);
                        updateTable();
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid price. Please enter a number.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a ticket to change the price.");
                }
            }
        });

        add(new JScrollPane(ticketTable), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(new JLabel("Enter Details:"));
        buttonPanel.add(textField);
        buttonPanel.add(buyButton);
        buttonPanel.add(changePriceButton);
        buttonPanel.add(backButton);
        add(buttonPanel, BorderLayout.SOUTH);


    }

    private void updateTicketPrice(int selectedRow, double newPrice) {
        if (selectedRow != -1) {
            Tickets selectedTicket = tickets.get(selectedRow);
            selectedTicket.changePrice(newPrice);
            JOptionPane.showMessageDialog(this, "Price updated!");
        }
    }

    private void updateTable() {
        DefaultTableModel model = (DefaultTableModel) ticketTable.getModel();
        model.setRowCount(0);
        for (Tickets ticket : tickets) {
            model.addRow(new Object[]{ticket.getPrice(), ticket.getType(), ticket.getMatch()});
        }
    }

}

