package mintuchel.AzureGradle.todo.dto;

import java.time.LocalDateTime;

public record TodoInfoResponse(
        int id,
        String task,
        LocalDateTime time,
        boolean completed
) { }
