package abstractizare.second;

import abstractizare.first.Task;

public class Stack implements Container{
    @Override
    public Task pop() {
        return null;
    }

    @Override
    public void push(Task task) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void transferFrom(Container container) {

    }
}
