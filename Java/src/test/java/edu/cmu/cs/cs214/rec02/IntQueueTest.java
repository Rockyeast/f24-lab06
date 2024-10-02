package edu.cmu.cs.cs214.rec02;

import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;


/**
 * TODO: 
 * 1. The {@link LinkedIntQueue} has no bugs. We've provided you with some example test cases.
 * Write your own unit tests to test against IntQueue interface with specification testing method 
 * using mQueue = new LinkedIntQueue();
 * 
 * 2. 
 * Comment `mQueue = new LinkedIntQueue();` and uncomment `mQueue = new ArrayIntQueue();`
 * Use your test cases from part 1 to test ArrayIntQueue and find bugs in the {@link ArrayIntQueue} class
 * Write more unit tests to test the implementation of ArrayIntQueue, with structural testing method
 * Aim to achieve 100% line coverage for ArrayIntQueue
 *
 * @author Alex Lockwood, George Guo, Terry Li
 */

/**
 * TODO: 
 * 1. {@link LinkedIntQueue} 类没有任何错误。我们已经为您提供了一些示例测试用例。
 * 请使用规格测试方法（specification testing method），编写自己的单元测试，测试 IntQueue 接口。
 * 使用 `mQueue = new LinkedIntQueue();`
 * 
 * 2. 
 * 注释掉 `mQueue = new LinkedIntQueue();` 并取消注释 `mQueue = new ArrayIntQueue();`
 * 使用您在第1部分中编写的测试用例来测试 ArrayIntQueue，找到 {@link ArrayIntQueue} 类中的错误。
 * 使用结构测试方法（structural testing method）编写更多的单元测试。
 * 目标是达到 ArrayIntQueue 的 100% 代码行覆盖率。
 * 
 * 写好之后用 mvn test 命令在根目录运行
 * @author Alex Lockwood, George Guo, Terry Li
 */

public class IntQueueTest {

    private IntQueue mQueue;
    private List<Integer> testList;

    /**
     * Called before each test.
     */
    @Before
    public void setUp() {
        // comment/uncomment these lines to test each class
        // mQueue = new LinkedIntQueue();
        mQueue = new ArrayIntQueue();

        testList = new ArrayList<>(List.of(1, 2, 3));
    }

    @Test
    public void testIsEmpty() {
        // This is an example unit test
        assertTrue(mQueue.isEmpty());
    }

    @Test
    public void testNotEmpty() {
        // TODO: write your own unit test
        mQueue.enqueue(1);
        assertFalse(mQueue.isEmpty());
    }
    // Calling the peek() method when the queue is empty
    @Test
    public void testPeekEmptyQueue() {
        // TODO: write your own unit test
        // Check if calling peek() on an empty queue returns null
        assertNull(mQueue.peek()); 
    }

    @Test
    public void testPeekNoEmptyQueue() {
        // TODO: write your own unit test
        mQueue.enqueue(1);
        assertNotNull(mQueue.peek()); 
    }

    // 从尾部入队
    @Test
    public void testEnqueue() {
        // This is an example unit test
        for (int i = 0; i < testList.size(); i++) {
            mQueue.enqueue(testList.get(i)); // 将 testList 中的第 i 个元素插入到队列中
            assertEquals(testList.get(0), mQueue.peek()); // testList 中的第一个元素。peek() 应该始终返回第一个被插入的元素 testList.get(0)
            assertEquals(i + 1, mQueue.size()); // 队列的大小 mQueue.size() 等于 i + 1
        }
    }
    // 从头部出队
    @Test
    public void testDequeue() {
        // TODO: write your own unit test
        for (int i = 0; i < testList.size(); i++) {
            mQueue.enqueue(testList.get(i));
        }

        for (int i = 0; i < testList.size(); i++) {
            assertEquals(testList.get(i), mQueue.dequeue());  // 确保移除的是队列中的第一个元素
            assertEquals(testList.size() - i - 1, mQueue.size());  // 确保队列大小减少
        }
    }

    @Test
    public void testContent() throws IOException {
        // This is an example unit test
        InputStream in = new FileInputStream("src/test/resources/data.txt");
        try (Scanner scanner = new Scanner(in)) {
            scanner.useDelimiter("\\s*fish\\s*");

            List<Integer> correctResult = new ArrayList<>();
            while (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                correctResult.add(input);
                System.out.println("enqueue: " + input);
                mQueue.enqueue(input);
            }

            for (Integer result : correctResult) {
                assertEquals(mQueue.dequeue(), result);
            }
        }
    }


}
