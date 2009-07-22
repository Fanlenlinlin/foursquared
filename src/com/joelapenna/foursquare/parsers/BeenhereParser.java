/**
 * Copyright 2009 Joe LaPenna
 */

package com.joelapenna.foursquare.parsers;

import com.joelapenna.foursquare.Foursquare;
import com.joelapenna.foursquare.error.FoursquareError;
import com.joelapenna.foursquare.error.FoursquareParseException;
import com.joelapenna.foursquare.types.Beenhere;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.util.Log;

import java.io.IOException;

/**
 * Auto-generated: 2009-06-10 02:19:21.530622
 *
 * @author Joe LaPenna (joe@joelapenna.com)
 * @param <T>
 */
public class BeenhereParser extends AbstractParser<Beenhere> {
    private static final String TAG = "BeenhereParser";
    private static final boolean DEBUG = Foursquare.DEBUG;

    @Override
    public Beenhere parseInner(XmlPullParser parser) throws XmlPullParserException, IOException,
            FoursquareError, FoursquareParseException {
        parser.require(XmlPullParser.START_TAG, null, "beenhere");

        Beenhere beenhere = new Beenhere();

        while (parser.nextTag() == XmlPullParser.START_TAG) {
            if (DEBUG) Log.d(TAG, "Tag Name: " + String.valueOf(parser.getName()));

            String name = parser.getName();
            if ("friends".equals(name)) {
                beenhere.setFriends(parser.nextText().equals("1"));

            } else if ("me".equals(name)) {
                beenhere.setMe(parser.nextText().equals("1"));

            } else {
                // Consume something we don't understand.
                if (DEBUG) Log.d(TAG, "Found tag that we don't recognize: " + name);
                skipSubTree(parser);
            }
        }
        return beenhere;
    }
}
