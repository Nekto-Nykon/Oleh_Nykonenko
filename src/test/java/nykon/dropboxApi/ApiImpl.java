package nykon.dropboxApi;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import nykon.domain.Entries;
import nykon.domain.Data;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
@Slf4j
public class ApiImpl implements Api{
    private final HttpClient client;
    private final String ACCESS_TOKEN;
    private final ObjectMapper objectMapper;

    public ApiImpl(String accessToken){
        this.ACCESS_TOKEN = accessToken;
        this.objectMapper = new ObjectMapper();
        client = HttpClient.newBuilder().build();
    }

    @SneakyThrows
    public void upload(Path path){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://content.dropboxapi.com/2/files/upload"))
                .header("Authorization", "Bearer " + ACCESS_TOKEN)
                .header("Dropbox-API-Arg",
                        "{\"autorename\":false," +
                                "\"mode\":\"add\"," +
                                "\"mute\":false," +
                                "\"path\":\"" + "/" + path + "\"," +
                                "\"strict_conflict\":false}")
                .header("Content-Type", "application/octet-stream")
                .POST(HttpRequest.BodyPublishers.ofFile(path))
                .build();

        HttpResponse<String> send = client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    @SneakyThrows
    public boolean download(Path fileToUploadPath, Path fileFromDropboxPath) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://content.dropboxapi.com/2/files/download"))
                .header("Authorization", "Bearer " + ACCESS_TOKEN)
                .header("Dropbox-API-Arg", "{\"path\":\"" + "/" + fileToUploadPath + "\"}")
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            Files.write(fileFromDropboxPath, response.body().getBytes());
            return true;
        } else {
            return false;
        }
    }

    @SneakyThrows
    public List<Data> getFileList() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.dropboxapi.com/2/files/list_folder"))
                .header("Authorization", "Bearer " + ACCESS_TOKEN)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString("{\"path\":\"\",\"recursive\":false," +
                        "\"include_media_info\":false," +
                        "\"include_deleted\":false," +
                        "\"include_has_explicit_shared_members\":false," +
                        "\"include_mounted_folders\":true," +
                        "\"include_non_downloadable_files\":true}"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String body = response.body();

        return objectMapper.readValue(body, Entries.class).getEntries();
    }

    @SneakyThrows
    public Optional<Data> getFileMetadata(Path path) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.dropboxapi.com/2/files/get_metadata"))
                .header("Authorization", "Bearer " + ACCESS_TOKEN)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString("{\"include_deleted\":false," +
                        "\"include_has_explicit_shared_members\":false," +
                        "\"include_media_info\":false," +
                        "\"path\":\"" + "/" + path + "\"}"
                )).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return Optional.of(objectMapper.readValue(response.body(), Data.class));
    }

    @SneakyThrows
    public void delete(Path path) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.dropboxapi.com/2/files/delete_v2"))
                .header("Authorization", "Bearer " + ACCESS_TOKEN)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString("{\"path\":\"" + "/" + path + "\"}"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != 200){
            throw new RuntimeException("File was not deleted");
        }
    }
}
