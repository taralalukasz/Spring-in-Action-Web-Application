package spitter.web;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import spitter.data.ISpitterRepository;
import spitter.data.SpitterRepository;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class SpitterControllerTest {

    ISpitterRepository spitterRepository = new SpitterRepository();

    @Test
    public void testOpenRegisterForm() throws Exception {
        SpitterController controllerUnderTest = new SpitterController(spitterRepository);
        MockMvc mockMvc =  standaloneSetup(controllerUnderTest).build();
        mockMvc.perform(get("/spitter/register"))
                .andExpect(view().name("registerForm"));
    }

    @Test
    public void testSubmitRegisterForm() throws Exception {
        SpitterController controllerUnderTest = new SpitterController(spitterRepository);
        MockMvc mockMvc =  standaloneSetup(controllerUnderTest).build();
        mockMvc.perform(post("/spitter/register")
                .param("name", "testName")
                .param("surname", "testSurname")
                .param("username", "testUsername")
                .param("password", "testPassword"))
                .andExpect(redirectedUrl("/spitter/testUsername"));

    }

    @Test
    public void testGetUserAccount() throws Exception {
        SpitterController controllerUnderTest = new SpitterController(spitterRepository);
        MockMvc mockMvc =  standaloneSetup(controllerUnderTest).build();
        mockMvc.perform(get("/spitter/testUsername"))
                .andExpect(model().attributeExists("spitter"))
                .andExpect(view().name("spitter"));
    }
}