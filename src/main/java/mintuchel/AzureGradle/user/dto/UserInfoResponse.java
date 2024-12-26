package mintuchel.AzureGradle.user.dto;

public record UserInfoResponse(
        int id,
        String username,
        String password
) { }
