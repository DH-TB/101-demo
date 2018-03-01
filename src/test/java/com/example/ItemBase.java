package com.example;

import com.example.entity.Item;
import com.example.repository.CategoryRepository;
import com.example.repository.ItemRepository;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles("test")
public class ItemBase {

    @Autowired
    WebApplicationContext wac;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private FlywayServiceTest flywayServiceTest;
    private static boolean initialized = false;

    @Before
    public void setup() throws Exception {
        if (!initialized) {
            flywayServiceTest.migrateDatabase();
            initItem();
            initialized = true;
        }
        RestAssuredMockMvc.webAppContextSetup(wac);
    }
    private void initItem() {
        itemRepository.save(new Item((long) 1, "饮料",3.00));
        itemRepository.save(new Item((long) 2, "饮料",3.00));
    }
}
