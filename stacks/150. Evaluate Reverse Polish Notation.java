// Evaluate the value of an arithmetic expression in Reverse Polish Notation.

// Valid operators are +, -, *, and /. Each operand may be an integer or another expression.

// Note that division between two integers should truncate toward zero.

// It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to a result, and there will not be any division by zero operation.

//Solution

class Solution {
    public int evalRPN(String[] t) {
        
        Stack<Integer> s = new Stack<Integer>();
            for(int i =0;i<t.length;i++){
                String str = t[i];
                if(str.equals("+") ){
                    int val2 = s.pop();
                    int val1 = s.pop();
                    int ans = val1+val2;
                    s.push(ans);
                }else if(str.equals("-") ){
                     int val2 = s.pop();
                    int val1 = s.pop();
                    int ans = val1-val2;
                    s.push(ans);
                }else if( str.equals("/") ){
                     int val2 = s.pop();
                    int val1 = s.pop();
                    int ans = val1/val2;
                    s.push(ans);
                }else if(str.equals("*")){
                        int val2 = s.pop();
                    int val1 = s.pop();
                    int ans = val1*val2;
                    s.push(ans);
                }else{
                    int val = Integer.parseInt(str);
                    s.push(val);
                }
            }
        int res = s.pop();
        return res;
        
    }
}
