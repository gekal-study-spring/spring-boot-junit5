package cn.gekal.sample.junit.tools;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Appender;
import org.mockito.ArgumentCaptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * ロガーヘルパー
 */
public class LoggerHelper {

    /** LOGGER */
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerHelper.class);

    /**
     * 対象クラスのアベンダーを追加する
     *
     * @param clazz 対象クラス
     * @return アベンダー
     */
    public static Appender<ILoggingEvent> addAppender(Class<?> clazz) {

        @SuppressWarnings("unchecked") Appender<ILoggingEvent> mockAppender = mock(Appender.class);
        var logger = LoggerFactory.getLogger(clazz);
        if (logger instanceof ch.qos.logback.classic.Logger logbackLogger) {
            logbackLogger.addAppender(mockAppender);
        }

        return mockAppender;
    }

    /**
     * ログのレベルとメッセージを検証する
     *
     * @param mockAppender アベンダー
     * @param levels       ログレベルリスト
     * @param messages     メッセージリスト
     */
    public static void verifyLog(Appender<ILoggingEvent> mockAppender, @NonNull List<Level> levels, @NonNull List<String> messages) {

        // ログレベル数とメッセージ数が一致するか検証する
        assertEquals(levels.size(), messages.size());

        // イベントをキャプチャする
        ArgumentCaptor<ILoggingEvent> eventCaptor = ArgumentCaptor.forClass(ILoggingEvent.class);
        verify(mockAppender, times(messages.size())).doAppend(eventCaptor.capture());

        // ログ出力内容を検証する
        List<ILoggingEvent> loggingEvents = eventCaptor.getAllValues();
        for (int i = 0; i < loggingEvents.size(); i++) {
            ILoggingEvent loggingEvent = loggingEvents.get(i);

            LOGGER.info("actual: LoggerName = [{}], Level = [{}], message = [{}]",
                    loggingEvent.getLoggerName(),
                    loggingEvent.getLevel(),
                    loggingEvent.getFormattedMessage());

            assertEquals(levels.get(i), loggingEvent.getLevel());
            assertEquals(messages.get(i), loggingEvent.getFormattedMessage());
        }
    }
}
