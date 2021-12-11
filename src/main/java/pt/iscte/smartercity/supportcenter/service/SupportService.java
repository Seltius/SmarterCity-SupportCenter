package pt.iscte.smartercity.supportcenter.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pt.iscte.smartercity.supportcenter.domain.Support;
import pt.iscte.smartercity.supportcenter.repository.SupportRepository;
import pt.iscte.smartercity.supportcenter.service.dto.SupportDTO;
import pt.iscte.smartercity.supportcenter.service.mapper.SupportMapper;

/**
 * Service Implementation for managing {@link Support}.
 */
@Service
@Transactional
public class SupportService {

    private final Logger log = LoggerFactory.getLogger(SupportService.class);

    private final SupportRepository supportRepository;

    private final SupportMapper supportMapper;

    public SupportService(SupportRepository supportRepository, SupportMapper supportMapper) {
        this.supportRepository = supportRepository;
        this.supportMapper = supportMapper;
    }

    /**
     * Save a support.
     *
     * @param supportDTO the entity to save.
     * @return the persisted entity.
     */
    public SupportDTO save(SupportDTO supportDTO) {
        log.debug("Request to save Support : {}", supportDTO);
        Support support = supportMapper.toEntity(supportDTO);
        support = supportRepository.save(support);
        return supportMapper.toDto(support);
    }

    /**
     * Partially update a support.
     *
     * @param supportDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<SupportDTO> partialUpdate(SupportDTO supportDTO) {
        log.debug("Request to partially update Support : {}", supportDTO);

        return supportRepository
            .findById(supportDTO.getId())
            .map(
                existingSupport -> {
                    supportMapper.partialUpdate(existingSupport, supportDTO);
                    return existingSupport;
                }
            )
            .map(supportRepository::save)
            .map(supportMapper::toDto);
    }

    /**
     * Get all the supports.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<SupportDTO> findAll() {
        log.debug("Request to get all Supports");
        return supportRepository.findAll().stream().map(supportMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one support by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<SupportDTO> findOne(Long id) {
        log.debug("Request to get Support : {}", id);
        return supportRepository.findById(id).map(supportMapper::toDto);
    }

    /**
     * Delete the support by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Support : {}", id);
        supportRepository.deleteById(id);
    }
}
