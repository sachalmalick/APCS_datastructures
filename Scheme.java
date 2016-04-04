/*
  Team: Over the Moon -- Sachal Malick, Kyle Moon
  APCS2 PD10
  HW24 -- Schemin
  2016-02-2016
*/

/*****************************************************
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 *
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
      1. Seperate expr by its whitespaces
      2. Traverse through the expr backwards
      3. Add all operands to a stack
      4. Keep track of open parens with a counter
      5. Once you hit an operator, find its respective operands using the counter
      6. Combine the operands with the operator correctly
      7. Rinse and repeat- but no recursion
      8. Complete after one traverse, return the last element in the stack
      *
      * STACK OF CHOICE: LLStack by sachal with minor tweaks by kyle
      * b/c it is simple and clean
      ******************************************************/

public class Scheme {

    /*
     * precond:  Assumes expr is a valid Scheme (prefix) expression,
     *           with whitespace separating all operators, parens, and
     *           integer operands.
     * postcond: Returns the simplified value of the expression, as a String
     * eg,
     *           evaluate( "( + 4 3 )" ) -> 7
     *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
     */

    public static String evaluate( String expr )
    {
        Stack<String> nums = new LLStack<String>();
        int counter = 0;
        String[] queue = expr.split(" ");
        for (int i = queue.length - 1; i >= 1; i--)
        {
            String s = queue[i];
            if (s.equals("("))
                continue;
            if (s.equals(")"))
                counter = 0;
            else if (isNumber(s))
            {
                counter += 1;
                nums.push(s);
            }
            else
            {
                String[] temp = new String[counter];
                while (counter > 0)
                {
                    temp[temp.length - counter] = nums.pop();
                    counter--;
                }
                nums.push(operation(s,temp));
                counter = nums.size();
            }
        }
        return nums.pop();
    }

    //applies the operation to all numbers in a list
    public static String operation(String op, String[] numbers)
    {
        int start = Integer.parseInt(numbers[0]);

        for (int k = 1; k < numbers.length; k++)
        {
            int i = Integer.parseInt(numbers[k]);
            if (op.equals("+"))
                start += i;
            if (op.equals("-"))
                start -= i;
            if (op.equals("*"))
                start *= i;
        }
        return start + "";
    }

    //optional check-to-see-if-its-a-number helper fxn:
    public static boolean isNumber( String s ) {
        try {
            Integer.parseInt(s);
            return true;
        }
        catch( NumberFormatException e ) {
            return false;
        }
    }

    //main method for testing
    public static void main( String[] args ) {

        String zoo1 = "( + 4 3 )";
        System.out.println(zoo1);
        System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
        //...7

        String zoo2 = "( + 4 ( * 2 5 ) 3 )";
        System.out.println(zoo2);
        System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
        //...17

        String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
        System.out.println(zoo3);
        System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
        //...29

        String zoo4 = "( - 1 2 3 )";
        System.out.println(zoo4);
        System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
        //...-4
        /*
        Stack<String> test = new LLStack<String>();
        test.push("3");
        test.push("2");
        test.push("1");
        System.out.println(operation("-",test));
*/
    }//main

}//end class Scheme
