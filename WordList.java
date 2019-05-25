
// sacha raman	

class WordList {

    //PRIVATE VARIABLES
    private Node head;

    //CONSTRUCTOR
    public WordList() {

    }

    //PUBLIC METHODS

    /*
     * This method  goes through list to see if the word is in the list
     * It is passed a string word and returns a boolean value
     */
    public boolean wordExists(String word) {
	//if the head is empty return false
	if(head == null)
	    return false;
	//make a temp node pointing to the start of list
	Node temp = head;
	//while temp is pointing to an item on the list:
	while(temp!=null) {
	    //if temp equals to the word we are searching for
	    if(word.equalsIgnoreCase(temp.GetWord()))
		//return true
		return true;
	    //otherwise move temp along one word in the list
	    else
		temp = temp.GetNext();
	}
	// return false since the word has not been found  
	return false;
    }

    //------------------------------------------------------------------//
    
    /*
     * This method adds a word to the front of the list.
     * It is passed a string word. Does not return a value
     */
    public void addWord(String word) {
	//create a new node temp: the word to be added to list
	Node temp = new Node(word);
	//if the list is empty them add the new word to the start of the list
	if(head == null)
	    head = temp;
	//otherwise set the next word after temp be the word at the top of list
	else {
	    temp.SetNext(head);	    
	    //make temp (the new word) the head of the list
	    head = temp;
	}
    }

    //------------------------------------------------------------------//

    /*
     * This method finds the index of a word already in the list
     * Is passed a string word and returns the index as an int.
     */
    public int findIndex(String word) {
	//create a temp node, this points to head
	Node temp = head;
	//create index counter, set to one
	int index = 1;
	//while the temp still points to a node
	while(temp != null) {
	    //check if the word equals the temp word, if so, return index
	    boolean same = word.equalsIgnoreCase(temp.GetWord());
	    if(same == true)
		return index;
	    //otherwise move temp down the list by one and increment index counter
	    else {
		temp = temp.GetNext();
		index++;
	    }
	}
	//return the index
	return index;
    }
    
    //------------------------------------------------------------------//
       
    /*
     * This method removes a word from the list and add it to the front
     * It is passed a word and does not return a value
    */
    public void moveToFront(String word) {
	//if the word is already at the front of the list
	if(word.equalsIgnoreCase(head.GetWord()))
	    return;
	// create new node to point to head
	Node curr = head;
	//while curr node is still pointing to something
	while(curr != null) {
	    //if the word is equal to the next word in the list after curr
	    if(word.equalsIgnoreCase(curr.GetNext().GetWord())) {
		//then create a new node pointing to this value (the next on after curr)
		//this will be the node we will be removing to add to the front
		Node temp = curr.GetNext();
		//make the next word in the list point to the word after temp	
		curr.SetNext(temp.GetNext());
		// make the next value of temp point to the head of the list
		temp.SetNext(head);
		head = temp;
		return;
	    }
	    //otherwise move the curr node along one down the list
	    else {
		curr = curr.GetNext();
	    }
	}
    }

    //------------------------------------------------------------------//

    /*
     * This method finds a word by its index
     * It is passed an integer index
     * It returns a string which is word at index
    */
    public String wordByIndex(int index)
    {
    	//create a temp node pointing to head
    	Node temp = head;
    	//Starting from 1, count up to the index
    	for(int i = 1; i < index; i++)
    	{
    		//move one along the list
    		temp = temp.GetNext();
    	}
    	//return the word that temp is pointing to
    	return temp.GetWord();
    	
    }

		
    //-------------------------------------------------------------------//

    //This is the Node object which is a string word
    private class Node {

	//PRIVATE VARIABLES

	// the word taken from the text
	private String word_;
	// points to the next node 
	private Node next_;

	//CONSTRUCTOR
	public Node(String x){
	    word_ = x;
	    next_ = null;
	}

	//PROPERTIES

	
	// Gets the word of node
	public String GetWord() {
	    return word_;
	}

	// Gets the next node
	public Node GetNext() {
	    return next_;
	}

	// Sets the next node
	public void SetNext(Node nextWord) {
	    next_ = nextWord;
	}		    

    }

}
