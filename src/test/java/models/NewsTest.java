package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewsTest {
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
    @Test
    public void getTitleReturnsCorrectTitle() throws Exception {
        News testNews = setupNews();
        assertEquals("Breaking News", testNews.getTitle());
    }
    @Test
    public void getDescriptionReturnsCorrectDescription() throws Exception {
        News testNews = setupNews();
        assertEquals("Schools closed over flu outbreak", testNews.getDescription());
    }
    @Test
    public void getTypeReturnsCorrectType() throws Exception {
        News testNews = setupNews();
        assertEquals("General", testNews.getType());
    }
    @Test
    public void getAuthorReturnsCorrectAuthor() throws Exception {
        News testNews = setupNews();
        assertEquals("Kemunto", testNews.getAuthor());
    }
    private News setupNews() {
    }
}