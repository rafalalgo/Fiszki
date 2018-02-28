# Fiszki

How does the learning work?

1. There is a huge list of flash cards in every language.
2. You choose randomly (firstly you have to accept words) 30 flash cards in a language, you are interested in. This is your box number 1. Flash cards are "native" side up.
3. (n /in [1,6]/union{9,12}): every day you try to answer what is on the other side of every flash card in box n, if you are right, it goes upside down to box n+1, otherwise it stays in box n.
4. (n /in {7,8,10,11}): every flash card instantly goes to box n+1
5. After answering for box 12's flash cards, 10 cards are randomly (including sides) choosen from box 13, if your answer is wrong, card goes to box nr. 2, otherwise nothing happens.


- Thus, there are 14 possible states of a flash card 0 to 13.
- Afterwards, we may add some special and different ways of learning.
