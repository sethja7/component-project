import components.map.Map;
import components.map.Map1L;

/**
 * Sportsbook test implementation for proof of concept.
 *
 * @author Seth Jarrett
 *
 */
public class SportsBookTest {
    /**
     * Representation of bet odds (moneyline and spread) for different teams.
     */
    private Map<String, Bet> availableBets;

    /**
     * Public constructor so this class can be instantianted.
     */
    public SportsBookTest() {
        this.availableBets = new Map1L<>();
    }

    /**
     * Method to add a bet to the system (either moneyline or spread).
     *
     * @param game
     *            the game to add a bet to
     * @param bet
     *            the details of the bet for the game
     * @ensures bet is added
     */
    public final void addBet(String game, Bet bet) {
        this.availableBets.add(game, bet);
    }

    /**
     * Method to place a bet on a game.
     *
     * @param game
     *            the game to place a bet on
     * @param wager
     *            the money placed on the bet
     * @param betType
     *            the type of bet (moneyline or spread)
     * @return the value of the payout if won
     */
    public final double placeBet(String game, double wager, BetType betType) {
        Bet bet = this.availableBets.value(game);
        if (bet != null) {
            return bet.calculatePayout(wager, betType);
        } else {
            System.out.println("No bet available for this game.");
            return 0;
        }
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        // Create sportsbook
        SportsBookTest sportsbook = new SportsBookTest();

        // Add bets for a game (example: Team A vs Team B)
        sportsbook.addBet("Ohio State vs Michigan",
                new Bet(-150, 110, -5.5, 5.5));

        // Place a moneyline bet on Ohio State with a $100 wager
        double payout = sportsbook.placeBet("Ohio State vs Michigan", 100,
                BetType.MONEYLINE_A);
        System.out.println("Payout for Ohio State moneyline bet: $" + payout);

        // Place a spread bet on Michigan with a $100 wager
        payout = sportsbook.placeBet("Ohio State vs Michigan", 100,
                BetType.SPREAD_B);
        System.out.println("Payout for Michigan spread bet: $" + payout);
    }
}

/**
 * Enum to represent different types of bets.
 */
enum BetType {
    MONEYLINE_A, MONEYLINE_B, SPREAD_A, SPREAD_B
}

/**
 * Class representing a bet (moneyline and spread odds for both teams).
 */
class Bet {
    /**
     * Moneyline odds for Team A.
     */
    private int moneylineA;

    /**
     * Moneyline odds for Team B.
     */
    private int moneylineB;

    /**
     * Spread for Team A.
     */
    private double spreadA;

    /**
     * Spread for Team B.
     */
    private double spreadB;

    /**
     * Useful constant, not a magic number: 100.0.
     */
    private final double oneHundred = 100.0;

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
     * Method to calculate the payout based on the type of bet.
     *
     * @param wager
     *            the amount of money bet
     * @param betType
     *            the type of bet chosen (moneyline or spread)
     * @return the value of the bet if won
     */
    public double calculatePayout(double wager, BetType betType) {
        switch (betType) {
            case MONEYLINE_A:
                return this.calculateMoneylinePayout(wager, this.moneylineA);
            case MONEYLINE_B:
                return this.calculateMoneylinePayout(wager, this.moneylineB);
            case SPREAD_A:
                return this.calculateSpreadPayout(wager, this.spreadA);
            case SPREAD_B:
                return this.calculateSpreadPayout(wager, this.spreadB);
            default:
                return 0;
        }
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
    private double calculateMoneylinePayout(double wager, int odds) {
        // Check for positive of negative odds
        double payout = 0;
        if (odds > 0) {
            // Calculate positive odds payout
            payout = wager * (odds / this.oneHundred) + wager;

        } else {
            // Calculate negative odds using absolute value
            payout = wager * (this.oneHundred / Math.abs(odds)) + wager;
        }

        return payout;

    }

    /**
     * Helper method to calculate spread payout (for simplicity, assuming even
     * payout).
     *
     * @param wager
     *            the amount of money bet
     * @param spread
     *            the spread of the bet to be calculated
     * @return the value of payout if won
     */
    private double calculateSpreadPayout(double wager, double spread) {
        // Assuming even payout for spread bets
        return wager * 2;
    }
}
