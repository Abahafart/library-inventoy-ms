package com.arch.library.inventory.ms.stream;

import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.arch.library.inventory.ms.stream.domain.BookDO;

@Component
public class NewBook implements Consumer<BookDO> {

  private static final Logger log = LoggerFactory.getLogger(NewBook.class);

  @Override
  public void accept(BookDO bookDO) {
    log.info("Book published: {}", bookDO);
  }
}
