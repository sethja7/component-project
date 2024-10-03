# Portfolio Part 1: Component Brainstorming

- **Name**: Seth Jarrett
- **Dot Number**: Jarrett.138
- **Due Date**: 9/16/24

## Assignment Overview

The overall goal of the portfolio project is to have you design and implement
your own OSU component. There are no limits to what you choose to design and
implement, but your component must fit within the constraints of our software
sequence discipline. In other words, the component must extend from Standard and
must include both a kernel and a secondary interface.

Because this is a daunting project, we will be providing you with a series of
activities to aid in your design decisions. For example, the point of this
assignment is to help you brainstorm a few possible components and get some
feedback. For each of these components, you will need to specify the high-level
design in terms of the software sequence discipline. In other words, you will
describe a component, select a few kernel methods for your component, and select
a few secondary methods to layer on top of your kernel methods.

You are not required to specify contracts at this time. However, you are welcome
to be as detailed as you'd like. More detail means you will be able to get more
detailed feedback, which may help you decide which component to ultimately
implement.

## Assignment Checklist

To be sure you have completed everything on this assignment, we have littered
this document with TODO comments. You can browse all of them in VSCode by
opening the TODOs window from the sidebar. The icon looks like a tree and will
likely have a large number next to it indicating the number of TODOS. You'll
chip away at that number over the course of the semester. However, if you'd
like to remove this number, you can disable it by removing the following
line from the `settings.json` file:

```json
"todo-tree.general.showActivityBarBadge": true,
```

Which is not to be confused with the following setting that adds the counts
to the tree diagram (you may remove this one as well):

```json
"todo-tree.tree.showCountsInTree": true,
```

## Assignment Learning Objectives

Without learning objectives, there really is no clear reason why a particular
assessment or activity exists. Therefore, to be completely transparent, here is
what we're hoping you will learn through this particular aspect of the portfolio
project. Specifically, students should be able to:

1. Integrate their areas of interest in their personal lives and/or careers with
   their knowledge of software design
2. Determine the achievablility of a software design given time constraints
3. Design high-level software components following the software sequence
   discipline

## Assignment Rubric: 10 Points

Again, to be completely transparent, most of the portfolio project, except the
final submission, is designed as a formative assessment. Formative assessments
are meant to provide ongoing feedback in the learning process. Therefore,
the rubric is designed to assess the learning objectives *directly* in a way
that is low stakes—meaning you shouldn't have to worry about the grade. Just
do good work.

1. (3 points) Each design must align with your personal values and long-term
   goals. Because the goal of this project is to help your build out a
   portfolio, you really ought to care about what you're designing. We'll give
   you a chance to share your personal values, interests, and long-term goals
   below.
2. (3 points) Each design must be achievable over the course of a single
   semester. Don't be afraid to design something very small. There is no shame
   in keeping it simple.
3. (4 points) Each design must fit within the software sequence discipline. In
   other words, your design should expect to inherit from Standard, and it
   should contain both kernel and secondary methods. Also, null and aliasing
   must be avoided, when possible. The methods themselves must also be in
   justifiable locations, such as kernel or secondary.

## Pre-Assignment

> Before you jump in, we want you to take a moment to share your interests
> below. Use this space to talk about your career goals as well as your personal
> hobbies. These will help you clarify your values before you start
> brainstorming. Plus it helps us get to know you better! Feel free to share
> images in this section.

> My career goals include finding productive ways to express technical skills. For
> me personally, I enjoy sports, including football, basketball, and other entertainment.
> My goal would be to find a way to integrate these understandings into these forms
> of entertainment. Potentially data science or analysis for sports, or sports gambling
> or other applications. Additionally, the technology used for sports science is intriguing
> to me and the methodolgies for prototyping and simulating.

## Assignment

As previously stated, you are tasked with brainstorming 3 possible components.
To aid you in this process, we have provided [some example components][example-components]
that may help you in your brainstorming. All of these components were made at
some point by one of your peers, so you should feel confident that you can
accomplish any of them.

There is no requirement that you use any of the components listed above.
If you want to model something else, go for it! Very common early object
projects usually attempt to model real-world systems like banks, cars,
etc. Make of this whatever seems interesting to you, and keep in mind that
you're just brainstorming right now. You do not have to commit to anything.

### Example Component

To help you brainstorm a few components, we've provided an example below of a
component you already know well: NaturalNumber. We highly recommend that you
mirror the formatting as close as possible in your designs. By following this
format, we can be more confident that your designs will be possible.

- Example Component: `NaturalNumber`
  - **Description**:
    - The purpose of this component is to model a non-negative
      integer. Our intent with this design was to keep a simple kernel that
      provides the minimum functionality needed to represent a natural number.
      Then, we provide more complex mathematical operations in the secondary
      interface.
  - **Kernel Methods**:
    - `void multiplyBy10(int k)`: multiplies `this` by 10 and adds `k`
    - `int divideBy10()`: divides `this` by 10 and reports the remainder
    - `boolean isZero()`: reports whether `this` is zero
  - **Secondary Methods**:
    - `void add(NaturalNumber n)`: adds `n` to `this`
    - `void subtract(NaturalNumber n)`: subtracts `n` from `this`
    - `void multiply(NaturalNumber n)`: multiplies `this` by `n`
    - `NaturalNumber divide(NaturalNumber n)`: divides `this` by `n`, returning
      the remainder
    - ...
  - **Additional Considerations** (*note*: "I don't know" is an acceptable
    answer for each of the following questions):
    - Would this component be mutable? Answer and explain:
      - Yes, basically all OSU components have to be mutable as long as they
        inherit from Standard. `clear`, `newInstance`, and `transferFrom` all
        mutate `this`.
    - Would this component rely on any internal classes (e.g., `Map.Pair`)?
      Answer and explain:
        - No. All methods work with integers or other NaturalNumbers.
    - Would this component need any enums or constants (e.g.,
      `Program.Instruction`)? Answer and explain:
        - Yes. NaturalNumber is base 10, and we track that in a constant called
          `RADIX`.
    - Can you implement your secondary methods using your kernel methods?
      Answer, explain, and give at least one example:
      - Yes. The kernel methods `multiplyBy10` and `divideBy10` can be used to
        manipulate our natural number as needed. For example, to implement
        `increment`, we can trim the last digit off with `divideBy10`, add 1 to
        it, verify that the digit hasn't overflown, and multiply the digit back.
        If the digit overflows, we reset it to zero and recursively call
        `increment`.

Keep in mind that the general idea when putting together these layered designs
is to put the minimal implementation in the kernel. In this case, the kernel is
only responsible for manipulating a digit at a time in the number. The secondary
methods use these manipulations to perform more complex operations like
adding two numbers together.

Also, keep in mind that we don't know the underlying implementation. It would be
completely reasonable to create a `NaturalNumber1L` class which layers the
kernel on top of the existing `BigInteger` class in Java. It would also be
reasonable to implement `NaturalNumber2` on top of `String` as seen in
Project 2. Do not worry about your implementations at this time.

On top of everything above, there is no expectation that you have a perfect
design. Part of the goal of this project is to have you actually use your
component once it's implemented to do something interesting. At which point, you
will likely refine your design to make your implementation easier to use.

### Component Designs

> Please use this section to share your designs.

- Component Design #1: Sportsbook
  - **Description**:
    - The purpose of this component is to model a sportsbook where users can place
      bets on sports games. My intent with this design was to keep a simple kernel
      that provides the minimum functionality needed to represent choices made on
      games in a sportsbook. Then, I provide more complex functions and operations
      in the secondary interface to represent betting on multiple games at once or new games.
  - **Kernel Methods**:
    - `Bet createOdds(String team, int odds)`: creates a team with odds to place bets on in `this`
    - `void updateOdds(String team, int odds)`: updates the odds for a specific team in `this`
    - `void resolveBet(Bet bet, String result)`: resolves a single bet as win or loss in `this`
    - `void placeBet(String team, int amount)`: places an amount of money on existing bet in `this`
    - `void placeParley(Set<Bet> bets, int amount)`: places an amount of money on a parlay of bets in `this`
  - **Secondary Methods**:
    - `void resolveParlay(Set<Bet>, String result)`: resolves a parlay of bets as win or loss in `this`
    - `double calculateParlayPayout(Set<Bet> bet)`: calculates the payout of `bets`
    - `double calculatePotentialParlay(Set<Bet> bets, int amount)`: calculates the payout of `bets` with the given `amount` bet
    - `double calculatePayout(Bet bet)`: calculates the payout of `bet`
    - `double calculatePotentialBet(Bet bet, int amount)`: calculates the payout of `bet` with the given `amount` bet
    - `Set<Bet> getOpenBets()`: retrieves the open bets in `this`
    - `double getCurrentBalance()`: reports the user's current balance in `this`
  - **Additional Considerations** (*note*: "I don't know" is an acceptable
    answer for each of the following questions):
    - Would this component be mutable? Answer and explain:
      - Yes, placing and resolving bets would modify the state of the sportsbook by
      updating open bets and the user's balance.
    - Would this component rely on any internal classes (e.g., `Map.Pair`)?
      Answer and explain:
      - Yes, I would need to rely on an internal class for bets, likely a "Bet" class
      that would store deteails such as the team, odds, amount bet, and potentially
      type of bet.
    - Would this component need any enums or constants (e.g.,
      `Program.Instruction`)? Answer and explain:
      - Yes, constants may be needed for different bet types if I choose to include
      various types, such as moneylines, spreads, over/under, etc. Also, I would need
      a enum for the current status of a bet (open, won, lost, closed).
    - Can you implement your secondary methods using your kernel methods?
      Answer, explain, and give at least one example:
      - Yes, I could use the reolveBet() kernel method in the resolveParlay() method
      as the resolveParlay may just use resolveBet() numerous times for each bet.


- Component Design #2: Fantasy Football Tracker
  - **Description**:
    - The purpose of this component is to manage and track fantasy football leagues.
      It handles player statistics, team management and scoring updates. It supports
      functionalities such as adding players to teams, tracking performances, calculating
      scores, and updating player statsitics.
  - **Kernel Methods**:
    - `void createPlayer(String player, String position)`: creates a class of player in `this`
    - `void addTeam(String team)`: creates a team in `this`
    - `void addPlayer(Player player, String team)`: adds a player to a team in `this`
    - `void updatePlayerStats(Player player, Map<String, Integer> stats)`: updates a player's stats in `this`
    - `double calculateTeamScore(String team)`: calculate the total score for a given team in `this`
  - **Secondary Methods**:
    - `void removePlayer(Player player`: removes a player from `this`
    - `void removeTeam(String team)`: removes a team from `this`
    - `void tradePlayer(Player player, String team)`: trades a player to a team in `this`
    - `double getPlayerPoints(Player player)`: reports a player's points in `this`
    - `double getTeamScore(String team)`: reports the total score for a given team in `this`
  - **Additional Considerations** (*note*: "I don't know" is an acceptable
    answer for each of the following questions):
    - Would this component be mutable? Answer and explain:
      - Yes, the state of the component changes when players are added and remove, teams
      are modified or created or removed, and when the scores of players/team are updated.
    - Would this component rely on any internal classes (e.g., `Map.Pair`)?
      Answer and explain:
      - Yes, I would likely create an internal class for "Player" and potentially
      one for "Team" to calculate and store player stats and a team's players.
    - Would this component need any enums or constants (e.g.,
      `Program.Instruction`)? Answer and explain:
      - Yes, I would use constants for scoring rules, such as touchdowns or yards
      and enums may be used for player positions.
    - Can you implement your secondary methods using your kernel methods?
      Answer, explain, and give at least one example:
      - Yes, I may use the updatePlayerStats() kernel method in the calculateTeamScore()
      secondary method and then sum the scores on the team.


- Component Design #3: Workout Tracker
  - **Description**:
    - The purpose of this component is to manage and track workouts, incluidng various
    exercises like squats, deadlifts, bench press, and more. It records exercise details,
    weight lifted, and workout routines, providing functionality to track progress over time.
  - **Kernel Methods**:
    - `void addExercise(String exercise)`: creates a new class of exercise in `this`
    - `void logWorkout(String date, Map<String, Set<ExerciseLog>> workoutDetails)`:
    logs a workout on specific date, including details of exercises in `this`
    - `Set<ExerciseLog> getWorkoutLog(String date)`: retrieves the workout log for a specific date in `this`
    - `int calculateTotalWeightLifted(String exercise)`: calculates the total weight lifted for a specific exercise in `this`
  - **Secondary Methods**:
    - `double getAverageWeightLifted(String exercise)`: calculates the average weight lifted for a specific exercise in `this`
    - `void removeExercise(String exercise)`: removes an exercise from `this`
    - `void updateExerciseName(String oldName, String newName)`: updates an exercise's name in `this`
    - `Set<ExerciseLog> getAllLogs()`: retrieves all exercise logs for all dates in `this`
  - **Additional Considerations** (*note*: "I don't know" is an acceptable
    answer for each of the following questions):
    - Would this component be mutable? Answer and explain:
      - Yes, adding and removing exercises, logging workouts, and updating logs
      will modify the state of the component.
    - Would this component rely on any internal classes (e.g., `Map.Pair`)?
      Answer and explain:
      - Yes, it would rely on an internal ExerciseLog class to organize details of
      each exercise log entry, including weight, the exercise name, the sets and reps.
    - Would this component need any enums or constants (e.g.,
      `Program.Instruction`)? Answer and explain:
      - Yes, constants may be used for weight values/plate values and possibly enums
      for designation of the part of the body exercised.
    - Can you implement your secondary methods using your kernel methods?
      Answer, explain, and give at least one example:
      - Yes, methods like calculateTotalWeightLifted() can be used in the
      getAverageWeightLifted() method.

## Post-Assignment

The following sections detail everything that you should do once you've
completed the assignment.

### Changelog

At the end of every assignment, you should update the
[CHANGELOG.md](../../CHANGELOG.md) file found in the root of the project folder.
Since this is likely the first time you've done this, we would recommend
browsing the existing file. It includes all of the changes made to the portfolio
project template. When you're ready, you should delete this file and start your
own. Here's what I would expect to see at the minimum:

```markdown
# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

## YYYY.MM.DD

### Added

- Designed a <!-- insert name of component 1 here --> component
- Designed a <!-- insert name of component 2 here --> component
- Designed a <!-- insert name of component 3 here --> component
```

Here `YYYY.MM.DD` would be the date of your submission, such as 2024.04.21.

You may notice that things are nicely linked in the root CHANGELOG. If you'd
like to accomplish that, you will need to make GitHub releases after each pull
request merge (or at least tag your commits). This is not required.

In the future, the CHANGELOG will be used to document changes in your
designs, so we can gauge your progress. Please keep it updated at each stage
of development.

### Submission

If you have completed the assignment using this template, we recommend that
you convert it to a PDF before submission. If you're not sure how, check out
this [Markdown to PDF guide][markdown-to-pdf-guide]. However, PDFs should be
created for you automatically every time you save, so just double check that
all your work is there before submitting. For future assignments, you will
just be submitting a link to a pull request. This will be the only time
you have to submit any PDFs.


### Peer Review

Following the completion of this assignment, you will be assigned three
students' component brainstorming assignments for review. Your job during the
peer review process is to help your peers flesh out their designs. Specifically,
you should be helping them determine which of their designs would be most
practical to complete this semester. When reviewing your peers' assignments,
please treat them with respect. Note also that we can see your comments, which
could help your case if you're looking to become a grader. Ultimately, we
recommend using the following feedback rubric to ensure that your feedback is
both helpful and respectful (you may want to render the markdown as HTML or a
PDF to read this rubric as a table).

| Criteria of Constructive Feedback | Missing                                                                                                                           | Developing                                                                                                                                                                                                                                | Meeting                                                                                                                                                               |
| --------------------------------- | --------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Specific                          | All feedback is general (not specific)                                                                                            | Some (but not all) feedback is specific and some examples may be provided.                                                                                                                                                                | All feedback is specific, with examples provided where possible                                                                                                       |
| Actionable                        | None of the feedback provides actionable items or suggestions for improvement                                                     | Some feedback provides suggestions for improvement, while some do not                                                                                                                                                                     | All (or nearly all) feedback is actionable; most criticisms are followed by suggestions for improvement                                                               |
| Prioritized                       | Feedback provides only major or minor concerns, but not both. Major and minar concerns are not labeled or feedback is unorganized | Feedback provides both major and minor concerns, but it is not clear which is which and/or the feedback is not as well organized as it could be                                                                                           | Feedback clearly labels major and minor concerns. Feedback is organized in a way that allows the reader to easily understand which points to prioritize in a revision |
| Balanced                          | Feedback describes either strengths or areas of improvement, but not both                                                         | Feedback describes both strengths and areas for improvement, but it is more heavily weighted towards one or the other, and/or descusses both but does not clearly identify which part of the feedback is a strength/area for improvement  | Feedback provides balanced discussion of the document's strengths and areas for improvement. It is clear which piece of feedback is which                             |
| Tactful                           | Overall tone and language are not appropriate (e.g., not considerate, could be interpreted as personal criticism or attack)       | Overall feedback tone and language are general positive, tactul, and non-threatening, but one or more feedback comments could be interpretted as not tactful and/or feedback leans toward personal criticism, not focused on the document | Feedback tone and language are positive, tactful, and non-threatening. Feedback addesses the document, not the writer                                                 |

### Assignment Feedback

If you'd like to give feedback for this assignment (or any assignment, really),
make use of [this survey][survey]. Your feedback helps make assignments
better for future students.

[example-components]: https://therenegadecoder.com/code/the-never-ending-list-of-small-programming-project-ideas/
[markdown-to-pdf-guide]: https://therenegadecoder.com/blog/how-to-convert-markdown-to-a-pdf-3-quick-solutions/
[survey]: https://forms.gle/dumXHo6A4Enucdkq9
