package org.example;

// separation of concerns
// during the runtime a class was getting creating - $Proxy12
// API interception
// class A;
// isLoggingRequired, isTimeStampReqd
// func(args) {
//  JOB
// }
// class LoggingEnabled extends A
// func(args) {
// log
// super.func(args)
//  log
// }

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
