package by.gsu.pms.reader.parser;

import by.gsu.pms.reader.parser.exception.UnsupportedParserTypeException;

public class ParserFactory {
    public static Parser getParser(String key) throws UnsupportedParserTypeException {
        if (key.contains("account")) {
            return new AccountParser();
        } else if (key.contains("days")) {
            return new DaysParser();
        } else if (key.contains("indices")) {
            return new IndexParser();
        } else if (key.contains("transport")) {
            return new TransportParser();
        } else if (key.contains("daily-rate")) {
            return new DailyRateParser();
        }

        throw new UnsupportedParserTypeException("Unsupported key");
    }
}

