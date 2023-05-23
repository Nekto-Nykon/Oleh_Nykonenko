package nykon.dropboxApi;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import nykon.factory.AbstractFactory;
import nykon.factory.Factory;
import nykon.domain.Data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
@Slf4j
@RequiredArgsConstructor
@AllArgsConstructor
public class ApiTest {
    private final Api api;
    private final Path filePath;
    private final Path uploadedFilePath;
    private Optional<Data> fileMetadata;

    public ApiTest() {
        Factory apiFactory = AbstractFactory.getImplInstance();
        api = apiFactory.getApi();
        filePath = Path.of("File.txt");
        uploadedFilePath = Path.of("uploadedFile.txt");
    }

    @Given("the file is created")
    public void createNewFile() {
        try {
            Files.write(filePath, "Some File".getBytes());
        } catch (IOException e) {
            throw new RuntimeException(String.format("Failed to create file: %s", e));
        }
    }

    @When("user uploads the file")
    public void uploadFileToDropbox() {
        api.upload(filePath);
    }

    @Then("the file is on Dropbox")
    public void verifyFileUploading() {
        List<Data> entries = api.getFileList();

        for (Data data : entries) {
            if (data.getName().equals(filePath.toString())) {
                return;
            }
        }
        throw new RuntimeException("Failed to get the file");
    }

    @And("user requests file's metadata")
    public void receiveFileMetadata() {
        log.info("Receiving the file metadata");
        fileMetadata = api.getFileMetadata(filePath);
    }

    @Then("file's metadata is received")
    public void verifyFileMetadata(){
        if (fileMetadata.isEmpty()) {
            throw new RuntimeException("Failed to get the file metadata");
        }
    }

    @And("user deletes the file")
    public void deleteFileFromDropbox() {
        api.delete(filePath);
    }

    @Then("there is no file on Dropbox")
    public void verifyFileExtraction() {
        boolean success = api.download(filePath, uploadedFilePath);
        if (success){
            throw new RuntimeException("Failed to delete the file");
        }
    }

    @After
    @SneakyThrows
    public void finalizeDropbox(){
        Files.deleteIfExists(filePath);
        Files.deleteIfExists(uploadedFilePath);
    }
}
