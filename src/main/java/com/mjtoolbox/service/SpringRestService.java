package com.mjtoolbox.service;

import com.mjtoolbox.bean.Message;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Project: springrest
 * Description:
 * Created by mijo on 2015-06-25.
 */
@Service
public class SpringRestService {

    private static List<Message> messageList = new ArrayList<Message>();

    public List<Message> getAllEvents() {
        if ( messageList.size() == 0) {
            messageList.add(new Message("", 12345L, "ABC", "Pending", "Message is pending", new Date(), new Date(), "MJ", "Pending", "noaction"));
            messageList.add(new Message("", 12346L, "EFG", "Created", "Message is created", new Date(), new Date(), "JSmith", "Submitted", "noaction"));
            messageList.add(new Message("", 12347L, "XXL", "Pending", "Message is pending", new Date(), new Date(), "JDoe", "Pending", "noaction"));
            messageList.add(new Message("", 12348L, "XSL", "Sent", "Message is sent", new Date(), new Date(), "WAnderson", "Sent", "noaction"));
            messageList.add(new Message("", 12349L, "MMG", "Completed", "Message was sent and completed", new Date(), new Date(), "KRon", "Completed", "noaction"));
        }
        return messageList;
    }

    public void addEvent(Message event) {
        messageList.add(event);
    }

    public void deleteEventById(Long id) {
        Message found = findMessageById(id);
        if (found != null) {
            messageList.remove(found);
            id--;
        }
    }

    public void updateEvent(Message event) {
        Message found = findMessageById(event.getId());
        if (found != null) {
            messageList.remove(found);
            messageList.add(event);
        }
    }

    public void deleteAll() {
        messageList.clear();
    }


    private Message findMessageById(Long id) {
        for (Message ms : messageList) {
            if (ms.getId() == id) {
                return ms;
            }
        }
        return null;
    }

}
