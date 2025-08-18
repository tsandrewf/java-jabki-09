import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

class MainTest {

    @Test
    void areAnagramsTest() {
        assertTrue(Main.areAnagrams("росинка","соринка"));
        assertTrue(Main.areAnagrams("каратист","артистка"));
        assertFalse(Main.areAnagrams("вперед", "назад"));
    }

    @Test
    void hasDuplicatesTest() {
        assertTrue(Main.hasDuplicates(new ArrayList<>(List.of(1, 3, 5, 3, 1))));
        assertFalse(Main.hasDuplicates(new ArrayList<>(List.of(1, 3, 5, 7, 11))));
    }

    @Test
    void getBestStudentTest() {
        HashMap<String, Integer> studentsScoreMap = new HashMap<>(){{
            put("John", 1);
            put("Sam", 2);
            put("Brendan", 3);
            put("Albert", 4);
            put("Steven", 5);
        }};

        assertEquals("Steven", Main.getBestStudent(studentsScoreMap));
    }

    @Test
    void addSynonymTest() {
        String word = "большой";
        Main.addSynonym(word, "гигантский");
        assertEquals(new HashSet<>(List.of("огромный", "гигантский", "великий", "массивный")), Main.synonymMap.get(word));

        Main.addSynonym(word, "крупный");
        assertEquals(new HashSet<>(List.of("огромный", "гигантский", "великий", "массивный", "крупный")), Main.synonymMap.get(word));

        word = "хороший";
        Main.addSynonym(word, "неплохой");
        assertEquals(new HashSet<>(List.of("неплохой")), Main.synonymMap.get(word));
    }
}