package pt.iscte.smartercity.supportcenter.process.supportProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/support-process/fill-support-request")
public class FillSupportRequestController {

    private final Logger log = LoggerFactory.getLogger(FillSupportRequestController.class);

    private final FillSupportRequestService fillSupportRequestService;

    public FillSupportRequestController(FillSupportRequestService fillSupportRequestService) {
        this.fillSupportRequestService = fillSupportRequestService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<FillSupportRequestContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        FillSupportRequestContextDTO fillSupportRequestContext = fillSupportRequestService.loadContext(id);
        return ResponseEntity.ok(fillSupportRequestContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<FillSupportRequestContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        FillSupportRequestContextDTO fillSupportRequestContext = fillSupportRequestService.claim(id);
        return ResponseEntity.ok(fillSupportRequestContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody FillSupportRequestContextDTO fillSupportRequestContext) {
        log.debug("REST request to complete SupportProcess.FillSupportRequest {}", fillSupportRequestContext.getTaskInstance().getId());
        fillSupportRequestService.complete(fillSupportRequestContext);
        return ResponseEntity.noContent().build();
    }
}
