package mintuchel.AzureGradle.todo;

import jakarta.persistence.*;
import lombok.*;
import mintuchel.AzureGradle.user.User;

import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    private String task;

    private LocalDateTime time;

    private boolean completed;

    private boolean calendered;
}

