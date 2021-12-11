package pt.iscte.smartercity.supportcenter.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import pt.iscte.smartercity.supportcenter.web.rest.TestUtil;

class SupportDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(SupportDTO.class);
        SupportDTO supportDTO1 = new SupportDTO();
        supportDTO1.setId(1L);
        SupportDTO supportDTO2 = new SupportDTO();
        assertThat(supportDTO1).isNotEqualTo(supportDTO2);
        supportDTO2.setId(supportDTO1.getId());
        assertThat(supportDTO1).isEqualTo(supportDTO2);
        supportDTO2.setId(2L);
        assertThat(supportDTO1).isNotEqualTo(supportDTO2);
        supportDTO1.setId(null);
        assertThat(supportDTO1).isNotEqualTo(supportDTO2);
    }
}
