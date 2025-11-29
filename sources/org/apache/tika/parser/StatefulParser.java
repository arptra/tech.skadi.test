package org.apache.tika.parser;

public class StatefulParser extends ParserDecorator {
    public StatefulParser(Parser parser) {
        super(parser);
    }
}
