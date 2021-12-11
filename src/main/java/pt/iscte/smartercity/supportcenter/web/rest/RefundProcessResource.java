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
import pt.iscte.smartercity.supportcenter.service.RefundProcessService;
import pt.iscte.smartercity.supportcenter.service.dto.RefundProcessDTO;
import pt.iscte.smartercity.supportcenter.web.rest.errors.BadRequestAlertException;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link pt.iscte.smartercity.supportcenter.domain.RefundProcess}.
 */
@RestController
@RequestMapping("/api")
public class RefundProcessResource {

    private final Logger log = LoggerFactory.getLogger(RefundProcessResource.class);

    private static final String ENTITY_NAME = "refundProcess";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final RefundProcessService refundProcessService;

    public RefundProcessResource(RefundProcessService refundProcessService) {
        this.refundProcessService = refundProcessService;
    }

    /**
     * {@code POST  /refund-processes} : Create a new refundProcess.
     *
     * @param refundProcessDTO the refundProcessDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new refundProcessDTO, or with status {@code 400 (Bad Request)} if the refundProcess has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/refund-processes")
    public ResponseEntity<RefundProcessDTO> create(@RequestBody RefundProcessDTO refundProcessDTO) throws URISyntaxException {
        log.debug("REST request to save RefundProcess : {}", refundProcessDTO);
        if (refundProcessDTO.getId() != null) {
            throw new BadRequestAlertException("A new refundProcess cannot already have an ID", ENTITY_NAME, "idexists");
        }
        RefundProcessDTO result = refundProcessService.create(refundProcessDTO);
        return ResponseEntity
            .created(new URI("/api/refund-processes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /refund-processes} : get all the refundProcesss.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of refundProcesss in body.
     */
    @GetMapping("/refund-processes")
    public List<RefundProcessDTO> getAllRefundProcesss() {
        log.debug("REST request to get all RefundProcesss");
        return refundProcessService.findAll();
    }

    /**
     * {@code GET  /refund-processes/:id} : get the "id" refundProcess.
     *
     * @param processInstanceId the id of the refundProcessDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the refundProcessDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/refund-processes/{processInstanceId}")
    public ResponseEntity<RefundProcessDTO> getByProcessInstanceId(@PathVariable Long processInstanceId) {
        log.debug("REST request to get RefundProcess by processInstanceId : {}", processInstanceId);
        Optional<RefundProcessDTO> refundProcessDTO = refundProcessService.findByProcessInstanceId(processInstanceId);
        return ResponseUtil.wrapOrNotFound(refundProcessDTO);
    }
}
