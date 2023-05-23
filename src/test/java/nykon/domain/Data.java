package nykon.domain;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@lombok.Data
@Slf4j
public class Data {
    @JsonProperty(".tag")
    private String tag;

    private String name;

    @JsonProperty("path_lower")
    private String pathLower;

    @JsonProperty("path_display")
    private String pathDisplay;

    private String id;

    @JsonProperty("client_modified")
    private String clientModified;

    @JsonProperty("server_modified")
    private String serverModified;

    private String rev;

    private int size;

    @JsonProperty("is_downloadable")
    private boolean isDownloadable;

    @JsonProperty("content_hash")
    private String contentHash;
}
