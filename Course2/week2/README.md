# Alterações e códigos

Essas são as alterações e os códigos que criei durante a tarefa do curso. A referência estará em uma linha comentada logo acima do método. 

~~~java

// Document.java, linha 65. Métodos criados.

protected int countSyllables(String word)
	{
		// TODO: Implement this method so that you can call it from the
	    // getNumSyllables method in BasicDocument (module 2) and
	    // EfficientDocument (module 3).

		char[] cArray = word.toCharArray();
		int syllables = 0;
		int i = 1;

		if (this.isVowel(cArray[0])){
			syllables++;
		}

		while (i < cArray.length) {
			if (i == cArray.length-1 && cArray[i]=='e'){
				if (syllables==0) {
					syllables++;
				}
			}
			else if (this.isVowel(cArray[i]) && !this.isVowel(cArray[i-1])){
				syllables++;
			}
			i++;
		}

	    return syllables;
	}

	private boolean isVowel(char c){
		String vowels = "aeiouyAEIOUY";
		if (vowels.indexOf(c) != -1){
			return true;
		}
		return false;
	}


// BasicDocument.java, line 94. Método criado.
private String[] textSplit(){
		String text = this.getText();
		if (text.equals("")){
			return null;
		}
		String[] textSplit = text.split("[^a-zA-Z]+");
		return textSplit;
	}


// BasicDocument.java, line 34. Método criado.
@Override
public int getNumWords()
	{
		//TODO: Implement this method in week 2 according to the comments above.
		// See the Module 2 support videos if you need help.
		String[] textSplit = this.textSplit();
		if (textSplit == null){
			return 0;
		}
	    return textSplit.length;
	}


// BasicDocument.java, line 58. Método criado.
@Override
public int getNumSentences()
	{
	    //TODO: Implement this method.  See the Module 2 support videos
        // if you need help.
		String text = this.getText();
		if (text.equals("")){
			return 0;
		}
		String[] textSplit = text.split("[.!?]+");

        return textSplit.length;
	}


// BasicDocument.java, line 86. Métodos criados.
@Override
public int getNumSyllables()
	{
	    //TODO: Implement this method in week 2.  See the Module 2 support videos
        // if you need help.  And note that there is no need to use a regular
		// expression for the syllable counting.  We recommend you implement
		// the helper function countSyllables in Document.java using a loop,
		// and then call it here on each word.

		if (this.textSplit() == null){
			return 0;
		}

		int numSyllables = 0;
		for (String s : this.textSplit()) {
			int count = this.countSyllables(s);
			numSyllables = numSyllables + count;
		}

        return numSyllables;
	}
~~~