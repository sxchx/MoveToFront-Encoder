# MoveToFront-Encoder
An adaptive word based move to front encoder and decoder. 

## Encoder 

### Input
Takes the file names of a text file to encode as a command line argument. 
```
$ java Encoder <textfile> > encoded.txt
```
### Output
Produces a line of output for each word in the input file.  When a word is first encountered the output is:
```
0 word
```
If the word has been encountered before, the output is a single integer specifying the index of that word in a list of known words ordered according to the most recently used.

## Decoder

### Input
Takes a Encoder encoded text file and restores it back to the input file prior to it having been encoded with the Enconder.java
```
$ java Decoder encoded.txt
```
