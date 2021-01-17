package com.trendyol.convertlink.controller;

import com.trendyol.convertlink.ConvertLinkApplication;
import com.trendyol.convertlink.TestConsts;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;


@Slf4j
@ExtendWith(SpringExtension.class)
@WebAppConfiguration()
@ContextConfiguration(classes = {ConvertLinkApplication.class})
public class LinkControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private static MockMvc mockMvc;

    public LinkControllerTest() {
    }

    @BeforeEach
    void setup() {
        if (mockMvc == null) {
            this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
            log.warn("spring started!!!");
        }
    }

    @ParameterizedTest
    @MethodSource(TestConsts.Controller.TEST_CLASS_SOURCE + "#linkArguments")
    public void should_be_ok_when_post(String requestUrlJson, String urlPath) throws Exception {

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(urlPath)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(requestUrlJson))
                .andReturn();

        int status = result.getResponse().getStatus();

        assertThat(status).isEqualTo(200);
    }
}
