# Execution and Development Environment
To complete this project, I used Intellij on my macbook and windows PC.
# Compilation Result
Using the terminal, I used the following commands on the project files:
> javac EvaluatorTester.java

> java EvaluatorTester

> javac EvaluatorUI.java

> java EvaluatorUI

> javac Evaluator.java
The program ran as expected and no error messages were displayed
# Assumptions
I assumed that incoming infix expressions were valid. For example, no extra parentheses, no
trailing operators (i.e. ++, --), and every open parentheses had its corresponding closed
parentheses. I also assumed all operands are integer values.
Implementation
Operator class
I began working on this project by implementing the operator class. Looking at the Evaluator
class, I knew I needed a working operator and operand classes before touching the Evaluator
algorithm. Following the instructions on the assignment page and hints in the code, I initialized
a HashMap to hold the operators I am interested in keyed by its corresponding subclass that
extends the abstract operator class. Then I simply left the priority() and execute(Operand,
Operand) to be implemented in each subclass with their respective values and calculation
algorithm.
Operator subclasses
For the implementation of the subclasses, I used @override to prevent the instantiation of either
operator method more than once. Then, following the instructions for this assignment, I
returned the respective priority value to each operator subclass. Finally, for the execute
method, I created an Operand object that holds the correct calculation for each operator
subclass.
Operand
The Operand class was mostly easy to implement. Two constructors, one holds a String token
and the other holds the corresponding integer value of the String, one getter method that
returns the integer value of the Operand object, and the boolean isNumber that checks if
scanned token is a string value. The boolean method was a bit tricky, however, after a few
attempts, I ended up using a try and catch to parse the token and check whether it indeed is a
string token.
Evaluator
After implementing the Operator class, Operand class, and the operator subclasses, I was
ready to begin working on the Evaluator class. After a few thinking sessions, I began to
understand the overall algorithm and how everything works together. I noticed that I’ll be using
the “process operators” algorithm more than once, so I decided to create a method that holds
these lines of code. Next, I opened the assignment instructions document and used a few
if/else if/else statements in the first while loop that hold the different conditions specified in the
document. After the first while loop ends and the expression is fully transformed into values
inside either the operand or operator stacks, if there are any operators left in the operator stack
other than parentheses, process them until the operator stack is empty then return the top of
the operand class as the answer.
EvaluatorUI
This class was fairly easy to implement, most of the code was already done for me. I did notice
that there were three for loops that loop through the same thing so I decided to merge them
into one to reduce runtime. For the actionPerformed function, I created a String that holds the
button presses then checks if the button pressed is =, C, or CE. For the = button, I created an
Evaluator object and used the eval method I previously implemented to calculate the String
token. As for C and CE, I set the function to clear the textfield. Finally, for all other buttons, the
function prints the number or operator on the screen.
Code Organization
To better organize this project I moved the Operator and Operand classes into a package,
created a different java file for each Operator subclass and placed all of them into a package
within the Operator and Operand package
