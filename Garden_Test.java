import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*; 
import javax.swing.border.EmptyBorder;

class Garden_Test extends JFrame {

    static String logString;
    static int logReadSoFarLineNum = 0;
    static int flowerNum = 0;
    static int bugNum = 0;
    static int timeStep = 0;
    static Color lightGreenColor = new Color(189, 242, 191, 100); 

    public Garden_Test() {
        initUI();
    }

    private void initUI() {

        var menubar = new JMenuBar();
        var timeStepMenu = new JMenu("Current time step: " + timeStep);

        menubar.add(timeStepMenu);
        setJMenuBar(menubar);

        var panel = new JPanel();

        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel.setLayout(new GridLayout(5, 4, 5, 5));
        // panel.setBackground(lightGreenColor);

        var vertical = new JToolBar(JToolBar.VERTICAL);
        vertical.setFloatable(false);
        vertical.setMargin(new Insets(10, 1, 1, 1));
        vertical.setBackground(Color.white);

        var emptyBorder = new EmptyBorder(10, 3, 3, 3);

        var startIcon = new ImageIcon("images/start.png");
        var seedIcon = new ImageIcon("images/seed.png");
        var waterIcon = new ImageIcon("images/watering.png");
        var pesticideIcon = new ImageIcon("images/insecticide.png");
        var logIcon = new ImageIcon("images/log.png");
        var flowerIcon = new ImageIcon("images/potted-plant.png");
        var bugIcon = new ImageIcon("images/bug.png");

        var startButton = new JButton(startIcon);
        startButton.setToolTipText("Start our garden");
        startButton.setBorder(emptyBorder);
        startButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String initialNumOfFlower = JOptionPane.showInputDialog(null,
                        "How many flowers do you want? Enter a number. ", null);
                String initalNumOfBug = JOptionPane.showInputDialog(null,
                "How many bugs do you want? Enter a number. ", null);

                for (int i = 0; i < Integer.parseInt(initialNumOfFlower); i++) {
                    addFlower(String.valueOf(i).toString(), panel, flowerIcon);
                }
        
                for (int i = 0; i < Integer.parseInt(initalNumOfBug); i++) {
                    addBug(String.valueOf(i).toString(), panel, bugIcon);
                }
                startButton.setEnabled(false);
            }
        });

        var plantButton = new JButton(seedIcon);
        plantButton.setToolTipText("Start a new plant");
        plantButton.setBorder(emptyBorder);
        plantButton.addActionListener((event) -> addFlower(String.valueOf(flowerNum), panel, flowerIcon));

        var waterButton = new JButton(waterIcon);
        waterButton.setToolTipText("Water the plants");
        waterButton.setBorder(emptyBorder);
        waterButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String flowerNumToBeWatered = JOptionPane.showInputDialog(null,
                        "Which flower do you want to water? Enter a number. ", null);
                waterFlower(flowerNumToBeWatered);
            }
        });

        var pesticideButton = new JButton(pesticideIcon);
        pesticideButton.setToolTipText("Spread the pesticide");
        pesticideButton.setBorder(emptyBorder);

        var viewLogButton = new JButton(logIcon);
        viewLogButton.setToolTipText("See what happened in our garden");
        viewLogButton.setBorder(emptyBorder);
        viewLogButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readLog("GardenLog.log");
                JOptionPane.showMessageDialog(null, logString);
            }
        });

        var exitIcon = new ImageIcon("images/exit.png");
        var exitButton = new JButton(exitIcon);
        exitButton.setToolTipText("Exit our garden");
        exitButton.setBorder(emptyBorder);
        exitButton.addActionListener((event) -> System.exit(0));

        vertical.add(startButton);
        vertical.add(plantButton);
        vertical.add(waterButton);
        vertical.add(pesticideButton);
        vertical.add(viewLogButton);
        vertical.add(exitButton);

        add(vertical, BorderLayout.WEST);

        add(panel, BorderLayout.CENTER);

        setSize(800, 500);
        setTitle("Our Garden");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private static void waterFlower(String num) {
        System.out.println(num);
    }

    private static void addFlower(String num, JPanel panel, ImageIcon flowerIcon) {
        var flowerButton = new JButton("flower " + num, flowerIcon);
        flowerButton.setHorizontalTextPosition(SwingConstants.CENTER);
        flowerButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        flowerButton.setBorder(new EmptyBorder(3, 0, 3, 0));
        flowerButton.setToolTipText("Click me");
        // flowerButton.setBackground(Color.white);
        // flowerButton.setBorderPainted(false);
        flowerButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JOptionPane.showMessageDialog(null, "My status");
            }
        });
        panel.add(flowerButton);
        flowerNum += 1;
        panel.revalidate();
    }

    private static void addBug(String num, JPanel panel, ImageIcon flowerIcon) {
        var bugButton = new JButton("bug " + num, flowerIcon);
        bugButton.setHorizontalTextPosition(SwingConstants.CENTER);
        bugButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        bugButton.setBorder(new EmptyBorder(3, 0, 3, 0));
        bugButton.setToolTipText("Click me");
        // flowerButton.setBackground(Color.white);
        // flowerButton.setBorderPainted(false);
        bugButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JOptionPane.showMessageDialog(null, "My status");
            }
        });
        panel.add(bugButton);
        bugNum += 1;
        panel.revalidate();
    }

    private static void readLog(String fileName) {
        ArrayList<String> logs = new ArrayList<String>();
        try{
            FileInputStream fstream = new FileInputStream(fileName);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String strLine;

            while ((strLine = br.readLine()) != null)   {
                logs.add(strLine);
            }
            in.close();
        }
        catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        for (int i = logReadSoFarLineNum; i < logs.size(); i++) {
            logString += logs.get(i) + "\n";
        }
        logReadSoFarLineNum = logs.size();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var ex = new Garden_Test();
            ex.setVisible(true);
        });
    }
 }
 