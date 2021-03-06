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
public interface ReadSupportResponseMapper {
    @Mapping(target = "processInstance", source = "processInstance", qualifiedByName = "loadTaskContext")
    SupportProcessDTO toSupportProcessDTO(SupportProcess supportProcess);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "supportId", source = "supportId")
    @Mapping(target = "createDate", source = "createDate")
    @Mapping(target = "issue", source = "issue")
    @Mapping(target = "userReply", source = "userReply")
    @Mapping(target = "isResolved", source = "isResolved")
    SupportDTO toSupportDTO(Support support);
}
