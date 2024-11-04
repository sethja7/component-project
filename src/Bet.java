/**
 * Class representing a bet (moneyline and spread odds for both teams).
 */
public class Bet {

    /**
     * Moneyline odds for Team A.
     */
    int moneylineA;

    /**
     * Moneyline odds for Team B.
     */
    int moneylineB;

    /**
     * Spread for Team A.
     */
    double spreadA;

    /**
     * Spread for Team B.
     */
    double spreadB;

    /**
     * Useful constant, not a magic number: 100.0.
     */
    private static final double oneHundred = 100.0;

    /**
     * Method to establish bet class.
     *
     * @param moneylineA
     *            moneyline for team A
     * @param moneylineB
     *            moneyline for team B
     * @param spreadA
     *            spread of A
     * @param spreadB
     *            spread of B
     */
    Bet(int moneylineA, int moneylineB, double spreadA, double spreadB) {
        this.moneylineA = moneylineA;
        this.moneylineB = moneylineB;
        this.spreadA = spreadA;
        this.spreadB = spreadB;
    }

    /**
     * Helper method to calculate moneyline payout.
     *
     * @param wager
     *            the amount of money bet
     * @param odds
     *            the odds for a moneyline bet
     * @return the value of payout if won
     */
    public static double calculateMoneylinePayout(double wager, int odds) {
        // Check for positive of negative odds
        double payout = 0;
        if (odds > 0) {
            // Calculate positive odds payout
            payout = wager * (odds / oneHundred) + wager;

        } else {
            // Calculate negative odds using absolute value
            payout = wager * (oneHundred / Math.abs(odds)) + wager;
        }

        return payout;

    }

    /**
     * Helper method to calculate spread payout (for simplicity, assuming even
     * payout).
     *
     * @param wager
     *            the amount of money bet
     * @return the value of payout if won
     */
    public static double calculateSpreadPayout(double wager) {
        // Assuming even payout for spread bets
        return wager * 2;
    }

}
