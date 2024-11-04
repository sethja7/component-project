import components.map.Map;
import components.set.Set;
import components.set.Set1L;

/**
 * {@code SportsBookKernel} enhanced with secondary methods implemented.
 */
public abstract class SportsBookSecondary {

    /**
     * The current value of all sportsbook bets.
     */
    private double currentBalance;

    /**
     * The map of open bets tracked in a map with a string of the team.
     */
    private Map<String, Set<Bet>> openBets;

    /**
     * Method to calculate the payout based on the type of bet.
     *
     * @param wager
     *            the amount of money bet
     * @param bet
     *            the given bet to check the odds for
     * @param betType
     *            the type of bet chosen (moneyline or spread)
     * @return the value of the bet if won
     */
    public double calculatePayout(double wager, Bet bet, BetType betType) {
        switch (betType) {
            case MONEYLINE_A:
                return Bet.calculateMoneylinePayout(wager, bet.moneylineA);
            case MONEYLINE_B:
                return Bet.calculateMoneylinePayout(wager, bet.moneylineB);
            case SPREAD_A:
            case SPREAD_B:
                return Bet.calculateSpreadPayout(wager);
            default:
                return 0;
        }
    }

    /**
     * Method to find the current set of open bets in the Sportsbook.
     *
     * @return A set of all the open bets is returned.
     */
    public Set<Bet> getOpenBets() {

        Set<Bet> currentOpenBets = new Set1L<Bet>();

        for (Bet bets : this.openBets.removeAny().value()) {
            currentOpenBets.add(bets);
        }
        return currentOpenBets;
    }

    /**
     * Method to find the current balance in the sportsbook.
     *
     * @return The value of the sportsbook current balance is found.
     */
    public double getCurrentBalance() {
        return this.currentBalance;
    }
}
