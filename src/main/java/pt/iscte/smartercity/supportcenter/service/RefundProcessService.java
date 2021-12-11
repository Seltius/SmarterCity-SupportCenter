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
import pt.iscte.smartercity.supportcenter.domain.RefundProcess;
import pt.iscte.smartercity.supportcenter.repository.RefundProcessRepository;
import pt.iscte.smartercity.supportcenter.repository.RefundRepository;
import pt.iscte.smartercity.supportcenter.service.dto.RefundProcessDTO;
import pt.iscte.smartercity.supportcenter.service.mapper.RefundProcessMapper;

/**
 * Service Implementation for managing {@link RefundProcess}.
 */
@Service
@Transactional
public class RefundProcessService {

    public static final String BPMN_PROCESS_DEFINITION_ID = "SupportProcess";

    private final Logger log = LoggerFactory.getLogger(RefundProcessService.class);

    private final ProcessInstanceService processInstanceService;

    private final RefundRepository refundRepository;

    private final RefundProcessRepository refundProcessRepository;

    private final RefundProcessMapper refundProcessMapper;

    public RefundProcessService(
        ProcessInstanceService processInstanceService,
        RefundRepository refundRepository,
        RefundProcessRepository refundProcessRepository,
        RefundProcessMapper refundProcessMapper
    ) {
        this.processInstanceService = processInstanceService;
        this.refundRepository = refundRepository;
        this.refundProcessRepository = refundProcessRepository;
        this.refundProcessMapper = refundProcessMapper;
    }

    /**
     * Save a refundProcess.
     *
     * @param refundProcessDTO the entity to save.
     * @return the persisted entity.
     */
    public RefundProcessDTO create(RefundProcessDTO refundProcessDTO) {
        log.debug("Request to save RefundProcess : {}", refundProcessDTO);

        RefundProcess refundProcess = refundProcessMapper.toEntity(refundProcessDTO);

        //Saving the domainEntity
        refundRepository.save(refundProcess.getRefund());

        //Creating the process instance in the Camunda and setting it in the process entity
        ProcessInstance processInstance = processInstanceService.create(
            BPMN_PROCESS_DEFINITION_ID,
            "Refund#" + refundProcess.getRefund().getId(),
            refundProcess
        );
        refundProcess.setProcessInstance(processInstance);

        //Saving the process entity
        refundProcess = refundProcessRepository.save(refundProcess);
        return refundProcessMapper.toDto(refundProcess);
    }

    /**
     * Get all the refundProcesss.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<RefundProcessDTO> findAll() {
        log.debug("Request to get all RefundProcesss");
        return refundProcessRepository.findAll().stream().map(refundProcessMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one refundProcess by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<RefundProcessDTO> findOne(Long id) {
        log.debug("Request to get RefundProcess : {}", id);
        return refundProcessRepository.findById(id).map(refundProcessMapper::toDto);
    }

    /**
     * Get one refundProcess by id.
     *
     * @param processInstanceId the id of the processInstance associated to the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<RefundProcessDTO> findByProcessInstanceId(Long processInstanceId) {
        log.debug("Request to get RefundProcess by  processInstanceId: {}", processInstanceId);
        return refundProcessRepository.findByProcessInstanceId(processInstanceId).map(refundProcessMapper::toDto);
    }
}
