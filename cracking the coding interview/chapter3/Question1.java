package chapter3;

import java.util.Hashtable;

class Question1{
    public static int[] mainArray = new int[30];
    public static Hashtable<Integer, Stack> stackTable = new Hashtable<Integer, Stack>();

	public static void main(String[] args){
	   Stack stack1 = new Stack(0,0,10);
	   Stack stack2 = new Stack(10,10,10);
	   Stack stack3 = new Stack(20,20,10);

       stackTable.put(1, stack1);
       stackTable.put(2, stack2);
       stackTable.put(3, stack3);
       
       pop(1);
       pop(2);
       pop(3);
       push(1, 6);
       push(2, 8);
       push(3, 9);
       pop(1);
       pop(2);
       pop(3);

    }
    public static void pop(int stackId){
        Stack stack = stackTable.get(stackId);
        if(stack.getTop() == stack.getBase()){
            System.out.println("The stack is empty");
        }
        else{
             int top = stack.getTop();
             top -=1;
             System.out.println("stack top "+ top);// ("stack top" + stack)
             System.out.println("Popping elment "+ mainArray[top]);
             stack.setTop(top);
        }

    }
    public static void push(int stackId, int val){
        Stack stack = stackTable.get(stackId);
        int top = stack.getTop();
        if((stack.getTop()-stack.getBase()) <= stack.getSize()){
            mainArray[top] = val;
            top += 1;
            stack.setTop(top);
        }
        else{
            resizeMainArray(stackId);
            int newTop = stack.getTop();       
            mainArray[newTop] = val;
            newTop += 1;
            stack.setTop(newTop);
        }
    }
    public static void resizeMainArray(int stackId){
    	System.out.println("RESIZE");
         return;
    }
}


class Stack{
	int base;
	int top;
	int size;
	Stack(int top, int base, int size){ //13,10,10
	   this.top = top;
	   this.base = base;
	   this.size = size;
	}
    public int getTop(){
       return this.top;
    }
    public int getSize(){
       return this.size;
    }
    public int getBase(){
       return this.base;
    }
	public void setTop(int top){
	   this.top = top;
	}
	public void setBase(int base){
	    this.base = base;
	}
	public void setSize(int size){
	   this.size = size;
	}
}