package org.elasticsearch.index.analysis;

import org.apache.lucene.analysis.TokenStream;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.elasticsearch.index.analysis.parser.HangulJamoParserType;

/**
 * Created by changoh on 17. 3. 20.
 */
public class HangulJamoTokenFilterFactory extends AbstractTokenFilterFactory {
    private HangulJamoParserType parserType;

    public HangulJamoTokenFilterFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        super(indexSettings, name, settings);
        this.parserType = HangulJamoParserType.getParserTypeByString(HangulJamoParserType.JAMO.name());
    }

    public TokenStream create(TokenStream tokenStream) {
        return new HangulJamoTokenFilter(tokenStream, parserType);
    }
}
