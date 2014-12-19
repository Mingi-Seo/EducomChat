package edu.educom.simplechat.server.core;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * Created by cmkim on 2014-12-13.
 */
public class SimpleChatServerCoreTest {
    @Test
    public void testServerCoreAliveOrClose() throws Exception {
        SimpleChatServerCore serverCore = new SimpleChatServerCore();

        //  처음 시작할 때에는 서버가 닫혀 있음
        assertEquals(false, serverCore.isAlive());
    }
}