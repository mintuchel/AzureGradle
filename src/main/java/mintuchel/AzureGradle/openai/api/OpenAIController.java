package mintuchel.AzureGradle.openai.api;

import mintuchel.AzureGradle.openai.dto.OpenAITransitionRequest;
import mintuchel.AzureGradle.openai.service.OpenAIService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/openai")
@RequiredArgsConstructor
public class OpenAIController {

    private final OpenAIService openAIService;

    @PostMapping("")
    public String changeToTodoList(@RequestBody OpenAITransitionRequest request){
        return openAIService.changeInputToTodoList(request.voiceInput());
    }
}
