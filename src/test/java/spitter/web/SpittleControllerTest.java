package spitter.web;

import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;
import spitter.data.ISpittleRepository;
import spitter.data.model.Spittle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class SpittleControllerTest  {



    @Test
    public void testSpittleController() throws Exception {
        List<Spittle> expectedSpittles = createSpittleList(20);

        ISpittleRepository repositoryMock = Mockito.mock(ISpittleRepository.class);
        when(repositoryMock.findSpittles(Long.MAX_VALUE, 20)).thenReturn(expectedSpittles);

        SpittleController testSubject = new SpittleController(repositoryMock);
        MockMvc mockMvc = standaloneSetup(testSubject)
                .setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp"))
                .build();
        mockMvc.perform(get("/spittles"))
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList", hasItems(expectedSpittles.toArray())));
    }

    @Test
    public void testShowSpittle() throws Exception {
        ISpittleRepository repositoryMock = Mockito.mock(ISpittleRepository.class);
        Spittle testSpittle = new Spittle(5l, "message of spittle 5", new Date());
        when(repositoryMock.findOne(5l)).thenReturn(testSpittle);

        SpittleController testSubject = new SpittleController(repositoryMock);
        MockMvc mockMvc = standaloneSetup(testSubject)
                .setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp"))
                .build();
        mockMvc.perform(get("/spittles/show/5"))
                .andExpect(view().name("spittle"))
                .andExpect(model().attribute("spittle", testSpittle));
    }

    @Test
    public void testShowSpittleNotFound() throws Exception {
        ISpittleRepository repositoryMock = Mockito.mock(ISpittleRepository.class);

        when(repositoryMock.findOne(5l)).thenReturn(null);

        SpittleController testSubject = new SpittleController(repositoryMock);
        MockMvc mockMvc = standaloneSetup(testSubject)
                .setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp"))
                .build();
        mockMvc.perform(get("/spittles/show/5"))
                .andExpect(view().name("spittle"));
    }


    private List<Spittle> createSpittleList(int count) {
        List<Spittle> spittles = new ArrayList<Spittle>();
        for (int i=0; i < count; i++) {
            spittles.add(new Spittle("Spittle " + i, new Date()));
        }
        return spittles; }
}