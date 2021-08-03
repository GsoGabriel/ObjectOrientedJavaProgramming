# Alterações e códigos

Essas são as alterações e os códigos que criei durante a tarefa do curso. A referência estará em uma linha comentada logo acima do método. 

### WEEK 4

~~~java
// MyLinkedList.java.
// Linha 18.
// Criação de método.

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		head = new LLNode<E>();
		tail = new LLNode<E>();
		head.next = tail;
		tail.prev = head;
		size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element )
	{
		// TODO: Implement this method
		if (element == null){
			throw new NullPointerException();
		}
		LLNode<E> newNode = new LLNode<E>(element);
		if(this.head.next == null){
			head.next = newNode;
			tail.prev = newNode;
			newNode.setPrevNext(this.head, this.tail);
			this.size++;
		}
		else{
			LLNode<E> lastNode = this.tail.prev;
			lastNode.next = newNode;
			this.tail.prev = newNode;
			newNode.setPrevNext(lastNode, this.tail);
			this.size++;

		}
		return true;
	}

	/** Get the element at position index
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index)
	{
		// TODO: Implement this method.

		if (index < 0 || index >= this.size){
			throw new IndexOutOfBoundsException();
		}
		LLNode<E> currNode = currNode(index);
		return currNode.data;
	}


// MyLinkedListTester.java.
// Linha 162.
// Criação de Método para teste com JUnit.

	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		emptyList.add(51);
		assertEquals("AddEnd: Check if emptyList add 51", (Integer)51, emptyList.get(0));

		emptyList.add(71);
		assertEquals("AddEnd: Check if emptyList add 71", (Integer)71, emptyList.get(1));

		shortList.add("C");
		assertEquals("AddEnd: Check if shortList add C", "C", shortList.get(2));

		shortList.add("D");
		assertEquals("AddEnd: Check if shortList add D", "D", shortList.get(3));

		try {
			shortList.add(null);
			fail("Check Null Point");
		}
		catch (NullPointerException e) {
			// TODO: handle exception
		}

	}


	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		assertEquals("Size: Check size method", 3, list1.size());
		assertEquals("Size: Check size method", LONG_LIST_LENGTH, longerList.size());
	}



	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
         //TODO: implement this test
		try {
			list2.add(-1, 98);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {

		}

		try {
			list2.add(10, 95);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {

		}
		list2.add(1, 95);
		assertEquals("AddAtIndex: Check if list2 changed correctly the position", (Integer)65, list2.get(0));
		assertEquals("AddAtIndex: Check if list2 add at correct position", (Integer)95, list2.get(1));
		assertEquals("AddAtIndex: Check if list2 changed correctly the position", (Integer)25, list2.get(2));
		assertEquals("AddAtIndex: Check if list2 changed correctly the position", (Integer)42, list2.get(3));

	}

// MyLinkedListTester.java.
// Linha 266.
// Criação de Método para teste com JUnit.

	@Test
	public void testAddAndRemove()
	{
		list3.add(4);
		assertEquals("", (Integer)4, list3.get(3));
		assertEquals("", 4, list3.size());
		list3.add(1, 5);
		assertEquals("", (Integer)5, list3.get(1));
		assertEquals("", 5, list3.size());
		list3.remove(1);
		assertEquals("", (Integer)1, list3.get(1));
		assertEquals("", 4, list3.size());
		list3.remove(list3.size()-1);
		assertEquals("", 3, list3.size());
		try {
			list3.get(3);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {

		}
		list3.add(6);
		assertEquals("", 4, list3.size());
		assertEquals("", (Integer)6, list3.get(3));

		MyLinkedList<Integer> list4 = new MyLinkedList<Integer>();
		list4.add(0, 1);
		assertEquals("", (Integer)1, list4.get(0));
		list4.remove(0);
		try {
			list4.add(1,1);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}

	}

// MyLinkedList.java.
// Linha 98.
// Criação de Método para teste com JUnit.

	/** Return the size of the list */
	public int size()
	{
		// TODO: Implement this method
		return this.size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 *
	 */
	public E remove(int index)
	{
		// TODO: Implement this method
		if (index < 0 || index >= this.size){
			throw new IndexOutOfBoundsException();
		}
		LLNode<E> currNode = currNode(index);
		currNode.prev.next = currNode.next;
		currNode.next.prev = currNode.prev;
		this.size--;
		return currNode.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element)
	{
		// TODO: Implement this method
		if (element == null){
			throw new NullPointerException();
		}
		else if (index < 0 || index >= this.size){
			throw new IndexOutOfBoundsException();
		}
		LLNode<E> currNode = currNode(index);
		E oldValue = currNode.data;
		currNode.data = element;
		return oldValue;
	}
}

~~~

### Week 5

~~~java
// DictionaryLL.java.
// Linha 14.
// Alteração e criação de Métodos.

	// TODO: Add a constructor
	public DictionaryLL() {
		// TODO Auto-generated constructor stub
		dict = new LinkedList<String>();
	}


    /** Add this word to the dictionary.  Convert it to lowercase first
     * for the assignment requirements.
     * @param word The word to add
     * @return true if the word was added to the dictionary
     * (it wasn't already there). */
    public boolean addWord(String word) {
    	// TODO: Implement this method
    	if (word == null || word.equals("")) {
			return false;
		}
    	String wordLower = word.toLowerCase();
    	if (!dict.contains(wordLower)){
    		return dict.add(wordLower);
    	}
        return false;
    }


    /** Return the number of words in the dictionary */
    public int size()
    {
        // TODO: Implement this method

        return dict.size();
    }

    /** Is this a word according to this dictionary? */
    public boolean isWord(String s) {
        //TODO: Implement this method
    	if (s == null || s.equals("")) {
			return false;
		}
        return dict.contains(s.toLowerCase());
    }


// DictionaryBST.java.
// Linha 14.
// Alteração e criação de Métodos.

   public DictionaryBST() {
	// TODO Auto-generated constructor stub
	   dict = new TreeSet<String>();
   }


    /** Add this word to the dictionary.  Convert it to lowercase first
     * for the assignment requirements.
     * @param word The word to add
     * @return true if the word was added to the dictionary
     * (it wasn't already there). */
    public boolean addWord(String word) {
    	// TODO: Implement this method
    	if (word == null || word.equals("")) {
			return false;
		}
    	String wordLower = word.toLowerCase();
    	if (!dict.contains(wordLower)){
    		return dict.add(wordLower);
    	}
        return false;
    }


    /** Return the number of words in the dictionary */
    public int size()
    {
    	// TODO: Implement this method
        return dict.size();
    }

    /** Is this a word according to this dictionary? */
    public boolean isWord(String s) {
    	//TODO: Implement this method
    	if (s == null || s.equals("")) {
			return false;
		}
    	return dict.contains(s.toLowerCase());
    }

// AutoCompleteDictionaryTrie.java.
// Linha 14.
// Alteração e criação de Métodos.


	public boolean addWord(String word)
	{
	    //TODO: Implement this method.
		char[] wordArray = word.toLowerCase().toCharArray();
		TrieNode currTrieNode = root;

		for (char c : wordArray)
		{
			TrieNode nextNode = currTrieNode.insert(c);

			if (nextNode == null) {
				currTrieNode = currTrieNode.getChild(c);
			}
			else {
				currTrieNode = nextNode;
			}
		}

		if (!currTrieNode.endsWord()) {
			currTrieNode.setEndsWord(true);
			this.size++;
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Return the number of words in the dictionary.  This is NOT necessarily the same
	 * as the number of TrieNodes in the trie.
	 */
	public int size()
	{
	    //TODO: Implement this method
	    return this.size;
	}


	/** Returns whether the string is a word in the trie, using the algorithm
	 * described in the videos for this week. */
	@Override
	public boolean isWord(String s)
	{
	    // TODO: Implement this method
		char[] wordArray = s.toLowerCase().toCharArray();
		TrieNode currTrieNode = root;

		for (char c : wordArray)
		{
			TrieNode nextNode = currTrieNode.getChild(c);

			if (nextNode == null) {
				return false;
			}
			else {
				currTrieNode = nextNode;
			}
		}
		return currTrieNode.endsWord();
	}

	/**
     * Return a list, in order of increasing (non-decreasing) word length,
     * containing the numCompletions shortest legal completions
     * of the prefix string. All legal completions must be valid words in the
     * dictionary. If the prefix itself is a valid word, it is included
     * in the list of returned words.
     *
     * The list of completions must contain
     * all of the shortest completions, but when there are ties, it may break
     * them in any order. For example, if there the prefix string is "ste" and
     * only the words "step", "stem", "stew", "steer" and "steep" are in the
     * dictionary, when the user asks for 4 completions, the list must include
     * "step", "stem" and "stew", but may include either the word
     * "steer" or "steep".
     *
     * If this string prefix is not in the trie, it returns an empty list.
     *
     * @param prefix The text to use at the word stem
     * @param numCompletions The maximum number of predictions desired.
     * @return A list containing the up to numCompletions best predictions
     */@Override
     public List<String> predictCompletions(String prefix, int numCompletions)
     {
    	 // TODO: Implement this method
    	 // This method should implement the following algorithm:
    	 // 1. Find the stem in the trie.  If the stem does not appear in the trie, return an
    	 //    empty list
    	 // 2. Once the stem is found, perform a breadth first search to generate completions
    	 //    using the following algorithm:
    	 //    Create a queue (LinkedList) and add the node that completes the stem to the back
    	 //       of the list.
    	 //    Create a list of completions to return (initially empty)
    	 //    While the queue is not empty and you don't have enough completions:
    	 //       remove the first Node from the queue
    	 //       If it is a word, add it to the completions list
    	 //       Add all of its child nodes to the back of the queue
    	 // Return the list of completions
    	char[] prefixArray = prefix.toLowerCase().toCharArray();
    	TrieNode currTrieNode = root;
    	List<String> list = new LinkedList<String>();

 		for (char c : prefixArray) {
 			TrieNode nextNode = currTrieNode.getChild(c);
 			if (nextNode != null) {
 				currTrieNode = nextNode;
 			}
 			else {
 				return list;
			}
 		}

 		LinkedList<TrieNode> queue = new LinkedList<TrieNode>();
 		queue.add(currTrieNode);

 		while (!queue.isEmpty() && list.size() < numCompletions){
 			TrieNode removed = queue.removeFirst();
 			if (removed.endsWord()) {
				list.add(removed.getText());
			}

 			for (Character c : removed.getValidNextCharacters()) {
				queue.add(removed.getChild(c));
			}
 		}
 		return list;
     }


~~~

