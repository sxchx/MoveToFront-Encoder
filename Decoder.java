import java.io.FileReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

// sacha raman

//This is will decode a MTFencodeded text file, which restores it back to a stream of words
public class Decoder {
	
	public static WordList wordList;
	public static void main(String[] args) {

		if(args.length != 1)
		    {
			System.err.println("Usage: java Decoder <filename>");
			return;
		    }
		
		//declare variables
		String delims = " ";
		//create new WordList
		wordList = new WordList();
		int index = 0;
		String word = "";
		String s = "";
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
			s = br.readLine();
			//while there are still words to be read
			while(s!=null) {
				//create a string tokenizer for the read string
				StringTokenizer st = new StringTokenizer(s,delims);
				//while there are still tokens
				while(st.hasMoreTokens()) {
					//read in index of word
					index = Integer.parseInt(st.nextToken());
					//if the index is 0, read the word following then 
					//print word to output and add to top of list
					if(index == 0) {
						word = st.nextToken();
						System.out.print(word + " ");
						wordList.addWord(word);
					}
					//otherwise find the word according to the index read
					//print out the word to output and then move the word
					//to the front of the list
					else {
						word = wordList.wordByIndex(index);
						System.out.print(word + " ");
						wordList.moveToFront(word);		
					}
				}
				//read the next line
				s = br.readLine();
			}			
			//close the buffered reader
			System.out.println();
			br.close();
		}
		catch(Exception e) {
		    // print out an error message
		    System.out.println("Error has occurred");
		}
	}
}

