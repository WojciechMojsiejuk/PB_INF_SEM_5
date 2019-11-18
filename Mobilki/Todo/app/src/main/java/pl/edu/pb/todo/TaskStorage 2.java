package pl.edu.pb.todo;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskStorage {
    private static final TaskStorage ourInstance = new TaskStorage();
    private List<Task> tasks;

    public List<Task> getTasks() { return tasks; }
    public Task getTask(UUID id) {
        Task result = null;
        for (Task task : tasks) {
            if (task.getId().equals(id)) { result = task; }
        }
        return result;
    }

    public static TaskStorage getInstance() {
        return ourInstance;
    }

    private TaskStorage() {
        tasks = new ArrayList<>();
        for (int i = 0; i < 100; i++) { tasks.add(new Task("Zadanie " + Integer.toString(i))); }
    }
}
