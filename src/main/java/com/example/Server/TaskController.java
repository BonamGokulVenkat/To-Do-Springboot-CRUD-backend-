package com.example.Server;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "http://localhost:5173") // Connects to React later
public class TaskController {
    private final TaskRepository repository;

    public TaskController(TaskRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Task> getTasks() { return repository.findAll(); }

    @PostMapping
    public Task addTask(@RequestBody Task task) { return repository.save(task); }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) { repository.deleteById(id); }
}