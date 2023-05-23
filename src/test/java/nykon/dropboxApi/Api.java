package nykon.dropboxApi;

import nykon.domain.Data;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;


public interface Api{
    void upload(Path path);

    boolean download(Path from, Path to);

    Optional<Data> getFileMetadata(Path path);

    void delete(Path path);

    List<Data> getFileList();
}
