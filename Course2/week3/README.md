# Alterações e códigos

Essas são as alterações e os códigos que criei durante a tarefa do curso. A referência estará em uma linha comentada logo acima do método. 



~~~java
// EfficientDocument.java. Linha 46. Métodos criados.

private void processText()
	{
		// Call getTokens on the text to preserve separate strings that are
		// either words or sentence-ending punctuation.  Ignore everything
		// That is not a word or a sentence-ending puctuation.
		// MAKE SURE YOU UNDERSTAND THIS LINE BEFORE YOU CODE THE REST
		// OF THIS METHOD.
		List<String> tokens = getTokens("[!?.]+|[a-zA-Z]+");
		numWords = 0;
		numSentences = 0;
		numSyllables = 0;
		for (String tok : tokens) {
			if (isWord(tok)){
				numWords++;
			}
			else{
				numSentences++;
			}
			int countSyllables = countSyllables(tok);
			numSyllables += countSyllables;
		}
		if (!tokens.isEmpty() && isWord(tokens.get(tokens.size() -1))){
			numSentences++;
		}
		// TODO: Finish this method.  Remember the countSyllables method from
		// Document.  That will come in handy here.  isWord defined above will also help.
	}

	@Override
	public int getNumSentences() {
		//TODO: write this method.  Hint: It's simple
		return this.numSentences;
	}
	@Override
	public int getNumWords() {
		//TODO: write this method.  Hint: It's simple
	    return this.numWords;
	}
	@Override
	public int getNumSyllables() {
        //TODO: write this method.  Hint: It's simple
        return this.numSyllables;
	}

// DocumentBenchmarking.java. Linha 37. Alteração e criação de código do main para testes.

		// TODO: Fill in the rest of this method so that it runs two loops
		// and prints out timing results as described in the assignment
		// instructions and following the pseudocode below.
		System.out.print("NumberOfChars\tBasicTime\tEfficientTime\n");
		for (int numToCheck = start; numToCheck < numSteps*increment + start;
				numToCheck += increment)
		{
			// numToCheck holds the number of characters that you should read from the
			// file to create both a BasicDocument and an EfficientDocument.

			/* Each time through this loop you should:
			 * 1. Print out numToCheck followed by a tab (\t) (NOT a newline)
			 * 2. Read numToCheck characters from the file into a String
			 *     Hint: use the helper method below.
			 * 3. Time a loop that runs trials times (trials is the variable above) that:
			 *     a. Creates a BasicDocument
			 *     b. Calls fleshScore on this document
			 * 4. Print out the time it took to complete the loop in step 3
			 *      (on the same line as the first print statement) followed by a tab (\t)
			 * 5. Time a loop that runs trials times (trials is the variable above) that:
			 *     a. Creates an EfficientDocument
			 *     b. Calls fleshScore on this document
			 * 6. Print out the time it took to complete the loop in step 5
			 *      (on the same line as the first print statement) followed by a newline (\n)
			 */

			 System.out.print(numToCheck + "\t");
			 String strFile = getStringFromFile(textfile, numToCheck);
			 long startTime = System.nanoTime();
			 for (int i = 0; i < trials; i++) {
				BasicDocument basicDocument = new BasicDocument(strFile);
				basicDocument.getFleschScore();
			}
			long endTime = System.nanoTime();
			long duration = (endTime - startTime);
			System.out.print(duration/1000000 + "\t");

			long startTime2 = System.nanoTime();
			 for (int i = 0; i < trials; i++) {
				EfficientDocument efficientDocument = new EfficientDocument(strFile);
				efficientDocument.getFleschScore();
			}
			long endTime2 = System.nanoTime();
			long duration2 = (endTime2 - startTime2);
			System.out.print(duration2/1000000 + "\n");
		}

~~~

