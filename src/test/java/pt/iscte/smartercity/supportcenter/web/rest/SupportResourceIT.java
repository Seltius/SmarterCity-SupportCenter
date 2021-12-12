package pt.iscte.smartercity.supportcenter.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import pt.iscte.smartercity.supportcenter.IntegrationTest;
import pt.iscte.smartercity.supportcenter.domain.Support;
import pt.iscte.smartercity.supportcenter.repository.SupportRepository;
import pt.iscte.smartercity.supportcenter.service.dto.SupportDTO;
import pt.iscte.smartercity.supportcenter.service.mapper.SupportMapper;

/**
 * Integration tests for the {@link SupportResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class SupportResourceIT {

    private static final Integer DEFAULT_SUPPORT_ID = 1;
    private static final Integer UPDATED_SUPPORT_ID = 2;

    private static final LocalDate DEFAULT_CREATE_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_CREATE_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_END_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_END_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_EMAIL = "AAAAAAAAAA";
    private static final String UPDATED_EMAIL = "BBBBBBBBBB";

    private static final String DEFAULT_ISSUE = "AAAAAAAAAA";
    private static final String UPDATED_ISSUE = "BBBBBBBBBB";

    private static final Boolean DEFAULT_IS_REFUND = false;
    private static final Boolean UPDATED_IS_REFUND = true;

    private static final Boolean DEFAULT_IS_VALID = false;
    private static final Boolean UPDATED_IS_VALID = true;

    private static final Integer DEFAULT_REFUND_ID = 1;
    private static final Integer UPDATED_REFUND_ID = 2;

    private static final Boolean DEFAULT_IS_RESOLVED = false;
    private static final Boolean UPDATED_IS_RESOLVED = true;

    private static final String DEFAULT_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_STATUS = "BBBBBBBBBB";

    private static final String DEFAULT_USER_REPLY = "AAAAAAAAAA";
    private static final String UPDATED_USER_REPLY = "BBBBBBBBBB";

    private static final String DEFAULT_SUPPORT_REPLY = "AAAAAAAAAA";
    private static final String UPDATED_SUPPORT_REPLY = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/supports";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private SupportRepository supportRepository;

    @Autowired
    private SupportMapper supportMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restSupportMockMvc;

    private Support support;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Support createEntity(EntityManager em) {
        Support support = new Support()
            .supportId(DEFAULT_SUPPORT_ID)
            .createDate(DEFAULT_CREATE_DATE)
            .endDate(DEFAULT_END_DATE)
            .name(DEFAULT_NAME)
            .email(DEFAULT_EMAIL)
            .issue(DEFAULT_ISSUE)
            .isRefund(DEFAULT_IS_REFUND)
            .isValid(DEFAULT_IS_VALID)
            .refundId(DEFAULT_REFUND_ID)
            .isResolved(DEFAULT_IS_RESOLVED)
            .status(DEFAULT_STATUS)
            .userReply(DEFAULT_USER_REPLY)
            .supportReply(DEFAULT_SUPPORT_REPLY);
        return support;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Support createUpdatedEntity(EntityManager em) {
        Support support = new Support()
            .supportId(UPDATED_SUPPORT_ID)
            .createDate(UPDATED_CREATE_DATE)
            .endDate(UPDATED_END_DATE)
            .name(UPDATED_NAME)
            .email(UPDATED_EMAIL)
            .issue(UPDATED_ISSUE)
            .isRefund(UPDATED_IS_REFUND)
            .isValid(UPDATED_IS_VALID)
            .refundId(UPDATED_REFUND_ID)
            .isResolved(UPDATED_IS_RESOLVED)
            .status(UPDATED_STATUS)
            .userReply(UPDATED_USER_REPLY)
            .supportReply(UPDATED_SUPPORT_REPLY);
        return support;
    }

    @BeforeEach
    public void initTest() {
        support = createEntity(em);
    }

    @Test
    @Transactional
    void getAllSupports() throws Exception {
        // Initialize the database
        supportRepository.saveAndFlush(support);

        // Get all the supportList
        restSupportMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(support.getId().intValue())))
            .andExpect(jsonPath("$.[*].supportId").value(hasItem(DEFAULT_SUPPORT_ID)))
            .andExpect(jsonPath("$.[*].createDate").value(hasItem(DEFAULT_CREATE_DATE.toString())))
            .andExpect(jsonPath("$.[*].endDate").value(hasItem(DEFAULT_END_DATE.toString())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)))
            .andExpect(jsonPath("$.[*].email").value(hasItem(DEFAULT_EMAIL)))
            .andExpect(jsonPath("$.[*].issue").value(hasItem(DEFAULT_ISSUE)))
            .andExpect(jsonPath("$.[*].isRefund").value(hasItem(DEFAULT_IS_REFUND.booleanValue())))
            .andExpect(jsonPath("$.[*].isValid").value(hasItem(DEFAULT_IS_VALID.booleanValue())))
            .andExpect(jsonPath("$.[*].refundId").value(hasItem(DEFAULT_REFUND_ID)))
            .andExpect(jsonPath("$.[*].isResolved").value(hasItem(DEFAULT_IS_RESOLVED.booleanValue())))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS)))
            .andExpect(jsonPath("$.[*].userReply").value(hasItem(DEFAULT_USER_REPLY)))
            .andExpect(jsonPath("$.[*].supportReply").value(hasItem(DEFAULT_SUPPORT_REPLY)));
    }

    @Test
    @Transactional
    void getSupport() throws Exception {
        // Initialize the database
        supportRepository.saveAndFlush(support);

        // Get the support
        restSupportMockMvc
            .perform(get(ENTITY_API_URL_ID, support.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(support.getId().intValue()))
            .andExpect(jsonPath("$.supportId").value(DEFAULT_SUPPORT_ID))
            .andExpect(jsonPath("$.createDate").value(DEFAULT_CREATE_DATE.toString()))
            .andExpect(jsonPath("$.endDate").value(DEFAULT_END_DATE.toString()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME))
            .andExpect(jsonPath("$.email").value(DEFAULT_EMAIL))
            .andExpect(jsonPath("$.issue").value(DEFAULT_ISSUE))
            .andExpect(jsonPath("$.isRefund").value(DEFAULT_IS_REFUND.booleanValue()))
            .andExpect(jsonPath("$.isValid").value(DEFAULT_IS_VALID.booleanValue()))
            .andExpect(jsonPath("$.refundId").value(DEFAULT_REFUND_ID))
            .andExpect(jsonPath("$.isResolved").value(DEFAULT_IS_RESOLVED.booleanValue()))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS))
            .andExpect(jsonPath("$.userReply").value(DEFAULT_USER_REPLY))
            .andExpect(jsonPath("$.supportReply").value(DEFAULT_SUPPORT_REPLY));
    }

    @Test
    @Transactional
    void getNonExistingSupport() throws Exception {
        // Get the support
        restSupportMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }
}
