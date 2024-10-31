import components.set.Set;

public abstract class SportsBookSecondary {
    -`void resolveParlay(Set<Bet>, String result)`: resolves a parlay of bets as win or loss in `this`
    - `double calculateParlayPayout(Set<Bet> bet)`: calculates the payout of `bets`
    - `double calculatePotentialParlay(Set<Bet> bets, int amount)`: calculates the payout of `bets` with the given `amount` bet
    - `double calculatePayout(Bet bet)`: calculates the payout of `bet`
    - `double calculatePotentialBet(Bet bet, int amount)`: calculates the payout of `bet` with the given `amount` bet
    - `Set<Bet> getOpenBets()`: retrieves the open bets in `this`
    - `double getCurrentBalance()`: reports the user's current balance in `this`
}
