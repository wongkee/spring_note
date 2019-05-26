package springwebservice.service;

import java.util.Date;

import org.springframework.stereotype.Service;
import springwebservice.service.HumanResourceService;

@Service
public class StubHumanResourceService implements HumanResourceService {
    public void bookHoliday(Date startDate, Date endDate, String name) {
        System.out.println("Booking holiday for [" + startDate + "-" + endDate + "] for [" + name + "] ");
    }
}