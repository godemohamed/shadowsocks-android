package com.github.shadowsocks.utils;


import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by terry on 2017/3/29.
 */

public class OkHttpClientManager {
    private static final String TAG = OkHttpClientManager.class.getSimpleName();

    private static OkHttpClient sOkClient;

    static {
        sOkClient = new OkHttpClient.Builder()
                .readTimeout(90, TimeUnit.SECONDS)
                .connectTimeout(90, TimeUnit.SECONDS)
                .writeTimeout(90, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();
    }


    public static void httpAsyncGet(String url, Callback cb) {
        Request request = new Request.Builder()
                .url(url)
                .header("User-Agent", HDR_VALUE_UA)
                .addHeader(HDR_KEY_CONNECTION, HDR_VALUE_CONNECTION)
                .addHeader(HDR_KEY_ACCEPT, HDR_VALUE_ACCEPT)
                .addHeader(HDR_KEY_ACCEPT_LANGUAGE, HDR_VALUE_ACCEPT_LANGUAGE)
                .addHeader(HDR_KEY_CHARSET, HDR_VALUE_CHARSET)
                .build();
        sOkClient.newCall(request).enqueue(cb);
    }

    public static String httpSyncGet(String url) throws IOException{
        Request request = new Request.Builder()
                .url(url)
                .build();
        String result = null;

        Response response = sOkClient.newCall(request).execute();

        if (!response.isSuccessful()) {
            throw new IOException("Unexpected code " + response);
        }

        result = response.body().string();

        return result;
    }

    private static String getHttpAcceptLanguage() {
        Locale locale = Locale.getDefault();
        StringBuilder builder = new StringBuilder();

        addLocaleToHttpAcceptLanguage(builder, locale);
        if (!locale.equals(Locale.US)) {
            if (builder.length() > 0) {
                builder.append(", ");
            }
            addLocaleToHttpAcceptLanguage(builder, Locale.US);
        }
        return builder.toString();
    }

    private static void addLocaleToHttpAcceptLanguage(StringBuilder builder,
                                                      Locale locale) {
        String language = locale.getLanguage();

        if (language != null) {
            builder.append(language);

            String country = locale.getCountry();

            if (country != null) {
                builder.append("-");
                builder.append(country);
            }
        }
    }

    private static final String HDR_KEY_ACCEPT = "Accept";

    private static final String HDR_KEY_ACCEPT_LANGUAGE = "Accept-Language";

    private static final String HDR_VALUE_ACCEPT = "application/vnd.wap.wmlscriptc, "
            + "text/vnd.wap.wml, application/vnd.wap.xhtml+xml, application/xhtml+xml, "
            + "text/html, multipart/mixed, */*, text/x-vcard, text/x-vcalendar, image/gif, "
            + "image/vnd.wap.wbmp";

    private static String HDR_VALUE_UA = "NokiaN73-1/4.0850.43.1.1 Series60/3.0 Profile/MIDP-2.0 Configuration/CLDC-1.1";

    private static final String HDR_VALUE_ACCEPT_LANGUAGE;
    static {
        HDR_VALUE_ACCEPT_LANGUAGE = getHttpAcceptLanguage();
    }

    private static final String HDR_KEY_CONNECTION = "Connection";

    private static final String HDR_VALUE_CONNECTION = "Keep-Alive";

    private static final String HDR_KEY_CHARSET = "Charset";

    private static final String HDR_VALUE_CHARSET = "UTF-8,ISO-8859-1,US-ASCII,ISO-10646-UCS-2;q=0.6";
}
