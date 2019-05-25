import java.io.FileReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

// sacha raman

//This is a word based move-to-front encoder for text files.
class Encoder
{
    public static WordList wordList;
    public static void main(String[] args)
    {
	if(args.length != 1)
	    {
		System.err.println("Usage: java Encoder <filename>");
		return;
	    }

	//declare variables
	String delims = ".,;:! \"\t\n";
	//create new WordList
	wordList = new WordList();
	boolean exists = false;
	int index = 0;
	String s = "";

	try
	    {
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		// read a line from the txt file
		s = br.readLine();
		while(s!=null)
		    {
			//split the string
			StringTokenizer st = new StringTokenizer(s,delims);
			while(st.hasMoreTokens())
			    {
				// get word
				String word = st.nextToken();
				// check if the word exists in list
				exists = wordList.wordExists(word);
				// if word does not exist, output on new line: 0 'word'
				if(exists == false) {
				    System.out.println("0 " + word);
				    // add the word to the front of the list
				    wordList.addWord(word);
				}
				//if the word exists, output the index of the word
				else if(exists == true) {
				    index = wordList.findIndex(word);
				    System.out.println(index);
				    // move the word to the front of the list
				    wordList.moveToFront(word);
				}		
			    }
			//read the next line
			s = br.readLine();
		    }
		// close the buffered reader
		br.close();
	    }
	catch(Exception e)
	    {
		//print out an error message displaying.
		System.out.println("Error has occurred");
	    }
    }
}
		    

	     
