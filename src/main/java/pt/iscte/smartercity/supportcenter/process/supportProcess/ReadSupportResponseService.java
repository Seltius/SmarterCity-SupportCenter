package pt.iscte.smartercity.supportcenter.process.supportProcess;

import java.util.ArrayList;
import java.util.List;
import org.akip.repository.TaskInstanceRepository;
import org.akip.service.TaskInstanceService;
import org.akip.service.dto.TaskInstanceDTO;
import org.akip.service.mapper.TaskInstanceMapper;
import org.springframework.stereotype.Component;
import pt.iscte.smartercity.supportcenter.domain.Message;
import pt.iscte.smartercity.supportcenter.repository.MessageRepository;
import pt.iscte.smartercity.supportcenter.repository.SupportProcessRepository;
import pt.iscte.smartercity.supportcenter.service.SupportService;
import pt.iscte.smartercity.supportcenter.service.dto.MessageDTO;
import pt.iscte.smartercity.supportcenter.service.dto.SupportDTO;
import pt.iscte.smartercity.supportcenter.service.dto.SupportProcessDTO;
import pt.iscte.smartercity.supportcenter.service.mapper.SupportProcessMapper;

@Component
public class ReadSupportResponseService {

    private final TaskInstanceService taskInstanceService;

    private final SupportService supportService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final SupportProcessRepository supportProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final ReadSupportResponseMapper readSupportResponseMapper;

    private final SupportProcessMapper supportProcessMapper;

    private final MessageRepository messageRepository;

    public ReadSupportResponseService(
        TaskInstanceService taskInstanceService,
        SupportService supportService,
        TaskInstanceRepository taskInstanceRepository,
        SupportProcessRepository supportProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        ReadSupportResponseMapper readSupportResponseMapper,
        SupportProcessMapper supportProcessMapper,
        MessageRepository messageRepository
    ) {
        this.taskInstanceService = taskInstanceService;
        this.supportService = supportService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.supportProcessRepository = supportProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.readSupportResponseMapper = readSupportResponseMapper;
        this.supportProcessMapper = supportProcessMapper;
        this.messageRepository = messageRepository;
    }

    public ReadSupportResponseContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        SupportProcessDTO supportProcess = supportProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(readSupportResponseMapper::toSupportProcessDTO)
            .orElseThrow();

        // GET ALL HISTORIC MESSAGES TODO USE MAPSTRUCT TO CONVERT DATA
        List<MessageDTO> messageList = new ArrayList<>();
        List<Message> messageEntityList = messageRepository.findAllBySupportId(supportProcess.getSupport().getSupportId());

        for (Message message : messageEntityList) {
            MessageDTO finalMessage = new MessageDTO();

            finalMessage.setValue(message.getValue());
            finalMessage.setMessageType(message.getMessageType());
            finalMessage.setDate(message.getDate());

            messageList.add(finalMessage);
        }
        supportProcess.getSupport().setMessageList(messageList);

        ReadSupportResponseContextDTO readSupportResponseContext = new ReadSupportResponseContextDTO();
        readSupportResponseContext.setTaskInstance(taskInstanceDTO);
        readSupportResponseContext.setSupportProcess(supportProcess);

        return readSupportResponseContext;
    }

    public ReadSupportResponseContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(ReadSupportResponseContextDTO readSupportResponseContext) {
        SupportDTO supportDTO = supportService.findOne(readSupportResponseContext.getSupportProcess().getSupport().getId()).orElseThrow();
        supportDTO.setSupportId(readSupportResponseContext.getSupportProcess().getSupport().getSupportId());
        supportDTO.setStartDate(readSupportResponseContext.getSupportProcess().getSupport().getStartDate());
        supportDTO.setUserName(readSupportResponseContext.getSupportProcess().getSupport().getUserName());
        supportDTO.setEmail(readSupportResponseContext.getSupportProcess().getSupport().getEmail());
        supportDTO.setMessage(readSupportResponseContext.getSupportProcess().getSupport().getMessage());
        supportDTO.setSupportMessage(readSupportResponseContext.getSupportProcess().getSupport().getSupportMessage());
        supportDTO.setIsResolved(readSupportResponseContext.getSupportProcess().getSupport().getIsResolved());
        supportService.save(supportDTO);
    }

    public void complete(ReadSupportResponseContextDTO readSupportResponseContext) {
        save(readSupportResponseContext);
        SupportProcessDTO supportProcess = supportProcessRepository
            .findByProcessInstanceId(readSupportResponseContext.getSupportProcess().getProcessInstance().getId())
            .map(supportProcessMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(readSupportResponseContext.getTaskInstance(), supportProcess);
    }
}
