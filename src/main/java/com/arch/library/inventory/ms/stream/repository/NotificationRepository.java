package com.arch.library.inventory.ms.stream.repository;


import com.arch.library.inventory.ms.stream.data.NotificationData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<NotificationData, Long> {}
