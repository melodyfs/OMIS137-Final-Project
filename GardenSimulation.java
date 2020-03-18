import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*; 
import javax.swing.border.EmptyBorder;

class GardenSimulation extends JFrame {

    static String logString;
    static int logReadSoFarLineNum = 0;
    static Garden garden = new Garden();
    static Watering watering = new Watering(700, 400, 100, 24, 10);

    public GardenSimulation() {
        initUI();
    }

    private void initUI() {

        var menubar = new JMenuBar();
        var timeStepMenu = new JMenu("Day: 0");
        var wateringMenu = new JMenu("Amount of water in gallon: " + watering.getGallons());
        wateringMenu.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        menubar.add(timeStepMenu);
        menubar.add(wateringMenu);
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
        var nextIcon = new ImageIcon("images/next.png");
        var waterIcon = new ImageIcon("images/watering.png");
        var pesticideIcon = new ImageIcon("images/insecticide.png");
        var logIcon = new ImageIcon("images/log.png");

        var startButton = new JButton("Start", startIcon);
        startButton.setToolTipText("Start our garden");
        startButton.setHorizontalTextPosition(SwingConstants.CENTER);
        startButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        startButton.setBorder(emptyBorder);
        startButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String initialNumOfFlower = JOptionPane.showInputDialog(null,
                                            "How many plants do you want? Enter a number. ", null);

                garden.initialPlantMaker(Integer.parseInt(initialNumOfFlower));
                initPlants(panel);
                garden.masterPlantReset();

                String initalNumOfBug = JOptionPane.showInputDialog(null,
                                        "How many bugs do you want? Enter a number. ", null);
                garden.initialBugMaker(Integer.parseInt(initalNumOfBug));
                initBugs(panel);

                startButton.setEnabled(false);
            }
        });

        var nextButton = new JButton("Next day", nextIcon);
        nextButton.setToolTipText("Go to next day");
        nextButton.setBorder(emptyBorder);
        nextButton.setHorizontalTextPosition(SwingConstants.CENTER);
        nextButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                garden.dayAdder();
                menubar.removeAll();
                watering.setGallons(watering.getGallons() - 10);
                
                var timeStepMenu = new JMenu("Day: " + garden.dayGetter());
                menubar.add(timeStepMenu);
                var wateringMenu = new JMenu("Amount of water (gallon): " + watering.getGallons());
                menubar.add(wateringMenu);
                menubar.revalidate();
                
                garden.growPlants();
                garden.masterBugBreeder();
                weeklyBugBreeder(panel);
                garden.masterBugsEating();
            }
        });

        var waterButton = new JButton("Water", waterIcon);
        waterButton.setToolTipText("Water the plants");
        waterButton.setBorder(emptyBorder);
        waterButton.setHorizontalTextPosition(SwingConstants.CENTER);
        waterButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        waterButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                watering.setGallons(watering.getGallons() + 100);
                menubar.remove(1);
                var wateringMenu = new JMenu("Amount of water (gallon): " + watering.getGallons());
                menubar.add(wateringMenu);
                menubar.revalidate();
            }
        });

        var pesticideButton = new JButton("Pesticide", pesticideIcon);
        pesticideButton.setToolTipText("Spread the pesticide");
        pesticideButton.setBorder(emptyBorder);
        pesticideButton.setHorizontalTextPosition(SwingConstants.CENTER);
        pesticideButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        pesticideButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String[] values = {"Hot Pepper", "Insect Soap", "Rubbing Alcohol"};

                Object selected = JOptionPane.showInputDialog(null, "Which pesticide do you want to use?", "Selection", JOptionPane.DEFAULT_OPTION, null, values, "0");
                if ( selected != null) {
                    String selectedString = selected.toString();
                    switch (selectedString) {
                        case "Hot Pepper":
                            garden.masterPesttoPlant(true, false, false);
                            garden.masterBugKiller(true, false, false);
                        case "Insect Soap":
                            garden.masterPesttoPlant(false, true, false);
                            garden.masterBugKiller(false, true, false);
                        default:
                            garden.masterPesttoPlant(false, false, true);
                            garden.masterBugKiller(false, false, true);
                    }
                }
            }
        });

        var viewLogButton = new JButton("View Log", logIcon);
        viewLogButton.setToolTipText("See what happened in our garden");
        viewLogButton.setBorder(emptyBorder);
        viewLogButton.setHorizontalTextPosition(SwingConstants.CENTER);
        viewLogButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        viewLogButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readLog("GardenLog.log");
                JOptionPane.showMessageDialog(null, logString);
            }
        });

        var exitIcon = new ImageIcon("images/exit.png");
        var exitButton = new JButton("Exit", exitIcon);
        exitButton.setToolTipText("Exit our garden");
        exitButton.setBorder(emptyBorder);
        exitButton.setHorizontalTextPosition(SwingConstants.CENTER);
        exitButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        exitButton.addActionListener((event) -> System.exit(0));

        vertical.add(startButton);
        vertical.add(nextButton);
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

    private static void initPlants(JPanel panel) {
        var roseIcon = new ImageIcon("images/rose.png");
        var daisyIcon = new ImageIcon("images/daisy.png");
        var sunflowerIcon = new ImageIcon("images/sunflower.png");
        var tomatoIcon = new ImageIcon("images/tomato.png");
        var basilIcon = new ImageIcon("images/basil.png");
        var cucumberIcon = new ImageIcon("images/cucumber.png");
        var strawberryIcon = new ImageIcon("images/strawberry.png");
    
        for (int i = 0; i < garden.roses.size(); i++) {
            Plant rose = garden.roses.get(i);
            addPlant("Rose " + String.valueOf(i).toString(), panel, roseIcon, rose);
        }
        for (int i = 0; i < garden.daisies.size(); i++) {
            Plant daisy = garden.daisies.get(i);
            addPlant("Daisy " + String.valueOf(i).toString(), panel, daisyIcon, daisy);
        }
        for (int i = 0; i < garden.sunflowers.size(); i++) {
            Plant sunflower = garden.sunflowers.get(i);
            addPlant("Sunflower " + String.valueOf(i).toString(), panel, sunflowerIcon, sunflower);
        }
        for (int i = 0; i < garden.tomatoes.size(); i++) {
            Plant tomato = garden.tomatoes.get(i);
            addPlant("Tomato " + String.valueOf(i).toString(), panel, tomatoIcon, tomato);
        }
        for (int i = 0; i < garden.basilList.size(); i++) {
            Plant basil = garden.basilList.get(i);
            addPlant("Basil " + String.valueOf(i).toString(), panel, basilIcon, basil);
        }
        for (int i = 0; i < garden.cucumbers.size(); i++) {
            Plant cucumber = garden.cucumbers.get(i);
            addPlant("Cucmber " + String.valueOf(i).toString(), panel, cucumberIcon, cucumber);
        }
        for (int i = 0; i < garden.strawberries.size(); i++) {
            Plant strawberry = garden.strawberries.get(i);
            addPlant("Strawberry " + String.valueOf(i).toString(), panel, strawberryIcon, strawberry);
        }
    }

    private static ImageIcon caterpillarIcon = new ImageIcon("images/caterpillar.png");
    private static ImageIcon antIcon = new ImageIcon("images/ant.png");
    private static ImageIcon aphidIcon = new ImageIcon("images/aphid.png");
    private static ImageIcon mealyBugIcon = new ImageIcon("images/mealyBug.png");
    private static ImageIcon miteIcon = new ImageIcon("images/mite.png");
    private static ImageIcon thripIcon = new ImageIcon("images/thrip.png");
    private static ImageIcon whiteflyIcon = new ImageIcon("images/whitefly.png");

    private static void initBugs(JPanel panel) {
        for (int i = 0; i < garden.caterpillars.size(); i++) {
            Bug caterpillar = garden.caterpillars.get(i);
            addBug("Caterpillar " + String.valueOf(i).toString(), panel, caterpillarIcon, caterpillar);
        }
        for (int i = 0; i < garden.ants.size(); i++) {
            Bug ant = garden.ants.get(i);
            addBug("Ant " + String.valueOf(i).toString(), panel, antIcon, ant);
        }
        for (int i = 0; i < garden.aphids.size(); i++) {
            Bug aphid = garden.aphids.get(i);
            addBug("Aphid " + String.valueOf(i).toString(), panel, aphidIcon, aphid);
        }
        for (int i = 0; i < garden.mealyBugs.size(); i++) {
            Bug mealyBug = garden.mealyBugs.get(i);
            addBug("MealyBug " + String.valueOf(i).toString(), panel, mealyBugIcon, mealyBug);
        }
        for (int i = 0; i < garden.mites.size(); i++) {
            Bug mite = garden.mites.get(i);
            addBug("Mite " + String.valueOf(i).toString(), panel, miteIcon, mite);
        }
        for (int i = 0; i < garden.thrips.size(); i++) {
            Bug thrip = garden.thrips.get(i);
            addBug("Thrip " + String.valueOf(i).toString(), panel, thripIcon, thrip);
        }
        for (int i = 0; i < garden.whiteflies.size(); i++) {
            Bug whitefly = garden.whiteflies.get(i);
            addBug("Whitefly " + String.valueOf(i).toString(), panel, whiteflyIcon, whitefly);
        }
    }
    
    private static void weeklyBugBreeder(JPanel panel) {
        if (garden.dayGetter() > 1 && garden.dayGetter() % 7 == 1) {
            for (int i = 0; i < garden.caterpillars.size()/2; i++) {
                Bug caterpillar = garden.caterpillars.get(i);
                addBug("Caterpillar " + String.valueOf(garden.caterpillars.size() + i).toString(), panel, caterpillarIcon, caterpillar);
            }
            for (int i = 0; i < garden.ants.size()/2; i++) {
                Bug ant = garden.ants.get(i);
                addBug("Ant " + String.valueOf(garden.ants.size() + i).toString(), panel, antIcon, ant);
            }
            for (int i = 0; i < garden.aphids.size()/2; i++) {
                Bug aphid = garden.aphids.get(i);
                addBug("Aphid " + String.valueOf(garden.aphids.size() + i).toString(), panel, aphidIcon, aphid);
            }
            for (int i = 0; i < garden.mealyBugs.size()/2; i++) {
                Bug mealyBug = garden.mealyBugs.get(i);
                addBug("MealyBug " + String.valueOf(garden.mealyBugs.size() + i).toString(), panel, mealyBugIcon, mealyBug);
            }
            for (int i = 0; i < garden.mites.size()/2; i++) {
                Bug mite = garden.mites.get(i);
                addBug("Mite " + String.valueOf(garden.mites.size() + i).toString(), panel, miteIcon, mite);
            }
            for (int i = 0; i < garden.thrips.size()/2; i++) {
                Bug thrip = garden.thrips.get(i);
                addBug("Thrip " + String.valueOf(garden.thrips.size()+ i).toString(), panel, thripIcon, thrip);
            }
            for (int i = 0; i < garden.whiteflies.size()/2; i++) {
                Bug whitefly = garden.whiteflies.get(i);
                addBug("Whitefly " + String.valueOf(garden.whiteflies.size() + i).toString(), panel, whiteflyIcon, whitefly);
            }
        }
    }

    private static void addPlant(String name, JPanel panel, ImageIcon icon, Plant plant) {
        var plantButton = new JButton(name, icon);
        plantButton.setHorizontalTextPosition(SwingConstants.CENTER);
        plantButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        plantButton.setBorder(new EmptyBorder(3, 0, 3, 0));
        plantButton.setToolTipText("Click me");
        plantButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String infoString = "Plant type: " + plant.plantType.name() + " \n" 
                                + "Height: " + plant.Height + "\n"
                                + "Max Height: " + plant.maxHeight + "\n" 
                                + "Growth Rate: " + plant.growthRate + "\n"
                                + "Color: " + plant.color;
                JOptionPane.showMessageDialog(null, infoString);
                
                if (plant.Height <= 0 || plant.growthRate <= 0) {
                    plantButton.setVisible(false);
                    panel.revalidate();
                }
            }
        });
        panel.add(plantButton);
        panel.revalidate();
    }

    private static void addBug(String name, JPanel panel, ImageIcon icon, Bug bug) {
        var bugButton = new JButton(name, icon);
        bugButton.setHorizontalTextPosition(SwingConstants.CENTER);
        bugButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        bugButton.setBorder(new EmptyBorder(3, 0, 3, 0));
        bugButton.setToolTipText("Click me to see if I'm dead");
        bugButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String infoString = "Bug type: " + bug.type.name() + " \n" 
                                + bug.type.name() + " eats this type of plant: " + bug.whichPlantEats + "\n"
                                + "Destruction rate: " + bug.destructionRate + "\n";
                JOptionPane.showMessageDialog(null, infoString);
                if ((bug.type == BugType.caterpillar && !garden.caterpillars.contains(bug)) 
                || (bug.type == BugType.ants && !garden.ants.contains(bug)) 
                || (bug.type == BugType.aphid && !garden.aphids.contains(bug))
                || (bug.type == BugType.mealyBug && !garden.mealyBugs.contains(bug))
                || (bug.type == BugType.mite && !garden.mites.contains(bug))
                || (bug.type == BugType.whiteflies && !garden.whiteflies.contains(bug)) 
                || (bug.type == BugType.thrips && !garden.thrips.contains(bug))) {
                        bugButton.setVisible(false);
                        panel.revalidate();
                }
            }
        });
        panel.add(bugButton);
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
            var ex = new GardenSimulation();
            ex.setVisible(true);
        });
    }
 }
 