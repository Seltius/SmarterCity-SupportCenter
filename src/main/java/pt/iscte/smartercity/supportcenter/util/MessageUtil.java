package pt.iscte.smartercity.supportcenter.util;

import java.time.LocalDate;
import pt.iscte.smartercity.supportcenter.service.dto.MessageDTO;
import pt.iscte.smartercity.supportcenter.service.dto.SupportProcessDTO;

public class MessageUtil {

    public static MessageDTO createMessage(Integer supportId, String value, String messageType) {
        MessageDTO message = new MessageDTO();

        message.setSupportId(supportId);
        message.setDate(LocalDate.now());
        message.setMessageType(messageType);
        message.setValue(value);

        return message;
    }
}
