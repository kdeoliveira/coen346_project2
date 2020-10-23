package exception;

/** Exception StackOutofBoundException
 * Implements exception for stack overflow operations
 * 
 * @author Kevin de Oliveira
 * @version 1.0
 */
public class StackOutOfBoundExcepetion extends Exception{
    private static final long serialVersionUID = 1;

    /**
     * Default constructors
     */
    public StackOutOfBoundExcepetion(){
        super("Stack is out of bound");
    }

    public StackOutOfBoundExcepetion(String str){
        super(str == null ? "" : str);
    }

    
    
}
