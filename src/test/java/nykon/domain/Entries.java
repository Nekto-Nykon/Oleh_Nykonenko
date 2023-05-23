package nykon.domain;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@lombok.Data
@Slf4j
public class Entries {
    private List<Data> entries;

    private String cursor;

    @JsonProperty("has_more")
    private boolean hasMore;
}
