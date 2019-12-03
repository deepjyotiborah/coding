package com.deep.datastructure.stack.problems;

/*
    Given an array, print the Next Greater Element (NGE) for every element.
    The Next greater Element for an element x is the first greater element on the right side of x in array.
     Elements for which no greater element exist, consider next greater element as -1
 */

import java.util.Stack;

public class NextGreaterElement {
    private void printNextGreaterElement(int[] arr) {
        Stack<Integer> intStack = new Stack<>();
        int next, element;
        intStack.push(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            next = arr[i];

            if (!intStack.empty()) {
                element = intStack.pop();
                /* If the popped element is smaller than
                   next, then a) print the pair b) keep
                   popping while elements are smaller and
                   stack is not empty */
                while (element < next) {
                    System.out.println(element + " ---> "+ next);
                    if(intStack.empty())
                        break;
                    element = intStack.pop();
                }
                if(element > next)
                    intStack.push(element);
            }

            /* push next to stack so that we can find next
               greater for it */
            intStack.push(next);
        }

        while (!intStack.empty()) {
            System.out.println(intStack.pop() + " ---> -1");
        }
    }

    public static void main(String[] args) {
        NextGreaterElement nextGreaterElement = new NextGreaterElement();
        int[] arr = {5, 1, 2, 6, 4};
        nextGreaterElement.printNextGreaterElement(arr);
    }
}
