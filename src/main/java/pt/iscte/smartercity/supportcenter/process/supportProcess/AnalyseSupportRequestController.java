package pt.iscte.smartercity.supportcenter.process.supportProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/support-process/analyse-support-request")
public class AnalyseSupportRequestController {

    private final Logger log = LoggerFactory.getLogger(AnalyseSupportRequestController.class);

    private final AnalyseSupportRequestService analyseSupportRequestService;

    public AnalyseSupportRequestController(AnalyseSupportRequestService analyseSupportRequestService) {
        this.analyseSupportRequestService = analyseSupportRequestService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnalyseSupportRequestContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        AnalyseSupportRequestContextDTO analyseSupportRequestContext = analyseSupportRequestService.loadContext(id);
        return ResponseEntity.ok(analyseSupportRequestContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<AnalyseSupportRequestContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        AnalyseSupportRequestContextDTO analyseSupportRequestContext = analyseSupportRequestService.claim(id);
        return ResponseEntity.ok(analyseSupportRequestContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody AnalyseSupportRequestContextDTO analyseSupportRequestContext) {
        log.debug(
            "REST request to complete SupportProcess.AnalyseSupportRequest {}",
            analyseSupportRequestContext.getTaskInstance().getId()
        );
        analyseSupportRequestService.complete(analyseSupportRequestContext);
        return ResponseEntity.noContent().build();
    }
}
