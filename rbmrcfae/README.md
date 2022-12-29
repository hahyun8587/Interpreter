## Compilation

    javac .\edu\handong\csee\plt\*.java .\edu\handong\csee\plt\ast\*.java .\edu\handong\csee\plt\exception\*.java .\edu\handong\csee\plt\interprete\*.java .\edu\handong\csee\plt\parse\*.java .\edu\handong\csee\plt\structure\*.java .\edu\handong\csee\plt\sugar\*.java .\edu\handong\csee\plt\util\*.java

  

## Usage
     java <Path to Main.class> [-p] <your code>
- -p: for using only parser  
    
  
## Supprotings
- Arithmetics
  - addition
  - substraction
  - multiplication
- Boolean type     
  - true: either non-zero or #t
  - false: either 0 or #f
- If operation
  - either "{if 12345 3 4 }" or "{if #t 3 4}"
- Recursion Operation
- Box operations
  - newbox
  - setbox
  - openbox
- Variable
- Call-by-value
- Call-by-reference
- Laziness
- Exception handling
  - Parse Exceptions
    - Type mismatch exception
    - Too many few arguments exception
    - Too many arguments exception
    - Parenthesis not matching exception
    - Invalid syntax exception
  - Interprete Exceptions
    - Cannot evaluate exception
    - Invalid AST exception


## Architecture
- ast
  - ast nodes
- exception
  - exceptions and exception handlers
- parse
  - parsing methods
    - unary parse
    - binary parse
    - trinary parse
    - binding parse
    - fun parse
- interprete
  - interpreting methods
    - binary interprete
    - app interprete
- structure
  - variable: structure for variable with its address
  - memory: structure for memory with the actual value
- sugar
  - with node 
- util
  - option to show exprV memory or unwrapped memory 