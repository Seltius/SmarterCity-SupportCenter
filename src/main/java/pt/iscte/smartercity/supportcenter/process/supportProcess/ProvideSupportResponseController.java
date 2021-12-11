package pt.iscte.smartercity.supportcenter.process.supportProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/support-process/provide-support-response")
public class ProvideSupportResponseController {

    private final Logger log = LoggerFactory.getLogger(ProvideSupportResponseController.class);

    private final ProvideSupportResponseService provideSupportResponseService;

    public ProvideSupportResponseController(ProvideSupportResponseService provideSupportResponseService) {
        this.provideSupportResponseService = provideSupportResponseService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProvideSupportResponseContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        ProvideSupportResponseContextDTO provideSupportResponseContext = provideSupportResponseService.loadContext(id);
        return ResponseEntity.ok(provideSupportResponseContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<ProvideSupportResponseContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        ProvideSupportResponseContextDTO provideSupportResponseContext = provideSupportResponseService.claim(id);
        return ResponseEntity.ok(provideSupportResponseContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody ProvideSupportResponseContextDTO provideSupportResponseContext) {
        log.debug(
            "REST request to complete SupportProcess.ProvideSupportResponse {}",
            provideSupportResponseContext.getTaskInstance().getId()
        );
        provideSupportResponseService.complete(provideSupportResponseContext);
        return ResponseEntity.noContent().build();
    }
}
