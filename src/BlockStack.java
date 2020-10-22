import exception.StackOutOfBoundExcepetion;

/**
 * Class BlockStack
 * Implements character block stack and operations upon it.
 *
 * $Revision: 1.4 $
 * $Last Revision Date: 2019/07/02 $
 *
 * @author Serguei A. Mokhov, mokhov@cs.concordia.ca;
 * Inspired by an earlier code by Prof. D. Probst

 */
class BlockStack
{
	/**
	 * # of letters in the English alphabet + 2
	 */
	private static final int MAX_SIZE = 28;

	/**
	 * Default stack size
	 */
	private static final int DEFAULT_SIZE = 6;

	/** 
	 * Default representation of non defined value on stack
	*/
	private char defaultEmpty = '*';

	/**
	 * Current size of the stack
	 */
	private int iSize = DEFAULT_SIZE;

	/**
	 * Current top of the stack
	 */
	private int iTop  = 3;

	/**
	 * Current number of access on stack
	 */
	private int stackAccessCounter = 0;

	/**
	 * stack[0:5] with four defined values
	 */
	private char acStack[] = new char[] {'a', 'b', 'c', 'd', '$', '$'};

	/**
	 * Default constructor
	 */
	public BlockStack()
	{
	}

	/**
	 * Supplied size
	 */
	public BlockStack(final int piSize)
	{


                if(piSize != DEFAULT_SIZE)
		{
			this.acStack = new char[piSize];

			// Fill in with letters of the alphabet and keep
			// 2 free blocks
			for(int i = 0; i < piSize - 2; i++)
				this.acStack[i] = (char)('a' + i);

			this.acStack[piSize - 2] = this.acStack[piSize - 1] = '$';

			this.iTop = piSize - 3;
                        this.iSize = piSize;
		}
	}

	/**
	 * Picks a value from the top without modifying the stack
	 * @return top element of the stack, char
	 */
	public char pick()
	{
		this.stackAccessCounter++;
		return this.checkUndefinedChar(this.acStack[this.iTop]);
	}

	/**
	 * Returns arbitrary value from the stack array
	 * @return the element, char
	 */
	public char getAt(final int piPosition)
	{
		this.stackAccessCounter++;
		return this.checkUndefinedChar(acStack[piPosition]);
	}

	public int getITop()
	{
		return this.iTop;
	}

	public int getISize()
	{
		return this.iSize;
	}

	public boolean isEmpty()
	{
		return this.iTop == -1;
	}

	public int getAccessCounter()
	{
		return this.stackAccessCounter;
	}

	/**
	 * Standard push operation
	 */
	public void push(final char pcBlock) throws StackOutOfBoundExcepetion
	{
		if(this.iTop == this.iSize)				throw new StackOutOfBoundExcepetion();
	
		this.acStack[++this.iTop] = pcBlock;
		
		this.stackAccessCounter++;
		System.out.println("push on stack");
	}

	/**
	 * Standard pop operation
	 * @return ex-top element of the stack, char
	 */
	public char pop() throws StackOutOfBoundExcepetion
	{
		if(this.isEmpty())			throw new StackOutOfBoundExcepetion();

		char cBlock = this.acStack[this.iTop];
		this.acStack[this.iTop--] = '$'; // Leave prev. value undefined
		this.stackAccessCounter++;
		System.out.println("pop on stack");

		return checkUndefinedChar(cBlock);
	}

	private char checkUndefinedChar(char ch){
		if(ch == '$')			return defaultEmpty;
		else					return ch;
	}
}

// EOF
