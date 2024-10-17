import components.set.Set;

/**
 * {@code SportsBookKernel} enhanced with secondary methods.
 */
public interface SportsBook extends SportsBookKernel {
    /**
     * Calculates the payout of a bet in {@code this}.
     *
     * @param bet
     *            the name of the bet to check
     *
     * @return the calculated value of the payout if bet is won
     */
    double calculatePayout(Bet bet);

    /**
     * Calculates the payout of a bet in {@code this}.
     *
     * @param bet
     *            the name of the bet to check
     * @param amount
     *            the value placed on a potential bet
     *
     * @return the calculated value of the payout if bet is won
     */
    double calculatePotentialBet(Bet bet, double amount);

    /**
     * Finds all the currently open bets in {@code this}.
     *
     *
     * @return all open bets in the SportsBook
     */
    Set<Bet> getOpenBets();

    /**
     * Finds the current value in the user's account.
     *
     *
     * @return the total amount of money in the user's account
     */
    double getCurrentBalance();
}
