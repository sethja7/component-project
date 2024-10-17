import components.standard.Standard;

/**
 * {@code Standard} enhanced with SportsBook specific kernel methods.
 */
public interface SportsBookKernel extends Standard<SportsBook> {

    /**
     * Creates a new game to bet on in {@code this}.
     *
     * @param teamA
     *            name of Team A in the new bet
     * @param teamB
     *            name of Team B in the new bet
     * @param moneylineAOdds
     *            the odds associated with Team A winning
     * @param moneylineBOdds
     *            the odds associated with Team B winning
     * @param spreadA
     *            the spread for Team A
     * @param spreadB
     *            the spread for Team B
     */
    void createGame(String teamA, String teamB, double moneylineAOdds,
            double moneylineBOdds, double spreadA, double spreadB);

    /**
     * Updates odds on an existing game in {@code this} for one team.
     *
     * @param team
     *            name of the team whom's odds are changing
     * @param betType
     *            type of bet that is being changed (moneyline or spread)
     * @param odds
     *            the updated value to associate with the bet
     */
    void updateOdds(String team, BetType betType, double odds);

    /**
     * Update an open bet in {@code this} with the result for the given bet.
     *
     * @param bet
     *            the bet to resolve
     * @param result
     *            the result of the bet (true if won, false if lost)
     */
    void resolveBet(Bet bet, Boolean result);

    /**
     * Places a new open bet in {@code this} to be stored.
     *
     * @param team
     *            the team to place a bet on
     * @param wager
     *            the money placed on the bet
     * @param betType
     *            the type of bet (moneyline or spread)
     */
    void placeBet(String team, double wager, BetType betType);

}
