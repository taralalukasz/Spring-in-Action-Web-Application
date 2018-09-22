package spitter.web;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import spitter.data.ISpitterRepository;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class SpitterControllerTest {

    ISpitterRepository spitterRepository;

    @Test
    public void testOpenRegisterForm() throws Exception {
        SpitterController controllerUnderTest = new SpitterController(spitterRepository);
        MockMvc mockMvc =  standaloneSetup(controllerUnderTest).build();
        mockMvc.perform(get("/spitter/register"))
                .andExpect(view().name("registerForm"));
    }
}