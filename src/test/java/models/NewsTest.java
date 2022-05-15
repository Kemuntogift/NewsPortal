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
        assertEquals("Breaking news", testNews.getTitle());
    }
    @Test
    public void getDescriptionReturnsCorrectDescription() throws Exception {
        News testNews = setupNews();
        assertEquals("Offices closed over flu outbreak", testNews.getDescription());
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
    @Test
    public void setTitleSetsCorrectTitle() throws Exception {
        News testNews = setupNews();
        testNews.setTitle("Sports");
        assertNotEquals("Breaking news",testNews.getTitle());
    }
    @Test
    public void setDescriptionReturnsCorrectDescription() throws Exception {
        News testNews = setupNews();
        testNews.setDescription("Game today");
        assertNotEquals("Offices closed over flu outbreak",testNews.getDescription());
    }
    @Test
    public void setTypeSetsCorrectType() throws Exception {
        News testNews = setupNews();
        testNews.setType("Departmental");
        assertNotEquals("General",testNews.getType());
    }
    @Test
    public void setAuthorSetsCorrectAuthor() throws Exception {
        News testNews = setupNews();
        testNews.setAuthor("Brian");
        assertNotEquals("Kemunto",testNews.getAuthor());
    }
    @Test
    public void setId() {
        News testNews = setupNews();
        testNews.setId(5);
        assertEquals(5, testNews.getId());
    }
    private News setupNews() {
        return new News ("Breaking news", "Offices closed over flu outbreak", "General", "Kemunto");
    }
}