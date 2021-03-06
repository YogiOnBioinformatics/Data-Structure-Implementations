
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.lang.Math;

/**
 * This class uses two stacks to evaluate an infix arithmetic expression from an
 * InputStream. It should not create a full postfix expression along the way; it
 * should convert and evaluate in a pipelined fashion, in a single pass.
 */
public class InfixExpressionEvaluator {
	
	private int numberOfOperands = 0;
	private int numberOfOperators = 0;
	private int typeOfBracket = 0;
    // Tokenizer to break up our input into tokens
    StreamTokenizer tokenizer;
	

    // Stacks for operators (for converting to postfix) and operands (for
    // evaluating)
    StackInterface<Character> operatorStack;
    StackInterface<Double> operandStack;
	
    /**
     * Initializes the evaluator to read an infix expression from an input
     * stream.
     * @param input the input stream from which to read the expression
     */
    public InfixExpressionEvaluator(InputStream input) {
        // Initialize the tokenizer to read from the given InputStream
        tokenizer = new StreamTokenizer(new BufferedReader(
                        new InputStreamReader(input)));

        // StreamTokenizer likes to consider - and / to have special meaning.
        // Tell it that these are regular characters, so that they can be parsed
        // as operators
        tokenizer.ordinaryChar('-');
        tokenizer.ordinaryChar('/');

        // Allow the tokenizer to recognize end-of-line, which marks the end of
        // the expression
        tokenizer.eolIsSignificant(true);

        // Initialize the stacks
        operatorStack = new ArrayStack<Character>();
        operandStack = new ArrayStack<Double>();
    }

    /**
     * Parses and evaluates the expression read from the provided input stream,
     * then returns the resulting value
     * @return the value of the infix expression that was parsed
     */
    public Double evaluate() throws ExpressionError {
        // Get the first token. If an IO exception occurs, replace it with a
        // runtime exception, causing an immediate crash.
        try {
			
			
            tokenizer.nextToken();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Continue processing tokens until we find end-of-line
        while (tokenizer.ttype != StreamTokenizer.TT_EOL) {
            // Consider possible token types
            switch (tokenizer.ttype) {
                case StreamTokenizer.TT_NUMBER:
                    // If the token is a number, process it as a double-valued
                    // operand
                    handleOperand((double)tokenizer.nval);
                    break;
                case '+':
                case '-':
                case '*':
                case '/':
                case '^':
                    // If the token is any of the above characters, process it
                    // is an operator
                    handleOperator((char)tokenizer.ttype);
                    break;
                case '(':
                case '<':
                    // If the token is open bracket, process it as such. Forms
                    // of bracket are interchangeable but must nest properly.
                    handleOpenBracket((char)tokenizer.ttype);
                    break;
                case ')':
                case '>':
                    // If the token is close bracket, process it as such. Forms
                    // of bracket are interchangeable but must nest properly.
                    handleCloseBracket((char)tokenizer.ttype);
                    break;
                case StreamTokenizer.TT_WORD:
                    // If the token is a "word", throw an expression error
                    throw new ExpressionError("Unrecognized token: " +
                                    tokenizer.sval);
                default:
                    // If the token is any other type or value, throw an
                    // expression error
                    throw new ExpressionError("Unrecognized token: " +
                                    String.valueOf((char)tokenizer.ttype));
            }

            // Read the next token, again converting any potential IO exception
            try {

                tokenizer.nextToken();
            } catch(IOException e) {
                throw new RuntimeException(e);
            }
        }

        // Almost done now, but we may have to process remaining operators in
        // the operators stack
		
        handleRemainingOperators();

        // Return the result of the evaluation
        // TODO: Fix this return statement
        return operandStack.pop();
    }

    /**
     * This method is called when the evaluator encounters an operand. It
     * manipulates operatorStack and/or operandStack to process the operand
     * according to the Infix-to-Postfix and Postfix-evaluation algorithms.
     * @param operand the operand token that was encountered
     */
    void handleOperand(double operand) {
		operandStack.push(operand);
		numberOfOperands++;
        // TODO: Complete this method
    }

    /**
     * This method is called when the evaluator encounters an operator. It
     * manipulates operatorStack and/or operandStack to process the operator
     * according to the Infix-to-Postfix and Postfix-evaluation algorithms.
     * @param operator the operator token that was encountered
     */
    void handleOperator(char operator) {
		
		
		if(operandStack.isEmpty()){
			
			throw new ExpressionError("Number must come first");
		}
		else if(operatorStack.isEmpty()){
			
		}
		else if(operatorStack.peek() == '^' && numberOfOperands>1){
			
			
			double exp = operandStack.pop();
			double base = operandStack.pop();
				
			operandStack.push(Math.pow(base, exp));
			numberOfOperands--;
				
			operatorStack.pop();
			numberOfOperators--;
		}
		else if(operatorStack.peek() == '*' && operator!= '^' && numberOfOperands>1){
			
			double num1 = operandStack.pop();
			double num2 = operandStack.pop();
			
			operandStack.push(num1 * num2);
			
			operatorStack.pop();
			
			numberOfOperands--;
			
			numberOfOperators--;
			
			
		}
		else if(operatorStack.peek() == '/' && operator!= '^' && numberOfOperands>1){
			
			double num1 = operandStack.pop();
			double num2 = operandStack.pop();
			
			operandStack.push(num2/num1);
			
			numberOfOperands--;
			
			operatorStack.pop();
			
			numberOfOperators--;
			
		}
		
		numberOfOperators++;
		operatorStack.push(operator);
		
		
		
	}
			
		
        // TODO: Complete this method

    /**
     * This method is called when the evaluator encounters an open bracket. It
     * manipulates operatorStack and/or operandStack to process the open bracket
     * according to the Infix-to-Postfix and Postfix-evaluation algorithms.
     * @param openBracket the open bracket token that was encountered
     */
    void handleOpenBracket(char openBracket) {
		
		if(openBracket == '('){
			typeOfBracket =1;
		}
		else{
			typeOfBracket =2;
		}
		
		
		operatorStack.push(openBracket);
		numberOfOperators++;
		
		
        // TODO: Complete this method
    }

    /**
     * This method is called when the evaluator encounters a close bracket. It
     * manipulates operatorStack and/or operandStack to process the close
     * bracket according to the Infix-to-Postfix and Postfix-evaluation
     * algorithms.
     * @param closeBracket the close bracket token that was encountered
     */
    void handleCloseBracket(char closeBracket) {
		
		if( closeBracket == ')' && typeOfBracket ==2){
			
				throw new ExpressionError("Brackets must match");
		}
		else if( closeBracket == '>' && typeOfBracket == 1){
				throw new ExpressionError("Brackets must match");
		}
		 
		while((typeOfBracket ==1 && operatorStack.peek()!= '(') || (typeOfBracket ==2 && operatorStack.peek()!= '<')){
			
		
		
			
			
			if(operatorStack.peek() == '^'){
				
				double exp = operandStack.pop();
				double base = operandStack.pop();
				
				operandStack.push(Math.pow(base, exp));
				numberOfOperands--;
				
				operatorStack.pop();
				numberOfOperators--;
			}
			else if(operatorStack.peek() == '*'){
				double num1 = operandStack.pop();
				double num2 = operandStack.pop();
			
				operandStack.push(num1 * num2);
				
				operatorStack.pop();
			
				numberOfOperands--;
			
				numberOfOperators--;
				
			}
			else if(operatorStack.peek() == '/'){
				
				double num1 = operandStack.pop();
				double num2 = operandStack.pop();
			
				operandStack.push(num2/num1);
			
				numberOfOperands--;
			
				operatorStack.pop();
			
				numberOfOperators--;
				
			}
			else if(operatorStack.peek() == '-'){
				
				double num1 = operandStack.pop();
				double num2 = operandStack.pop();
			
				operandStack.push(num2-num1);
			
				numberOfOperands--;
			
				operatorStack.pop();
			
				numberOfOperators--;
			}
			else if(operatorStack.peek() == '+'){
				
				double num1 = operandStack.pop();
				double num2 = operandStack.pop();
			
				operandStack.push(num2+num1);
			
				numberOfOperands--;
			
				operatorStack.pop();
			
				numberOfOperators--;
			}
		
			
		}
		
		return;
	}
		
		
		
        // TODO: Complete this method

    /**
     * This method is called when the evaluator encounters the end of an
     * expression. It manipulates operatorStack and/or operandStack to process
     * expression. It manipulates operatorStack and/or operandStack to process
     * the operators that remain on the stack, according to the Infix-to-Postfix
     * and Postfix-evaluation algorithms.
     */
    void handleRemainingOperators() {
		
		
		while(!operatorStack.isEmpty()){
			
			if(numberOfOperators ==1 && operatorStack.peek() == '('){
				return;
			}
			
			if(operatorStack.peek() == '^' && numberOfOperands>1){
			
				double exp = operandStack.pop();
				double base = operandStack.pop();
				
				operandStack.push(Math.pow(base, exp));
				numberOfOperands--;
				
				operatorStack.pop();
				numberOfOperators--;
			}
			else if(operatorStack.peek() == '*' && numberOfOperands>1){
				
				double num1 = operandStack.pop();
				double num2 = operandStack.pop();
			
				operandStack.push(num1 * num2);
			
				operatorStack.pop();
			
				numberOfOperands--;
			
				numberOfOperators--;
			
			}
			else if(operatorStack.peek() == '/' && numberOfOperands>1){
			
				double num1 = operandStack.pop();
				double num2 = operandStack.pop();
			
				operandStack.push(num2/num1);
			
				numberOfOperands--;
			
				operatorStack.pop();
			
				numberOfOperators--;
			
			}
			else if(operatorStack.peek() == '-' && numberOfOperands>1){
				
				double num1 = operandStack.pop();
				double num2 = operandStack.pop();
			
				operandStack.push(num2-num1);
			
				numberOfOperands--;
			
				operatorStack.pop();
			
				numberOfOperators--;
			}
			else if(operatorStack.peek() == '+' && numberOfOperands>1){
				
				
				double num1 = operandStack.pop();
				double num2 = operandStack.pop();
			
				operandStack.push(num2+num1);
			
				numberOfOperands--;
			
				operatorStack.pop();
			
				numberOfOperators--;
			}
        // TODO: Complete this method
    }
}
	
	

    /**
     * Creates an InfixExpressionEvaluator object to read from System.in, then
     * evaluates its input and prints the result.
     * @param args not used
     */
    public static void main(String[] args) {
        System.out.println("Infix expression:");
		
        InfixExpressionEvaluator evaluator =
                        new InfixExpressionEvaluator(System.in);
		/* legitExpression(input);
		
		private void legitExpression(input){
				
			int forParen = 0;
			int bacParen = 0;
			char[] chars = input.toCharArray();
			
			if (isOperator(chars[0]){
				throw new ExpressionError("Cannot start expression with an operator");
			}
			for(int i = 0; i<chars.length-1; i++){
				
				if(isForwardParantheses(chars[i]){
					forParen++;
				}
				else if (isBackwardParantheses(chars[i]){
					bacParen++;
				}
				
				if(isOperator(chars[i]) && isOperator(chars[i+1]){
					throw new ExpressionError("Back to back operators not allowed");
				}
				else if(isForwardParantheses[i] && isForwardParantheses[i+1]){
					throw new ExpressionError("Two forward parantheses not allowed");
				}
				else if(isBackwardParantheses[i] && isBackwardParantheses[i+1]){
					throw new ExpressionError("Two backward parantheses not allowed");
				}
				else if(isForwardParantheses[i] && isBackwardParantheses[i+1]{
					throw new ExpressionError("Empty parantheses not allowed");
				}
			}
			
			if(forParen != bacParen){
				throw new ExpressionError("Nesting of parantheses is incorrect");
			}
		
		}
		
		private boolean isOperator(char c){
			
			if(c == '+' || '-' || '*' || '/' || '^'){
				return true;
			}
			else {
				return false;
			}
		}
		
		private boolean isOperand(char c){
			
			if(c!= '+' || c!='-' || c!='*'|| c!='/'|| c!='/'|| c!='('|| c!=')'|| c!='<'|| c!='>'){
				return true;
			}
			else {
				return false;
			}
		}
		private boolean isForwardParantheses(char c){
			if(c == '(' || c== '<'){
				return true;
			}
			else{
				return false;
			}
		}
		private boolean isBackwardParantheses(char c){
			
			if(c == ')' || c== '>'){
				return true;
			}			
			else{
				return false;
			}
		} */
        Double value = null;
        try {
            value = evaluator.evaluate();
        } catch (ExpressionError e) {
            System.out.println("ExpressionError: " + e.getMessage());
        }
        if (value != null) {
            System.out.println(value);
        } else {
            System.out.println("Evaluator returned null");
        }
    }

}





