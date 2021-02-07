# RandomWordGenerator

Hi! This is an Eclipse project of a random word generator I created that creates pronounceable English-looking words that do not exist. It is based off letter-pairing frequency data to generate natural combinations of letters (such as [B, A]) as opposed to non-natural combinations (such as [X, V]) to make the words more readable and pronounceable. The words can be used in a variety of circumstances, such as username generation, unique character naming, and much more. There are two main modes which will be documented below.

The frequency of letter-pairings is based off this [data set](https://english.stackexchange.com/a/110579). The frequencies are stored in a .txt file which the program reads from.


# Modes

There are two main modes. The first mode generates a random word within the designated size limit. The second mode generates a random word with a *preset starting character* within the designated size limit. Both modes create a randomly-sized word within the *min* and *max* parameters in length.

## Mode 1

This mode can be used to generate random words with any starting character. 

### Parameters
> **min**: The minimum length of the generated word.
> **max**:  The maximum length of the generated word.
### Sample Output
```
INPUT: generateWord(3, 5)
kiogi
paba
arvin
narv
frel
ylekl
vimb
osh
rmec
kedo
ypan
sesip
rarm
apal
glock
```
## Mode 2
This mode can be used to generate random words with a set starting character.
### Parameters
> **min**: The minimum length of the generated word.
> **max**:  The maximum length of the generated word.
> **firstLetter**: The first letter of the generated word.
### Sample Output
```
INPUT: generateWord(3, 5, 'v')
vele
vinor
vilac
verm
vapan
vengi
ven
valab
veons
vin
vexom
vul
viat
veda
veter
```
