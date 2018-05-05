This project dealt with working with Stacks as a way to create an Infix Expression Calculator. 

The Stack is a fundamental data structure that maintains items in a LIFO order (Last in, First out). The particular set-up of this data structure makes it useful to use since it can help with precedence and order of operations. 

The Stack we used was an Array-based Stack implementation denoted by the data structure "ArrayStack". This "ArrayStack" structure is used by the "InfixExpressionEvaluator" data structure as a means to accurately calculate a given input expression. 

We assume that users wanting to use the "InfixExpressionEvaluator" data structure will pass in well-formatted Infix Expressions, although there are many places where the data structure throws an "ExpressionError" in case the input string is not well-formatted. 