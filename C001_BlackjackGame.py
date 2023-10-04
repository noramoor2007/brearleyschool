import random # This imports the library called random that is used to pick random things when used with the point operator in the code.
import re # Used to clear formatting by recompiling text.

class Card: # This class is called "Card" and it consists of attributes that hold list values.
  suit_names = ["Clubs", "Diamonds", "Hearts", "Spades"]
  suit_symbols = ["♣", "\x1b[31m♦︎\x1b[0m", "\x1b[31m♥︎\x1b[0m", "♠"]
  rank_names = [None, "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"]
  def __init__ (self, suit, rank):
  # Instantiation functions will always be called when creating an instance of the class/object.
    self.suit = suit
    self.rank = rank
  def __str__(self):
  # This is run when you try to print an object.
    return Card.suit_symbols [self.suit] + Card.rank_names [self.rank]
  def value (self):
  # Face cards all have a value of 10 while the ace has a value of 1 or 11. All the rest have the same values as their names.
    if self.rank > 10:
      return 10
    else:
      return self.rank
  def __add__ (self, other):
  # This is run when you try to add two "Card" objects.
    return self.value () + other.value ()
    #return card1.value () + card2.value ()

class Deck:
  # The deck is populated with 52 cards automatically.
  def __init__ (self):
    self.cards = []
    for suit in range (4):  #0,1,2,3
      for rank in range (1, 14):  #1,2,...,13
        card = Card (suit, rank)
        self.cards.append (card)
  def __str__ (self):
    s = ""
    for c in self.cards:
    # Each c is going to be a different card object stored in the "self.cards" list.
      s += str (c) + "\n"
    return s
  def deal (self, player, n):
    # This deals "n" cards to player.
    while n > 0:
      player.cards.append (self.cards.pop (0))
      n -= 1
  def shuffle (self):
    random.shuffle (self.cards)

class Player:
  def __init__ (self, name):
    self.name = name
    self.cards = []
    self.busted = False
    self.winner = False
  def __str__ (self):
    return self.name
  def get_scoredealer (self):
    score = 0
    ace_no = 0
    for c in self.cards:
      score += c.value ()  
      # "Value" in "c.value" is a method, so you are required to add parenthesis.
      # Attributes are in the init function so it's different.
      if c.rank == 1:
        ace_no += 1
    if score < 17 and ace_no > 0:
      while ace_no > 0 and score + 10 < 17:
        score += 10
    elif score > 17:
      self.busted = True
    return score
  def get_score (self):
    score = 0
    ace_no = 0
    for c in self.cards:
      score += c.value ()
      if c.rank == 1:
        ace_no += 1
    if score < 21 and ace_no > 0:
      while ace_no > 0 and score + 10 < 21:
      # The ace is counted as a 1 and is already added to the score.
      # If player gets "A", the code checks if current score plus the remaining 10 < 21.
      # If it is, it will add it to the score, if not, it won't.
        score += 10
    return score

class Game:
  def __init__ (self, n = 7):
  # "n" is a fixed value and represents the number of players.
    self.deck = Deck () # "self.deck" is a variable/object of the "Deck" class.
    self.dealer = Player ("\x1b[4mDealer\x1b[0m")
    self.players = [] # This makes a list of players.
    self.players.append (Player("\x1b[4mDealer\x1b[0m")) # This adds dealer (player 0).
    # Appending is for lists; concatenating is for strings.
    # Here we are creating an instance of the "player" class.
    j = 1 # In order to have the player number start at 1 instead of 7.
    while j <= n:
    # To list the players #'s the while loop creates a new instance every iteration.
      # Here is a new instance of the "Player" class.
      self.players.append (Player("\x1b[4mPlayer #" + str(j) + "\x1b[0m"))
      j += 1
  def __str__ (self): # This brings the above altogether and returns s.
    s = ""
    for p in self.players:
    # Because "self.players" is a list of player objects.
    # This means "p" is a player object.
      s += "\n" + p.name + "\n"
      for c in p.cards: # "p.cards" is the card that the player has at the moment.
        s += str (c) + "\n"
      # "p.get_score ()" is calling the function in the "Player" class.
      s += "Score: " + str (p.get_score ()) + "\n"
    return s
  def play_round(self): 
  # This plays out a round of a game of blackjack, however, only first round.
    # Initial dealing
    self.deck.shuffle ()
    for p in self.players:
      self.deck.deal (p, 2)
    print (self)
    # This will track whether each player wants to hit or pass.
    all_players_passed = False # At least one player has NOT passed.
    while not all_players_passed: # This checks if "all_players_passed" is false.
      all_players_passed = True
      for p in self.players:
        # So this gets the index of "self.players" which should be the dealer.
        if p.name != "\x1b[4mDealer\x1b[0m":
          # This line compiles a regular expression pattern that matches ANSI escape codes within a string.
          # ANSI escape codes are used for text formatting in the terminal.
          ansi_escape = re.compile(r'\x1B[@-_][0-?]*[ -/]*[@-~]')
          # This line uses the compiled regular expression to find and replace all ANSI escape codes in the string p.name with an empty string.
          # This effectively removes the ANSI formatting from the p.name string.
          clear_text = ansi_escape.sub ('', p.name)
          user = input ("\x1b[106m" + clear_text + "\'s Turn\x1b[0m " + "\nWould you like to \x1b[3mHit\x1b[0m or \x1b[3mPass\x1b[0m? (Y/N): ")
          if (user.upper () == "Y"):
            self.deck.deal (p, 1)
            print (self)
            all_players_passed = False  # If any player hits, not all have passed.
    # Dealer is assigned a reference to the first player (index 0).
    dealer = self.players [0]
    self.deck.deal (dealer, 1)
    # This makes sure that the dealer only takes one card.
    if dealer.get_scoredealer () < 17:
      # This is used to deal one card from the game's deck to the dealer during their turn in a game of blackjack. 
      self.deck.deal (dealer, 1)
    print (self)
    max_score = 0
    closest_to_21 = None # None represents an absence of a value; null.
    for p in self.players: # Exclude the dealer from displaying their final score.
      score = p.get_score ()
      if 21 >= score > max_score and not p.busted:
        max_score = score
        closest_to_21 = p
    if closest_to_21:
      closest_to_21.winner = True
      closest_to_21.winnerdealer = True
      ansi_escape = re.compile (r'\x1B[@-_][0-?]*[ -/]*[@-~]')
      clear_text = ansi_escape.sub ('', closest_to_21.name)
      print ("\x1b[1m" + clear_text + " is the closest to 21 and wins, everyone else is busted!\x1b[0m")
  for p in self.players:
    ansi_escape = re.compile (r'\x1B[@-_][0-?]*[ -/]*[@-~]')
    clear_text = ansi_escape.sub ('', p.name)
    print (clear_text + "'s final score: " + str (p.get_score ()))

# This is the main method.
print (" ____   _         _     ____  _  __    _    _     ____  _  __\n| __ ) | |       / \\   / ___|| |/ /   | |  / \\   / ___|| |/ /\n|  _ \ | |      / _ \\ | |    | ' / _  | | / _ \\ | |    | ' / \n| |_) || |___  / ___ \\| |___ | . \\| |_| |/ ___ \\| |___ | . \\ \n|____/ |_____|/_/   \\_\\\\____||_|\\_\\\\___//_/   \\_\\\\____||_|\\_\\\n ___   ___   ___\n|\x1b[31mK\x1b[0m  | |\x1b[31m2\x1b[0m  | |6  | Welcome to this game of \x1b[1mBlackJack\x1b[0m!\n| \x1b[31m♦︎\x1b[0m | | \x1b[31m♥︎\x1b[0m | | ♠ | The goal of the game is to be the closest to 21!\n|__\x1b[31mK\x1b[0m| |__\x1b[31m2\x1b[0m| |__6| Good luck!\n")
multi_sing = input ("Would you like to play multiplayer? (Y/N): ")
if multi_sing.upper () == "Y":
  while True:
    number_of_players = input ("How many players? ")
    if number_of_players.isdigit ():
      myGame = Game (int (number_of_players))
      myGame.play_round ()
      break
    else:
      print ("Please enter a valid integer for the number of players.")
elif multi_sing.upper () == "N":
  myGame = Game (1) # For singleplayer only.
  myGame.play_round ()
else:
  print("Invalid input. Please enter 'Y' for multiplayer or 'N' for singleplayer.")