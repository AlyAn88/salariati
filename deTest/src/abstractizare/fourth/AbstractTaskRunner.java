package abstractizare.fourth;

import abstractizare.first.Task;
import abstractizare.second.Container;
import abstractizare.third.ContainerFactory;
import abstractizare.third.Strategy;

public abstract class AbstractTaskRunner {
	private Container container;

    protected AbstractTaskRunner(Strategy strategy) {
        container = ContainerFactory.INSTANCE.createContainer(strategy);
    }

    public void addTask(Task task) {
        container.push(task);
    }

    public void executeAll() {
        while (!container.isEmpty()) {
            Task task = container.pop();

            task.execute();

            afterExecution(task);
        }
    }

    protected abstract void afterExecution(Task task);
}
