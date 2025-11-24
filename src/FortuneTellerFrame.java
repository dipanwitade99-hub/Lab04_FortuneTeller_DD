import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {

    private JTextArea fortunesArea;
    private JButton readFortuneButton;
    private JButton quitButton;
    private List<String> fortunes;
    private Random rng;
    private int lastIndex = -1;

    public FortuneTellerFrame() {
        super("Fortune Teller");

        rng = new Random();
        fortunes = new ArrayList<>();
        populateFortunes();

        setLayout(new BorderLayout(10, 10));


        JLabel titleLabel = new JLabel("Fortune Teller", new ImageIcon("fortune_teller.jpg"), JLabel.CENTER);
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);
        titleLabel.setVerticalTextPosition(JLabel.BOTTOM);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 48));
        add(titleLabel, BorderLayout.NORTH);


        fortunesArea = new JTextArea(10, 40);
        fortunesArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
        fortunesArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(fortunesArea);
        add(scrollPane, BorderLayout.CENTER);


        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());

        readFortuneButton = new JButton("Read My Fortune!");
        readFortuneButton.setFont(new Font("SansSerif", Font.BOLD, 18));
        readFortuneButton.addActionListener(e -> showRandomFortune());
        bottomPanel.add(readFortuneButton);

        quitButton = new JButton("Quit");
        quitButton.setFont(new Font("SansSerif", Font.BOLD, 18));
        quitButton.addActionListener(e -> System.exit(0));
        bottomPanel.add(quitButton);

        add(bottomPanel, BorderLayout.SOUTH);


        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) (screenSize.width * 0.75);
        int height = (int) (screenSize.height * 0.75);
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Add at least 12 humorous fortunes
    private void populateFortunes() {
        fortunes.add("You will find a surprise in your mailbox soon.");
        fortunes.add("A thrilling time is in your near future.");
        fortunes.add("You will meet someone famous in a surprising place.");
        fortunes.add("Your luck will turn today – maybe at lunch!");
        fortunes.add("A secret admirer will send you a mysterious message.");
        fortunes.add("You will discover a hidden talent for karaoke.");
        fortunes.add("Today is a perfect day to try something new.");
        fortunes.add("Beware of flying objects… but not too much.");
        fortunes.add("You will have a laugh that echoes for days.");
        fortunes.add("A small act of kindness will bring you joy.");
        fortunes.add("Unexpected good news is coming your way.");
        fortunes.add("You might get an opportunity you’ve been waiting for.");
    }


    private void showRandomFortune() {
        if (fortunes.isEmpty()) return;

        int index;
        do {
            index = rng.nextInt(fortunes.size());
        } while (index == lastIndex);

        lastIndex = index;
        fortunesArea.append(fortunes.get(index) + "\n");
    }
}
