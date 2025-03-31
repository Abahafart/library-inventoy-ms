package com.arch.library.inventory.ms.stream.domain;

import java.io.Serializable;
import java.time.Instant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDO implements Serializable {

  private Long bookId;
  private String title;
  private String isbn;
  private String subject;
  private String publisher;
  private String language;
  private int numberOfPages;
  private AuthorDO author;
  private Instant createdAt;
  private Instant updatedAt;
  private int version;

  @Override
  public String toString() {
    return "BookDO {" +
        "bookId=" + bookId +
        ", title='" + title + '\'' +
        ", ISBN='" + isbn + '\'' +
        ", subject='" + subject + '\'' +
        ", publisher='" + publisher + '\'' +
        ", language='" + language + '\'' +
        ", numberOfPages=" + numberOfPages +
        ", author=" + author +
        ", createdAt=" + createdAt +
        ", updatedAt=" + updatedAt +
        ", version=" + version +
        '}';
  }
}
