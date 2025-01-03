package mintuchel.AzureGradle.todo;

import lombok.RequiredArgsConstructor;
import mintuchel.AzureGradle.todo.dto.CreateTodoRequest;
import mintuchel.AzureGradle.todo.dto.TodoInfoResponse;
import mintuchel.AzureGradle.todo.dto.UpdateTodoStatusRequest;
import mintuchel.AzureGradle.user.User;
import mintuchel.AzureGradle.user.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    // private final OpenAIService openAIService;

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<TodoInfoResponse> getTodoListByUserId(String userId){
        return todoRepository.getTodoByUserId(userId).stream()
                .map(todo -> new TodoInfoResponse(todo.getId(), todo.getTask(), todo.getTime(), todo.isCompleted()))
                .toList();
    }

    @Transactional
    public int createNewTodo(CreateTodoRequest createTodoRequest){
        User user = userRepository.findById(createTodoRequest.userId()).orElseThrow();

        Todo todo = Todo.builder()
                .user(user)
                .time(createTodoRequest.time())
                .task(createTodoRequest.task())
                .completed(false)
                .calendered(createTodoRequest.calendered())
                .build();

        todoRepository.save(todo);

        return 1;
    }

    @Transactional
    public int updateTodoStatus(UpdateTodoStatusRequest updateTodoStatusRequest){
        Todo todo = todoRepository.findById(updateTodoStatusRequest.todoId()).orElseThrow();

        todoRepository.changeTodoStatus(todo.getId());

        return 1;
    }
}
