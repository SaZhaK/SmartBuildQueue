import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    Train train = new Train(1, LocalTime.of(12, 12), Duration.ofMinutes(20), 10.5);
    Stack stack = new Stack();

    @Test
    void get() {
        stack.push(train);
        assertEquals(train, stack.get(0));
    }

    @Test
    void push() {
        stack.push(train);
        assertEquals(train, stack.get(0));
    }

    @Test
    void pop() {
        stack.push(train);
        assertEquals(train, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    void peek() {
        stack.push(train);
        assertEquals(train, stack.peek());
        assertFalse(stack.isEmpty());
    }

    @Test
    void size() {
        stack.push(train);
        assertEquals(1, stack.size());
        stack.pop();
        assertEquals(0, stack.size());
    }

    @Test
    void isEmpty() {
        assertTrue(stack.isEmpty());
        stack.push(train);
        assertFalse(stack.isEmpty());
    }
}