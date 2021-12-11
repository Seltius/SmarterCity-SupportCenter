package pt.iscte.smartercity.supportcenter.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.iscte.smartercity.supportcenter.repository.SupportRepository;
import pt.iscte.smartercity.supportcenter.service.SupportService;
import pt.iscte.smartercity.supportcenter.service.dto.SupportDTO;
import pt.iscte.smartercity.supportcenter.web.rest.errors.BadRequestAlertException;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link pt.iscte.smartercity.supportcenter.domain.Support}.
 */
@RestController
@RequestMapping("/api")
public class SupportResource {

    private final Logger log = LoggerFactory.getLogger(SupportResource.class);

    private final SupportService supportService;

    private final SupportRepository supportRepository;

    public SupportResource(SupportService supportService, SupportRepository supportRepository) {
        this.supportService = supportService;
        this.supportRepository = supportRepository;
    }

    /**
     * {@code GET  /supports} : get all the supports.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of supports in body.
     */
    @GetMapping("/supports")
    public List<SupportDTO> getAllSupports() {
        log.debug("REST request to get all Supports");
        return supportService.findAll();
    }

    /**
     * {@code GET  /supports/:id} : get the "id" support.
     *
     * @param id the id of the supportDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the supportDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/supports/{id}")
    public ResponseEntity<SupportDTO> getSupport(@PathVariable Long id) {
        log.debug("REST request to get Support : {}", id);
        Optional<SupportDTO> supportDTO = supportService.findOne(id);
        return ResponseUtil.wrapOrNotFound(supportDTO);
    }
}
