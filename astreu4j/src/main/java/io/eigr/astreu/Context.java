package io.eigr.astreu;

import org.slf4j.Logger;

public interface Context {
    String SOURCE_MESSAGE_TIME_NANOS = "source-time-nanos";
    String SOURCE_MESSAGE_TIME_SECONDS = "source-time-seconds";

    Logger logger();
}
