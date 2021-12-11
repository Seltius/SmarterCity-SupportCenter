package pt.iscte.smartercity.supportcenter.service.mapper;

import org.mapstruct.*;
import pt.iscte.smartercity.supportcenter.domain.*;
import pt.iscte.smartercity.supportcenter.service.dto.SupportDTO;

/**
 * Mapper for the entity {@link Support} and its DTO {@link SupportDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface SupportMapper extends EntityMapper<SupportDTO, Support> {}
