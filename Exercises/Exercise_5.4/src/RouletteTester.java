public class RouletteTester {
    public static void main(String[] args) {
        RoulettePlayer simulator = new RoulettePlayer();

        for (int i = 0; i < 10000; i++) {
            simulator.visitCasino(100, 200);
        }

        System.out.println("Probability of success: " + simulator.getWinProbability() + "%");
    }
}
