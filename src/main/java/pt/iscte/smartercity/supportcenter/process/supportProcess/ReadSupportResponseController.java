package pt.iscte.smartercity.supportcenter.process.supportProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/support-process/read-support-response")
public class ReadSupportResponseController {

    private final Logger log = LoggerFactory.getLogger(ReadSupportResponseController.class);

    private final ReadSupportResponseService readSupportResponseService;

    public ReadSupportResponseController(ReadSupportResponseService readSupportResponseService) {
        this.readSupportResponseService = readSupportResponseService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReadSupportResponseContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        ReadSupportResponseContextDTO readSupportResponseContext = readSupportResponseService.loadContext(id);
        return ResponseEntity.ok(readSupportResponseContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<ReadSupportResponseContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        ReadSupportResponseContextDTO readSupportResponseContext = readSupportResponseService.claim(id);
        return ResponseEntity.ok(readSupportResponseContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody ReadSupportResponseContextDTO readSupportResponseContext) {
        log.debug("REST request to complete SupportProcess.ReadSupportResponse {}", readSupportResponseContext.getTaskInstance().getId());
        readSupportResponseService.complete(readSupportResponseContext);
        return ResponseEntity.noContent().build();
    }
}
