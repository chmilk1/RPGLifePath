public class Main {
    public static void main(String[] args) {
        System.out.println("Starting up ... credit James Maron, chmilk1 on GitHub");
        StringBuilder masterLog = new StringBuilder();

        LifeEventsGUI mainGUI = new LifeEventsGUI(masterLog);
        mainGUI.init();

        System.out.print(masterLog.toString());
    }
}