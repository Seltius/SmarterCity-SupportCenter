package pt.iscte.smartercity.supportcenter.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import pt.iscte.smartercity.supportcenter.web.rest.TestUtil;

class SupportTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Support.class);
        Support support1 = new Support();
        support1.setId(1L);
        Support support2 = new Support();
        support2.setId(support1.getId());
        assertThat(support1).isEqualTo(support2);
        support2.setId(2L);
        assertThat(support1).isNotEqualTo(support2);
        support1.setId(null);
        assertThat(support1).isNotEqualTo(support2);
    }
}
