package pt.iscte.smartercity.supportcenter.process.refundProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/refund-process/fill-refund-form")
public class FillRefundFormController {

    private final Logger log = LoggerFactory.getLogger(FillRefundFormController.class);

    private final FillRefundFormService fillRefundFormService;

    public FillRefundFormController(FillRefundFormService fillRefundFormService) {
        this.fillRefundFormService = fillRefundFormService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<FillRefundFormContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        FillRefundFormContextDTO fillRefundFormContext = fillRefundFormService.loadContext(id);
        return ResponseEntity.ok(fillRefundFormContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<FillRefundFormContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        FillRefundFormContextDTO fillRefundFormContext = fillRefundFormService.claim(id);
        return ResponseEntity.ok(fillRefundFormContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody FillRefundFormContextDTO fillRefundFormContext) {
        log.debug("REST request to complete RefundProcess.FillRefundForm {}", fillRefundFormContext.getTaskInstance().getId());
        fillRefundFormService.complete(fillRefundFormContext);
        return ResponseEntity.noContent().build();
    }
}
