package com.eos.act;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLocal {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private String name;

    // 测试log
    @Test
    public void logbackTest() {
        logger.info("Info级别");
        logger.debug("debug级别");
        logger.error("error级别");
        logger.trace("trace级别");
        logger.warn("warn级别");
    }
}
