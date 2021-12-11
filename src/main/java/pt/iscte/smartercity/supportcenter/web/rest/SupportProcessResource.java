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
import pt.iscte.smartercity.supportcenter.service.SupportProcessService;
import pt.iscte.smartercity.supportcenter.service.dto.SupportProcessDTO;
import pt.iscte.smartercity.supportcenter.web.rest.errors.BadRequestAlertException;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link pt.iscte.smartercity.supportcenter.domain.SupportProcess}.
 */
@RestController
@RequestMapping("/api")
public class SupportProcessResource {

    private final Logger log = LoggerFactory.getLogger(SupportProcessResource.class);

    private static final String ENTITY_NAME = "supportProcess";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SupportProcessService supportProcessService;

    public SupportProcessResource(SupportProcessService supportProcessService) {
        this.supportProcessService = supportProcessService;
    }

    /**
     * {@code POST  /support-processes} : Create a new supportProcess.
     *
     * @param supportProcessDTO the supportProcessDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new supportProcessDTO, or with status {@code 400 (Bad Request)} if the supportProcess has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/support-processes")
    public ResponseEntity<SupportProcessDTO> create(@RequestBody SupportProcessDTO supportProcessDTO) throws URISyntaxException {
        log.debug("REST request to save SupportProcess : {}", supportProcessDTO);
        if (supportProcessDTO.getId() != null) {
            throw new BadRequestAlertException("A new supportProcess cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SupportProcessDTO result = supportProcessService.create(supportProcessDTO);
        return ResponseEntity
            .created(new URI("/api/support-processes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /support-processes} : get all the supportProcesss.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of supportProcesss in body.
     */
    @GetMapping("/support-processes")
    public List<SupportProcessDTO> getAllSupportProcesss() {
        log.debug("REST request to get all SupportProcesss");
        return supportProcessService.findAll();
    }

    /**
     * {@code GET  /support-processes/:id} : get the "id" supportProcess.
     *
     * @param processInstanceId the id of the supportProcessDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the supportProcessDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/support-processes/{processInstanceId}")
    public ResponseEntity<SupportProcessDTO> getByProcessInstanceId(@PathVariable Long processInstanceId) {
        log.debug("REST request to get SupportProcess by processInstanceId : {}", processInstanceId);
        Optional<SupportProcessDTO> supportProcessDTO = supportProcessService.findByProcessInstanceId(processInstanceId);
        return ResponseUtil.wrapOrNotFound(supportProcessDTO);
    }
}
