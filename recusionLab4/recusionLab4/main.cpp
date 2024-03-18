#include <iostream>
#include <stack>

using namespace std;


class Stack {
    stack<int> s;
public:
    // Pushes an element on top of the stack
    void push(int data) {
        s.push(data);
    }

    // Returns the top element of the stack
    int top() {
        return s.top();
    }

    // Removes the top element of the stack
    void pop() {
        if (!s.empty()) {
            s.pop();
        }
    }

    // Checks if the stack is empty
    bool isEmpty() {
        return s.empty();
    }
};

// Function to insert an # at the bottom of a stack
void insertAtBottom(Stack& stack, int item) {
    // If stack is empty, push the item onto the stack
    if (stack.isEmpty()) {
        stack.push(item);
    }
    else {
        // Otherwise, recursively move elements from top to bottom
        // and insert the item at the bottom
        int top = stack.top();
        stack.pop();
        insertAtBottom(stack, item);

        // Push the top element back after insertion
        stack.push(top);
    }
}

// Recursive function to reverse the stack
void reverseStack(Stack& stack) {
    // If the stack is not empty
    if (!stack.isEmpty()) {
        // Remove the top element and reverse the remaining stack
        int top = stack.top();
        stack.pop();
        reverseStack(stack);

        // Insert the removed element at the bottom of the stack
        insertAtBottom(stack, top);
    }
}

int main() {
    Stack stack;
    // Push # onto the stack
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);

    // Print the original stack
    cout << "Original Stack: ";
    while (!stack.isEmpty()) {
        cout << stack.top() << " ";
        stack.pop();
    }

    // Resetting the stack og state
    stack.push(2);
    stack.push(3);
    stack.push(4);

    // Reversing the stack
    reverseStack(stack);

    // Print the reversed stack
    cout << "\nReversed Stack: ";
    while (!stack.isEmpty()) {
        cout << stack.top() << " ";
        stack.pop();
    }

    return 0;
}
