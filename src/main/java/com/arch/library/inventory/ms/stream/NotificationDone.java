package com.arch.library.inventory.ms.stream;

import com.arch.library.inventory.ms.stream.data.NotificationData;
import com.arch.library.inventory.ms.stream.domain.NotificationDoneDO;
import com.arch.library.inventory.ms.stream.repository.NotificationRepository;
import java.util.function.Consumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("notificationDone")
public class NotificationDone implements Consumer<NotificationDoneDO> {

  private final NotificationRepository repository;

  public NotificationDone(NotificationRepository repository) {
    this.repository = repository;
  }

  @Override
  public void accept(NotificationDoneDO notificationDoneDO) {
    log.info("Information comes in {}", notificationDoneDO);
    
    
    NotificationData data = new NotificationData();
    data.setCountry(notificationDoneDO.country());
    data.setName(notificationDoneDO.name());
    data.setState(notificationDoneDO.state());
    NotificationData saved = repository.save(data);
    
    log.info("Information saved with id {}", saved.getId());
  }
}
