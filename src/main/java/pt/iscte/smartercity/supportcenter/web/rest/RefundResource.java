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
import pt.iscte.smartercity.supportcenter.repository.RefundRepository;
import pt.iscte.smartercity.supportcenter.service.RefundService;
import pt.iscte.smartercity.supportcenter.service.dto.RefundDTO;
import pt.iscte.smartercity.supportcenter.web.rest.errors.BadRequestAlertException;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link pt.iscte.smartercity.supportcenter.domain.Refund}.
 */
@RestController
@RequestMapping("/api")
public class RefundResource {

    private final Logger log = LoggerFactory.getLogger(RefundResource.class);

    private final RefundService refundService;

    private final RefundRepository refundRepository;

    public RefundResource(RefundService refundService, RefundRepository refundRepository) {
        this.refundService = refundService;
        this.refundRepository = refundRepository;
    }

    /**
     * {@code GET  /refunds} : get all the refunds.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of refunds in body.
     */
    @GetMapping("/refunds")
    public List<RefundDTO> getAllRefunds() {
        log.debug("REST request to get all Refunds");
        return refundService.findAll();
    }

    /**
     * {@code GET  /refunds/:id} : get the "id" refund.
     *
     * @param id the id of the refundDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the refundDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/refunds/{id}")
    public ResponseEntity<RefundDTO> getRefund(@PathVariable Long id) {
        log.debug("REST request to get Refund : {}", id);
        Optional<RefundDTO> refundDTO = refundService.findOne(id);
        return ResponseUtil.wrapOrNotFound(refundDTO);
    }
}
