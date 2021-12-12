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
public class ProvideSupportResponseService {

    private final TaskInstanceService taskInstanceService;

    private final SupportService supportService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final SupportProcessRepository supportProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final ProvideSupportResponseMapper provideSupportResponseMapper;

    private final SupportProcessMapper supportProcessMapper;

    private final MessageRepository messageRepository;

    public ProvideSupportResponseService(
        TaskInstanceService taskInstanceService,
        SupportService supportService,
        TaskInstanceRepository taskInstanceRepository,
        SupportProcessRepository supportProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        ProvideSupportResponseMapper provideSupportResponseMapper,
        SupportProcessMapper supportProcessMapper,
        MessageRepository messageRepository
    ) {
        this.taskInstanceService = taskInstanceService;
        this.supportService = supportService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.supportProcessRepository = supportProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.provideSupportResponseMapper = provideSupportResponseMapper;
        this.supportProcessMapper = supportProcessMapper;
        this.messageRepository = messageRepository;
    }

    public ProvideSupportResponseContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        SupportProcessDTO supportProcess = supportProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(provideSupportResponseMapper::toSupportProcessDTO)
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

        ProvideSupportResponseContextDTO provideSupportResponseContext = new ProvideSupportResponseContextDTO();
        provideSupportResponseContext.setTaskInstance(taskInstanceDTO);
        provideSupportResponseContext.setSupportProcess(supportProcess);

        return provideSupportResponseContext;
    }

    public ProvideSupportResponseContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(ProvideSupportResponseContextDTO provideSupportResponseContext) {
        SupportDTO supportDTO = supportService
            .findOne(provideSupportResponseContext.getSupportProcess().getSupport().getId())
            .orElseThrow();
        supportDTO.setSupportId(provideSupportResponseContext.getSupportProcess().getSupport().getSupportId());
        supportDTO.setCreateDate(provideSupportResponseContext.getSupportProcess().getSupport().getCreateDate());
        supportDTO.setName(provideSupportResponseContext.getSupportProcess().getSupport().getName());
        supportDTO.setEmail(provideSupportResponseContext.getSupportProcess().getSupport().getEmail());
        supportDTO.setIssue(provideSupportResponseContext.getSupportProcess().getSupport().getIssue());
        supportDTO.setSupportReply(provideSupportResponseContext.getSupportProcess().getSupport().getSupportReply());
        supportService.save(supportDTO);
    }

    public void complete(ProvideSupportResponseContextDTO provideSupportResponseContext) {
        save(provideSupportResponseContext);
        SupportProcessDTO supportProcess = supportProcessRepository
            .findByProcessInstanceId(provideSupportResponseContext.getSupportProcess().getProcessInstance().getId())
            .map(supportProcessMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(provideSupportResponseContext.getTaskInstance(), supportProcess);
    }
}
