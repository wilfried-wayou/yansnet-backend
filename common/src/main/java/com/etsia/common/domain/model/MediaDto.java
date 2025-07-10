package com.etsia.common.domain.model;

import lombok.Builder;
import lombok.Value;
import com.etsia.common.domain.model.sub.MediaType;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link com.etsia.common.infrastructure.entities.Media}
 */



@Builder
@Value
public class MediaDto implements Serializable {
    Integer id;
    String url;
    Instant uploadedAt;
    PostDto post;
    MediaType type;
    
}