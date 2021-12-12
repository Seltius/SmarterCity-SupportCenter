package pt.iscte.smartercity.supportcenter.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.iscte.smartercity.supportcenter.service.MessageProcessService;
import pt.iscte.smartercity.supportcenter.service.dto.MessageProcessDTO;
import pt.iscte.smartercity.supportcenter.web.rest.errors.BadRequestAlertException;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link pt.iscte.smartercity.supportcenter.domain.MessageProcess}.
 */
@RestController
@RequestMapping("/api")
public class MessageProcessResource {

    private final Logger log = LoggerFactory.getLogger(MessageProcessResource.class);

    private static final String ENTITY_NAME = "messageProcess";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final MessageProcessService messageProcessService;

    public MessageProcessResource(MessageProcessService messageProcessService) {
        this.messageProcessService = messageProcessService;
    }

    /**
     * {@code POST  /message-processes} : Create a new messageProcess.
     *
     * @param messageProcessDTO the messageProcessDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new messageProcessDTO, or with status {@code 400 (Bad Request)} if the messageProcess has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/message-processes")
    public ResponseEntity<MessageProcessDTO> create(@RequestBody MessageProcessDTO messageProcessDTO) throws URISyntaxException {
        log.debug("REST request to save MessageProcess : {}", messageProcessDTO);
        if (messageProcessDTO.getId() != null) {
            throw new BadRequestAlertException("A new messageProcess cannot already have an ID", ENTITY_NAME, "idexists");
        }
        MessageProcessDTO result = messageProcessService.create(messageProcessDTO);
        return ResponseEntity
            .created(new URI("/api/message-processes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /message-processes} : get all the messageProcesss.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of messageProcesss in body.
     */
    @GetMapping("/message-processes")
    public List<MessageProcessDTO> getAllMessageProcesss() {
        log.debug("REST request to get all MessageProcesss");
        return messageProcessService.findAll();
    }

    /**
     * {@code GET  /message-processes/:id} : get the "id" messageProcess.
     *
     * @param processInstanceId the id of the messageProcessDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the messageProcessDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/message-processes/{processInstanceId}")
    public ResponseEntity<MessageProcessDTO> getByProcessInstanceId(@PathVariable Long processInstanceId) {
        log.debug("REST request to get MessageProcess by processInstanceId : {}", processInstanceId);
        Optional<MessageProcessDTO> messageProcessDTO = messageProcessService.findByProcessInstanceId(processInstanceId);
        return ResponseUtil.wrapOrNotFound(messageProcessDTO);
    }
}
