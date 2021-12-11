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
import pt.iscte.smartercity.supportcenter.domain.SupportProcess;
import pt.iscte.smartercity.supportcenter.repository.SupportProcessRepository;
import pt.iscte.smartercity.supportcenter.repository.SupportRepository;
import pt.iscte.smartercity.supportcenter.service.dto.SupportProcessDTO;
import pt.iscte.smartercity.supportcenter.service.mapper.SupportProcessMapper;

/**
 * Service Implementation for managing {@link SupportProcess}.
 */
@Service
@Transactional
public class SupportProcessService {

    public static final String BPMN_PROCESS_DEFINITION_ID = "SupportProcess";

    private final Logger log = LoggerFactory.getLogger(SupportProcessService.class);

    private final ProcessInstanceService processInstanceService;

    private final SupportRepository supportRepository;

    private final SupportProcessRepository supportProcessRepository;

    private final SupportProcessMapper supportProcessMapper;

    public SupportProcessService(
        ProcessInstanceService processInstanceService,
        SupportRepository supportRepository,
        SupportProcessRepository supportProcessRepository,
        SupportProcessMapper supportProcessMapper
    ) {
        this.processInstanceService = processInstanceService;
        this.supportRepository = supportRepository;
        this.supportProcessRepository = supportProcessRepository;
        this.supportProcessMapper = supportProcessMapper;
    }

    /**
     * Save a supportProcess.
     *
     * @param supportProcessDTO the entity to save.
     * @return the persisted entity.
     */
    public SupportProcessDTO create(SupportProcessDTO supportProcessDTO) {
        log.debug("Request to save SupportProcess : {}", supportProcessDTO);

        SupportProcess supportProcess = supportProcessMapper.toEntity(supportProcessDTO);

        //Saving the domainEntity
        supportRepository.save(supportProcess.getSupport());

        //Creating the process instance in the Camunda and setting it in the process entity
        ProcessInstance processInstance = processInstanceService.create(
            BPMN_PROCESS_DEFINITION_ID,
            "Support#" + supportProcess.getSupport().getId(),
            supportProcess
        );
        supportProcess.setProcessInstance(processInstance);

        //Saving the process entity
        supportProcess = supportProcessRepository.save(supportProcess);
        return supportProcessMapper.toDto(supportProcess);
    }

    /**
     * Get all the supportProcesss.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<SupportProcessDTO> findAll() {
        log.debug("Request to get all SupportProcesss");
        return supportProcessRepository
            .findAll()
            .stream()
            .map(supportProcessMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one supportProcess by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<SupportProcessDTO> findOne(Long id) {
        log.debug("Request to get SupportProcess : {}", id);
        return supportProcessRepository.findById(id).map(supportProcessMapper::toDto);
    }

    /**
     * Get one supportProcess by id.
     *
     * @param processInstanceId the id of the processInstance associated to the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<SupportProcessDTO> findByProcessInstanceId(Long processInstanceId) {
        log.debug("Request to get SupportProcess by  processInstanceId: {}", processInstanceId);
        return supportProcessRepository.findByProcessInstanceId(processInstanceId).map(supportProcessMapper::toDto);
    }
}
