package pt.iscte.smartercity.supportcenter.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pt.iscte.smartercity.supportcenter.domain.Refund;
import pt.iscte.smartercity.supportcenter.repository.RefundRepository;
import pt.iscte.smartercity.supportcenter.service.dto.RefundDTO;
import pt.iscte.smartercity.supportcenter.service.mapper.RefundMapper;

/**
 * Service Implementation for managing {@link Refund}.
 */
@Service
@Transactional
public class RefundService {

    private final Logger log = LoggerFactory.getLogger(RefundService.class);

    private final RefundRepository refundRepository;

    private final RefundMapper refundMapper;

    public RefundService(RefundRepository refundRepository, RefundMapper refundMapper) {
        this.refundRepository = refundRepository;
        this.refundMapper = refundMapper;
    }

    /**
     * Save a refund.
     *
     * @param refundDTO the entity to save.
     * @return the persisted entity.
     */
    public RefundDTO save(RefundDTO refundDTO) {
        log.debug("Request to save Refund : {}", refundDTO);
        Refund refund = refundMapper.toEntity(refundDTO);
        refund = refundRepository.save(refund);
        return refundMapper.toDto(refund);
    }

    /**
     * Partially update a refund.
     *
     * @param refundDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<RefundDTO> partialUpdate(RefundDTO refundDTO) {
        log.debug("Request to partially update Refund : {}", refundDTO);

        return refundRepository
            .findById(refundDTO.getId())
            .map(
                existingRefund -> {
                    refundMapper.partialUpdate(existingRefund, refundDTO);
                    return existingRefund;
                }
            )
            .map(refundRepository::save)
            .map(refundMapper::toDto);
    }

    /**
     * Get all the refunds.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<RefundDTO> findAll() {
        log.debug("Request to get all Refunds");
        return refundRepository.findAll().stream().map(refundMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one refund by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<RefundDTO> findOne(Long id) {
        log.debug("Request to get Refund : {}", id);
        return refundRepository.findById(id).map(refundMapper::toDto);
    }

    /**
     * Delete the refund by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Refund : {}", id);
        refundRepository.deleteById(id);
    }
}
