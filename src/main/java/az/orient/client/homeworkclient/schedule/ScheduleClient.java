package az.orient.client.homeworkclient.schedule;

import az.orient.client.homeworkclient.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ScheduleClient {

    private final UserService userService;

//    @Scheduled(cron = "*/5 * * * * *")
//    public void run() {
//        try {
//            userService.getUserList();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }


}
