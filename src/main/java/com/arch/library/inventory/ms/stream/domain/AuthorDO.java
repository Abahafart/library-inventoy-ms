package com.arch.library.inventory.ms.stream.domain;

import java.io.Serializable;
import java.time.Instant;

public record AuthorDO(Long authorId, String name, String description, Instant createdAt, Instant updatedAt, int version) implements
    Serializable {

  public AuthorDO(String name, String description) {
    this(null, name, description, null, null, 0);
  }
  public AuthorDO(long authorId) {
    this(authorId, null, null, null, null, 0);
  }

}
