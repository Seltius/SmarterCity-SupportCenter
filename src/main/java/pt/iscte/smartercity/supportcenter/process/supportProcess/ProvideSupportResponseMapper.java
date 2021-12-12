package pt.iscte.smartercity.supportcenter.process.supportProcess;

import org.akip.service.mapper.ProcessInstanceMapper;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pt.iscte.smartercity.supportcenter.domain.Support;
import pt.iscte.smartercity.supportcenter.domain.SupportProcess;
import pt.iscte.smartercity.supportcenter.service.dto.SupportDTO;
import pt.iscte.smartercity.supportcenter.service.dto.SupportProcessDTO;

@Mapper(componentModel = "spring", uses = { ProcessInstanceMapper.class })
public interface ProvideSupportResponseMapper {
    @Mapping(target = "processInstance", source = "processInstance", qualifiedByName = "loadTaskContext")
    SupportProcessDTO toSupportProcessDTO(SupportProcess supportProcess);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "supportId", source = "supportId")
    @Mapping(target = "startDate", source = "startDate")
    @Mapping(target = "userName", source = "userName")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "message", source = "message")
    @Mapping(target = "supportMessage", source = "supportMessage")
    SupportDTO toSupportDTO(Support support);
}