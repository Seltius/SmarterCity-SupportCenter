package pt.iscte.smartercity.supportcenter.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.akip.domain.ProcessInstance;
import org.akip.service.ProcessInstanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pt.iscte.smartercity.supportcenter.domain.MessageProcess;
import pt.iscte.smartercity.supportcenter.repository.MessageProcessRepository;
import pt.iscte.smartercity.supportcenter.repository.MessageRepository;
import pt.iscte.smartercity.supportcenter.service.dto.MessageProcessDTO;
import pt.iscte.smartercity.supportcenter.service.mapper.MessageProcessMapper;

/**
 * Service Implementation for managing {@link MessageProcess}.
 */
@Service
@Transactional
public class MessageProcessService {

    public static final String BPMN_PROCESS_DEFINITION_ID = "MessageProcess";

    private final Logger log = LoggerFactory.getLogger(MessageProcessService.class);

    private final ProcessInstanceService processInstanceService;

    private final MessageRepository messageRepository;

    private final MessageProcessRepository messageProcessRepository;

    private final MessageProcessMapper messageProcessMapper;

    public MessageProcessService(
        ProcessInstanceService processInstanceService,
        MessageRepository messageRepository,
        MessageProcessRepository messageProcessRepository,
        MessageProcessMapper messageProcessMapper
    ) {
        this.processInstanceService = processInstanceService;
        this.messageRepository = messageRepository;
        this.messageProcessRepository = messageProcessRepository;
        this.messageProcessMapper = messageProcessMapper;
    }

    /**
     * Save a messageProcess.
     *
     * @param messageProcessDTO the entity to save.
     * @return the persisted entity.
     */
    public MessageProcessDTO create(MessageProcessDTO messageProcessDTO) {
        log.debug("Request to save MessageProcess : {}", messageProcessDTO);

        MessageProcess messageProcess = messageProcessMapper.toEntity(messageProcessDTO);

        //Saving the domainEntity
        messageRepository.save(messageProcess.getMessage());

        //Creating the process instance in the Camunda and setting it in the process entity
        ProcessInstance processInstance = processInstanceService.create(
            BPMN_PROCESS_DEFINITION_ID,
            "Message#" + messageProcess.getMessage().getId(),
            messageProcess
        );
        messageProcess.setProcessInstance(processInstance);

        //Saving the process entity
        messageProcess = messageProcessRepository.save(messageProcess);
        return messageProcessMapper.toDto(messageProcess);
    }

    /**
     * Get all the messageProcesss.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<MessageProcessDTO> findAll() {
        log.debug("Request to get all MessageProcesss");
        return messageProcessRepository
            .findAll()
            .stream()
            .map(messageProcessMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one messageProcess by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<MessageProcessDTO> findOne(Long id) {
        log.debug("Request to get MessageProcess : {}", id);
        return messageProcessRepository.findById(id).map(messageProcessMapper::toDto);
    }

    /**
     * Get one messageProcess by id.
     *
     * @param processInstanceId the id of the processInstance associated to the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<MessageProcessDTO> findByProcessInstanceId(Long processInstanceId) {
        log.debug("Request to get MessageProcess by  processInstanceId: {}", processInstanceId);
        return messageProcessRepository.findByProcessInstanceId(processInstanceId).map(messageProcessMapper::toDto);
    }
}
