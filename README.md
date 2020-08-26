Use command **start** then the following command :
  1. user to play
  2. medium/easy to select the AI difficulty

Example:
  1. start user medium -> you start as X 
  2. start easy user -> you start as O 

The "easy" level difficulty makes a random move, every time

The "medium" level difficulty makes a move using the following process:

  1. If it can win in one move (if it has two in a row), it places a third to get three in a row and win
  2. If the opponent can win in one move, it plays the third itself to block the opponent to win
  3. Otherwise, it makes a random move

User input, or coordinates, in grid are the following

- - - - - - - - - - 
| 1 3 | 2 3 | 3 3 |

| 1 2 | 2 2 | 3 2 |

| 1 1 | 2 1 | 3 1 |
- - - - - - - - - -

Note that it's possible to create a bot fight! 
