package nadiatests;

// https://stackoverflow.com/questions/12798290/java-program-to-read-parenthesis-curly-braces-and-brackets
public class BalancedExpression
{
    private int sp;
    private int[] theStack;
    private static final int MAX_STACK_SIZE = 6;
    public BalancedExpression() // Default Constructor
    {
        sp = 0; // the stack pointer
        theStack = new int[MAX_STACK_SIZE];
    }
    public void push(int value) // Method to push an expression into the stack
    {
        if (!isFull())
            theStack[sp++] = value;
    }
    public int pop() // Method to pop an expression out of the stack
    {
        return (!isEmpty() ? theStack[--sp] : -1);
    }
    public boolean isFull() // Method to determine if the stack is full
    {
        return (sp == MAX_STACK_SIZE ? true : false)  ;
    }
    public boolean isEmpty() // Method to determine if the stack is empty
    {
        return (sp == 0 ? true : false);
    }
    public int topValue() {
        return theStack[sp-1];
    }
    public static boolean checkExpression(String expressionString) // Method to check Expression in stack
    {
        BalancedExpression balancedExpression = new BalancedExpression();
        for(int i = 0; i <  MAX_STACK_SIZE && i < expressionString.length(); i++)
        {
            char ch = expressionString.charAt(i);
            if(ch == '(' || ch == '{' ||  ch == '[')
                balancedExpression.push(ch);
            else if(ch == '}' && !balancedExpression.isEmpty() && balancedExpression.topValue() == '{')
                balancedExpression.pop();
            else if(ch == ']' && !balancedExpression.isEmpty() && balancedExpression.topValue() == '[')
                balancedExpression.pop();
            else if(ch == ')' && !balancedExpression.isEmpty() && balancedExpression.topValue() == '(')
                balancedExpression.pop();
            else if(ch == ')' || ch == '}' ||  ch == ']' ) //did not find a matching close brace
                return false;
        }
        if(!balancedExpression.isEmpty())      //important
            return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println("{a} "+checkExpression("{a}"));
        System.out.println("{(a)} "+checkExpression("{(a)}"));
        System.out.println("{(a)}] "+checkExpression("{(a)}]"));
    }
}// End of class BalancedExpression
