package pt.iscte.smartercity.supportcenter.process.supportProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/support-process/analyse-refund-request")
public class AnalyseRefundRequestController {

    private final Logger log = LoggerFactory.getLogger(AnalyseRefundRequestController.class);

    private final AnalyseRefundRequestService analyseRefundRequestService;

    public AnalyseRefundRequestController(AnalyseRefundRequestService analyseRefundRequestService) {
        this.analyseRefundRequestService = analyseRefundRequestService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnalyseRefundRequestContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        AnalyseRefundRequestContextDTO analyseRefundRequestContext = analyseRefundRequestService.loadContext(id);
        return ResponseEntity.ok(analyseRefundRequestContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<AnalyseRefundRequestContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        AnalyseRefundRequestContextDTO analyseRefundRequestContext = analyseRefundRequestService.claim(id);
        return ResponseEntity.ok(analyseRefundRequestContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody AnalyseRefundRequestContextDTO analyseRefundRequestContext) {
        log.debug("REST request to complete SupportProcess.AnalyseRefundRequest {}", analyseRefundRequestContext.getTaskInstance().getId());
        analyseRefundRequestService.complete(analyseRefundRequestContext);
        return ResponseEntity.noContent().build();
    }
}
