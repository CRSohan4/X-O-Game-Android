package com.example.crsohan.xogamemultiplayer;

public class stack {
    int max = 10;
    int top,i;
    char[] stack = new char[12];

    public void push(char item){
        if(top == max){

        }else{
            top = top + 1;
            stack[top] = item;
        }
    }

    public char pop(){
        char item;
        if(top == 0){
            return 'y';
        }else{
            item = stack[top];
            top = top - 1;
            return item;
        }
    }

    public char show(int count){
        char item = stack[count];
        return item;
    }


}
