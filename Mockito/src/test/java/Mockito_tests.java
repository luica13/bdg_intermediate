import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class Mockito_tests {
    @Test
    public void whenNotUseMockAnnotation_thenCorrect() {
        List mockList = mock(ArrayList.class);

        mockList.add("one");
        verify(mockList).add("one");

        assertEquals(0, mockList.size());

        when(mockList.size()).thenReturn(100);
        assertEquals(100, mockList.size());
    }

//    @Mock
//    List<String> mockedList;
//
//    @Test
//    public void whenUseMockAnnotation_thenMockIsInjected() {
//        mockedList.add("one");
//        Mockito.verify(mockedList).add("one");
//        assertEquals(0, mockedList.size());
//
//        Mockito.when(mockedList.size()).thenReturn(100);
//        assertEquals(100, mockedList.size());
//    }
}
