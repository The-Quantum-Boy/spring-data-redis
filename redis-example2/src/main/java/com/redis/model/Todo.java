package com.redis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@RedisHash
public class Todo {

    @Id
    private Long id;

    private String title;

    private Boolean completed =false;

    private Long order;

    private String url;

}
